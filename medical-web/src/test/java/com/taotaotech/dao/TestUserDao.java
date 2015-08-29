package com.taotaotech.dao;

import com.taotaotech.core.utils.JsonUtil;
import com.taotaotech.domain.User;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Cailin.Chen
 * @Date 15/8/23
 * @eMail cailin618@sina.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:conf/spring-mybatis.xml")
public class TestUserDao {
    private static Logger logger = Logger.getLogger(TestUserDao.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByPriKey(){
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(JsonUtil.clazz2Json(user));
        System.out.println(user.toString());
    }
}
