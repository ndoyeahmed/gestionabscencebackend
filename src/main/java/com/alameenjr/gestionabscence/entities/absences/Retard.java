package com.alameenjr.gestionabscence.entities.absences;

import com.alameenjr.gestionabscence.entities.inscription.Inscription;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Retard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String justification;
    private boolean archiver;

    @ManyToOne
    @JoinColumn(name = "inscription", referencedColumnName = "id")
    private Inscription inscription;

    @ManyToOne
    @JoinColumn(name = "cours", referencedColumnName = "id")
    private Cours cours;
}
