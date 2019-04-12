package com.zuulserver.hystrix;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * Created by space163 on 2019/4/10.
 */
@Component
public class ZuulFallback implements FallbackProvider{
    @Override
    public String getRoute() {
        return null;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String s, Throwable throwable) {
        return null;
    }
}
