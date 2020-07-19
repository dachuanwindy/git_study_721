package com.bj.tomato.gitwebtest.config.shard;

import com.google.code.shardbatis.strategy.ShardStrategy;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/7/14 20:21
 */
public class MyShardStd implements ShardStrategy {
    /**
     * 得到实际表名
     *
     * @param baseTableName 逻辑表名,一般是没有前缀或者是后缀的表名
     * @param params        mybatis执行某个statement时使用的参数
     * @param mapperId      mybatis配置的statement id
     * @return
     */
    @Override
    public String getTargetTableName(String baseTableName, Object params, String mapperId) {

        System.out.println("tableName---->" + baseTableName);
        System.out.println("params---->" + params);
        System.out.println("mapperId---->" + mapperId);

        return baseTableName + "_" + "1";
    }
}
