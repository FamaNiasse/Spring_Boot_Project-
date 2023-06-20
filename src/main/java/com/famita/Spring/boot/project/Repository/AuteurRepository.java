package com.famita.Spring.boot.project.Repository;

import com.famita.Spring.boot.project.Entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Integer> {
}
