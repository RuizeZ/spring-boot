package com.zeze.springboot.dao;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//@Before("execution(* addAccount(..))")
@Before("execution(* com.zeze.springboot.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("=====>>> before addAccount()");
    }
}
