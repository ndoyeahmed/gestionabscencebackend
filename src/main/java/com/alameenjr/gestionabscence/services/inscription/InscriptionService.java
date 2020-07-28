package com.alameenjr.gestionabscence.services.inscription;

import com.alameenjr.gestionabscence.entities.inscription.AnneeScolaire;
import com.alameenjr.gestionabscence.entities.inscription.Etudiant;
import com.alameenjr.gestionabscence.entities.inscription.Inscription;
import com.alameenjr.gestionabscence.repositories.inscription.AnneeScolaireRepository;
import com.alameenjr.gestionabscence.repositories.inscription.EtudiantRepository;
import com.alameenjr.gestionabscence.repositories.inscription.InscriptionRepository;
import com.alameenjr.gestionabscence.services.admin.UtilisateurService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log
@Transactional
public class InscriptionService {
    private UtilisateurService utilisateurService;
    private InscriptionRepository inscriptionRepository;
    private AnneeScolaireRepository anneeScolaireRepository;
    private EtudiantRepository etudiantRepository;

    @Autowired
    public InscriptionService(UtilisateurService utilisateurService,
                              InscriptionRepository inscriptionRepository,
                              AnneeScolaireRepository anneeScolaireRepository,
                              EtudiantRepository etudiantRepository) {
        this.utilisateurService = utilisateurService;
        this.inscriptionRepository = inscriptionRepository;
        this.anneeScolaireRepository = anneeScolaireRepository;
        this.etudiantRepository = etudiantRepository;
    }

    public Inscription findInscriptionByEtudiantId(AnneeScolaire anneeScolaire, Etudiant etudiant) {
        return inscriptionRepository.findByAnneeScolaireAndEtudiant(anneeScolaire, etudiant).orElse(null);
    }

    public Etudiant findEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public AnneeScolaire findAnneeScolaireEncours() {
        return anneeScolaireRepository.findByEncoursTrue().orElse(null);
    }
}
