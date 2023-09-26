package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter() {
    }

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter() {
    }

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====> Executing @Before advice on method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=====> Performing API analytics");
    }

    // @Before("execution(public void addAccount())")
    // @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(void add*())")
    // @Before("execution(* add*())")
    // @Before("execution(* add*(com.luv2code.aopdemo.Account))")
    // @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
    // @Before("execution(* com.luv2code..add*(..))")
    // @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    /*    public void beforeAddAccountAdvice() {
        System.out.println("\n=====> Executing @Before advice on method");
    }*/
}