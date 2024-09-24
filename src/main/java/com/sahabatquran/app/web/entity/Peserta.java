package com.sahabatquran.app.web.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "peserta")
public class Peserta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "pengguna_id", nullable = false, unique = true)
    private Pengguna pengguna;

    @Column(nullable = false)
    private String kelas;

    @Column(nullable = false)
    private String wali;
}
