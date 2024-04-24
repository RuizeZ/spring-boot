package com.zeze.springboot.core.rest;

import com.zeze.springboot.core.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;
    private Coach myAnotherCoach;
    // define a constructor for dependency injection
//    @Autowired // inject a dependency
//    public DemoController(Coach theCoach){
//        myCoach = theCoach;
//    }
        @Autowired // inject a dependency
    public DemoController(@Qualifier("baseballCoach") Coach theCoach, @Qualifier("baseballCoach") Coach theAnotherCoach){
            System.out.println("Building " + getClass().getSimpleName());
            myCoach = theCoach;
            myAnotherCoach = theAnotherCoach;
    }
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach = theCoach;
//    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
            return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check(){
            return "Comparing beans: " + (myCoach == myAnotherCoach);
    }

}
