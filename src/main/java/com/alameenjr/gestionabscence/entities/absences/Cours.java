package com.alameenjr.gestionabscence.entities.absences;

import com.alameenjr.gestionabscence.entities.etablissementadmin.Classe;
import com.alameenjr.gestionabscence.entities.etablissementadmin.Module;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private Timestamp jour;
    private String heureDebut;
    private String heureFin;
    private boolean archive;

    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    private List<Absence> absences;

    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    private List<Retard> retards;

    @ManyToOne
    @JoinColumn(name = "classe", referencedColumnName = "id")
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "module", referencedColumnName = "id")
    private Module module;
}
