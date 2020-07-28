package com.alameenjr.gestionabscence.entities.inscription;

import com.alameenjr.gestionabscence.entities.absences.Absence;
import com.alameenjr.gestionabscence.entities.absences.Retard;
import com.alameenjr.gestionabscence.entities.etablissementadmin.Classe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private Timestamp date;
    private boolean archiver;

    @ManyToOne
    @JoinColumn(name = "etudiant", referencedColumnName = "id")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "anneeScolaire", referencedColumnName = "id")
    private AnneeScolaire anneeScolaire;

    @OneToMany(mappedBy = "inscription")
    @JsonIgnore
    private List<Absence> absences;

    @OneToMany(mappedBy = "inscription")
    @JsonIgnore
    private List<Retard> retards;

    @ManyToOne
    @JoinColumn(name = "classe", referencedColumnName = "id")
    private Classe classe;
}
