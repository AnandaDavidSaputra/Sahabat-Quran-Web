package com.sahabatquran.app.web.repository;

import com.sahabatquran.app.web.entity.Peran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeranRepository extends JpaRepository<Peran, Long> {
    Optional<Peran> findByName(String name);
}
