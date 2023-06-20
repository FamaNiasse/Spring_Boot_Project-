package com.famita.Spring.boot.project.Repository;

import com.famita.Spring.boot.project.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
