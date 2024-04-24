package com.zeze.springboot.core.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // mark the class as a spring bean
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("Building " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Baseball: Run for 15 minutes!!!";
    }
}
