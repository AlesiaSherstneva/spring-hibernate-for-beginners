package com.luv2code.springmvc.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springmvc.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.luv2code.springmvc.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.luv2code.springmvc.dao.*.*(..))")
    private void forDaoPackage() {
    }
}