package com.alameenjr.gestionabscence.repositories.etablissementadmin;

import com.alameenjr.gestionabscence.entities.etablissementadmin.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
