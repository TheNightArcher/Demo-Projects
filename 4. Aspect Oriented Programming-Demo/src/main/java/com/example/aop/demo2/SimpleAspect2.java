package com.example.aop.demo2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SimpleAspect2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleAspect2.class);

    @Pointcut("execution(* com.example.aop.DummyObject.concat(..))")
    void onConcat() {
    }

    @Around(value = "onConcat() && args(a,b)")
    public String onConcat(ProceedingJoinPoint point,
                           String a,
                           String b) throws Throwable {
        LOGGER.info("The on concat method was called with arguments [{}] and [{}].",
                a,
                b);

        var modifiedA = "(" + a + ")";
        var modifiedB = "(" + b + ")";

        // execute the method
        var result = point.proceed(new Object[]{modifiedA, modifiedB});

        // modify the result
        return "[" + result + "]";
    }
}
