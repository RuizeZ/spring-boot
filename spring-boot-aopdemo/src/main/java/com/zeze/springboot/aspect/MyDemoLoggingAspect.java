package com.zeze.springboot.aspect;

import com.zeze.springboot.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
    @After("execution( * com.zeze.springboot.dao.AccountDAO.findAccounts(..))")
    public void afterFinally(JoinPoint theJoinPoint){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("Running After finally " +  method);
    }
    @AfterThrowing(
            pointcut = "execution( * com.zeze.springboot.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowing(JoinPoint theJoinPoint, Throwable theExc){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("Running After throwing " +  method);
        System.out.println("=======>>>> The exceptiog is " + theExc);
    }

    @AfterReturning(
            pointcut = "execution( * com.zeze.springboot.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterRecturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("Running " +  method);
        System.out.println("Result is " + result);
        convertAccountNamesToUpperCase(result);
        System.out.println("Result is " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount :
                result) {
            String theUpperName = tempAccount.getName().toUpperCase();
            tempAccount.setName(theUpperName);
        }
    }


//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//@Before("execution(* addAccount(..))")
//    @Before("forDaoPackage()")

    @Before("com.zeze.springboot.aspect.AopExpressions.noGetterSetter()")
    public void logToLoggingAnalytics(JoinPoint theJoinPoint){
        System.out.println("=========>>> Performing Logging analytics ");
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println(methodSignature);
        Object[] args = theJoinPoint.getArgs();
        for(Object arg : args){
            System.out.println("arg:" + arg);
            if(arg instanceof Account){
                System.out.println("name:" + ((Account) arg).getName());
            }
        }
    }


}
