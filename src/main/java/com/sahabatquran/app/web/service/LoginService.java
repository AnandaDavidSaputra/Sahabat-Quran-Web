package com.sahabatquran.app.web.service;

import com.sahabatquran.app.web.repository.PenggunaRepository;
import com.sahabatquran.app.web.entity.Pengguna;
import com.sahabatquran.app.web.entity.Peran;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    private final PenggunaRepository penggunaRepository;

    public LoginService(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pengguna pengguna = penggunaRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return User.builder()
                .username(pengguna.getEmail())
                .password(pengguna.getPassword())
                .authorities(pengguna.getPeran().stream().map(peran -> "ROLE_" + peran.getName()).toArray(String[]::new))
                .build();
    }
}
