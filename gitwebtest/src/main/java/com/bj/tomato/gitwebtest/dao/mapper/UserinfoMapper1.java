package com.bj.tomato.gitwebtest.dao.mapper;

import com.bj.tomato.gitwebtest.dto.model.Userinfo;

/**
 * @author sunfch
 * @description: 用户基本信息表
 * @date 2020/1/6 23:59
 */
public interface UserinfoMapper1 {
    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo querUserInfo(Long id);


}