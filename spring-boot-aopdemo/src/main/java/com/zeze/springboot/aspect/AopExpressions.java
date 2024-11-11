package com.zeze.springboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {
    @Pointcut("execution(* com.zeze.springboot.dao.*.*(..))")
    public void forDaoPackage() {}
    @Pointcut("execution(* com.zeze.springboot.dao.*.get*(..))")
    public void getMethod() {}
    @Pointcut("execution(* com.zeze.springboot.dao.*.set*(..))")
    public void setMethod() {}
    @Pointcut("forDaoPackage() && !(getMethod() || setMethod())")
    public void noGetterSetter() {}
}
