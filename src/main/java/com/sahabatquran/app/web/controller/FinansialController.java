package com.sahabatquran.app.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinansialController {

    @GetMapping("/finansial")
    public String index(Authentication authentication) {
        return "finansial/finansial";
    }
}
