package com.taotaotech.dao.user;

import com.taotaotech.domain.user.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUsername(@Param("username")String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}