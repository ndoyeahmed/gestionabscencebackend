package com.alameenjr.gestionabscence.services.absences;

import com.alameenjr.gestionabscence.entities.absences.Absence;
import com.alameenjr.gestionabscence.entities.absences.Cours;
import com.alameenjr.gestionabscence.entities.admin.Utilisateur;
import com.alameenjr.gestionabscence.entities.etablissementadmin.Classe;
import com.alameenjr.gestionabscence.entities.etablissementadmin.Module;
import com.alameenjr.gestionabscence.entities.etablissementadmin.UE;
import com.alameenjr.gestionabscence.entities.inscription.AnneeScolaire;
import com.alameenjr.gestionabscence.entities.inscription.Etudiant;
import com.alameenjr.gestionabscence.repositories.absences.AbsenceRepository;
import com.alameenjr.gestionabscence.repositories.absences.CoursRepository;
import com.alameenjr.gestionabscence.services.admin.UtilisateurService;
import com.alameenjr.gestionabscence.services.inscription.InscriptionService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
@Transactional
public class AbsenceService {

    private AbsenceRepository absenceRepository;
    private CoursRepository coursRepository;
    private UtilisateurService utilisateurService;
    private InscriptionService inscriptionService;

    @Autowired
    public AbsenceService(AbsenceRepository absenceRepository,
                          CoursRepository coursRepository,
                          UtilisateurService utilisateurService,
                          InscriptionService inscriptionService) {
        this.absenceRepository = absenceRepository;
        this.coursRepository = coursRepository;
        this.utilisateurService = utilisateurService;
        this.inscriptionService = inscriptionService;
    }

    public Absence saveAbsence(Absence absence) {
        try {
            absence.setArchiver(false);
            absenceRepository.save(absence);
            return absence;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    public Absence findAbsenceById(Long id) {
        return absenceRepository.findById(id).orElse(null);
    }

    public List<Absence> findAllAbsenceByArchive(boolean archive) {
        Utilisateur utilisateur = utilisateurService.connectedUser();
        if (utilisateur.getEtablissement() != null) {
            return absenceRepository
                    .findAllByArchiverAndCours_Classe_Formation_Campus_EtablissementAndInscription_AnneeScolaire
                            (archive, utilisateur.getEtablissement(), inscriptionService.findAnneeScolaireEncours())
                    .orElse(new ArrayList<>());
        } else {
            return absenceRepository.findAllByArchiver(archive).orElse(new ArrayList<>());
        }
    }

    public Cours findCoursById(Long id) {
        return coursRepository.findById(id).orElse(null);
    }

    public Integer nombreAbsenceByEtudiantAndAnneeScolaire(Etudiant etudiant, AnneeScolaire anneeScolaire) {
        return absenceRepository
                .countAbsenceByArchiverFalseAndInscription_EtudiantAndInscription_AnneeScolaire(etudiant, anneeScolaire)
                .orElse(null);
    }

    public Integer nombreAbsenceByCoursAndAnneeScolaire(Cours cours, AnneeScolaire anneeScolaire) {
        return absenceRepository
                .countAbsenceByArchiverFalseAndCoursAndInscription_AnneeScolaire(cours, anneeScolaire)
                .orElse(null);
    }

    public Integer nombreAbsenceByClasseAndAnneeScolaire(Classe classe, AnneeScolaire anneeScolaire) {
        return absenceRepository
                .countAbsenceByArchiverFalseAndCours_ClasseAndInscription_AnneeScolaire
                        (classe, anneeScolaire).orElse(null);
    }

    public Integer nombreAbsenceByModuleAndAnneeScolaire(Module module, AnneeScolaire anneeScolaire) {
        return absenceRepository
                .countAbsenceByArchiverFalseAndCours_ModuleAndInscription_AnneeScolaire
                        (module, anneeScolaire).orElse(null);
    }

    public Integer nombreAbsenceByUEAndAnneeScolaire(UE ue, AnneeScolaire anneeScolaire) {
        return absenceRepository
                .countAbsenceByArchiverFalseAndCours_Module_UeAndInscription_AnneeScolaire
                        (ue, anneeScolaire).orElse(null);
    }
}
