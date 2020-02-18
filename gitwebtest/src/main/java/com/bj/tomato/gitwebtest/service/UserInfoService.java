package com.bj.tomato.gitwebtest.service;

import com.bj.tomato.gitwebtest.dto.model.Userinfo;
import org.springframework.stereotype.Service;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 用户基本信息查询
 * @date 2020/1/7 00:02
 */

@Service
public interface UserInfoService {


    /**
     * @Param: id
     * @return: userInfo
     * @Author: sunfch
     * @Date: 2020/1/12
     */
    Userinfo getUserInfo(Long id);
}
