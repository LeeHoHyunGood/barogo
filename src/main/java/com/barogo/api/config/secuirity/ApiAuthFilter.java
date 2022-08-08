package com.barogo.api.config.secuirity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * jwt 인증 필터
 *  */
@Data
@EqualsAndHashCode(callSuper=false)
public class ApiAuthFilter extends GenericFilterBean {

    private final AuthTokenProvider authTokenProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = ((HttpServletRequest) request).getHeader("AccessToken");
        if(token != null) {
            String memberId = authTokenProvider.valiToken(token);
        }
    }
}
