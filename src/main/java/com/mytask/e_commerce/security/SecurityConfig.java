package com.mytask.e_commerce.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select id, password, active from user where id = ?"
        );

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select id, role from user where id = ?"
        );
        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(c->
                c.requestMatchers(HttpMethod.GET, "/users").hasAuthority("ADMIN"));
        httpSecurity.authorizeHttpRequests(c->
                c.requestMatchers(HttpMethod.POST,"users/**").hasAuthority("CUSTOMER"));

        httpSecurity.httpBasic();
        httpSecurity.csrf().disable();
        return httpSecurity.build();

    }
}
