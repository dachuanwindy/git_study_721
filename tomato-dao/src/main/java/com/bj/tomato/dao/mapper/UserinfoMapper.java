package com.bj.tomato.dao.mapper;

import com.bj.tomato.dto.model.Userinfo;

public interface UserinfoMapper {
    int insert(Userinfo record);

    int insertSelective(Userinfo record);
}