package com.alameenjr.gestionabscence.entities.etablissementadmin;

import com.alameenjr.gestionabscence.entities.absences.Cours;
import com.alameenjr.gestionabscence.entities.inscription.Inscription;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String libelle;
    private boolean archive;

    @OneToMany(mappedBy = "classe")
    @JsonIgnore
    private List<Inscription> inscriptions;

    @ManyToOne
    @JoinColumn(name = "niveau", referencedColumnName = "id")
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name = "formation", referencedColumnName = "id")
    private Formation formation;

    @OneToMany(mappedBy = "classe")
    @JsonIgnore
    private List<Cours> cours;
}
