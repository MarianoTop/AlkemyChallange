package com.Challenge.Alkemy.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pelicula")
@Getter
@Setter
@SQLDelete(sql= "UPDATE pelicula set deleted=true WHERE id=?")
@Where(clause="deleted=false")
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

    @ManyToOne(fetch= FetchType.EAGER)

    @JoinColumn(name="genero_id",insertable = false,updatable = false)
    private Genero genero;

    @Column(name="genero_id", nullable = false)
    private Long generoId;

  /*
  ¿ no seria mas simple hacerlo asi? No termino de tener en claro porque el profesor
  del video decidio la otra manera
      @JoinColumn(name="genero_id")
    private Genero genero;
*/

// revisar el fetch y cascade
    @ManyToMany(cascade= {
            CascadeType.PERSIST,
            CascadeType.MERGE }  )
    @JoinTable(
            name="pelicula_personaje",
            joinColumns = @JoinColumn(name="pelicula_id"),
            inverseJoinColumns = @JoinColumn(name="personaje_id") )
    private Set<Personaje> personajes= new HashSet<>();
    private boolean deleted= Boolean.FALSE;
}
