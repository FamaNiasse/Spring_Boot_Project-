package com.famita.Spring.boot.project.Entity;

import jakarta.persistence.*;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String labelle;
    @Column(nullable = true)
    private String mot_clef;
}
