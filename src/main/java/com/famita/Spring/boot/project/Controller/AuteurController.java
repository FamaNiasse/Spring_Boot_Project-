package com.famita.Spring.boot.project.Controller;

import com.famita.Spring.boot.project.Entity.Auteur;
import com.famita.Spring.boot.project.Service.AuteurService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/auteurs")
public class AuteurController {

    private AuteurService auteurService;

    public AuteurController(AuteurService auteurService){
        this.auteurService = auteurService;
    }

    @GetMapping("")
    @ResponseBody
    public List<Auteur> auteurs(){return auteurService.tousLesAuteurs();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Auteur auteur(@PathVariable int id) {return auteurService.unAuteur(id);}

    @PostMapping("/ajouter")
    @ResponseBody
    public Auteur ajouter(@RequestParam String nom, @RequestParam String prenom, @RequestParam String bio, @RequestParam Date naissance){
        return auteurService.ajouterUnAuteur(nom, prenom, bio, naissance);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean supprimer(@PathVariable int id){
        auteurService.supprimerUnAuteur(id);
        return true;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Auteur modifier(@PathVariable int id, @RequestParam String nom, @RequestParam String prenom, @RequestParam String bio, @RequestParam Date naissance){
        return auteurService.modifierUnAuteur(id, nom, prenom, bio,naissance);
    }
}
