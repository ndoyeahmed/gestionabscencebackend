package com.alameenjr.gestionabscence.entities.inscription;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AnneeScolaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String annee;
    private boolean encours;
    private boolean archiver;

    @OneToMany(mappedBy = "anneeScolaire")
    @JsonIgnore
    private List<Inscription> inscriptions;
}
