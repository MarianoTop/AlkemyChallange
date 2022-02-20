package com.Challenge.Alkemy.dto;


import com.Challenge.Alkemy.entity.Pelicula;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GeneroDTO {

    private Long id;
    private String nombre;
    private String imagen;
    private List<Pelicula> peliculas= new ArrayList<>();

}
