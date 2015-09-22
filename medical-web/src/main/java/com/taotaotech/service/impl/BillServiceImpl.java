package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.taotaotech.core.dto.DWZResponseResult;
import com.taotaotech.core.dto.ResponseResult;
import com.taotaotech.core.utils.ProcessBillUtil;
import com.taotaotech.dao.*;
import com.taotaotech.domain.*;
import com.taotaotech.dto.BillRich;
import com.taotaotech.dto.ImportBill;
import com.taotaotech.service.IBillService;
import com.taotaotech.service.Page;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Cailin.Chen
 * @Date 15/8/30
 * @eMail cailin618@sina.com
 */

@Service
public class BillServiceImpl implements IBillService {

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private BillRichMapper billRichMapper;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private MedicineMapper medicineMapper;

    @Autowired
    AgentMapper agentMapper;

    @Autowired
    UserMapper userMapper;

    @Transactional
    public DWZResponseResult parseBillTable(MultipartFile file) {
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
                        generateSalesman(ib);
                        generateTwoLevelAgent(ib);
                        generateThreeLevelAgent(ib);
                        //方便bill计算佣金，减少数据库查询使用
                        generateBillRich(ib);
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

    @Override
    public Page<BillRich> findBillList(Page<BillRich>page,Map map) {
         PageList<BillRich> list = (PageList)billRichMapper.findBillList(map, page.createPageBounds());
        page.setList(list);
        return page;
    }

    private Integer generateCilent(ImportBill bill) {
        if (bill.getClientCode() == null || bill.getClientCode().equals("") ||
                bill.getClientName() == null || bill.getClientName().equals("")) {
            return null;
        }
        if (!clientMapper.existByClientCode(bill.getClientCode())) {
            Client client = new Client();
            client.setCode(bill.getClientCode());
            client.setName(bill.getClientName());
            client.setRegional(bill.getRegional());
            client.setBusinessType(bill.getBusinessType());
            return clientMapper.insertSelective(client);
        }
        return null;
    }

    private Integer generateBill(ImportBill ib) {
        if (ib.getBillCode() == null || ib.getBillCode().equals("")) {
            return null;
        }
        if (!billMapper.existByBillCode(ib.getBillCode())) {
            Bill bill = new Bill();
            bill.setCode(ib.getBillCode());
            if (!ib.getNumber().equals("")) {
                bill.setNumber(Integer.parseInt(ib.getNumber()));
            }
            bill.setClientCode(ib.getClientCode());
            bill.setUserCode(ib.getSalesmanCode());
            bill.setDate(ib.getInvoiceDate());
            bill.setTwoLevelCode(ib.getTwoLevelCode());
            bill.setThreeLevelCode(ib.getThreeLevelCode());
            bill.setMedicineCode(ib.getMedicineCode());
            return billMapper.insertSelective(bill);
        }
        return null;
    }

    private Integer generateMedicine(ImportBill ib) {
        if (ib.getLotNumber() == null || ib.getLotNumber().equals("") ||
                ib.getMedicineCode() == null || ib.getMedicineCode().equals("")) {
            return null;
        }
        if (!medicineMapper.existByMedicineCodeAndLotNumber(ib.getMedicineCode(), ib.getLotNumber())) {
            Medicine medicine = new Medicine();
            medicine.setCode(ib.getMedicineCode());
            medicine.setName(ib.getMedicineName());
            medicine.setLotNumber(ib.getLotNumber());
            medicine.setSpecification(ib.getMedicineSpecification());
            medicine.setManufacturerName(ib.getManufacturerName());
            if (!ib.getPrice().equals("")) {
                medicine.setPrice(Float.parseFloat(ib.getPrice()));
            }
            medicine.setUnits(ib.getUnits());
            medicine.setValidityPeriod(ib.getValidityPeriod());
            return medicineMapper.insertSelective(medicine);
        }
        return null;
    }

    private Boolean generateSalesman(ImportBill ib) {
        if (ib.getSalesmanName() == null || ib.getSalesmanName().equals("") ||
                ib.getSalesmanCode() == null || ib.getSalesmanCode().equals("")) {
            return false;
        }
        if (!userMapper.existBySalesmanCode(ib.getSalesmanCode())) {
            User user = new User();
            user.setUsername(ib.getSalesmanName());
            user.setCode(ib.getSalesmanCode());
            user.setPassword("000000");
            user.setRole((byte) 2);
            userMapper.insertSelective(user);
            return true;
        }

        return false;
    }


    private Integer generateBillRich(ImportBill ib) {
        if (ib.getBillCode() == null || ib.getBillCode().equals("")) {
            return null;
        }
        if (!billRichMapper.existByBillCode(ib.getBillCode())) {
            BillRich bill = new BillRich();
            bill.setCode(ib.getBillCode());
            if (!ib.getNumber().equals("")) {
                bill.setNumber(Integer.parseInt(ib.getNumber()));
            }
            bill.setClientCode(ib.getClientCode());
            bill.setUserCode(ib.getSalesmanCode());
            bill.setDate(ib.getInvoiceDate());
            bill.setTwoLevelCode(ib.getTwoLevelCode());
            bill.setThreeLevelCode(ib.getThreeLevelCode());
            bill.setMedicineCode(ib.getMedicineCode());
            bill.setUserName(ib.getSalesmanName());
            bill.setMedicineName(ib.getMedicineName());
            bill.setClientName(ib.getClientName());
            return billRichMapper.insertSelective(bill);
        }
        return null;
    }


    private Boolean generateTwoLevelAgent(ImportBill ib) {
        if (ib.getTwoLevelCode() == null || ib.getTwoLevelCode().equals("")) {
            return false;
        }
        Agent agent = new Agent();
        agent.setName(ib.getTwoLevelName());
        agent.setCode(ib.getTwoLevelCode());
        agent.setLevel("2");
        return generateAgent(agent);
    }

    private Boolean generateThreeLevelAgent(ImportBill ib) {
        if (ib.getThreeLevelCode() == null || ib.getThreeLevelCode().equals("")) {
            return false;
        }
        Agent agent = new Agent();
        agent.setName(ib.getThreeLevelName());
        agent.setCode(ib.getThreeLevelCode());
        agent.setLevel("3");
        return generateAgent(agent);
    }

    private Boolean generateAgent(Agent agent) {

        if (!agentMapper.existByAgentCode(agent.getCode())) {
            agentMapper.insertSelective(agent);
            return true;
        }

        return false;
    }
}
