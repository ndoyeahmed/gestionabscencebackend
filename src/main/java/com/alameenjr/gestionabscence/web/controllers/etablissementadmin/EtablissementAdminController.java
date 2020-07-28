package com.alameenjr.gestionabscence.web.controllers.etablissementadmin;

import com.alameenjr.gestionabscence.entities.etablissementadmin.Module;
import com.alameenjr.gestionabscence.entities.etablissementadmin.UE;
import com.alameenjr.gestionabscence.services.etablissementadmin.EtablissementAdminService;
import com.alameenjr.gestionabscence.web.exceptions.BadRequestException;
import com.alameenjr.gestionabscence.web.exceptions.EntityNotFoundException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Log
@RequestMapping("/api")
public class EtablissementAdminController {

    private EtablissementAdminService etablissementAdminService;

    @Autowired
    public EtablissementAdminController(EtablissementAdminService etablissementAdminService) {
        this.etablissementAdminService = etablissementAdminService;
    }

    @PostMapping("/modules")
    public ResponseEntity<?> saveModule(@RequestBody Module module) {
        if (module == null) throw new BadRequestException("module cannot be null");
        if (module.getLibelle() == null || module.getLibelle().trim().equals(""))
            throw new BadRequestException("libelle module required");
        if (module.getUe() == null) throw new BadRequestException("ue required");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(etablissementAdminService.saveModule(module));
    }

    @GetMapping("/modules/archive/{archive}")
    public ResponseEntity<?> findAllModuleByArchive(@PathVariable Boolean archive) {
        if (archive == null) throw new BadRequestException("archive status required");

        return ResponseEntity.ok(etablissementAdminService.findAllModuleByArchive(archive));
    }

    @GetMapping("/modules/ue/{ueId}/archive/{archive}")
    public ResponseEntity<?> findAllModuleByUeAndArchive(@PathVariable Long ueId, @PathVariable Boolean archive) {
        if (archive == null) throw new BadRequestException("archive status required");

        UE ue = etablissementAdminService.findUeById(ueId);
        if (ue == null) throw new EntityNotFoundException("ue not found");

        return ResponseEntity
                .ok(etablissementAdminService.findAllModuleByUeAndArchive(ue, archive));
    }

    @PutMapping("/modules/{moduleId}")
    public ResponseEntity<?> updateModule(@RequestBody Module module, @PathVariable Long moduleId) {
        if (moduleId == null) throw new BadRequestException("moduleId required");

        Module module1 = etablissementAdminService.findModuleById(moduleId);
        if (module1 == null) throw new EntityNotFoundException("module not found");

        module1.setArchive(module.isArchive());
        module1.setLibelle(module.getLibelle());
        module1.setUe(module.getUe());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(etablissementAdminService.updateModule(module1));
    }

    @PostMapping("/ue")
    public ResponseEntity<?> saveUe(@RequestBody UE ue) {
        if (ue == null) throw new BadRequestException("ue required");
        if (ue.getLibelle() == null || ue.getLibelle().trim().equals(""))
            throw new BadRequestException("libelle required");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(etablissementAdminService.saveUe(ue));
    }

    @GetMapping("/ue/archive/{archive}")
    public ResponseEntity<?> listUeByArchive(@PathVariable Boolean archive) {
        if (archive == null) throw new BadRequestException("archive required");

        return ResponseEntity.ok(etablissementAdminService.findAllUEByArchive(archive));
    }

    @PutMapping("/ue/ueId/{ueId}")
    public ResponseEntity<?> updateUE(@RequestBody UE ue, @PathVariable Long ueId) {
        if (ueId == null) throw new BadRequestException("ueId required");
        if (ue == null) throw new BadRequestException("entity cannot be null");
        UE ue1 = etablissementAdminService.findUeById(ueId);
        if (ue1 == null) throw new EntityNotFoundException("ueId not found");

        ue1.setArchive(ue.isArchive());
        ue1.setLibelle(ue.getLibelle());
        ue1.setSemestre(ue.getSemestre());

        return ResponseEntity.ok(etablissementAdminService.updateUe(ue1));
    }
}
