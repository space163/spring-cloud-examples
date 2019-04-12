package com.client2.service;

import com.client2.hystrix.RegisterHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by space163 on 2019/4/8.
 */
@FeignClient(name = "spring-cloud-client1",fallback = RegisterHystrix.class)
public interface WebService {
    @RequestMapping("/")
    String hello();

    @RequestMapping("/login")
    String login(@RequestParam("name") String name,@RequestParam("password") String password);
}
