package com.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by space163 on 2019/4/8.
 */
@FeignClient("spring-cloud-registerApp")
public interface RegisterService {
    @GetMapping("/name")
    String name();


}
