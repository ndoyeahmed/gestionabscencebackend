package com.alameenjr.gestionabscence.repositories.admin;

import com.alameenjr.gestionabscence.entities.admin.Profil;
import com.alameenjr.gestionabscence.entities.admin.ProfilUtilisateur;
import com.alameenjr.gestionabscence.entities.admin.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilUtilisateurRepository extends JpaRepository<ProfilUtilisateur, Long> {
    Optional<ProfilUtilisateur> findByUtilisateurAndProfil(Utilisateur utilisateur, Profil profil);
}
