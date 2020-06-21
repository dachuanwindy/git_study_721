package com.bj.tomato.esjob.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author sunfch
 * @version V1.0
 * @Description: TODO
 * @date 2020/6/21 19:12
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceProperties {
    private String url;
    private String username;
    private String password;

    @Bean
    @Primary
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}

