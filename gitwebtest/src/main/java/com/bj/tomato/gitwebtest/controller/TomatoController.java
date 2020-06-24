package com.bj.tomato.gitwebtest.controller;

import com.bj.tomato.gitwebtest.dto.model.PlateFormResponse;
import com.bj.tomato.gitwebtest.dto.model.ResponseUtils;
import com.bj.tomato.gitwebtest.dto.model.Userinfo;
import com.bj.tomato.gitwebtest.dto.model.request.ProductsQueryReq;
import com.bj.tomato.gitwebtest.service.UserInfoService;
import com.bj.tomato.gitwebtest.util.paramvalid.ParamValid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 西红柿网首页测试
 * @date 2020/1/4 02:26
 */

@RestController
@Slf4j
@RequestMapping(value = "tomato")
public class TomatoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "test1")
    public String dataStr() {
        return "西红柿网开发中";
    }


    @GetMapping("response")
    public PlateFormResponse testPlateForm() {
        PlateFormResponse response = ResponseUtils.plateFormResponseBuildFail("1", "sunfengchuan ");
        return response;

    }


    @GetMapping(value = "/mybatisTest/{id}")
    public PlateFormResponse mybatisTest(@PathVariable Long id) {
        Userinfo userInfo = userInfoService.getUserInfo(1L);
        PlateFormResponse<Userinfo> response = new PlateFormResponse<>();
        response.setData(userInfo);
        return response;
    }

    /**
     * description: 查询产品属性信息
     *
     * @param productsQueryReq
     * @return com.bj.tomato.gitwebtest.dto.model.PlateFormResponse
     */
    @RequestMapping(value = "valid")
    public PlateFormResponse validData(ProductsQueryReq productsQueryReq) {

        ParamValid.volidateToException(productsQueryReq);
        PlateFormResponse response = new PlateFormResponse();
        response.setCode("11");
        response.setMsg("12333");
        response.setData(productsQueryReq);
        return response;
    }
}
