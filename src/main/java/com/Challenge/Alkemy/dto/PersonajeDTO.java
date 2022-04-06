package com.Challenge.Alkemy.dto;

import com.Challenge.Alkemy.entity.Pelicula;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class PersonajeDTO {

    private long id;
    private String imagen;
    private String nombre;

    @Min(value = 0)
    @Max(value = 150)
    private int edad;
    @Min(value = 0)
    @Max(value = 500)
    private double peso;

    private String historia;
    private Set<PeliculaDTO> peliculas= new HashSet<>();
}
