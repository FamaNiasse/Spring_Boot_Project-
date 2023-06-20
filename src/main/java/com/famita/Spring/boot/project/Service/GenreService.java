package com.famita.Spring.boot.project.Service;

import com.famita.Spring.boot.project.Entity.Genre;
import com.famita.Spring.boot.project.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private GenreRepository genreRepository;
    @Autowired
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public List<Genre> tousLesGenres(){return this.genreRepository.findAll();}

    public Genre unGenre(int id){return this.genreRepository.findById(id).get();}

}
