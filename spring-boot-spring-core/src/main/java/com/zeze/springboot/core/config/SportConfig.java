package com.zeze.springboot.core.config;

import com.zeze.springboot.core.common.Coach;
import com.zeze.springboot.core.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("mySwimCoach")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
