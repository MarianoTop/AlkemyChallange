package com.Challenge.Alkemy.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="genero")
@Getter
@Setter
@SQLDelete(sql= "UPDATE genero set deleted=true WHERE id=?")
@Where(clause="deleted=false")
public class Genero {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String imagen;

    @OneToMany(mappedBy="genero")
    private List<Pelicula> peliculas= new ArrayList<>();
    private boolean deleted= Boolean.FALSE;
}
