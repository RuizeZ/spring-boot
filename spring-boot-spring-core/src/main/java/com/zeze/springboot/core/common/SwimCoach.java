package com.zeze.springboot.core.common;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("Building " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim: Run for 15 minutes!!!";
    }
}
