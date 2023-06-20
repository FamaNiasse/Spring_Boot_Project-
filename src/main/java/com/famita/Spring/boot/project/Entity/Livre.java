package com.famita.Spring.boot.project.Entity;

import jakarta.persistence.*; // POUR EVITER D'AVOIR TROP D'IMPORTS INTELLIJ METS UNE ETOILE

@Entity // CHARGE LE PACKAGE ENTITY
@Table(name = "livre") // DANS NOTRE CAS DE FIGURE LE NOM DE LA TABLE NEST PAS NECESSAIRE DANS LA MESURE OU LA TABLE A LE MËME NOM QUE LA CLASS
public class Livre {
@Id //CLEF PRIMAIRE
@GeneratedValue(strategy = GenerationType.IDENTITY) // REMPLACE L'AUTO IMPLEMENTATION
    private int id;
    @Column(nullable = false) // UNE ANNOTATION SE PLACE AU DESSUS DE LA PROPRIETE OU CLASS SUR LAQUELLE IL AGIT
    private String titre;
    @Column(nullable = true)
    private String resume;
    @JoinColumn(nullable = false, name="auteur_id")
    @ManyToOne() // UN AUTEUR PEUT ËTRE RELIE A UN OU PLUSIEURS LIVRES
    private Auteur auteur;

    public Livre (String titre, String resume, Auteur auteur){
        this.titre = titre;
        this.resume = resume;
        this.auteur = auteur;
    }
    public Livre(){} //CONSTRUCTEUR PAR DEFAUT QU'IL FAUT REDECLARER SI ON AJOUTE UN AUTRE CONSTRUCTEUR SINON IL NE SERA PAS UTILISABLE
    //LE CONTRUCTEUR PAR DEFAUT EST OBLIGATOIRE DANS LES CLASS ENTITY DANS LE FRAMEWOK
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }


}
