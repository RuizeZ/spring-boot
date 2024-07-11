package com.zeze.springboot.rest.recurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
//@EnableWebSecurity
public class DemoSecurityConfig {
/*    @Bean
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
    }*/

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager((dataSource));
        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain fileterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests((configurer ->
//                configurer
//                        .requestMatchers(HttpMethod.GET, "thymeleaf/hello").hasRole("EMPLOYEE")
//        ));
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

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/thymeleaf/hello").permitAll() // Endpoints to be ignored
//                      .anyRequest().authenticated() // All other endpoints require authentication
//            );
//
//        return http.build();
//    }
}
