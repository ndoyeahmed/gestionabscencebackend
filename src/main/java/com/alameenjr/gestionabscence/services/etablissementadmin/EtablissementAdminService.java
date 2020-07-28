package com.alameenjr.gestionabscence.services.etablissementadmin;

import com.alameenjr.gestionabscence.entities.etablissementadmin.Module;
import com.alameenjr.gestionabscence.entities.etablissementadmin.UE;
import com.alameenjr.gestionabscence.repositories.etablissementadmin.ModuleRepository;
import com.alameenjr.gestionabscence.repositories.etablissementadmin.UERepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
@Transactional
public class EtablissementAdminService {
    private ModuleRepository moduleRepository;
    private UERepository ueRepository;

    @Autowired
    public EtablissementAdminService(ModuleRepository moduleRepository, UERepository ueRepository) {
        this.moduleRepository = moduleRepository;
        this.ueRepository = ueRepository;
    }

    public Module saveModule(Module module) {
        module.setArchive(false);
        moduleRepository.save(module);
        return module;
    }

    public List<Module> findAllModuleByArchive(boolean archive) {
        return moduleRepository.findAllByArchive(archive).orElse(new ArrayList<>());
    }

    public Module updateModule(Module module) {
        try {
            moduleRepository.save(module);
            return module;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }

    public Module findModuleById(Long id) {
        return moduleRepository.findById(id).orElse(null);
    }

    public List<Module> findAllModuleByUeAndArchive(UE ue, boolean archive) {
        return moduleRepository.findAllByUeAndArchive(ue, archive)
                .orElse(new ArrayList<>());
    }

    public UE findUeById(Long id) {
        return ueRepository.findById(id).orElse(null);
    }

    public UE saveUe(UE ue) {
        ue.setArchive(false);
        ueRepository.save(ue);
        return ue;
    }

    public List<UE> findAllUEByArchive(boolean archive) {
        return ueRepository.findAllByArchive(archive)
                .orElse(new ArrayList<>());
    }

    public UE updateUe(UE ue) {
        ueRepository.save(ue);
        return ue;
    }
}
