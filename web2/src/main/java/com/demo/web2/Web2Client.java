package com.demo.web2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("web2")
public interface Web2Client {
    @RequestMapping(value = "/hello/test", method = RequestMethod.GET)
    String test();
}
