package com.example.aop.demo2;

import com.example.aop.DummyObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleAspectDemo2 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleAspectDemo2.class);

    private final DummyObject dummyObject;

    public SimpleAspectDemo2(DummyObject dummyObject) {
        this.dummyObject = dummyObject;
    }


    @Override
    public void run(String... args) throws Exception {
        LOGGER.info(dummyObject.concat("Hello, ", "guys!"));
    }
}
