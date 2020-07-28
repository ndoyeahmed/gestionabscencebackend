package com.alameenjr.gestionabscence.entities.etablissementadmin;

import com.alameenjr.gestionabscence.entities.absences.Cours;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "serial")
    private Long id;
    private String libelle;
    private boolean archive;

    @ManyToOne
    @JoinColumn(name = "ue", referencedColumnName = "id")
    private UE ue;

    @OneToMany(mappedBy = "module")
    @JsonIgnore
    private List<Cours> cours;
}
