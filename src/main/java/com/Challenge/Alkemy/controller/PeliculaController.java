package com.Challenge.Alkemy.controller;

import com.Challenge.Alkemy.dto.PeliculaBasicDTO;
import com.Challenge.Alkemy.dto.PeliculaDTO;
import com.Challenge.Alkemy.dto.PersonajeBasicDTO;
import com.Challenge.Alkemy.dto.PersonajeDTO;
import com.Challenge.Alkemy.service.PeliculaService;
import com.Challenge.Alkemy.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")

public class PeliculaController {
    @Autowired
    PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<PeliculaBasicDTO>> getAll(){
        List<PeliculaBasicDTO> peliculas = peliculaService.getAllPeliculas();

        return ResponseEntity.ok().body(peliculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> getById(@PathVariable Long id){
        PeliculaDTO dto= peliculaService.findById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PeliculaDTO> save (@RequestBody PeliculaDTO dto){
        PeliculaDTO peliculaSaved = peliculaService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculaDTO> update (@PathVariable Long id, @RequestBody PeliculaDTO dto){
        PeliculaDTO peliculaSaved = peliculaService.update(id,dto);
        return ResponseEntity.ok().body(peliculaSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        peliculaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
