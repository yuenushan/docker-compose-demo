package com.demo.web2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "web1", fallback = Web1ClientFallback.class)
public interface Web1Client {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();
}
