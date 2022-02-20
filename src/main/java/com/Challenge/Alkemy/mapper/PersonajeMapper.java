package com.Challenge.Alkemy.mapper;

import com.Challenge.Alkemy.dto.GeneroDTO;
import com.Challenge.Alkemy.dto.PersonajeBasicDTO;


import com.Challenge.Alkemy.dto.PersonajeDTO;
import com.Challenge.Alkemy.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonajeMapper {

    @Autowired
    PeliculaMapper peliculaMapper;

    public Personaje personajeDTO2Entity(PersonajeDTO dto){

        Personaje entity= new Personaje();
        entity.setImagen(dto.getImagen());
        entity.setNombre(dto.getNombre());
        entity.setEdad(dto.getEdad());

            entity.setPeliculas(peliculaMapper.peliculaDTOSet2EntitySet(dto.getPeliculas()));

        entity.setHistoria(dto.getHistoria());
        entity.setPeso(dto.getPeso());
        return entity;
    }

    public PersonajeDTO personajeEntity2PersonajeDTO(Personaje entity, boolean loadMovies){

        PersonajeDTO dto= new PersonajeDTO();
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        dto.setEdad(entity.getEdad());
        if(loadMovies){
            dto.setPeliculas(peliculaMapper.peliculaEntitySet2DTOSet(entity.getPeliculas(),false));
        }

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

    public Set<PersonajeDTO> personajeEntitySet2DTOSet(Set<Personaje> entities,boolean loadMovies){

        Set<PersonajeDTO> personajesDtoSet= new HashSet<>();

        for(Personaje entity: entities){
            personajesDtoSet.add(this.personajeEntity2PersonajeDTO(entity,loadMovies));
        }

        return personajesDtoSet;

    }

    public Set<Personaje> personajeDTOSet2EntitySet(Set<PersonajeDTO> dtos){

        Set<Personaje> personajesEntitySet= new HashSet<>();

        for(PersonajeDTO dto: dtos){
            personajesEntitySet.add(this.personajeDTO2Entity(dto));
        }

        return personajesEntitySet;

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
            entity.setPeliculas(peliculaMapper.peliculaDTOSet2EntitySet(dto.getPeliculas()));
        }

       return entity;

    }

}
