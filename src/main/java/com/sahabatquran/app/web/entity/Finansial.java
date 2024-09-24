package com.sahabatquran.app.web.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "finansial")
public class Finansial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pengguna_id", nullable = false, unique = true)
    private Pengguna pengguna;

    @Column(nullable = false, length = 255)
    private String nomorRekening;

    @Column(nullable = true, length = 255)
    private String namaBank;
}
