package com.kuang.elasticsearch.esstudy.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 配置文件
 * @date 2020/6/23 18:01
 */

@Configuration
public class EsConfig {

    /**
     * description: 初始化客户端
     *
     * @param
     * @return org.elasticsearch.client.RestHighLevelClient
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {

        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("localhost", 9200, "http")));

        return restHighLevelClient;

    }
}
