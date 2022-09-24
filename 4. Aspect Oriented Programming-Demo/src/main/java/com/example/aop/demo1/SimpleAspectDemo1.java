package com.example.aop.demo1;

import com.example.aop.DummyObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SimpleAspectDemo1 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleAspectDemo1.class);

    private final DummyObject dummyObject;

    public SimpleAspectDemo1(DummyObject dummyObject) {
        this.dummyObject = dummyObject;
    }

    @Override
    public void run(String... args) throws Exception {
         dummyObject.saySomething();
         dummyObject.echo("Stay HUMBLE!!!");

         try {
             dummyObject.boom();
         }catch (Exception e){
             LOGGER.info("Exception from boom called!");
         }

        LOGGER.info(dummyObject.concat("Hello, ", "world!"));
    }
}
