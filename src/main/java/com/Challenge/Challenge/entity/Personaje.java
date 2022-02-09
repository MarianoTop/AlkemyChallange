package com.Challenge.Challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    // ¿Esta bien inicializarlo aca (vi que en los videos lo hacen asi?, ¿deberia hacerlo en un constructor?
    private List<Pelicula> peliculas= new ArrayList<>();


}
