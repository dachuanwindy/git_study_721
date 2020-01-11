package com.bj.tomato.gitwebtest.dto.model;

import com.bj.tomato.gitwebtest.constant.ReturnCodeEnum;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/1/11 16:22
 */
public class ResponseUtils {
    /**
     * @description: 平台失败之后返回结果
     * @author sunfch
     * @date 2020/1/11 23:04
     */
    public static <T> PlateFormResponse plateFormResponseBuildFail(String code, String msg) {
        PlateFormResponse<T> response = new PlateFormResponse<T>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    /**
     * @description: 成功之后返回结果
     * @author sunfch
     * @date 2020/1/11 23:04
     */
    public static <T> PlateFormResponse plateFormResponseBuildSuccess(T data) {
        PlateFormResponse<T> response = new PlateFormResponse<>();
        response.setCode(ReturnCodeEnum.SUCCESS.getCode());
        response.setMsg(ReturnCodeEnum.SUCCESS.getMsg());
        response.setData(data);
        return response;
    }
}
