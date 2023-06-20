package com.famita.Spring.boot.project.Repository;

import com.famita.Spring.boot.project.Entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// LES INTERFACES NE SONT PAS DES CLASS MAIS ON VA POUVOIR LES IMPLEMENTER DANS D'AUTRES CLASS
public interface LivreRepository extends JpaRepository<Livre, Integer> {
}

