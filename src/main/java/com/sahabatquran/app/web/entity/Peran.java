package com.sahabatquran.app.web.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "peran")
public class Peran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;
}
