package com.alameenjr.gestionabscence.repositories.admin;

import com.alameenjr.gestionabscence.entities.admin.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {
}
