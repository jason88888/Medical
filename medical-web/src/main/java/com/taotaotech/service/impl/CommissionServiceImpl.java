package com.taotaotech.service.impl;

import com.taotaotech.core.utils.DateUtil;
import com.taotaotech.dao.*;
import com.taotaotech.domain.MedicinePolicy;
import com.taotaotech.dto.BillRich;
import com.taotaotech.dto.Commission;
import com.taotaotech.service.ICommissionService;
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
    public List<Commission> findCommissionList() {
        List<Commission> commissionList = null;
        ArrayList<BillRich> billList = (ArrayList<BillRich>) billRichMapper.findBillList();
        if (billList.size() != 0) {
            commissionList = new ArrayList<>();
        }
        //TODO 根据一个单据，查询一个政策，生成一条佣金结算
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
            if (policy.getPrice() != null) {
                commission.setSalesmanCharge("" + (billRich.getNumber() * policy.getPrice()));
            }
            commissionList.add(commission);
        }
        return commissionList;
    }
}
