package com.bj.tomato.gitwebtest.constant;

import java.beans.ConstructorProperties;

public enum ReturnCodeEnum {

    SUCCESS("0", "成功"),
    FAIL("1", "失败"),
    PROC("2", "处理中"),
    ERROR("9", "系统异常"),
    ;


    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    @ConstructorProperties({"code", "message"})
    private ReturnCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
