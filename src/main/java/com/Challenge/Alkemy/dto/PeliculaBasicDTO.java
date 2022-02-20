package com.Challenge.Alkemy.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class PeliculaBasicDTO {

    private long id;
    private String imagen;
    private String titulo;

    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate fechaCreacion;
}
