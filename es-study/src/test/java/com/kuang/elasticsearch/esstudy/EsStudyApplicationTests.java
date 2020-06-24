package com.kuang.elasticsearch.esstudy;

import com.alibaba.fastjson.JSON;
import com.kuang.elasticsearch.esstudy.Dto.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class EsStudyApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;


    /**
     * @description: 创建索引, 就是创建数据库, index
     * @author sunfch
     * @date 2020/6/23 18:32
     */
    @Test
    void contextLoads() throws IOException {

        CreateIndexRequest request = new CreateIndexRequest("sun_index");
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
        System.out.println("哈哈哈哈哈");
    }


    /**
     * @description: 判断索引是否存在
     * @author sunfch
     * @date 2020/6/23 18:35
     */
    @Test
    void findIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest("sun_index");
        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * @description: 刪除索引
     * @author sunfch
     * @date 2020/6/23 18:44
     */
    @Test
    void deleteIndex() throws IOException {

        DeleteIndexRequest deleteRequest = new DeleteIndexRequest("sun_aa");
        try {
            AcknowledgedResponse delete = client.indices().delete(deleteRequest, RequestOptions.DEFAULT);
            System.out.println("========> delete" + delete);
        } catch (Exception e) {
            System.out.println("索引不存在");
        }
    }

    /**
     * @description: 添加文档
     * @author sunfch
     * @date 2020/6/23 18:56
     */
    @Test
    void addDocument() throws IOException {
        //创建索引
        for (int i = 1; i < 100; i++) {
            User user = new User("sunfengchuan" + i, i);
            IndexRequest request = new IndexRequest("sun_index");
            request.id("1" + i);
            request.timeout("1s");
            request.source(JSON.toJSON(user), XContentType.JSON);
            IndexResponse index = client.index(request, RequestOptions.DEFAULT);
            System.out.println(index.toString());
            //对应命令返回 ..这个结果是create
            System.out.println(index.status());
        }

    }

    /**
     * @description: 获取文档
     * @author sunfch
     * @date 2020/6/23 19:37
     */
    @Test
    void getDocument() throws IOException {


        GetRequest request = new GetRequest("sun_index", "2");
        //   request.fetchSourceContext(new FetchSourceContext(false));
        //  request.storedFields("_non_");
        boolean exists = client.exists(request, RequestOptions.DEFAULT);
        System.out.println("是否存在这条记录" + exists);
        GetResponse documentFields = client.get(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(documentFields));

    }


    /**
     * @description: 条件构造,
     * @author sunfch
     * @date 2020/6/23 20:06
     */
    @Test
    void testSearch() throws IOException {

        SearchRequest searchRequest = new SearchRequest("sun_index");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //精确匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("user", "sunfengchuan");
        SearchSourceBuilder query = searchSourceBuilder.query(termQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(search));
        System.out.println("输出的结果是====" + search.getHits());
    }

}
