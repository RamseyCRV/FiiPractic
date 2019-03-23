package com.robert.bankTr.configuration;

import com.robert.bankTr.service.CustomUserDetaillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable();

        HttpBasicConfigurer<HttpSecurity> httpSecurityHttpBasicConfigurer = httpSecurity.httpBasic();
        httpSecurityHttpBasicConfigurer.and().authorizeRequests();

        httpSecurity.authorizeRequests().anyRequest().authenticated();

/*
        httpSecurity.


        httpSecurity.httpBasic().and().authorizeRequests().antMatchers("/users/**").
                hasRole("USER").antMatchers("/**").hasRole("ADMIN").
                and().csrf().disable().headers().frameOptions().disable();*/
    }
    @Autowired
    CustomUserDetaillsService csr;




    public void configure(AuthenticationManagerBuilder auth) throws Exception{

        //PasswordEncoder encoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();

        //hei spring ! please use my custom authentication server
        auth.userDetailsService(csr);


        //in memory authentication
        /*
         auth.inMemoryAuthentication().withUser("user1").password(encoder.encode("secret1")).roles("USER").
                and().withUser("admin").
                password(encoder.encode("secret1")).roles("USER","ADMIN");*/
    }
}
