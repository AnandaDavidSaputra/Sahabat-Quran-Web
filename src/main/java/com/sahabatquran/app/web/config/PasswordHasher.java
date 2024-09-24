package com.sahabatquran.app.web.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword1 = "peserta123";
        String hashedPassword1 = passwordEncoder.encode(rawPassword1);
        System.out.println("Hashed Password for peserta: " + hashedPassword1);

        String rawPassword2 = "admin123";
        String hashedPassword2 = passwordEncoder.encode(rawPassword2);
        System.out.println("Hashed Password for admin: " + hashedPassword2);

        String rawPassword3 = "finansial123";
        String hashedPassword3 = passwordEncoder.encode(rawPassword3);
        System.out.println("Hashed Password for finansial: " + hashedPassword3);

        String rawPassword4 = "pengajar123";
        String hashedPassword4 = passwordEncoder.encode(rawPassword4);
        System.out.println("Hashed Password for pengajar: " + hashedPassword4);
    }
}
