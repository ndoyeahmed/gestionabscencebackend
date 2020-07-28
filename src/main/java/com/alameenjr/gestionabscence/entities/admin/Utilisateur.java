package com.alameenjr.gestionabscence.entities.admin;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@JsonFilter("passwordFilter")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    @Lob
    private String photo;
    private boolean statut;
    @Column(columnDefinition = "boolean default false")
    private boolean archive;
    @Column(columnDefinition = "boolean default false")
    private boolean passwordChange;

    @OneToMany(mappedBy = "utilisateur")
    private List<ProfilUtilisateur> profilUtilisateurs;

    @ManyToOne
    @JoinColumn(name = "etablissement", referencedColumnName = "id")
    private Etablissement etablissement;
}
