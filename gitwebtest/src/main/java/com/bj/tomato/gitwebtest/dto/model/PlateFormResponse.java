package com.bj.tomato.gitwebtest.dto.model;

import lombok.Data;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 标准输出
 * @date 2020/1/11 16:48
 */

@Data
public class PlateFormResponse<T> {
    private String code;
    private String msg;
    private T data;

}
