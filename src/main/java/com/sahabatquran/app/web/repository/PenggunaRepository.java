package com.sahabatquran.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sahabatquran.app.web.entity.Pengguna;

import java.util.Optional;

@Repository
public interface PenggunaRepository extends JpaRepository<Pengguna, Long> {
    Optional<Pengguna> findByEmail(String email);
}
