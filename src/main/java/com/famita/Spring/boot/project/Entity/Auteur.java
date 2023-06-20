package com.famita.Spring.boot.project.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = true)
    private String bio;
    @Column(nullable = true)
    private Date naissance;

    public Auteur (String nom, String prenom, String bio, Date naissance){
        this.nom = nom;
        this.prenom = prenom;
        this.bio = bio;
        this.naissance = naissance;

    }

    public Auteur(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        this.naissance = naissance;
    }
}
