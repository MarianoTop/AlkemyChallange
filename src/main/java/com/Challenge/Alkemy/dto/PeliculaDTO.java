package com.Challenge.Alkemy.dto;

import com.Challenge.Alkemy.entity.Genero;
import com.Challenge.Alkemy.entity.Personaje;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class PeliculaDTO {

    private long id;
    private String imagen;
    private String titulo;

    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate fechaCreacion;

    private int Calificacion;
    private Genero genero;
    private Long generoId;
    private Set<PersonajeDTO> personajes= new HashSet<>();

}
