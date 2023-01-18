package com.example.projetcaisse.rest.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UtilisateurDto {
    private Long idUser ;
    private String cin ;
    private String nom ;
    private String prenom ;
    private String adresse ;
    private Long numCompte;
    private String grade;
}
