package com.zeze.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    // expose "/" that return ""Hello World
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "workout";
    }
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "coach name: " + coachName + " team name: " + teamName;
    }

}
