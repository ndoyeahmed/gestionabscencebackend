package com.alameenjr.gestionabscence.repositories.etablissementadmin;

import com.alameenjr.gestionabscence.entities.etablissementadmin.FormationSemestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationSemestreRepository extends JpaRepository<FormationSemestre, Long> {
}
