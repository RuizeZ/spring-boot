package com.zeze.springboot.core.common;

import org.springframework.stereotype.Component;

@Component // mark the class as a spring bean
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Football: Run for 15 minutes!!!";
    }
}
