package com.sahabatquran.app.web.controller;

import com.sahabatquran.app.web.entity.Pengguna;
import com.sahabatquran.app.web.entity.Peran;
import com.sahabatquran.app.web.entity.Status;
import com.sahabatquran.app.web.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/register")
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
        return "register";
    }

    @PostMapping("/register/add")
    public String registerUser(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String fullName,
            @RequestParam String phone,
            Model model) {

        try {
            registerService.register(email, fullName, phone, password, Status.AKTIF);
            return "redirect:/register/success";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/register/success")
    public String registerSuccess() {
        return "register_success";
    }
}
