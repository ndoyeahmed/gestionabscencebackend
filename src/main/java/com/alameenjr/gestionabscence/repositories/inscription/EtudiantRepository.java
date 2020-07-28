package com.alameenjr.gestionabscence.repositories.inscription;

import com.alameenjr.gestionabscence.entities.inscription.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
