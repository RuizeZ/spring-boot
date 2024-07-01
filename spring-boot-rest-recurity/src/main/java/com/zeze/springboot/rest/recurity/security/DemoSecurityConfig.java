package com.zeze.springboot.rest.recurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("MANAGER")
                .build();
        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean
    public SecurityFilterChain fileterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "api/security/employees").hasRole("EMPLOYEE")
        ));

        http.authorizeHttpRequests((configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "api/security/employees/**").hasRole("EMPLOYEE")
        ));

        http.authorizeHttpRequests((configurer ->
                configurer
                        .requestMatchers(HttpMethod.POST, "api/security/employees").hasRole("MANAGER")
        ));

        http.authorizeHttpRequests((configurer ->
                configurer
                        .requestMatchers(HttpMethod.PUT, "api/security/employees").hasRole("MANAGER")
        ));

        http.authorizeHttpRequests((configurer ->
                configurer
                        .requestMatchers(HttpMethod.PUT, "api/security/employees").hasRole("ADMIN")
        ));

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());
        // disable CSRF
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
