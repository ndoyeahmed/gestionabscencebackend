package com.alameenjr.gestionabscence.entities.admin;

import com.alameenjr.gestionabscence.entities.etablissementadmin.Formation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String libelle;
    private String telephone;
    private String adresse;
    private double latitude;
    private double longitude;
    private boolean archiver;

    @ManyToOne
    @JoinColumn(name = "etablissement", referencedColumnName = "id")
    private Etablissement etablissement;

    @OneToMany(mappedBy = "campus")
    @JsonIgnore
    private List<Formation> formations;
}
