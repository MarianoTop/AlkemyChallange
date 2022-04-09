package com.Challenge.Alkemy.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class PersonajeFilterDTO {

    private String name;
    private Integer age;
    private Set<Long> idMovies;

    public PersonajeFilterDTO(String name, Integer age, Set<Long> idMovies){
        this.name=name;
        this.age=age;
        this.idMovies=idMovies;
    }
}
