package com.alameenjr.gestionabscence.repositories.etablissementadmin;

import com.alameenjr.gestionabscence.entities.etablissementadmin.Module;
import com.alameenjr.gestionabscence.entities.etablissementadmin.UE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    Optional<List<Module>> findAllByArchive(boolean archive);

    Optional<List<Module>> findAllByUeAndArchive(UE ue, boolean archive);
}
