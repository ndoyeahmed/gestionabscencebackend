package com.alameenjr.gestionabscence.entities.etablissementadmin;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FormationSemestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "formation", referencedColumnName = "id")
    private Formation formation;

    @ManyToOne
    @JoinColumn(name = "semestre", referencedColumnName = "id")
    private Semestre semestre;
}
