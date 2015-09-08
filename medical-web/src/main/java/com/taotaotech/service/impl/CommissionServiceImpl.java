package com.taotaotech.service.impl;

import com.taotaotech.dao.AgentMapper;
import com.taotaotech.dao.BillMapper;
import com.taotaotech.dao.CommissionMapper;
import com.taotaotech.domain.Agent;
import com.taotaotech.domain.Bill;
import com.taotaotech.dto.Commission;
import com.taotaotech.service.IAgentService;
import com.taotaotech.service.ICommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:06
 * @description
 */
@Service
public class CommissionServiceImpl implements ICommissionService {
    @Autowired
    private BillMapper billMapper;

    @Override
    public List<Commission> findCommissionList() {
        List<Commission> commissionList = null;
        ArrayList<Bill> billList = (ArrayList<Bill>) billMapper.findBillList();
        if (billList.size() != 0) {
            commissionList = new ArrayList<>();
        }
        //TODO 根据一个单据，查询一个政策，生成一条佣金结算
        /*
        药品编码 药品名称 客户码 终端名称 月份(开票日期) 业务员姓名  业务员费用 二级费用 三级费用
        厂家费用 附加费用1 附加费用2 附加费用3 营业额 总费用
        */

        return commissionList;
    }
}
