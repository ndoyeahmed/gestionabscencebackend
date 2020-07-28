package com.alameenjr.gestionabscence.repositories.absences;

import com.alameenjr.gestionabscence.entities.absences.Absence;
import com.alameenjr.gestionabscence.entities.absences.Cours;
import com.alameenjr.gestionabscence.entities.admin.Etablissement;
import com.alameenjr.gestionabscence.entities.etablissementadmin.Classe;
import com.alameenjr.gestionabscence.entities.etablissementadmin.Module;
import com.alameenjr.gestionabscence.entities.etablissementadmin.UE;
import com.alameenjr.gestionabscence.entities.inscription.AnneeScolaire;
import com.alameenjr.gestionabscence.entities.inscription.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    Optional<List<Absence>> findAllByArchiver(boolean archiver);

    Optional<Integer> countAbsenceByArchiverFalseAndInscription_EtudiantAndInscription_AnneeScolaire(Etudiant etudiant, AnneeScolaire anneeScolaire);

    Optional<Integer> countAbsenceByArchiverFalseAndCoursAndInscription_AnneeScolaire(Cours cours, AnneeScolaire anneeScolaire);

    Optional<Integer> countAbsenceByArchiverFalseAndCours_ClasseAndInscription_AnneeScolaire(Classe classe, AnneeScolaire anneeScolaire);

    Optional<Integer> countAbsenceByArchiverFalseAndCours_ModuleAndInscription_AnneeScolaire(Module module, AnneeScolaire anneeScolaire);

    Optional<Integer> countAbsenceByArchiverFalseAndCours_Module_UeAndInscription_AnneeScolaire(UE ue, AnneeScolaire anneeScolaire);

    Optional<List<Absence>> findAllByArchiverAndCours_Classe_Formation_Campus_EtablissementAndInscription_AnneeScolaire(boolean archiver, Etablissement etablissement, AnneeScolaire anneeScolaire);
}
