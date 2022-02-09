package com.Challenge.Challenge.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="pelicula")
@Getter
@Setter
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String imagen;
    private String titulo;

    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate fechaCreacion;

    private int Calificacion;

    @ManyToOne(fetch= FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name="genero_id",insertable = false,updatable = false)
    private Genero genero;

    @Column(name="genero_id", nullable = false)
    private Long generoId;

    @ManyToMany(cascade= {
            CascadeType.PERSIST,
            CascadeType.MERGE }  )
    @JoinTable(
            name="pelicula_personaje",
            joinColumns = @JoinColumn(name="pelicula_id"),
            inverseJoinColumns = @JoinColumn(name="personaje_id") )
    private Set<Personaje> personajes= new HashSet<>();
}
