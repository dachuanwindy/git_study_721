package com.kuang.elasticsearch.esstudy.Dto;

import lombok.Data;

import java.util.Date;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/19 09:23
 */

@Data
public class UserDto {

    private String user;
    private Date postDate;
    private String message;
}
