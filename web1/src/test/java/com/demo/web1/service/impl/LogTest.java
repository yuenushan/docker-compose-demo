package com.demo.web1.service.impl;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {

    static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test() {
        logger.info("test...");
    }
}
