package com.kuang.elasticsearch.esstudy;

import com.alibaba.fastjson.JSON;
import com.kuang.elasticsearch.esstudy.Dto.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.compress.CompressedXContent;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EsStudyApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;


    /**
     * @description: 创建索引, 就是创建数据库, index
     * @author sunfch
     * @date 2020/6/23 18:32
     * <p>
     * curl 'localhost:9200/_cat/indices?v'  判断索引是否已经创建成功
     */
    @Test
    void contextLoads() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("kuang_sun");
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
        System.out.println("哈哈哈哈哈");
    }


    /**
     * @description: 添加数据到ES库中
     * @author sunfch
     * @date 2020/7/19 09:20
     */
    @Test
    public void addIndex() throws IOException {
        // 这个是通过Map进行的.
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy222");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch2222222");
        IndexRequest indexRequest = new IndexRequest("kuang_sun").id("2").source(jsonMap);

        IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(index));
        System.out.println(index.getIndex());
        client.close();
    }

    /**
     * @description: 添加数据的第二种方式
     * @author sunfch
     * @date 2020/7/19 09:21
     */
    @Test
    public void addData2() throws IOException {

//        UserDto userDto = new UserDto();
//        userDto.setUser("sun");
//        userDto.setPostDate(new Date());
//        userDto.setMessage("this is first data");
        User userDto = new User("sunf", 14);
        IndexRequest indexRequest = new IndexRequest("kuang_sun").id("4").source(JSON.toJSONString(userDto), XContentType.JSON);
        IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(index));
        System.out.println(index.getIndex());
        client.close();

    }


    /**
     * @description:
     * @author sunfch
     * @date 2020/7/18 18:42
     */
    @Test
    public void queryStoreData() throws IOException {

        GetIndexRequest request = new GetIndexRequest("sun_index2");
        GetIndexResponse response = client.indices().get(request, RequestOptions.DEFAULT);
        CompressedXContent sun_index2 = response.getMappings().get("sun_index2").source();
        byte[] compressed = sun_index2.compressed();
        byte[] sun_index2s = response.getMappings().get("sun_index2").source().uncompressed();

        System.out.println(response);

        String s = new String(sun_index2s, "UTF-8");
        System.out.println(s);
        System.out.println();


    }

    /**
     * @description: 判断索引是否存在
     * @author sunfch
     * @date 2020/6/23 18:35
     */
    @Test
    void findIndex() throws IOException {

        GetIndexRequest getIndexRequest = new GetIndexRequest("sun_index2");
        boolean exists1 = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists1);
    }

    /**
     * @description: 刪除索引
     * @author sunfch
     * @date 2020/6/23 18:44
     */
    @Test
    void deleteIndex() throws IOException {

        DeleteIndexRequest deleteRequest = new DeleteIndexRequest("sun_index2");
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
            IndexRequest request = new IndexRequest("kuang_sun");
            request.id("1" + i);
            request.timeout("1s");
            request.create(true);
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

        //组织信息;
        User user = new User("sunTest", 12);
        IndexRequest addReq = new IndexRequest("sun_index2");
        addReq.id("12345");
        addReq.timeout("2s");
        addReq.source(JSON.toJSON(user), XContentType.JSON);
        //执行add 插入数据到数据库, 这个ID 就可以作为全局唯一ID,执行快速搜索,
        IndexResponse index = client.index(addReq, RequestOptions.DEFAULT);
        System.out.println("输出添加信息的相应");
        System.out.println(JSON.toJSONString(index));


        // 获取信息,主要是获取source信息;
        GetRequest request = new GetRequest("sun_index2", "12345");
        boolean exists = client.exists(request, RequestOptions.DEFAULT);
        System.out.println("是否存在这条记录" + exists);
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());

    }

    /**
     * @description: 删除数据, 实现了前端数据的修改
     * @author sunfch
     * @date 2020/7/19 00:02
     */
    @Test
    void deleteData() throws IOException {

        DeleteRequest request = new DeleteRequest("sun_index2", "12345");
        DeleteResponse delete = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.status());
    }

    /**
     * @description: 更新数据, 首先要有数据, 然后才能更新
     * @author sunfch
     * @date 2020/7/19 00:06
     */
    @Test
    void updateData() throws IOException {
        UpdateRequest sun_index2 = new UpdateRequest("sun_index2", "1232");
        User user = new User("lilei", 12);
        sun_index2.doc(JSON.toJSON(user), XContentType.JSON);
        UpdateResponse update = client.update(sun_index2, RequestOptions.DEFAULT);
        System.out.println(update.status());
        System.out.println(JSON.toJSONString(update));

        // 修改完对象之后,获取对象;
        GetRequest request = new GetRequest("sun_index2", "1232");
        GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
        System.out.println(getResponse.getSourceAsString());
        Map<String, Object> source = getResponse.getSource();
        System.out.println(source.toString());

    }


    /**
     * @description: 批量插入删除指令
     * @author sunfch
     * @date 2020/7/19 00:15
     */
    @Test
    void batchInsert() throws IOException {
        BulkRequest request = new BulkRequest("sun_index2");
        for (int i = 0; i < 10; i++) {
            IndexRequest request1 = new IndexRequest();
            request1.source(JSON.toJSON(new User("sun_" + i, 100 + i)), XContentType.JSON);
            request1.id("123" + i);
            request.add(request1);
        }
        BulkResponse bulk = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(bulk.status());
        System.out.println(JSON.toJSONString(bulk));
    }

    /**
     * @description: 条件构造,
     * @author sunfch
     * @date 2020/6/23 20:06
     */
    @Test
    void testSearch() throws IOException {

        SearchRequest searchRequest = new SearchRequest("kuang_sun");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        //精确匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("user", "sunf");
        SearchSourceBuilder query = searchSourceBuilder.query(termQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(search));
        System.out.println("输出的结果是====" + search.getHits());
    }


    /**
     * @description: 查询, 这个地方
     * @author sunfch
     * @date 2020/7/19 00:29
     */
    @Test
    void searchTest2() throws IOException {


        SearchRequest searchRequest = new SearchRequest("kuang_sun");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("user", "sunf");

        // 全局搜素,搜索出全部来
        // MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        SearchSourceBuilder query = builder.query(termQueryBuilder);
        searchRequest.source(query);
        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(search.status());
        System.out.println(JSON.toJSONString(search.getHits()));
        System.out.println(JSON.toJSONString(search));
        System.out.println("-------------------------");

        SearchHits hits = search.getHits();
        for (SearchHit t : hits) {
            System.out.println(t.getSourceAsMap());
        }
    }


    //模糊查询
    @Test
    void FuzzySearch() throws IOException {
        SearchRequest request = new SearchRequest("kuang_sun");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("message", "out");
        sourceBuilder.query(fuzzyQueryBuilder);
        request.source(sourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        System.out.println(response.status());
        System.out.println(response.getHits().toString());
        System.out.println("----------------------->");

        SearchHit[] hits = response.getHits().getHits();
        for (int i = 0; i < hits.length; i++) {
            System.out.println(hits[i]);
        }
    }

}
