package com.bj.tomato.common.ResultCode;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/4/21 10:31
 */
public class PlateResponseUtil {

    public PlateResponseUtil() {
    }

    /**
     * description:  成功
     *
     * @param
     * @return com.bj.tomato.common.ResultCode.BasePlatformResponse
     */
    public static <T> BasePlatformResponse buildSuccess() {
        BasePlatformResponse<T> response = new BasePlatformResponse<>();
        response.setCode(ResultEnum.SUCCESS.getCode());
        response.setMsg(ResultEnum.SUCCESS.getMsg());
        return response;
    }

    /**
     * description: 返回失败
     *
     * @param
     * @return com.bj.tomato.common.ResultCode.BasePlatformResponse
     */
    public static <T> BasePlatformResponse buildFailure() {
        BasePlatformResponse<T> response = new BasePlatformResponse<>();
        response.setCode(ResultEnum.FAILED.getCode());
        response.setMsg(ResultEnum.FAILED.getMsg());
        return response;
    }

    /**
     * description: 参数检查错误
     *
     * @param
     * @return com.bj.tomato.common.ResultCode.BasePlatformResponse
     */
    public static <T> BasePlatformResponse paramFailure(String msg) {
        BasePlatformResponse<T> response = new BasePlatformResponse<>();
        response.setCode(ResultEnum.PARAM_ERROR.getCode());
        response.setMsg(msg);
        return response;
    }

    public static <T> BasePlatformResponse paramFailure() {
        BasePlatformResponse<T> response = new BasePlatformResponse<>();
        response.setCode(ResultEnum.PARAM_ERROR.getCode());
        response.setMsg(ResultEnum.PARAM_ERROR.getMsg());
        return response;
    }
}
