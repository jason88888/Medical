package com.taotaotech.service.impl;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.core.utils.ChineseCharToEn;
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
    ICommercialCompanyService commercialCompanyService;
    @Autowired
    IWarehouseService warehouseService;
    @Autowired
    ICgrkOrderService rkOrderService;
    @Autowired
    IAgentService agentService;

    @Autowired
    IStockService stockService;
    @Autowired
    IUserService userService;

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
                        Integer commercialCompanyId = generateCommercialCompany(ip);
                        Integer warehouseId = generateWarehouse(ip);
                        Integer agentId = generateAgent(ip);
                        generateRkOrder(ip, commercialCompanyId, medicineId, warehouseId, providerId, agentId);
                        generateStock(ip, medicineId, warehouseId);
//                        System.out.println("--------------------------------------------------"+index);
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

    private int generateProvider(ImportPurchasement ip) {
        Provider p = new Provider();
        p.setName(ip.getSaleCompany());
        p.setAreaName(ip.getSaleArea());

        Provider provider = providerService.find(p);
        if (null == provider) {
            return providerService.create(p);
        } else {
            return provider.getId();
        }


    }

    private int generateCommercialCompany(ImportPurchasement ip) {
        CommercialCompany commercialCompany = new CommercialCompany();
        commercialCompany.setName(ip.getBuyCompany());
        CommercialCompany ac = commercialCompanyService.find(commercialCompany);
        if (null == ac) {
            return commercialCompanyService.create(commercialCompany);
        }
        return ac.getId();
    }

    private int generateAgent(ImportPurchasement ip) {
        Agent agent = new Agent();
        agent.setName(ip.getClientName());
        Agent ag = agentService.find(agent);
        if (null == ag) {
            return agentService.create(agent);
        }
        return ag.getId();
    }


    private int generateWarehouse(ImportPurchasement ip) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(ip.getActualStorePlace());
        Warehouse wh = warehouseService.find(warehouse);
        if (null == wh) {
            return warehouseService.create(warehouse);
        }
        return wh.getId();
    }

    private int getAdminUserId() {
        User user = new User();
        user.setUsername("admin");
        User u = userService.find(user);
        if (null == u) {
            user.setPassword("111111");
            return userService.create(user);
        }
        return u.getId();
    }

    private int generateRkOrder(ImportPurchasement ip, Integer commercialCompanyId, Integer medicineId, Integer warehouseId, Integer providerId, Integer agentId) {
        CgrkOrder order = new CgrkOrder();
        if (!StringUtils.isEmpty(ip.getInvoiceNumber())) {
            order.setInvoiceNumber(Integer.parseInt(ip.getInvoiceNumber()));
        }
        order.setCommercialCompanyId(commercialCompanyId);
        order.setAgentId(agentId);
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
        order.setSysUserId(getAdminUserId());
        CgrkOrder rk = rkOrderService.find(order);
        if (null == rk) {
            return rkOrderService.create(order);
        }
        return rk.getId();
    }


    private void generateStock(ImportPurchasement ip, Integer medicineId, Integer warehouseId) {
        Stock stock = stockService.getStockByMedicineIdAndWarehouseId(medicineId, warehouseId);
        if (null != stock) {
            Integer quantity = Integer.parseInt(stock.getNowQuantity()) + ip.getPurchaseNumber();
            stock.setNowQuantity(quantity.toString());
        } else {
            stock = new Stock();
            stock.setNowQuantity(ip.getPurchaseNumber().toString());
            stock.setWarehouseId(warehouseId);
            stock.setMedicineId(medicineId);
            stock.setStartQuantity(ip.getPurchaseNumber().toString());
        }
        stockService.save(stock);
    }


    private int generateMedicine(ImportPurchasement ip) {
//        if (StringUtils.isEmpty(ip.getLotNumber()) || StringUtils.isEmpty(ip.getMedicineUniqueCode())) {
//            return -1;
//        }
        Medicine medicine = new Medicine();
        medicine.setName(ip.getMedicineName());
        Medicine m = medicineService.find(medicine);
        if (null == m) {
            medicine = new Medicine();
            medicine.setUniqueCode(ChineseCharToEn.getAllFirstLetter(ip.getMedicineName()));
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
        } else {
            return m.getId();
        }
    }

}
