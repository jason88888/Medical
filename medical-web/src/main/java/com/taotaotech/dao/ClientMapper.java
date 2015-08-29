package com.taotaotech.dao;

import com.taotaotech.domain.Client;
import org.apache.ibatis.annotations.Param;

public interface ClientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

    Boolean existByClientCode(@Param("code")String code);
}