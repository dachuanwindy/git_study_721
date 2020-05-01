package com.bj.tomato.gitwebtest.dto.model.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 获取的所有产品属性
 * @date 2020/4/21 09:11
 */
@Data
public class ProductsQueryReq {

    @NotNull(message = "产品编码不能为空")
    private String code;

    @NotEmpty(message = "产品不能为空")
    private String productName;

    @Length(min = 0, max = 12)
    private String price;
}
