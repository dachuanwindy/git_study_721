package com.bj.tomato.gitwebtest.controller;

import com.bj.tomato.gitwebtest.dao.mapper.UserinfoMapper1;
import com.bj.tomato.gitwebtest.dto.model.Userinfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 实现debug Mybatis
 * @date 2020/6/24 22:59
 */
@SpringBootTest
@Slf4j
public class MybatisTest {

    @Autowired
    SqlSessionFactory sqlSessionFactory;


    @Test
    void queryTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserinfoMapper1 mapper = sqlSession.getMapper(UserinfoMapper1.class);
        Userinfo userinfo = mapper.querUserInfo(1L);
    }


}
