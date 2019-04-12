package com.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.netty.http.server.HttpServerResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Created by space163 on 2019/4/11.
 */
@Component
public class TokenGatewayFilterFactory extends AbstractGatewayFilterFactory<TokenGatewayFilterFactory.Config> {

    public TokenGatewayFilterFactory(){
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("enabled");
    }


    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            if (!config.isEnabled()){
                return chain.filter(exchange);
            }
            ServerHttpRequest request = exchange.getRequest();
            String token = request.getHeaders().getFirst("token");
            if (token == null){
                token = request.getQueryParams().getFirst("token");
            }
            ServerHttpResponse response = exchange.getResponse();
            if (token == null || "".equals(token)){
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }
            return chain.filter(exchange);
        };
    }

    public static class Config{
        private boolean enabled;

        public Config(){}

        public boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
