package com.client2.controller;

import com.client2.entity.User;
import com.client2.service.UserService;
import com.client2.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by space163 on 2019/4/8.
 */
@RestController
@RefreshScope
public class RegisterController {
    @Autowired
    private WebService webService;
    @Autowired
    private UserService userService;
    @Value("${server.port}")
    private String port;
    @Value("${name}")
    private String name;
    @Autowired
    private Environment env;

    @RequestMapping("/hello")
    public String hello(){
        return webService.hello();
    }

    @RequestMapping("/name")
    public String name(){
        return env.getProperty("name") +" "+ env.getProperty("age");
    }

    @RequestMapping("/register")
    @ResponseBody
    public User register(@RequestBody User register){
        return register;
    }
    @RequestMapping("/foo")
    public String foo(){
        return "hello,foo";
    }
}
