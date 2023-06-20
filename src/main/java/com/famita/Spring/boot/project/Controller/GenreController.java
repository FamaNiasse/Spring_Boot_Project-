package com.famita.Spring.boot.project.Controller;

import com.famita.Spring.boot.project.Entity.Genre;
import com.famita.Spring.boot.project.Service.GenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private GenreService genreService;

    public GenreController(GenreService genreService){this.genreService = genreService;}

    @GetMapping("")
    @ResponseBody
    private List<Genre> genres(){return genreService.tousLesGenres();}
    @GetMapping("/{id}")
    private Genre genre(@PathVariable int id){return genreService.unGenre(id);}


}
