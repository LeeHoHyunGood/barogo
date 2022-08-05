package com.barogo.api.config.secuirity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthTokenProvider {

    private String secretKey = "dlghgus";
    private long tokenValidTime = 3 * 60 * 1000L;
}
