package com.alameenjr.gestionabscence.entities.inscription;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    private Timestamp dateNaissance;
    private String lieuNaissance;
    @Lob
    private String photo;
    private String divers;
    private boolean statut;
    private boolean archive;

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private List<Inscription> inscriptions;
}
