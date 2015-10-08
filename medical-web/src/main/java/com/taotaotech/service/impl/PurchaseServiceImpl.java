package com.taotaotech.service.impl;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.persistence.Page;
import com.taotaotech.core.service.CrudService;
import com.taotaotech.core.utils.DateUtil;
import com.taotaotech.core.utils.ProcessPurchaseUtil;
import com.taotaotech.dao.PurchaseClientMapper;
import com.taotaotech.dao.PurchaseMoneytaxMapper;
import com.taotaotech.dao.PurchasementMapper;
import com.taotaotech.domain.Medicine;
import com.taotaotech.domain.PurchaseClient;
import com.taotaotech.domain.PurchaseMoneytax;
import com.taotaotech.domain.Purchasement;
import com.taotaotech.dto.ImportBill;
import com.taotaotech.dto.ImportPurchasement;
import com.taotaotech.service.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zk
 * @date 2015/10/2 14:34
 * @description
 */
@Service
public class PurchaseServiceImpl extends CrudService<PurchasementMapper,Purchasement> implements IPurchaseService {

    @Autowired
    PurchasementMapper purchasementMapper;
    @Autowired
    IMedicineService medicineService;
    @Autowired
    IPurchaseClientService clientService;
    @Autowired
    IPurchaseMoneyTaxService moneyTaxService;

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
                        generateMedicine(ip);
                        generatePurchasement(ip);
                        generatePurchaseCilent(ip);
                        generatePurchaseTaxMoney(ip);
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

    private void generatePurchaseTaxMoney(ImportPurchasement ip) {
        PurchaseMoneytax moneyTax = new PurchaseMoneytax();
        moneyTax.setPaymentCategory(ip.getPaymentCategory());
        moneyTax.setPaymentMode(ip.getPaymentMode());
        moneyTax.setPaymentMoney(ip.getPaymentMoney());
        moneyTax.setWorkFlow(ip.getWorkFlow());
        if (null != ip.getPurchaseUnitPrice() && ip.getPurchaseUnitPrice().equals("")){
            moneyTax.setPurchaseUnitPrice(Long.parseLong(ip.getPurchaseUnitPrice()));
        }
        moneyTax.setPurchaseMoney(ip.getPurchaseMoney());
        moneyTax.setTax(ip.getTax());
        moneyTax.setTaxPayMode(ip.getTaxPayMode());
        moneyTax.setTaxPayDate(DateUtil.getDate(ip.getTaxPayDate(), "yyyy-MM-dd"));
        if (null != ip.getInvoiceNumber() && ip.getInvoiceNumber().equals("")){
            moneyTax.setInvoiceNumber(Integer.parseInt(ip.getInvoiceNumber()));
        }
        moneyTax.setInvoiceDate(DateUtil.getDate(ip.getInvoiceDate(),"yyyy-MM-dd"));
        moneyTaxService.save(moneyTax);
    }

    private void generatePurchaseCilent(ImportPurchasement ip) {
        PurchaseClient client = new PurchaseClient();
        client.setSaleCompany(ip.getSaleCompany());
        client.setBuyCompany(ip.getBuyCompany());
        client.setClientName(ip.getClientName());
        client.setSaleArea(ip.getSaleArea());
        clientService.save(client);
    }

    private void generatePurchasement(ImportPurchasement ip) {
        if(ip.getPurchaseSaleCode() == null || ip.getPurchaseSaleCode().equals("")){
            return;
        }
        if (!purchasementMapper.existByPurchaseSaleCode(ip.getPurchaseSaleCode())) {
            Purchasement purchasement = new Purchasement();
            purchasement.setPurchaseSaleType(ip.getPurchaseSaleType());
            purchasement.setPurchasePayDate(ip.getPurchasePayDate());
            purchasement.setPurchaseStoreDate(ip.getPurchaseStoreDate());
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
            if (null != ip.getPurchasePrice() && ip.getPurchasePrice().equals("")) {
                purchasement.setPurchasePrice(Long.parseLong(ip.getPurchasePrice()));
            }
            purchasement.setPaymentMoney(ip.getPaymentMoney());
            purchasement.setWorkFlow(ip.getWorkFlow());
            purchasement.setClientName(ip.getClientName());
            purchasement.setSaleArea(ip.getSaleArea());
            if (null != ip.getPurchaseUnitPrice() && ip.getPurchaseUnitPrice().equals("")) {
                purchasement.setPurchaseUnitPrice(Long.parseLong(ip.getPurchaseUnitPrice()));
            }
            purchasement.setPurchaseMoney(ip.getPurchaseMoney());
            purchasement.setTax(ip.getTax());
            purchasement.setTaxPayMode(ip.getTaxPayMode());
            purchasement.setTaxPayDate(ip.getTaxPayDate());
            if (null != ip.getInvoiceNumber() && ip.getInvoiceNumber().equals("")) {
                purchasement.setInvoiceNumber(Integer.parseInt(ip.getInvoiceNumber()));
            }
            purchasement.setInvoiceDate(ip.getInvoiceDate());
            purchasement.setIfCheck(ip.getCheck());
            save(purchasement);
        }
    }


    private void generateMedicine(ImportPurchasement ip) {
        if (ip.getLotNumber() == null || ip.getLotNumber().equals("") ||
                ip.getMedicineUniqueCode() == null || ip.getMedicineUniqueCode().equals("")) {
            return ;
        }
        if (!medicineService.existByMedicineCodeAndLotNumber(ip.getMedicineCode(), ip.getLotNumber())) {
            Medicine medicine = new Medicine();
            medicine.setUniqueCode(ip.getMedicineUniqueCode());
            medicine.setCode(ip.getMedicineCode());
            medicine.setName(ip.getMedicineName());
            medicine.setLotNumber(ip.getLotNumber());
            medicine.setSpecification(ip.getSpecification());
            medicine.setManufacturerName(ip.getManufacturerName());
            if (!ip.getPurchasePrice().equals("")) {
                medicine.setPrice(Float.parseFloat(ip.getPurchasePrice()));
            }
            medicine.setUnits(ip.getUnits());
            medicine.setValidityPeriod(ip.getValidityPeriod());
            medicine.setPurchaseNumber(ip.getPurchaseNumber());
            medicine.setPackageNumber(ip.getPackageNumber());
            medicineService.save(medicine);
        }
    }

}
