package com.zeze.springboot.thymeleaf.model;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private List<String> favoriteSystem;

    public Student(){

    }


}
