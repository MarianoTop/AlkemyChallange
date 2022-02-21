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

    private int calificacion;
    private GeneroDTO genero;
    private Long generoId;
    private Set<PersonajeDTO> personajes= new HashSet<>();

    public void setCalificacion(int calificacion){

        if(calificacion<=0|| calificacion>5){
            throw new RuntimeException("el numero debe ser superior a 0 y menor a 6");
        }
        this.calificacion=calificacion;
    }

}
