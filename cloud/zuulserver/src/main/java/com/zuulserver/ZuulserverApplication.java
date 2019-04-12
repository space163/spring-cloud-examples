package com.zuulserver;

import com.zuulserver.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulserverApplication.class, args);
	}

	@Bean
	public TokenFilter tokenFilter(){
		return new TokenFilter();
	}
}
