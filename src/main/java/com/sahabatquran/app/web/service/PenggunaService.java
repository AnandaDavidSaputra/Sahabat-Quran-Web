package com.sahabatquran.app.web.service;

import com.sahabatquran.app.web.repository.PenggunaRepository;
import com.sahabatquran.app.web.repository.PeranRepository;
import com.sahabatquran.app.web.entity.Pengguna;
import com.sahabatquran.app.web.entity.Peran;
import com.sahabatquran.app.web.entity.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

@Component
public class PenggunaService implements CommandLineRunner {

    private final PenggunaRepository penggunaRepository;
    private final PeranRepository peranRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public PenggunaService(PenggunaRepository penggunaRepository, PeranRepository peranRepository, BCryptPasswordEncoder passwordEncoder) {
        this.penggunaRepository = penggunaRepository;
        this.peranRepository = peranRepository;
    }

    @Override
    public void run(String... args) {
        Peran admin = new Peran();
        admin.setName("ADMIN");

        Peran peserta = new Peran();
        peserta.setName("PESERTA");

        Peran finansial = new Peran();
        finansial.setName("FINANSIAL");

        Peran pengajar = new Peran();
        pengajar.setName("PENGAJAR");

        if (peranRepository.count() == 0) {
            peranRepository.saveAll(List.of(admin, peserta, finansial, pengajar));
        }

        String encryptedPassword1 = passwordEncoder.encode("admin123");
        String encryptedPassword2 = passwordEncoder.encode("peserta123");
        String encryptedPassword3 = passwordEncoder.encode("finansial123");
        String encryptedPassword4 = passwordEncoder.encode("pengajar123");

        Peran adminRole = peranRepository.findByName("ADMIN").orElseThrow();
        Peran pesertaRole = peranRepository.findByName("PESERTA").orElseThrow();
        Peran finansialRole = peranRepository.findByName("FINANSIAL").orElseThrow();
        Peran pengajarRole = peranRepository.findByName("PENGAJAR").orElseThrow();

        Pengguna pengguna1 = new Pengguna();
        pengguna1.setEmail("admin@gmail.com");
        pengguna1.setFullName("Admin User");
        pengguna1.setPhone("089893494238");
        pengguna1.setPassword(encryptedPassword1);
        pengguna1.setStatus(Status.AKTIF);
        pengguna1.setPeran(new HashSet<>());
        pengguna1.getPeran().add(adminRole);

        Pengguna pengguna2 = new Pengguna();
        pengguna2.setEmail("peserta@gmail.com");
        pengguna2.setFullName("Peserta User");
        pengguna2.setPhone("089798373493");
        pengguna2.setPassword(encryptedPassword2);
        pengguna2.setStatus(Status.AKTIF);
        pengguna2.setPeran(new HashSet<>());
        pengguna2.getPeran().add(pesertaRole);

        Pengguna pengguna3 = new Pengguna();
        pengguna3.setEmail("finansial@gmail.com");
        pengguna3.setFullName("Finansial User");
        pengguna3.setPhone("083927972332");
        pengguna3.setPassword(encryptedPassword3);
        pengguna3.setStatus(Status.AKTIF);
        pengguna3.setPeran(new HashSet<>());
        pengguna3.getPeran().add(finansialRole);

        Pengguna pengguna4 = new Pengguna();
        pengguna4.setEmail("pengajar@gmail.com");
        pengguna4.setFullName("Pengajar User");
        pengguna4.setPhone("083992222439");
        pengguna4.setPassword(encryptedPassword4);
        pengguna4.setStatus(Status.AKTIF);
        pengguna4.setPeran(new HashSet<>());
        pengguna4.getPeran().add(pengajarRole);

        if (penggunaRepository.count() == 0) {
            penggunaRepository.saveAll(List.of(pengguna1, pengguna2, pengguna3, pengguna4));
        }
    }
}
