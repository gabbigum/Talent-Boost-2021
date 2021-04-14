package com.vmware.talentboost.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;
    // Add a second user that has a "MENTOR" role only that can access /talent-boost & /talent-boost/mentors
    // Login at http://localhost:8080/login
    // Try accessing both endpoints in the browser

    // Add unit tests to test that:
    // 1. The participant can access /talent-boost
    // 2. The participant can't access /talent-boost/mentors
    // 3. The mentor can access /talent-boost
    // 4. The mentor can access /talent-boost/mentors

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Georgi")
                .password(passwordEncoder.encode("1234"))
                .roles("PARTICIPANT", "MENTOR")
                .and()
                .withUser("Ivan")
                .password(passwordEncoder.encode("7890"))
                .roles("PARTICIPANT");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/login")
                .permitAll()
                .and()
                .formLogin()
                .init(http);
    }
}
