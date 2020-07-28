package com.alameenjr.gestionabscence.web.controllers.admin;

import java.io.IOException;
import java.util.List;

import com.alameenjr.gestionabscence.utils.EtudiantExcelExport;
import com.alameenjr.gestionabscence.entities.inscription.Etudiant;
import com.alameenjr.gestionabscence.services.admin.EtudiantsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantsController {
	
	@Autowired
	private final EtudiantsServiceImp etudiantsService;

	public EtudiantsController(EtudiantsServiceImp etudiantsService) {
		this.etudiantsService = etudiantsService;
	}

	@PostMapping
	public Etudiant AddEtudiant(@RequestBody Etudiant etudiants) {
		return etudiantsService.addEtudiant(etudiants);
		
	}
	
	@GetMapping
	public List<Etudiant> findAll(){
		return etudiantsService.getAllEtudiant();
	}
	
	@GetMapping("{id}")
	public Etudiant getOne(@PathVariable Long id){
		return etudiantsService.getEtudiant(id);
	}
	
	@PutMapping("{id}")
	public Etudiant updateEtudiant(@RequestBody Etudiant etudiants, @PathVariable Long id) {
		//etudiant.setDateInscrit(new Date());
		return etudiantsService.updateEtudiant(etudiants, id);
	}
	
	@DeleteMapping("{id}")
	public void delete(Long id) {
		etudiantsService.deleteEtudiant(id);
	}

	@PostMapping("/upload")
	public void uploadListEtudiant(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachement; filename=etudiants.xlsx";

		response.setHeader(headerKey, headerValue);

		List<Etudiant> etudiantsList = etudiantsService.getAllEtudiant();

		EtudiantExcelExport etudiantExcelExport = new EtudiantExcelExport(etudiantsList);
		etudiantExcelExport.export(response);
	}
}
