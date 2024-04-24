package com.zeze.springboot.core.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // mark the class as a spring bean
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("Building " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Baseball: Run for 15 minutes!!!";
    }
}
