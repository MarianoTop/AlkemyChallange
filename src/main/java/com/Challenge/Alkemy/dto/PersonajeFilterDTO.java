package com.Challenge.Alkemy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonajeFilterDTO {

    private String name;
    private Integer age;
    private Long idMovie;

    public PersonajeFilterDTO(String name, Integer age, Long idMovie){
        this.name=name;
        this.age=age;
        this.idMovie=idMovie;
    }
}
