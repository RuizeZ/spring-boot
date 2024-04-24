package com.zeze.springboot.core.common;

import org.springframework.stereotype.Component;

@Component // mark the class as a spring bean
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("Building " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Cricket: Run for 15 minutes!!!";
    }
}
