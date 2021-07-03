package com.bj.tomato.myservice.myservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class MyserviceApplication extends AbstractInit {

    @Test
    void contextLoads() {

        log.info("启动失败");
    }

}
