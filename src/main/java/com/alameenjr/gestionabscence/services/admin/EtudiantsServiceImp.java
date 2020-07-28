package com.alameenjr.gestionabscence.services.admin;

import com.alameenjr.gestionabscence.entities.inscription.Etudiant;
import com.alameenjr.gestionabscence.repositories.inscription.EtudiantRepository;
import org.aspectj.weaver.tools.cache.FlatFileCacheBacking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantsServiceImp {
	//@Autowired
	//private EtudiantRepository etudiantRepository;
	private final EtudiantRepository etudiantsRepository;
	private FlatFileCacheBacking WorkbookFactory;

	public EtudiantsServiceImp(EtudiantRepository etudiantsRepository) {
		this.etudiantsRepository = etudiantsRepository;
	}

	public Etudiant addEtudiant(Etudiant etudiants) {
		// TODO Auto-generated method stub
		return etudiantsRepository.save(etudiants);
	}

	public List<Etudiant> getAllEtudiant() {
		// TODO Auto-generated method stub
		return etudiantsRepository.findAll();
	}

	public Etudiant updateEtudiant(Etudiant etudiants, Long id) {
		// TODO Auto-generated method stub
		Etudiant etudiantsUpdate = etudiantsRepository.findById(id).get();
		etudiantsUpdate.setNom(etudiants.getNom());
		etudiantsUpdate.setPrenom(etudiants.getPrenom());
		etudiantsUpdate.setDateNaissance(etudiants.getDateNaissance());
		etudiantsUpdate.setMatricule(etudiants.getMatricule());
		return etudiantsRepository.saveAndFlush(etudiantsUpdate);
	}

	public void deleteEtudiant(Long id) {
		// TODO Auto-generated method stub
		etudiantsRepository.deleteById(id);
	}


	public Etudiant getEtudiant(Long id) {
		// TODO Auto-generated method stub
		return etudiantsRepository.findById(id).get();
	}

}
