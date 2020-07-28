package com.alameenjr.gestionabscence;

import com.alameenjr.gestionabscence.config.SpringSecurityAuditorAware;
import com.alameenjr.gestionabscence.services.admin.UtilisateurService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableSwagger2
@Log
@SpringBootApplication
public class GestionabscenceApplication extends SpringBootServletInitializer implements CommandLineRunner {
	private UtilisateurService utilisateurService;

	@Bean
	public AuditorAware<String> auditorAware() {
		return new SpringSecurityAuditorAware();
	}

	@Autowired
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GestionabscenceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		utilisateurService.addDefaultAdmin();
	}
}
