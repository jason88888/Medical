package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.Client;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientMapper  extends CrudMapper<Client> {
    int deleteByPrimaryKey(Integer id);

    int delete(List<Integer> ids);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);

    List<Client> findClientList(PageBounds pageBounds);

    Boolean existByClientCode(@Param("code")String code);
}