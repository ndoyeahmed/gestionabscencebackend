package com.alameenjr.gestionabscence.entities.etablissementadmin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String libelle;
    private boolean archive;

    @OneToMany(mappedBy = "semestre")
    @JsonIgnore
    private List<FormationSemestre> formationSemestres;

    @OneToMany(mappedBy = "semestre")
    @JsonIgnore
    private List<UE> ueList;
}
