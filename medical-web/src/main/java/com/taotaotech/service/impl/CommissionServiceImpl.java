package com.taotaotech.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.utils.DateUtil;
import com.taotaotech.core.utils.MapUtil;
import com.taotaotech.dao.*;
import com.taotaotech.domain.MedicinePolicy;
import com.taotaotech.dto.BillRich;
import com.taotaotech.dto.Commission;
import com.taotaotech.service.ICommissionService;
import com.taotaotech.service.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class CommissionServiceImpl implements ICommissionService {
    @Autowired
    private BillRichMapper billRichMapper;

    @Autowired
    private MedicinePolicyMapper medicinePolicyMapper;

    @Override
    public Page<Commission> findCommissionList(Page page,BillRich billR) {
        Map billMap =  MapUtil.bean2Map(billR);
        List<Commission> commissionList = null;
        List<BillRich> billList =  billRichMapper.findBillList(billMap,page.createPageBounds());
        if (billList.size() != 0) {
            commissionList = new ArrayList<>();
        }
        calculatePrice(billList,commissionList);
         page.setList(commissionList);
        return page;
    }

    private void calculatePrice(List<BillRich> billList,List<Commission> commissionList){
        for (int i = 0; i < billList.size(); i++) {
            BillRich billRich = billList.get(i);
            //根据日期生成月份
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            Date date = DateUtil.getDate(billRich.getDate(), DateUtil.FORMAT_YYYYMMDD);
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            MedicinePolicy policy = medicinePolicyMapper.getPolicyByMonthAndClientAndMedicine(billRich.getClientCode(),
                    billRich.getMedicineCode(), year + "/" + month);
            if (policy == null) {//没找到对应的政策
                continue;
            }else{
                //TODO 如何提醒客户该单据没有对应政策
            }
            Commission commission = new Commission();
            commission.setId(billRich.getId());
            commission.setMedicineCode(billRich.getMedicineCode());
            commission.setMedicineName(billRich.getMedicineName());
            commission.setClientCode(billRich.getClientCode());
            commission.setClientName(billRich.getClientName());
            commission.setInvoiceDate(billRich.getDate());
            commission.setSalesmanName(billRich.getUserName());
            //业务
            /*
        药品编码 药品名称 客户码 终端名称 月份(开票日期) 业务员姓名  业务员费用 二级费用 三级费用
        厂家费用 附加费用1 附加费用2 附加费用3 营业额 总费用
        */
            if (policy.getPrice() != null && billRich.getNumber() != null) {
                float salesmanCharge = billRich.getNumber() * policy.getSalesmanPolicy();
                float twoLevelCharge = billRich.getNumber() * policy.getTwoLevelPolicy();
                float threeLevelCharge = billRich.getNumber() * policy.getThreeLevelPolicy();
                float manufacturerCharge = billRich.getNumber() * policy.getManufacturerPolicy();
                float clinicalCharge = billRich.getNumber() * policy.getClinicalPolicy();
                float addCharge1 = billRich.getNumber() * policy.getAddPolicy1();
                float addCharge2 = billRich.getNumber() * policy.getAddPolicy2();
                float addCharge3 = billRich.getNumber() * policy.getAddPolicy3();
                commission.setSalesmanCharge("" + salesmanCharge);
                commission.setTwoLevelCharge("" + twoLevelCharge);
                commission.setThreeLevelCharge("" + threeLevelCharge);
                commission.setManufacturerCharge("" + manufacturerCharge);
                commission.setClinicalCharge("" + clinicalCharge);
                commission.setAddCharge1("" + addCharge1);
                commission.setAddCharge2("" + addCharge2);
                commission.setAddCharge3("" + addCharge3);
                commission.setBusinessFee("" + (billRich.getNumber() * policy.getPrice()));
                commission.setTotalCharge("" + (salesmanCharge + twoLevelCharge + threeLevelCharge + manufacturerCharge +
                        clinicalCharge + addCharge1 + addCharge2 + addCharge3));
            } else {
                //TODO 数据有误,有脏数据
                continue;
            }
            commissionList.add(commission);
        }
    }

    private Commission initCommission(){
        Commission commission = new Commission();
        commission.setSalesmanCharge("0" );
        commission.setTwoLevelCharge("0" );
        commission.setThreeLevelCharge("0" );
        commission.setManufacturerCharge("0" );
        commission.setClinicalCharge("0" );
        commission.setAddCharge1("0" );
        commission.setAddCharge2("0" );
        commission.setAddCharge3("0" );
        commission.setBusinessFee("0" );
        commission.setTotalCharge("0");
        return commission;
    }
    @Override
    public Commission statisticsCommission(BillRich billRich) {

        Map billMap =  MapUtil.bean2Map(billRich);
        List<Commission> commissionList = null;
        List<BillRich> billList =  billRichMapper.findBillList(billMap,new PageBounds());
        if (billList.size() != 0) {
            commissionList = new ArrayList<>();
        }
        calculatePrice(billList, commissionList);
        Commission countCommission = initCommission();

        if (commissionList.size()>0){
            for (int index = 0; index < commissionList.size(); index++) {
                Commission commission = commissionList.get(index);

                countCommission.setSalesmanCharge(""+(Float.parseFloat(countCommission.getSalesmanCharge()) + Float.parseFloat(commission.getSalesmanCharge())));
                countCommission.setTwoLevelCharge("" + (Float.parseFloat(countCommission.getTwoLevelCharge()) + Float.parseFloat(commission.getTwoLevelCharge())));
                countCommission.setThreeLevelCharge("" + (Float.parseFloat(countCommission.getThreeLevelCharge()) + Float.parseFloat(commission.getThreeLevelCharge())));
                countCommission.setManufacturerCharge("" + (Float.parseFloat(countCommission.getManufacturerCharge()) + Float.parseFloat(commission.getManufacturerCharge())));
                countCommission.setClinicalCharge("" + (Float.parseFloat(countCommission.getClinicalCharge()) + Float.parseFloat(commission.getClinicalCharge())));
                countCommission.setAddCharge1("" + (Float.parseFloat(countCommission.getAddCharge1()) + Float.parseFloat(commission.getAddCharge1())));
                countCommission.setAddCharge2("" + (Float.parseFloat(countCommission.getAddCharge2()) + Float.parseFloat(commission.getAddCharge2())));
                countCommission.setAddCharge3("" + (Float.parseFloat(countCommission.getAddCharge3()) + Float.parseFloat(commission.getAddCharge3())));
                countCommission.setBusinessFee("" + (Float.parseFloat(countCommission.getBusinessFee()) + Float.parseFloat(commission.getBusinessFee())));
                countCommission.setTotalCharge("" + (Float.parseFloat(countCommission.getTotalCharge()) + Float.parseFloat(commission.getTotalCharge())));
            }
        }
        return countCommission;
    }
}
