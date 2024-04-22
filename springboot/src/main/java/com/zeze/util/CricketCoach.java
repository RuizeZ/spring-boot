package com.zeze.util;

import org.springframework.stereotype.Component;

@Component // mark the class as a spring bean
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run for 15 minutes";
    }
}
