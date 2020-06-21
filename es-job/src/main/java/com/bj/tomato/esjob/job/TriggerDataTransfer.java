package com.bj.tomato.esjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 触发调用电子签章接口
 * @date 2020/6/21 19:52
 */
@Slf4j
@Component
public class TriggerDataTransfer implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {

    }
}