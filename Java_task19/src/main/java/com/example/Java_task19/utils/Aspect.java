package com.example.Java_task19.utils;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@org.aspectj.lang.annotation.Aspect
@Component
@Slf4j
public class Aspect {
    @Pointcut("within(com.example.Java_task19.services.*)")
    public void allServiceMethods() {}

    @Around("allServiceMethods()")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        log.info("Method {} worked {} ms", joinPoint.getSignature(), System.currentTimeMillis() - start);
        return result;
    }
}
