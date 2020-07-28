package com.alameenjr.gestionabscence.repositories.absences;

import com.alameenjr.gestionabscence.entities.absences.Retard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetardRepository extends JpaRepository<Retard, Long> {
}
