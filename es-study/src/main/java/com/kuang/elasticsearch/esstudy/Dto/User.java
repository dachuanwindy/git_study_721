package com.kuang.elasticsearch.esstudy.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 实例对象, 这个就是存储到es的对象
 * @date 2020/6/23 18:57
 */
@Data
@AllArgsConstructor
public class User {

    private String user;

    private int age;
}
