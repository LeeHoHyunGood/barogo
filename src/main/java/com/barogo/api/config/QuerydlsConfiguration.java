package com.barogo.api.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@Configuration
public class QuerydlsConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        log.info("QueryDSL load -> {}",entityManager.getDelegate().getClass());
        return new JPAQueryFactory(entityManager);
    }
}
