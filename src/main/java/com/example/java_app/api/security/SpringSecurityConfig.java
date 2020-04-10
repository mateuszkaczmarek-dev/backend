package com.example.java_app.api.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
        .withUser("root")
        .password(encoder.encode("root"))
        .roles("ADMIN");
        
        //auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
    }

    //filtrowanie zadan ktore przychodza do server , sprawdza zadanie czy ma odpowiednie uprawnienia 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.authorizeRequests().antMatchers("api/login/**")
        .fullyAuthenticated()
        .and()
        .httpBasic();
    }

}