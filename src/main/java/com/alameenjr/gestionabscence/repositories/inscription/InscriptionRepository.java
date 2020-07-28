package com.alameenjr.gestionabscence.repositories.inscription;

import com.alameenjr.gestionabscence.entities.inscription.AnneeScolaire;
import com.alameenjr.gestionabscence.entities.inscription.Etudiant;
import com.alameenjr.gestionabscence.entities.inscription.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    Optional<Inscription> findByAnneeScolaireAndEtudiant(AnneeScolaire anneeScolaire, Etudiant etudiant);
}
