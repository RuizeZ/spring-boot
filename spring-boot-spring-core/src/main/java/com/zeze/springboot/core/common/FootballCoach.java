package com.zeze.springboot.core.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // mark the class as a spring bean
@Lazy
public class FootballCoach implements Coach{
    public FootballCoach(){
        System.out.println("Building " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Football: Run for 15 minutes!!!";
    }
}
