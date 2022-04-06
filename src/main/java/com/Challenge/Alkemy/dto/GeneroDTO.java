package com.Challenge.Alkemy.dto;


import com.Challenge.Alkemy.entity.Pelicula;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class GeneroDTO {


    private Long id;
    @NotBlank
    private String nombre;
    private String imagen;


}
