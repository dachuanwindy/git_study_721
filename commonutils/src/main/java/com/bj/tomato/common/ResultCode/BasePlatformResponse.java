package com.bj.tomato.common.ResultCode;

import lombok.Data;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/4/21 09:42
 */
@Data
public class BasePlatformResponse<T> {
    private String code;
    private String msg;
    private T data;


}
