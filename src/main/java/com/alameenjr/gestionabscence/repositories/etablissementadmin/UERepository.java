package com.alameenjr.gestionabscence.repositories.etablissementadmin;

import com.alameenjr.gestionabscence.entities.etablissementadmin.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UERepository extends JpaRepository<UE, Long> {
    Optional<List<UE>> findAllByArchive(boolean archive);
}
