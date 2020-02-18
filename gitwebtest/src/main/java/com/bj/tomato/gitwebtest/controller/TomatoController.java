package com.bj.tomato.gitwebtest.controller;

import com.bj.tomato.gitwebtest.dto.model.PlateFormResponse;
import com.bj.tomato.gitwebtest.dto.model.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
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

    // @Autowired
    //  private UserInfoService userInfoService;

    @RequestMapping(value = "test1")
    public String dataStr() {
        return "西红柿网开发中";
    }


    @GetMapping("response")
    public PlateFormResponse testPlateForm() {
        PlateFormResponse response = ResponseUtils.plateFormResponseBuildFail("1", "sunfengchuan ");
        return response;

    }


    @GetMapping(value = "mybatisTest/{id}")
    public PlateFormResponse mybatisTest(@PathVariable Long id) {
        //  Userinfo userInfo = userInfoService.getUserInfo(id);
        com.bj.tomato.dto.model.Userinfo userInfo2 = new com.bj.tomato.dto.model.Userinfo();
        // userinfoMapper22.select(userInfo2);
        //   return ResponseUtils.plateFormResponseBuildSuccess(userInfo);
        return null;
    }
}
