package com.demo.web2;

import org.springframework.stereotype.Component;

@Component
public class Web1ClientFallback implements Web1Client {

    @Override
    public String hello() {
        return "hystrix...";
    }
}
