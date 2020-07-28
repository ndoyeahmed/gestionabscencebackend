package com.alameenjr.gestionabscence.repositories.absences;

import com.alameenjr.gestionabscence.entities.absences.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
}
