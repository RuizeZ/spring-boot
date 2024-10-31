package com.zeze.springboot.dao;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(* com.zeze.springboot.dao.*.*(..))")
    private void forDaoPackage() {}
    @Pointcut("execution(* com.zeze.springboot.dao.*.get*(..))")
    private void getMethod() {}
    @Pointcut("execution(* com.zeze.springboot.dao.*.set*(..))")
    private void setMethod() {}
    @Pointcut("forDaoPackage() && !(getMethod() || setMethod())")
    private void noGetterSetter() {}

//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//@Before("execution(* addAccount(..))")
//    @Before("forDaoPackage()")
    @Before("noGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("=====>>> before addAccount()");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("=========>>> Performing API analytics ");
    }


}
