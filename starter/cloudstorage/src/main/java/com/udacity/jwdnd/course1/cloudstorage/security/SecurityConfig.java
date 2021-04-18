package com.udacity.jwdnd.course1.cloudstorage.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests()
        .antMatchers("/signup", "/css/**", "/js/**").permitAll()
        .antMatchers("/h2-console/**").permitAll()
        .anyRequest().authenticated();

        http.formLogin()
        .loginPage("/login")
        .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.formLogin()
        .defaultSuccessUrl("/home", true);
        
    }
    
}