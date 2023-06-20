package com.famita.Spring.boot.project.Service;

import com.famita.Spring.boot.project.Entity.Auteur;
import com.famita.Spring.boot.project.Entity.Livre;
import com.famita.Spring.boot.project.Repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {
    private LivreRepository livreRepository; // ON APPELLE D'ABORD LES PROPRIETES
    private AuteurService auteurService;
    @Autowired // INSTANTIATION DE REPOSITORY
    public LivreService(LivreRepository livreRepository, AuteurService auteurService){ // LE DEUXIEME livreRepository EST UNE VARIABLE
        this.livreRepository = livreRepository; // LE DEUXIEME EST LA VARIABLE CI DESSUS
        this.auteurService = auteurService;
    }

    public List<Livre> tousLesLivres(){
        return this.livreRepository.findAll();
    }

    public Livre unLivre(int id) {
        return this.livreRepository.findById(id).get();
    }

    public Livre ajouterUnLivre(String titre, String resume, int auteurId){
        Auteur a = this.auteurService.unAuteur(auteurId);
        Livre l = new Livre(titre, resume, a);
        return livreRepository.saveAndFlush(l);

    }


    public void supprimerUnLivre(int id){
        Livre l = livreRepository.findById(id).get();
        livreRepository.delete(l);
    }

    public Livre modifierLivre(int id, String titre, String resume, int auteurId){
        Livre l = livreRepository.findById(id).get();
        l.setTitre(titre);
        l.setResume(resume);
        l.setAuteur(auteurService.unAuteur(auteurId));
        return livreRepository.saveAndFlush(l);

    }
}
