package com.bj.tomato.gitwebtest.dto.mapper;

import com.bj.tomato.gitwebtest.dto.model.Userinfo;

public interface UserinfoMapper {
    int insert(Userinfo record);

    int insertSelective(Userinfo record);
}