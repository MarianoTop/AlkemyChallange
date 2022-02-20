package com.Challenge.Alkemy.controller;


import com.Challenge.Alkemy.dto.GeneroDTO;
import com.Challenge.Alkemy.entity.Genero;
import com.Challenge.Alkemy.service.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> getAll(){
        List<GeneroDTO> generos= generoService.getAllGeneros();
        return ResponseEntity.ok().body(generos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO> getById(@PathVariable Long id){
       GeneroDTO genero= generoService.getById(id);
        return ResponseEntity.ok().body(genero);
    }

    @PostMapping
    public ResponseEntity<GeneroDTO> save (@RequestBody GeneroDTO genero){
        GeneroDTO generoGuardado = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }


}
