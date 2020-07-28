package com.alameenjr.gestionabscence.repositories.admin;

import com.alameenjr.gestionabscence.entities.admin.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
}
