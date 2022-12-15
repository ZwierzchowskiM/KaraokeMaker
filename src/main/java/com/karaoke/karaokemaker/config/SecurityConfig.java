package com.karaoke.karaokemaker.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Scanner;

@Configuration
class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(
//                requests -> requests
//                        .mvcMatchers("/").permitAll() //MvcMatcher -> PermitAllAuthorizationManager
//                        .mvcMatchers("/songs").hasAnyRole("USER", "ADMIN")//MvcMatcher -> PermitAllAuthorizationManager
//                        .mvcMatchers(HttpMethod.POST, "/songs/save").hasAnyRole("USER", "ADMIN") //MvcMatcher -> AuthorityAuthorizationManager Żądania POST wysyłane pod adres /songs/save mogą wykonywać tylko użytkownicy z rolą USER, lub ADMIN
//                        .mvcMatchers(HttpMethod.POST, "/songcreate/addbars2").hasAnyRole("USER", "ADMIN") //MvcMatcher -> AuthorityAuthorizationManager Żądania POST wysyłane pod adres /songs/save mogą wykonywać tylko użytkownicy z rolą USER, lub ADMIN
//                        .mvcMatchers("/register", "/confirmation").permitAll()
//                        .mvcMatchers("/images/**", "/stylesheets/**").permitAll()
//                        .mvcMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers(PathRequest.toH2Console()).permitAll()
//                        .anyRequest().authenticated() //AnyRequestMatcher -> AuthenticatedAuthorizationManager Wszystkie pozostałe żądania wymagają uwierzytelnienia z dowolną rolą.
//        );
//        http.formLogin(login -> login.loginPage("/login").permitAll());
//        http.logout(logout -> logout
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout/**", HttpMethod.GET.name()))
//                .logoutSuccessUrl("/")
//        );
//        http.csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()));
//        http.headers().frameOptions().sameOrigin();
//
//
//        return http.build();

        http.csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()));
        http.cors().and().csrf().disable();

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
