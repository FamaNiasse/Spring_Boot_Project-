package com.famita.Spring.boot.project.Controller;

import com.famita.Spring.boot.project.Entity.Livre;
import com.famita.Spring.boot.project.Service.LivreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // GESTION DES URLs
@RequestMapping("/livres") // DEFINIS LA ROUTE URLs
public class LivreController {
    private LivreService livreService;

    public LivreController(LivreService livreService){
        this.livreService = livreService;
    }

    @GetMapping("") // ON LAISSE LE CHAMPS VIDE POUR AFFICHER TOUS LES LIVRES GRACE A LA @RequestMapping QUI A DEFINI L'URL ("/livres")
    @ResponseBody // POUR ENVOYER LES INFOS EN FORMAT JSON
    public List<Livre> livres(){
        return livreService.tousLesLivres();
    }

    @GetMapping("/{id}") // CETTE URL EST VARIABLE C'EST POURQUOI ON MET DES ACCOLADES
    @ResponseBody
    public Livre livre(@PathVariable int id){ // L'ANNOTATION DIT JE VAIS RECUPERER LA VARIABLE ID DANS LE CHEMIN
        return livreService.unLivre(id);
    }

    @PostMapping("/ajouter")
    @ResponseBody
    public Livre ajouter(@RequestParam String titre, @RequestParam String resume, @RequestParam int auteur_id){
        return livreService.ajouterUnLivre(titre, resume, auteur_id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody

    public boolean supprimer(@PathVariable int id){
        livreService.supprimerUnLivre(id);
        return true;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Livre modifier(@PathVariable int id, @RequestParam String titre, @RequestParam String resume, @RequestParam int auteur_id) {
        return livreService.modifierLivre(id, titre, resume, auteur_id);
    }

}
