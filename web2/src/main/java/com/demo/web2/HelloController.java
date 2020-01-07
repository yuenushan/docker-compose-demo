package com.demo.web2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Web1Client web1Client;
    @Autowired
    private Web2Client web2Client;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${info.name}")
    private String value;

    @GetMapping("")
    public String hello() {
//        System.out.println("web2 hello...");
//        return restTemplate.getForObject("http://web1/hello", String.class);
        return web1Client.hello();
//        return web2Client.test();
    }

    @GetMapping("/test")
    public String test() throws InterruptedException {
        System.out.println("test...");
        Thread.sleep(5000);
        return "test";
    }

    @GetMapping("/fail")
    @HystrixCommand(fallbackMethod = "fallback")
    public String fail() {
        int a = 1 / 0;
        return "fail";
    }

    @GetMapping("/value")
    public String getValue() {
        return value;
    }

    private String fallback() {
        return "hystrix success";
    }

}
