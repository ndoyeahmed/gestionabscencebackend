package com.alameenjr.gestionabscence.repositories.etablissementadmin;

import com.alameenjr.gestionabscence.entities.etablissementadmin.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {
}
