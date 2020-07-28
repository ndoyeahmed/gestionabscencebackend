package com.alameenjr.gestionabscence.entities.etablissementadmin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String libelle;
    private boolean archive;

    @OneToMany(mappedBy = "niveau")
    @JsonIgnore
    private List<Classe> classes;
}
