package com.taotaotech.service;

import com.taotaotech.domain.Agent;
import com.taotaotech.dto.Commission;

import java.util.List;

/**
 * @author zk
 * @date 2015/9/4 10:04
 * @description
 */
public interface ICommissionService {
    public List<Commission> findCommissionList();
}
