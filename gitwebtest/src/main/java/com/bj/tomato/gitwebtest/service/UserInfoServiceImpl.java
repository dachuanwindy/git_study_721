package com.bj.tomato.gitwebtest.service;

import com.alibaba.fastjson.JSON;
import com.bj.tomato.gitwebtest.dao.mapper.UserinfoMapper1;
import com.bj.tomato.gitwebtest.dto.model.Userinfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 用户基本信息查询实现
 * @date 2020/1/7 00:03
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {


    @Resource
    UserinfoMapper1 mapper;

    @Override
    public Userinfo getUserInfo(Long id) {
        Userinfo userinfo = mapper.querUserInfo(1L);
        log.info("输出的结果是===={}", JSON.toJSONString(userinfo));
        return userinfo;
    }
}
