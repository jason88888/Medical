package com.taotaotech.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.taotaotech.core.persistence.CrudMapper;
import com.taotaotech.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends CrudMapper<User> {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUsername(@Param("username")String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Boolean existBySalesmanCode(@Param("code")String code);
}