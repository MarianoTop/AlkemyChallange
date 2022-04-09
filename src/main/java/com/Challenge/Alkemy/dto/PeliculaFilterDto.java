package com.Challenge.Alkemy.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeliculaFilterDto {

    private String name;
    private Long genreId;
    private String order;

    public PeliculaFilterDto(String name, Long genreId, String order) {
        this.name = name;
        this.genreId = genreId;
        this.order = order;
    }

    public boolean isAsc(){
        return this.order.compareToIgnoreCase("ASC") ==0;
    }
    public boolean isDesc(){
        return this.order.compareToIgnoreCase("Desc") ==0;
    }


}
