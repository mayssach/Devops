package com.example.projetcaisse.rest.controller;

import com.example.projetcaisse.model.entity.Utilisateur;
import com.example.projetcaisse.rest.dto.UtilisateurDto;
import com.example.projetcaisse.service.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Type;
import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService ;
    @Autowired
    private ModelMapper modelMapper ;
    @GetMapping("/utilisateurs")
    public Object Utilisateurlist() {
        List<Utilisateur> utilisateurs= utilisateurService.getUtilisateurList();
        Type listType = new TypeToken<List<UtilisateurDto>>() {}.getType() ;
        List <UtilisateurDto> utilisateurDtos= modelMapper.map(utilisateurs,listType);
        return ResponseEntity.status(HttpStatus.OK).body(utilisateurDtos);
    }
    @GetMapping("/utilisateurs/{idUtilisateur}")
    public Object Utilisateur(@PathVariable Long idUtilisateur ) {
        Utilisateur utilisateur = utilisateurService.getUtilisateur(idUtilisateur) ;
        UtilisateurDto utilisateurDto= modelMapper.map(utilisateur, UtilisateurDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(utilisateurDto);
    }

    @GetMapping("/utilisateurs/cin/{cin}")
    public Object UtilisateurCin(@PathVariable Long cin) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurByCin(cin.toString()) ;
        UtilisateurDto utilisateurDto= modelMapper.map(utilisateur, UtilisateurDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(utilisateurDto);
    }

    @PostMapping("/utilisateurs")
    public Object AddUtilisateur(@Validated @RequestBody UtilisateurDto utilisateurDto)
    {
        Utilisateur utilisateur = modelMapper.map(utilisateurDto, Utilisateur.class);
        utilisateur = utilisateurService.AddUtilisateur(utilisateur);
        utilisateurDto = modelMapper.map(utilisateur, UtilisateurDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurDto);
    }

    @PutMapping("/utilisateurs/{idUtilisateur}")
    public Object UpdateUtilisateur (@Validated @RequestBody UtilisateurDto utilisateurDto , @PathVariable Long idUtilisateur) {
        Utilisateur utilisateur = modelMapper.map(utilisateurDto,Utilisateur.class);
        utilisateur= utilisateurService.UpdateUtilisateur(idUtilisateur, utilisateur);
        utilisateurDto = modelMapper.map(utilisateur,UtilisateurDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurDto);

    }

    @DeleteMapping("/utilisateurs/{idUtilisateur}")
    public Object DeleteUtilisateur(@PathVariable Long idUtilisateur) {
        utilisateurService.DeleteUtilisateur(idUtilisateur);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}

