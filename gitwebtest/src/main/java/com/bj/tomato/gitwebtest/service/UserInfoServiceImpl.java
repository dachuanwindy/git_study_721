package com.bj.tomato.gitwebtest.service;

import com.bj.tomato.gitwebtest.dto.model.Userinfo;
import org.springframework.stereotype.Service;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 用户基本信息查询实现
 * @date 2020/1/7 00:03
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {


    //  @Resource
    //   private UserinfoMapper userinfoMapper;

    /**
     * 实现获取Mybatis中的最新消息
     *
     * @Param: id
     * @return: userInfo
     * @Author: sunfch
     * @Date: 2020/1/12
     */
    @Override
    public Userinfo getUserInfo(Long id) {
        // Userinfo userinfo = userinfoMapper.querUserInfo(id);
        return null
                ;
    }
}
