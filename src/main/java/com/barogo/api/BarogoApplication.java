package com.barogo.api;

import com.barogo.api.common.CommonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import javax.persistence.Entity;

@SpringBootApplication(exclude = { JacksonAutoConfiguration.class })
@EntityScan(basePackages = {CommonConfiguration.PROJECT_DOMAIN})
@ComponentScan(basePackages = {CommonConfiguration.PROJECT_ROOT},
        excludeFilters = {
                @ComponentScan.Filter(value = Entity.class, type = FilterType.ANNOTATION)
        }
)
public class BarogoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BarogoApplication.class, args);
    }

}
