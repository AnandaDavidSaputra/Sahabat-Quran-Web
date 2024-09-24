package com.sahabatquran.app.web.service;

import com.sahabatquran.app.web.entity.Pengguna;
import com.sahabatquran.app.web.entity.Peran;
import com.sahabatquran.app.web.entity.Status;
import com.sahabatquran.app.web.repository.PenggunaRepository;
import com.sahabatquran.app.web.repository.PeranRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RegisterService {

    private final PenggunaRepository penggunaRepository;
    private final PeranRepository peranRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(PenggunaRepository penggunaRepository, PeranRepository peranRepository, PasswordEncoder passwordEncoder) {
        this.penggunaRepository = penggunaRepository;
        this.peranRepository = peranRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(String email, String fullName, String phone, String password, Status status) {
        Pengguna pengguna = new Pengguna();
        pengguna.setEmail(email);
        pengguna.setFullName(fullName);
        pengguna.setPhone(phone);
        pengguna.setPassword(passwordEncoder.encode(password));
        pengguna.setStatus(status);
        Peran pesertaRole = peranRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        pengguna.setPeran(Set.of(pesertaRole));

        penggunaRepository.save(pengguna);
    }
}
