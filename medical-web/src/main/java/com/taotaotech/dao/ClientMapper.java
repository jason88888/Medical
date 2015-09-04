package com.taotaotech.dao;

import com.taotaotech.domain.Client;
import com.taotaotech.domain.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

    List<Client> findClientList();

    Boolean existByClientCode(@Param("code")String code);
}