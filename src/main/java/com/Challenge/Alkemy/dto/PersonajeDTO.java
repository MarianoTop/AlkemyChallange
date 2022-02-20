package com.Challenge.Alkemy.dto;

import com.Challenge.Alkemy.entity.Pelicula;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class PersonajeDTO {

    private long id;
    private String imagen;
    private String nombre;
    private int edad;
    private double peso;
    private String historia;
    private Set<Pelicula> peliculas= new HashSet<>();
}
