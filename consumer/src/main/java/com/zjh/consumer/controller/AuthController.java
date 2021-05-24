package com.zjh.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.QueryParam;

@RestController
@Configuration
public class AuthController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String findName() {

        // todo 检测name和password
        // 一种通过host + serviceName + url调用内部服务的方式
        String msg = restTemplate.getForObject("http://producer/hello/", String.class);
        //HttpEntity httpEntity = new HttpEntity();
        System.out.println(msg);
        return msg;
    }
}