package com.taotaotech.service.impl;

import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.core.utils.ProcessBillUtil;
import com.taotaotech.core.utils.ProcessPolicylUtil;
import com.taotaotech.dao.BillMapper;
import com.taotaotech.dao.ClientMapper;
import com.taotaotech.dao.MedicineMapper;
import com.taotaotech.domain.Bill;
import com.taotaotech.domain.Client;
import com.taotaotech.domain.Medicine;
import com.taotaotech.dto.ImportBill;
import com.taotaotech.dto.ImportPolicy;
import com.taotaotech.service.IBillService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Cailin.Chen
 * @Date 15/8/30
 * @eMail cailin618@sina.com
 */

@Service
public class BillServiceImpl implements IBillService{

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private MedicineMapper medicineMapper;

    @Transactional
    public ResponseResult parseBillTable(MultipartFile file) {
        ResponseResult result = new ResponseResult();

        if (!file.isEmpty()) {
            try {
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());

                List<ImportBill> list = new ArrayList<ImportBill>();
                // 循环工作表Sheet
                for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {

                    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

                    if (hssfSheet == null || !ProcessBillUtil.isValidBillExcel(hssfSheet.getRow(0))) {
                        result.setSuccess(false);
                        result.setMsg("请选择有效的文件上传!");
                        continue;
                    }
                    List<ImportBill> importBills = ProcessBillUtil.getImportBills(hssfSheet);
                    for (int index = 0; index < importBills.size(); index++) {
                        ImportBill ib = importBills.get(index);
                        generateMedicine(ib);
                        generateBill(ib);
                        generateCilent(ib);
                    }
                    break;
                }
                list.size();

            } catch (Exception e) {
                result.setSuccess(false);
                result.setMsg("异常情况:" + e.getMessage());
            }
        } else {
            result.setSuccess(false);
            result.setMsg("文件不能为空，请选择文件上传!");
        }
        return result;
    }

    @Transactional
    public DWZResponseResult parseBillTable2(MultipartFile file) {
        DWZResponseResult result = new DWZResponseResult();

        if (!file.isEmpty()) {
            try {
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());

                List<ImportBill> list = new ArrayList<ImportBill>();
                // 循环工作表Sheet
                for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {

                    HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);

                    if (hssfSheet == null || !ProcessBillUtil.isValidBillExcel(hssfSheet.getRow(0))) {
                        result.setStatusCode("300");
                        result.setMessage("请选择有效的文件上传!");
                        continue;
                    }
                    List<ImportBill> importBills = ProcessBillUtil.getImportBills(hssfSheet);
                    for (int index = 0; index < importBills.size(); index++) {
                        ImportBill ib = importBills.get(index);
                        generateMedicine(ib);
                        generateBill(ib);
                        generateCilent(ib);
                    }
                    break;
                }
                list.size();

                result.setMessage("导入成功！");
                result.setCallbackType("closeCurrent");
                result.setNavTabId("bill_list");
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

    private Integer generateCilent(ImportBill bill) {
        if (bill.getClientCode()==null || bill.getClientCode().equals("") ||
                bill.getClientName()==null || bill.getClientName().equals("") ){
            return null;
        }
        if (!clientMapper.existByClientCode(bill.getClientCode())){
            Client client = new Client();
            client.setCode(bill.getClientCode());
            client.setName(bill.getClientName());
            client.setBusinessType(bill.getBusinessType());
            return clientMapper.insertSelective(client);
        }
        return null;
    }

    private Integer generateBill(ImportBill ib) {
        if (ib.getBillCode()==null || ib.getBillCode().equals("") ){
            return null;
        }
        if (!billMapper.existByBillCode(ib.getBillCode())) {
            Bill bill = new Bill();
            bill.setCode(ib.getBillCode());
            if (!ib.getNumber().equals("")){
                bill.setNumber(Integer.parseInt(ib.getNumber()));
            }
            bill.setDate(ib.getInvoiceDate());

            return billMapper.insertSelective(bill);
        }
        return null;
    }

    private Integer generateMedicine(ImportBill bill) {
        if (bill.getLotNumber()==null || bill.getLotNumber().equals("") ||
            bill.getMedicineCode() == null || bill.getMedicineCode().equals("")){
            return null;
        }
        if (!medicineMapper.existByMedicineCodeAndLotNumber(bill.getMedicineCode(), bill.getLotNumber())){
            Medicine medicine = new Medicine();
            medicine.setCode(bill.getMedicineCode());
            medicine.setName(bill.getMedicineName());
            medicine.setLotNumber(bill.getLotNumber());
            medicine.setSpecification(bill.getMedicineSpecification());
            medicine.setManufacturerName(bill.getManufacturerName());
            if (!bill.getPrice().equals("")){
                medicine.setPrice(Float.parseFloat(bill.getPrice()));
            }
            medicine.setUnits(bill.getUnits());
            medicine.setValidityPeriod(bill.getValidityPeriod());
            return medicineMapper.insertSelective(medicine);
        }
        return null;
    }


}
