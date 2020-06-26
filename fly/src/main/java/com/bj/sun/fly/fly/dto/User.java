package com.bj.sun.fly.fly.dto;

import java.beans.ConstructorProperties;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 实现对象的初始化;
 * @date 2020/6/25 09:55
 */
public class User {

    private String userName;
    private String homeDress;
    private String idCard;
    private String bankCardNum;

    private String phoneNum;


    /**
     * description: 指定对象进行初始化.
     *
     * @param userName 姓名;
     * @param phoneNum 手机号;
     * @return
     */
    @ConstructorProperties({"userName", "phoneNum"})
    User(String userName, String phoneNum) {
        this.userName = userName;
        this.phoneNum = phoneNum;
    }
}
