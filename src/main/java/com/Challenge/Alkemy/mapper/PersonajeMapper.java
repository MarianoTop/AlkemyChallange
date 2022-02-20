package com.Challenge.Alkemy.mapper;

import com.Challenge.Alkemy.dto.GeneroDTO;
import com.Challenge.Alkemy.dto.PersonajeBasicDTO;


import com.Challenge.Alkemy.dto.PersonajeDTO;
import com.Challenge.Alkemy.entity.Personaje;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonajeMapper {

    public Personaje personajeDTO2Entity(PersonajeDTO dto){

        Personaje entity= new Personaje();
        entity.setImagen(dto.getImagen());
        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());
        entity.setPeliculas(dto.getPeliculas());
        entity.setHistoria(dto.getHistoria());
        entity.setPeso(dto.getPeso());
        return entity;
    }

    public PersonajeDTO personajeEntity2PersonajeDTO(Personaje entity){

        PersonajeDTO dto= new PersonajeDTO();
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        dto.setPeliculas(entity.getPeliculas());
        dto.setHistoria(entity.getHistoria());
        dto.setPeso(entity.getPeso());
        dto.setId(entity.getId());
        return dto;
    }


    public PersonajeBasicDTO personajeEntity2basicDTO(Personaje entity){
       PersonajeBasicDTO dto =  new PersonajeBasicDTO();
       dto.setId(entity.getId());
       dto.setImagen(entity.getImagen());
       dto.setNombre(entity.getNombre());
       return dto;
    }

    public List<PersonajeBasicDTO> personajeEntityList2BasicDTOList(List<Personaje> entities){

        List<PersonajeBasicDTO> personajesBasicDtoList= new ArrayList<>();

        for(Personaje entity: entities){
            personajesBasicDtoList.add(this.personajeEntity2basicDTO(entity));
        }

        return personajesBasicDtoList;

    }

    public Personaje personajeEntityRefreshValues(Personaje entity, PersonajeDTO dto){

        if(dto.getEdad()!=0){
            entity.setEdad(dto.getEdad());
        }

        if(dto.getNombre()!=null && !dto.getNombre().isEmpty()){
            entity.setNombre(dto.getNombre());
        }

        if(dto.getHistoria()!=null && !dto.getHistoria().isEmpty()){
            entity.setHistoria(dto.getHistoria());
        }

        if(dto.getImagen()!=null && !dto.getImagen().isEmpty()){
            entity.setImagen(dto.getImagen());
        }

        if(dto.getPeso()!=0){
            entity.setPeso(dto.getPeso());
        }
        if(dto.getPeliculas().size()!=0){
            entity.setPeliculas(dto.getPeliculas());
        }

       return entity;

    }

}
