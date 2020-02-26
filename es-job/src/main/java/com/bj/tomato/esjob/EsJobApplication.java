package com.bj.tomato.esjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author sunfch
 * @description: spring boot启动，首先要启动zk
 * @date 2020/2/26 22:31
 */
@SpringBootApplication
public class EsJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsJobApplication.class, args);
    }

}
