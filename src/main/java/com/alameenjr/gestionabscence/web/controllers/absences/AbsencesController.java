package com.alameenjr.gestionabscence.web.controllers.absences;

import com.alameenjr.gestionabscence.entities.absences.Absence;
import com.alameenjr.gestionabscence.entities.absences.Cours;
import com.alameenjr.gestionabscence.entities.inscription.AnneeScolaire;
import com.alameenjr.gestionabscence.entities.inscription.Etudiant;
import com.alameenjr.gestionabscence.entities.inscription.Inscription;
import com.alameenjr.gestionabscence.services.absences.AbsenceService;
import com.alameenjr.gestionabscence.services.inscription.InscriptionService;
import com.alameenjr.gestionabscence.web.exceptions.BadRequestException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Log
@RequestMapping("/api")
public class AbsencesController {
    private InscriptionService inscriptionService;
    private AbsenceService absenceService;

    @Autowired
    public AbsencesController(InscriptionService inscriptionService, AbsenceService absenceService) {
        this.inscriptionService = inscriptionService;
        this.absenceService = absenceService;
    }

    @PostMapping("/absences")
    public ResponseEntity<?> saveAbsence(@RequestBody Map<String, String> body) {
        if (body.get("etudiant") == null) throw new BadRequestException("etudiant required");

        if (body.get("cours") == null) throw new BadRequestException("cours required");

        Cours cours = absenceService.findCoursById(Long.valueOf(body.get("cours")));

        if (cours == null) throw new BadRequestException("cours required");

        Inscription inscription = inscriptionService
                .findInscriptionByEtudiantId(inscriptionService.findAnneeScolaireEncours(),
                        inscriptionService.findEtudiantById(Long.valueOf(body.get("etudiant"))));

        if (inscription == null) throw new BadRequestException("etudiant required");

        Absence absence = new Absence();
        absence.setInscription(inscription);
        absence.setCours(cours);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(absenceService.saveAbsence(absence));
    }

    @GetMapping("/absences/archive/{archive}")
    public ResponseEntity<?> listAbsence(@PathVariable boolean archive) {
        return ResponseEntity.ok(absenceService.findAllAbsenceByArchive(archive));
    }

    @GetMapping("/absences/id/{id}")
    public ResponseEntity<?> getAbsenceById(@PathVariable Long id) {
        if (id == null) throw new BadRequestException("id required");

        return ResponseEntity.ok(absenceService.findAbsenceById(id));
    }

    @GetMapping("/absences/nombre/etudiant/{etudiantId}")
    public ResponseEntity<?> nombreAbsenceByEtudiantAndAnneeScolaire(@PathVariable Long etudiantId) {
        if (etudiantId == null) throw new BadRequestException("etudiantId required");

        Etudiant etudiant = inscriptionService.findEtudiantById(etudiantId);
        AnneeScolaire anneeScolaire = inscriptionService.findAnneeScolaireEncours();

        if (etudiant == null) throw new BadRequestException("etudiantId not exist");

        return ResponseEntity.ok(absenceService
                .nombreAbsenceByEtudiantAndAnneeScolaire(etudiant, anneeScolaire));
    }

    @GetMapping("/absences/nombre/cours/{coursId}")
    public ResponseEntity<?> nombreAbsenceByCoursAndAnneeScolaire(@PathVariable Long coursId) {
        if (coursId == null) throw new BadRequestException("coursId required");

        Cours cours = absenceService.findCoursById(coursId);
        AnneeScolaire anneeScolaire = inscriptionService.findAnneeScolaireEncours();

        if (cours == null) throw new BadRequestException("coursId not exist");

        return ResponseEntity.ok(absenceService
                .nombreAbsenceByCoursAndAnneeScolaire(cours, anneeScolaire));
    }
}
