package com.barogo.api.config;

import com.barogo.api.common.CommonConfiguration;
import com.barogo.api.common.JpaExpdSimpleRepository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Slf4j
@EnableJpaRepositories(basePackages = {CommonConfiguration.PROJECT_DOMAIN},repositoryBaseClass = JpaExpdSimpleRepository.class)
public class JpaConfiguration {

    @Primary
    @Bean(name = "dataSource")
    public HikariDataSource dataSource() {
        return dataSourceInit();
    }

    private HikariDataSource dataSourceInit() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(CommonConfiguration.JDBC_URL);
        config.setUsername(CommonConfiguration.JDBC_USERNAME);
        config.setPassword(CommonConfiguration.JDBC_PWD);
        config.setMaximumPoolSize(CommonConfiguration.JDBC_MAX_POOL_SIZE);
        config.setMinimumIdle(CommonConfiguration.JDBC_MINIMUM_IDLE);
        return new HikariDataSource( config );
    }
}
