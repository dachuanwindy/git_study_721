package com.bj.tomato.esjob.job;


import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 任务调度子任务，就是在这执行任务的
 * @date 2020/2/22 23:27
 */

@Component
@Slf4j
public class FileSimpleJob implements SimpleJob {

    /**
     * description:
     *
     * @param shardingContext
     * @return void
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        String shardingParameter = shardingContext.getShardingParameter();
        log.info("这就是任务调度系统实现");
    }
}
