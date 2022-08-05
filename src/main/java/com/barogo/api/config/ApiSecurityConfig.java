package com.barogo.api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class ApiSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors().and() // CorsFilter라는 필터 활성
                .csrf().disable() // jwt 써야 하기에 비활성화
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // 시큐리티에서 세선 관리 x jwt 쓸거고 헤더에 token 방식으로 할거라  ㄴㄴ
                .authorizeRequests()
                .antMatchers("/api/common/**").permitAll()
                .antMatchers("/api/member/join/**").permitAll()
                .antMatchers("/**").hasRole("USER")
                .anyRequest().permitAll()
                .and()
                .formLogin().disable()
                .addFilterBefore()
                .build();
    }

//    @Bean
//    public FilterRegistrationBean<ApiAuthFilter> apiAuthFilter() {
//        FilterRegistrationBean<ApiAuthFilter> registrationBean = new FilterRegistrationBean<ApiAuthFilter>(new ApiAuthFilter());
//        registrationBean.addUrlPatterns("/epe/*");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }

}