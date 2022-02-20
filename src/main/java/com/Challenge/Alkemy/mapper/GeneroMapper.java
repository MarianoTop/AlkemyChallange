package com.Challenge.Alkemy.mapper;

import com.Challenge.Alkemy.dto.GeneroDTO;
import com.Challenge.Alkemy.entity.Genero;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    public Genero generoDTO2Entity(GeneroDTO dto){
        Genero generoEntity = new Genero();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setNombre(dto.getNombre());
        generoEntity.setPeliculas(dto.getPeliculas());

        return generoEntity;
    }

    public GeneroDTO generoEntity2DTO(Genero entity){
       GeneroDTO dto =  new GeneroDTO();
       dto.setImagen(entity.getImagen());
       dto.setNombre(entity.getNombre());
       dto.setPeliculas(entity.getPeliculas());
       dto.setId(entity.getId());
       return dto;
    }

    public List<GeneroDTO> generoEntityList2DTOList(List<Genero> entities) {
        List<GeneroDTO> dtos= new ArrayList<>();
        for (Genero entity: entities){
            dtos.add(this.generoEntity2DTO(entity));
        }

        return dtos;
    }


}
