package com.bj.tomato.common.ResultCode;

import lombok.Getter;

/**
 * @author sunfch
 * @description: 错误码枚举值
 * @date 2020/4/21 09:37
 */

@Getter
public enum ResultEnum {

    SUCCESS("000", "成功"),
    FAILED("001", "失败"),
    SYSTEM_ERROR("002", "系统异常"),
    PARAM_ERROR("003", "参数异常"),
    ;

    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
