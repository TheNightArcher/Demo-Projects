package com.example.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DummyObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(DummyObject.class);

    public void saySomething() {
        LOGGER.info("Hello, guys.");
    }

    public void boom() {
        throw new NullPointerException("Ups, something get wrong!");
    }

    public void echo(String word) {
        LOGGER.info("I'm echoing this {}", word);
    }

    public String concat(String a, String b) {
        return a + b;
    }
}
