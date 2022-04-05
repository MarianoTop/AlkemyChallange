package com.Challenge.Alkemy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonajeFilterDTO {

    private String name;
    private int age;
    private Long idMovie;

    public PersonajeFilterDTO(String name, int age, Long idMovie){
        this.name=name;
        this.age=age;
        this.idMovie=idMovie;
    }
}
