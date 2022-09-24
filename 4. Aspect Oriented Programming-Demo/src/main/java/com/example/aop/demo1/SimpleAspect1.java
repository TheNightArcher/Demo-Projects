package com.example.aop.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class SimpleAspect1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleAspect1.class);

    @Pointcut("execution(* com.example.aop.DummyObject.*(..))")
    void allDummyObjectMethods() {
    }

    @Pointcut("execution(* com.example.aop.DummyObject.echo(..))")
    void echoCall() {
    }

    @AfterThrowing(pointcut = "execution(* com.example.aop.DummyObject.boom())", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        LOGGER.error("Ups, I think that the method {} threw Exception and the exception is...",
                joinPoint.getSignature(), error);
    }

    @Before("allDummyObjectMethods()")
    public void beforeEchoMethod(JoinPoint joinPoint) {
        LOGGER.info("Before calling method {} with arguments {}"
                , joinPoint.getSignature()
                , Arrays.asList(joinPoint.getArgs()));
    }
}
