package com.shop.Config;

import com.shop.Service.Member_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Security_Config {

    @Autowired
    Member_Service member_service;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/member/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/member/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/")
        ;

        http.authorizeRequests() // 시큐리티 처리에 httpservletRequest를 이용한다는 의미
                .mvcMatchers("/css/**", "/js/**", "/img/**").permitAll() // 모든 사용자가 로그인 없이 경로 접근
                .mvcMatchers("/", "/member/**", "/item/**", "/images/**").permitAll()
                .mvcMatchers("/admin/**").hasRole("ADMIN") // ADMIN인 경우 접근가능
                .anyRequest().authenticated()
        ;

        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
        ; // 인증되지 않은 사용자가 리소스에 접근했을때 수행되는 핸들러 등록

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

