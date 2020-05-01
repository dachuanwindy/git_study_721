package com.bj.tomato.gitwebtest.exception;

import lombok.Data;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/4/21 09:04
 */
@Data
public class MyException extends RuntimeException {

    private String code;

    private String msg;

    public MyException(String code, String msg) {
        super(code + "_" + msg);
        this.code = code;
        this.msg = msg;
    }
}
