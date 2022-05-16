package com.example.Spring_Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //We can define how we want to authenticate

        //Code to define hardcode inmemory user and password and authorities(If not given it will error out)
        auth.inMemoryAuthentication()
                .withUser("Nijin")
                .password("$2a$10$J6WcNJncyhTdrUKgj5JNeuk3BUc74CiHpT4vZrt3w6fx/DNLWm/s6")
                .authorities("admin")
                .and()
                .withUser("abc")
                .password("$2a$10$ZQWT3Pui0BSj0FgwWPVZCeZs2UAJxQIhY6a7KO1q1uHMMnaCYyOSG")
                .authorities("user");
    }

//    Mandatory bean required for the spring security to function(Will get "There is no PasswordEncoder mapped for the id "null"" error)
    @Bean
    public PasswordEncoder getPE(){
        return new BCryptPasswordEncoder();
    }
}