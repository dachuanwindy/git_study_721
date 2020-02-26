package com.bj.tomato.esjob.config;

import com.bj.tomato.esjob.job.FileSimpleJob;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/2/23 00:34
 */

@Configuration
@Slf4j
public class JobConfig {


    @Autowired
    private DataSource dataSource;

    @Autowired
    FileSimpleJob fileSimpleJob;

    @Autowired
    RegisterConfig registerConfig;


    private LiteJobConfiguration createJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                        final String cron,
                                                        final int shardingTotalCount,
                                                        final String shardingItemParameters) {
        //JobCoreConfigurationBuilder
        JobCoreConfiguration.Builder JobCoreConfigurationBuilder = JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount);
        //设置shardingItemParameters
        if (!StringUtils.isEmpty(shardingItemParameters)) {
            JobCoreConfigurationBuilder.shardingItemParameters(shardingItemParameters);
        }
        JobCoreConfiguration jobCoreConfiguration = JobCoreConfigurationBuilder.build();
        //创建SimpleJobConfiguration
        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, jobClass.getCanonicalName());
        //创建LiteJobConfiguration
        LiteJobConfiguration liteJobConfiguration = LiteJobConfiguration.newBuilder(simpleJobConfiguration).overwrite(true)
                .monitorPort(9888)//设置dump端口
                .build();
        return liteJobConfiguration;
    }

    @Bean(initMethod = "init")
    public SpringJobScheduler springJobScheduler() {

        //时间追踪，将信息写在数据库中
        JobEventConfiguration jobEventConfig = new JobEventRdbConfiguration(dataSource);

        //任务执行计划
        SpringJobScheduler springJobScheduler = new SpringJobScheduler(fileSimpleJob,
                registerConfig.registryCenter(),
                createJobConfiguration(fileSimpleJob.getClass(), "0/10 * * * * ?", 4, "0=text,1=image,2=radio,3=vedio"),
                jobEventConfig);
        return springJobScheduler;
    }

}
