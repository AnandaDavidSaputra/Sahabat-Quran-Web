package com.sahabatquran.app.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String index(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                String role = authority.getAuthority();
                switch (role) {
                    case "ROLE_ADMIN":
                        return "redirect:/admin";
                    case "ROLE_PESERTA":
                        return "redirect:/peserta";
                    case "ROLE_FINANSIAL":
                        return "redirect:/finansial";
                    case "ROLE_PENGAJAR":
                        return "redirect:/pengajar";
                }
            }
        }
        return "login";
    }
}

