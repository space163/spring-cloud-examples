package com.client.controller;

import com.client.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by space163 on 2019/4/8.
 */
@RestController
public class Controller {
    @Value("${server.port}")
    private String port;

//    @Autowired
//    private RegisterService registerService;

    @RequestMapping("/name")
    public String hello(){
        return "client:hello,"+port;
    }

//    @GetMapping("/abc")
//    public String name(){
//        return registerService.name();
//    }
//
//    @RequestMapping("/login")
//    public String login(String name,String password){
//        return name+" "+password+" port:"+port;
//    }
}
