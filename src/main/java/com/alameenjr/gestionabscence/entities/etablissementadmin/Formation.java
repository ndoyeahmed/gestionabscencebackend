package com.alameenjr.gestionabscence.entities.etablissementadmin;

import com.alameenjr.gestionabscence.entities.admin.Campus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String libelle;
    private boolean archive;

    @ManyToOne
    @JoinColumn(name = "campus", referencedColumnName = "id")
    private Campus campus;

    @OneToMany(mappedBy = "formation")
    @JsonIgnore
    private List<FormationSemestre> formationSemestres;

    @OneToMany(mappedBy = "formation")
    @JsonIgnore
    private List<Classe> classes;
}
