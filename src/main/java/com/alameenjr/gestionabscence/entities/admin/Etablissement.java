package com.alameenjr.gestionabscence.entities.admin;

import com.alameenjr.gestionabscence.entities.etablissementadmin.Formation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String libelle;
    private String siteWeb;
    private String telephone;
    private String adresse;
    private double latitude;
    private double longitude;
    private boolean archiver;

    @OneToMany(mappedBy = "etablissement")
    @JsonIgnore
    private List<Utilisateur> utilisateurs;

    @OneToMany(mappedBy = "etablissement")
    @JsonIgnore
    private List<Campus> campuses;
}
