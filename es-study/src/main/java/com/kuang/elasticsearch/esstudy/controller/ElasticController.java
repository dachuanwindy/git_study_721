package com.kuang.elasticsearch.esstudy.controller;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/18 17:51
 */
@RestController
@RequestMapping("es")
public class ElasticController {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @RequestMapping(value = "create")
    public String createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("kuang_sun");
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(response));
        return JSON.toJSONString(response);
    }

    /**
     * @description: 采坑总结: 采用了低版本的es 而是用了高版本的esclient 导致查询报错.
     * @author sunfch
     * @date 2020/7/18 18:12
     */
    @RequestMapping(value = "createok")
    public String createIndexOk() throws IOException {
        GetIndexRequest request = new GetIndexRequest("kuang_sun");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
        return JSON.toJSONString(exists);
    }

}
