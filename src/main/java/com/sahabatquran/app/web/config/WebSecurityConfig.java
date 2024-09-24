package com.sahabatquran.app.web.config;

import com.sahabatquran.app.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Autowired
    private LoginService loginService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/index.html", "/assets/**",
                                "/register", "/register/success", "/register/add").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/peserta/**").hasRole("PESERTA")
                        .requestMatchers("/finansial/**").hasRole("FINANSIAL")
                        .requestMatchers("/pengajar/**").hasRole("PENGAJAR")
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .successHandler((request, response, authentication) -> {
                            if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
                                for (GrantedAuthority authority : authentication.getAuthorities()) {
                                    String role = authority.getAuthority();
                                    switch (role) {
                                        case "ROLE_ADMIN":
                                            response.sendRedirect("/admin");
                                            return;
                                        case "ROLE_PESERTA":
                                            response.sendRedirect("/peserta");
                                            return;
                                        case "ROLE_FINANSIAL":
                                            response.sendRedirect("/finansial");
                                            return;
                                        case "ROLE_PENGAJAR":
                                            response.sendRedirect("/pengajar");
                                            return;
                                    }
                                }
                            }
                            response.sendRedirect("/login");
                        })
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(loginService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

