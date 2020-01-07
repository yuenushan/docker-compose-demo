package com.demo.web1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("")
    public String hello() {
        System.out.println(discoveryClient.getServices());
        System.out.println("web1 hello...");
        return "hello world!!!";
    }
}
