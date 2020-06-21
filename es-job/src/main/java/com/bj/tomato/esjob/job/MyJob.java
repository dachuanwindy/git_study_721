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
        log.info("输出配置信息===={}", shardingContext.toString());
    }
}
