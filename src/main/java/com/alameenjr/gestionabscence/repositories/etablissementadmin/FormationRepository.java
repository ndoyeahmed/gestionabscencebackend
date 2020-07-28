package com.alameenjr.gestionabscence.repositories.etablissementadmin;

import com.alameenjr.gestionabscence.entities.etablissementadmin.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
}
