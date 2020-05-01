package com.bj.tomato.common.ResultCode;

import lombok.Data;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 返回结果码描述
 * @date 2020/4/21 09:27
 */
@Data
public class ResultCode {

    private String code;
    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
