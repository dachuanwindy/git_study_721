package com.bj.tomato.esjob.config;

import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 注册中心，连接到zookeeper中 这个是任务调度系统关键
 *
 * 任务调度的灵魂，实现了分布式锁，任务的分配，分片信息的编写
 * @date 2020/2/23 00:16
 */
@Configuration
@Slf4j
public class RegisterConfig {

    /**
     * 连接到zookeeper的本地地址；
     */
    private String ZOOKEEPER_CONNECTION_STRING = "localhost:2181";
    /**
     * 定时任务命名空间
     */
    private String JOB_NAMESPACE = "elastic-job-example-java";


    /**
     * @description: 初始化zookeeper 连接信息，注册中心
     * @author sunfch
     * @date 2020/2/23 00:24
     */
    @Bean(initMethod = "init")
    public CoordinatorRegistryCenter registryCenter() {
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(ZOOKEEPER_CONNECTION_STRING, JOB_NAMESPACE);
        ZookeeperRegistryCenter zookeeperRegistryCenter = new ZookeeperRegistryCenter(zookeeperConfiguration);
        return zookeeperRegistryCenter;
    }

}
