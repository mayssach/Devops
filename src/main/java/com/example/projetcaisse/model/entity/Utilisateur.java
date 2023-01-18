package com.example.projetcaisse.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "UTILISATEUR")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Utilisateur implements Serializable {

    /**
     * generated serial ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * User id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
    @SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
    @Column(name = "idUser", updatable = false, nullable = false)
    private Long idUser ;

    @Column(name="cin")
    private String cin ;

    @Column(name="nom")
    private String nom ;

    @Column(name="prenom")
    private String prenom ;

    @Column(name="adresse")
    private String adresse ;

    @Column(name="numCompte")
    private Long numCompte;

    @Column(name="grade")
    private String grade;


}

