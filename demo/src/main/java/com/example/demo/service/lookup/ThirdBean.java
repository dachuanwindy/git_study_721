package com.example.demo.service.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2021/4/24 18:00
 */
@Component
public class ThirdBean {
    @Autowired
    private SingleTonBean singleTonBean;

    // 备注:期望这个是原型模式,每次获取的bean都是不一样的;
    public SingleTonBean getSingleTonBean() {
        return singleTonBean;
    }

    @Lookup
    public ProtoTypeBean getProtoTypeBean() {
        return null;
    }

}
