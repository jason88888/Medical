package com.taotaotech.service.impl;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.core.utils.DateUtil;
import com.taotaotech.core.utils.ProcessPurchaseUtil;
import com.taotaotech.dao.PurchasementMapper;
import com.taotaotech.domain.*;
import com.taotaotech.dto.ImportPurchasement;
import com.taotaotech.service.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zk
 * @date 2015/10/2 14:34
 * @description
 */
@Service
public class PurchaseServiceImpl extends CrudService<PurchasementMapper, Purchasement> implements IPurchaseService {

    @Autowired
    PurchasementMapper purchasementMapper;
    @Autowired
    IMedicineService medicineService;
    @Autowired
    IProviderService providerService;
    @Autowired
    IAgentClientService agentClientService;
    @Autowired
    IWarehouseService warehouseService;
    @Autowired
    IRkOrderService rkOrderService;

    @Autowired
    IStockService stockService ;

    @Override
    @Transactional
    public DWZResponseResult parsePurchaseTable(MultipartFile file) {
        DWZResponseResult result = new DWZResponseResult();

        if (!file.isEmpty()) {
            try {
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());

                List<ImportPurchasement> list = new ArrayList<ImportPurchasement>();
                // 循环工作表Sheet
                for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {

                    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

                    if (hssfSheet == null || !ProcessPurchaseUtil.isValidPurchaseExcel(hssfSheet.getRow(0))) {
                        result.setStatusCode("300");
                        result.setMessage("请选择有效的文件上传!");
                        continue;
                    }
                    List<ImportPurchasement> importPurchases = ProcessPurchaseUtil.getImportPurchases(hssfSheet);
                    for (int index = 0; index < importPurchases.size(); index++) {
                        ImportPurchasement ip = importPurchases.get(index);
                        Integer medicineId = generateMedicine(ip);
                        Integer providerId = generateProvider(ip);
                        Integer agentClientId = generateAgentClient(ip);
                        Integer warehouseId = generateWarehouse(ip);
                        generateRkOrder(ip,agentClientId,medicineId,warehouseId,providerId);
                        generateStock(ip,medicineId,warehouseId);
//                        generatePurchasement(ip);
//                        generatePurchaseCilent(ip);
//                        generatePurchaseTaxMoney(ip);
                    }
                    break;
                }
                list.size();
                result.setMessage("导入成功！");
                result.setCallbackType("closeCurrent");
                result.setNavTabId("purchase_list");
            } catch (Exception e) {
                result.setStatusCode("300");
                result.setMessage("异常情况:" + e.getMessage());
            }
        } else {
            result.setStatusCode("300");
            result.setMessage("文件不能为空，请选择文件上传!");
        }
        return result;
    }

    private int generateProvider(ImportPurchasement ip){
        Provider provider = new Provider();
        provider.setName(ip.getSaleCompany());
        provider.setAreaName(ip.getSaleArea());
        return providerService.create(provider);
    }

    private int generateAgentClient(ImportPurchasement ip){
        AgentClient agentClient = new AgentClient();
        if (ip.getPurchaseSaleType().equals("底价销售")){
            agentClient.setName(ip.getSaleCompany());
        }else if (ip.getPurchaseSaleType().equals("铺货")){
            agentClient.setName(ip.getBuyCompany());
        }
        AgentClient ac = agentClientService.get(agentClient);
        if (null == ac){
            return agentClientService.create(agentClient);
        }
        return ac.getId();
    }

    private int generateWarehouse(ImportPurchasement ip){
        Warehouse warehouse = new Warehouse();
        warehouse.setName(ip.getActualStorePlace());
        return warehouseService.create(warehouse);
    }

    private int generateRkOrder(ImportPurchasement ip,Integer agentClientId,Integer medicineId,Integer warehouseId,Integer providerId){
        RkOrder order = new RkOrder();
        if (!StringUtils.isEmpty(ip.getInvoiceNumber())){
            order.setInvoiceNumber(Integer.parseInt(ip.getInvoiceNumber()));
        }
        order.setAgentClientId(agentClientId);
        order.setOrderCode(ip.getPurchaseSaleCode());
        order.setProviderId(providerId);
        order.setInvoiceDate(DateUtil.dateFormat(ip.getInvoiceDate(), DateUtil.FORMAT_YYYYMMDD));
        order.setMedicineId(medicineId);
        order.setPayDate(ip.getPurchasePayDate());
        order.setPurchasePrice(ip.getPurchasePrice());
        order.setPurchaseMoney(ip.getPurchaseMoney());
        order.setStoreDate(DateUtil.dateFormat(ip.getPurchaseStoreDate(), DateUtil.FORMAT_YYYYMMDD));
        order.setWarehouseId(warehouseId);
        order.setTax(ip.getTax());
        order.setQuantity(ip.getPurchaseNumber());
        order.setUnits(ip.getUnits());
        order.setTaxpayMode(ip.getTaxPayMode());
        order.setTaxpayDate(ip.getTaxPayDate());
        return rkOrderService.create(order);
    }



    private void generateStock(ImportPurchasement ip,Integer medicineId,Integer warehouseId){
        Stock stock = stockService.getStockByMedicineIdAndWarehouseId(medicineId,warehouseId);
        if (null != stock){
            Integer quantity = Integer.parseInt(stock.getNowQuantity()) + ip.getPurchaseNumber();
            stock.setNowQuantity(quantity.toString());
        }else {
            stock = new Stock();
            stock.setNowQuantity(ip.getPurchaseNumber().toString());
            stock.setWarehouseId(warehouseId);
            stock.setMedicineId(medicineId);
            stock.setStartQuantity(ip.getPurchaseNumber().toString());
        }
        stockService.save(stock);
    }


    private void generatePurchasement(ImportPurchasement ip) {
        if (ip.getPurchaseSaleCode() == null || ip.getPurchaseSaleCode().equals("")) {
            return;
        }
        if (!purchasementMapper.existByPurchaseSaleCode(ip.getPurchaseSaleCode())) {
            Purchasement purchasement = new Purchasement();
            purchasement.setPurchaseSaleType(ip.getPurchaseSaleType());
            try {
                purchasement.setPurchasePayDate(DateUtil.dateFormat(ip.getPurchasePayDate(), DateUtil.FORMAT_YYYYMMDD));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                purchasement.setPurchaseStoreDate(DateUtil.dateFormat(ip.getPurchaseStoreDate(), DateUtil.FORMAT_YYYYMMDD));
            } catch (Exception e) {
                e.printStackTrace();
            }
            purchasement.setActualStorePlace(ip.getActualStorePlace());
            purchasement.setPurchaseSaleCode(ip.getPurchaseSaleCode());
            purchasement.setMedicineName(ip.getMedicineName());
            purchasement.setMedicineUniqueCode(ip.getMedicineUniqueCode());
            purchasement.setManufacturerName(ip.getManufacturerName());
            purchasement.setSpecification(ip.getSpecification());
            purchasement.setUnits(ip.getUnits());
            purchasement.setPackageNumber(ip.getPackageNumber());
            purchasement.setSaleCompany(ip.getSaleCompany());
            purchasement.setBuyCompany(ip.getBuyCompany());
            purchasement.setPaymentCategory(ip.getPaymentCategory());
            purchasement.setPaymentMode(ip.getPaymentMode());
            purchasement.setPurchaseNumber(ip.getPurchaseNumber());
            if (!StringUtils.isEmpty(ip.getPurchasePrice())) {
                purchasement.setPurchasePrice(Long.parseLong(ip.getPurchasePrice()));
            }
            purchasement.setPaymentMoney(ip.getPaymentMoney());
            purchasement.setWorkFlow(ip.getWorkFlow());
            purchasement.setClientName(ip.getClientName());
            purchasement.setSaleArea(ip.getSaleArea());
            if (!StringUtils.isEmpty(ip.getPurchaseUnitPrice())) {
                purchasement.setPurchaseUnitPrice(Long.parseLong(ip.getPurchaseUnitPrice()));
            }
            purchasement.setPurchaseMoney(ip.getPurchaseMoney());
            purchasement.setTax(ip.getTax());
            purchasement.setTaxPayMode(ip.getTaxPayMode());
            try {
                purchasement.setTaxPayDate(DateUtil.dateFormat(ip.getTaxPayDate(), DateUtil.FORMAT_YYYYMMDD));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!StringUtils.isEmpty(ip.getInvoiceNumber())) {
                purchasement.setInvoiceNumber(Integer.parseInt(ip.getInvoiceNumber()));
            }
            try {
                purchasement.setInvoiceDate(DateUtil.dateFormat(ip.getInvoiceDate(), DateUtil.FORMAT_YYYYMMDD));
            } catch (Exception e) {
                e.printStackTrace();
            }
            purchasement.setIfCheck(ip.getCheck());
            save(purchasement);
        }
    }


    private int generateMedicine(ImportPurchasement ip) {
//        if (StringUtils.isEmpty(ip.getLotNumber()) || StringUtils.isEmpty(ip.getMedicineUniqueCode())) {
//            return -1;
//        }
        Medicine m = medicineService.getMedicineByMedicineCodeAndLotNumber(ip.getMedicineCode(), ip.getLotNumber());
        if (null == m) {
            Medicine medicine = new Medicine();
            medicine.setUniqueCode(ip.getMedicineUniqueCode());
            medicine.setCode(ip.getMedicineCode());
            medicine.setName(ip.getMedicineName());
            medicine.setLotNumber(ip.getLotNumber());
            medicine.setSpecification(ip.getSpecification());
            medicine.setManufacturerName(ip.getManufacturerName());
            if (!StringUtils.isEmpty(ip.getPurchasePrice())) {
                medicine.setPrice(Float.parseFloat(ip.getPurchasePrice()));
            }
            medicine.setUnits(ip.getUnits());
            medicine.setValidityPeriod(ip.getValidityPeriod());
            medicine.setPurchaseNumber(ip.getPurchaseNumber());
            medicine.setPackageNumber(ip.getPackageNumber());
           return medicineService.create(medicine);
        }else {
            return m.getId();
        }
    }

}
