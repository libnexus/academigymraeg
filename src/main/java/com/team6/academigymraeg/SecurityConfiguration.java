package com.team6.academigymraeg;

import com.team6.academigymraeg.security.AGUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    @Autowired
    private AGUserDetailsService userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetails() {
        return userDetailsService;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin((form) -> {
            form.loginPage("/login")
                    .loginProcessingUrl("/logincheck")
                    .defaultSuccessUrl("/index", true)
                    .failureUrl("/login?error=1");
        }).logout((logout) -> {
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));
        }).userDetailsService(userDetails());

        return httpSecurity.build();
    }
}
