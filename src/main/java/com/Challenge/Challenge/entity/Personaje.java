package com.Challenge.Challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="personaje")
@Getter
@Setter
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String imagen;
    private String nombre;
    private int edad;
    private double peso;
    private String historia;

    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL)
    /* ¿Es necesario inicializar el objecto (vi que en los videos lo hacen asi?,
    entiendo segun este link que para diagramar no es necesario, pero que para que
    no devuelva null si
    https://stackoverflow.com/questions/20715143/to-initialize-or-not-initialize-jpa-relationship-mappings
    */
    private Set<Pelicula> peliculas= new HashSet<>();


}
