package com.famita.Spring.boot.project.Service;

import com.famita.Spring.boot.project.Entity.Auteur;
import com.famita.Spring.boot.project.Entity.Livre;
import com.famita.Spring.boot.project.Repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuteurService {

    private AuteurRepository auteurRepository;
    @Autowired
    public AuteurService(AuteurRepository auteurRepository){
        this.auteurRepository = auteurRepository;
    }

    public List<Auteur> tousLesAuteurs(){return this.auteurRepository.findAll();}

    public Auteur unAuteur(int id){return this.auteurRepository.findById(id).get();}

    public Auteur ajouterUnAuteur(String nom, String prenom, String bio, Date naissance){
        Auteur a = new Auteur(nom, prenom, bio, naissance);
        return auteurRepository.saveAndFlush(a);
    }

    public void supprimerUnAuteur(int id){
        Auteur a = auteurRepository.findById(id).get();
        auteurRepository.delete(a);
    }

    public Auteur modifierUnAuteur(int id, String nom, String prenom, String bio, Date naissance){
        Auteur a = auteurRepository.findById(id).get();
        a.setNom(nom);
        a.setPrenom(prenom);
        a.setBio(bio);
        a.setNaissance(naissance);
        return auteurRepository.saveAndFlush(a);
    }



}
