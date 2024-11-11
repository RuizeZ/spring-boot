package com.zeze.springboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAnalyticsAspect {

//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//@Before("execution(* addAccount(..))")
//    @Before("forDaoPackage()")

    @Before("com.zeze.springboot.aspect.AopExpressions.noGetterSetter()")
    public void logToCloudAnalytics(){
        System.out.println("=========>>> Performing cloud analytics ");
    }


}
