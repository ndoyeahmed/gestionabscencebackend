package com.alameenjr.gestionabscence.repositories.inscription;

import com.alameenjr.gestionabscence.entities.inscription.AnneeScolaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire, Long> {
    Optional<AnneeScolaire> findByEncoursTrue();
}
