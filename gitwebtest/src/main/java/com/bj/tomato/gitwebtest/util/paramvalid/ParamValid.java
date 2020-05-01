package com.bj.tomato.gitwebtest.util.paramvalid;

import com.bj.tomato.common.ResultCode.BasePlatformResponse;
import com.bj.tomato.common.ResultCode.PlateResponseUtil;
import com.bj.tomato.common.ResultCode.ResultEnum;
import com.bj.tomato.gitwebtest.exception.MyException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.*;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 参数校验, 通过注解方式校验
 * <p>
 * 实现原理:通过代理复现这个类,然后通过这个类的注解,判断其参数
 * @date 2020/4/21 09:02
 */
public class ParamValid {
    public ParamValid() {
    }


    public static <T> List<ConstraintViolation<T>> validate(T t) {
        List<ConstraintViolation<T>> list = new ArrayList();
        if (t != null) {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<T>> violations = validator.validate(t, new Class[0]);
            Iterator<ConstraintViolation<T>> iter = violations.iterator();
            if (iter.hasNext()) {
                ConstraintViolation<T> cv = (ConstraintViolation) iter.next();
                list.add(cv);
            }
        }

        return list;
    }

    public static <T> Map<String, String> validateToMap(T t) {
        Map<String, String> errorMap = new HashMap();
        if (t != null) {
            List<ConstraintViolation<T>> list = validate(t);
            if (list != null && list.size() > 0) {
                Iterator var3 = list.iterator();

                while (var3.hasNext()) {
                    ConstraintViolation<T> cv = (ConstraintViolation) var3.next();
                    String filedName = cv.getPropertyPath().toString();
                    String message = cv.getMessage();
                    errorMap.put(filedName, message);
                }
            }
        }

        return errorMap;
    }

    public static void volidateToException(Object t) {
        Map<String, String> result = validateToMap(t);
        if (null != result && result.size() > 0) {
            Set<String> keySet = result.keySet();
            Iterator var3 = keySet.iterator();
            if (var3.hasNext()) {
                String key = (String) var3.next();
                System.out.format("PARAM_INVALID:{%s}-{%s}", key, result.get(key));
                throw new MyException(ResultEnum.PARAM_ERROR.getCode(), result.get(key));
            }
        }
    }

    /**
     * description:
     *
     * @param t
     * @return com.bj.tomato.common.ResultCode.BasePlatformResponse
     */
    public static BasePlatformResponse validParam(Object t) {
        try {
            volidateToException(t);
        } catch (MyException e) {
            return PlateResponseUtil.paramFailure(e.getMsg());
        } catch (Exception e) {
            return PlateResponseUtil.buildFailure();
        }
        return null;
    }
}


