package com.Challenge.Alkemy.controller;

import com.Challenge.Alkemy.dto.GeneroDTO;
import com.Challenge.Alkemy.dto.PersonajeBasicDTO;
import com.Challenge.Alkemy.dto.PersonajeDTO;
import com.Challenge.Alkemy.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("characters")
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;

    @GetMapping
    public ResponseEntity<List<PersonajeDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int age,
            @RequestParam(required = false) long idMovie
            )    {
        List<PersonajeDTO> personajes = personajeService.getByFilters(name,age,idMovie);

        return ResponseEntity.ok(personajes);
    }


    @RequestMapping("/getAll")
    @GetMapping
    public ResponseEntity<List<PersonajeBasicDTO>> getAll() {
        List<PersonajeBasicDTO> personajes = personajeService.getAllPersonajes();

        return ResponseEntity.ok().body(personajes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> getById(@PathVariable Long id) {
        PersonajeDTO dto = personajeService.findById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@Valid @RequestBody PersonajeDTO dto) {
        PersonajeDTO personajeGuardado = personajeService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDTO> update(@PathVariable Long id, @Valid @RequestBody PersonajeDTO dto) {
        PersonajeDTO personajeSaved = personajeService.update(id, dto);
        return ResponseEntity.ok().body(personajeSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
