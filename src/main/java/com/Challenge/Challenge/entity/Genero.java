package com.Challenge.Challenge.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="genero")
@Getter
@Setter
public class Genero {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String imagen;

    @OneToMany(mappedBy="genero")
    private List<Pelicula> peliculas= new ArrayList<>();

}
