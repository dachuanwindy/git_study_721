package com.bj.tomato.gitwebtest.dto.model.request;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 获取的所有产品属性
 * @date 2020/4/21 09:11
 */
@Data
public class ProductsQueryReq {

    @NotNull
    private String code;

    @NotEmpty(message = "产品不能为空")
    private String productName;

    private String price;
}
