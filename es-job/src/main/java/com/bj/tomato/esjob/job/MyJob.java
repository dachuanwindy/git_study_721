package com.bj.tomato.esjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 实现我自己的作业
 * @date 2020/6/21 19:35
 */

@Component
@Slf4j
public class MyJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        //分片参数, 主要是通过这个参数实现对不同分片执行不同的任务.  shardingParam 对不同的业务进行细分
        String shardingParameter = shardingContext.getShardingParameter();
        log.info("任务ID=={} 当前的是哪个分片===={}, 设置的参数是=={}", shardingContext.getTaskId(), shardingContext.getShardingItem(), shardingParameter);
        log.info("输出配置信息===={}", shardingContext.toString());
        String name = Thread.currentThread().getName();
        System.out.println("当前线程的名字是====>>>>>>>>" + name);

    }
}
