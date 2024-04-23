package com.zeze.springboot.core.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // mark the class as a spring bean
@Primary
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Football: Run for 15 minutes!!!";
    }
}
