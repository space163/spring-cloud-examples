package com.client2.hystrix;

import com.client2.service.WebService;
import org.springframework.stereotype.Component;

/**
 * Created by space163 on 2019/4/8.
 */
@Component
public class RegisterHystrix implements WebService{
    @Override
    public String hello() {
        return "failed";
    }

    @Override
    public String login(String name, String password) {
        return "service has stopped";
    }
}
