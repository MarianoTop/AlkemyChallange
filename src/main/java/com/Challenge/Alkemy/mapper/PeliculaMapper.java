package com.Challenge.Alkemy.mapper;

import com.Challenge.Alkemy.dto.PeliculaBasicDTO;
import com.Challenge.Alkemy.dto.PeliculaDTO;

import com.Challenge.Alkemy.entity.Pelicula;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaMapper {

    public Pelicula peliculaDTO2Entity(PeliculaDTO dto){

        Pelicula entity= new Pelicula();
        entity.setImagen(dto.getImagen());
        entity.setCalificacion(dto.getCalificacion());
        entity.setGeneroId(dto.getGeneroId());
        entity.setPersonajes(dto.getPersonajes());
        entity.setTitulo(dto.getTitulo());
        entity.setFechaCreacion(dto.getFechaCreacion());
        return entity;
    }

    public PeliculaDTO peliculaEntity2PeliculaDTO(Pelicula entity){

        PeliculaDTO dto= new PeliculaDTO();
        dto.setImagen(entity.getImagen());
        dto.setGenero(entity.getGenero());
        dto.setCalificacion(entity.getCalificacion());
        dto.setPersonajes(entity.getPersonajes());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setTitulo(entity.getTitulo());
        dto.setId(entity.getId());

        return dto;
    }


    public PeliculaBasicDTO peliculaEntity2basicDTO(Pelicula entity){
       PeliculaBasicDTO dto =  new PeliculaBasicDTO();
       dto.setId(entity.getId());
       dto.setImagen(entity.getImagen());
       dto.setFechaCreacion(entity.getFechaCreacion());
       dto.setTitulo(entity.getTitulo());
       return dto;
    }

    public List<PeliculaBasicDTO> peliculaEntityList2BasicDTOList(List<Pelicula> entities){

        List<PeliculaBasicDTO> peliculaBasicDtoList= new ArrayList<>();

        for(Pelicula entity: entities){
            peliculaBasicDtoList.add(this.peliculaEntity2basicDTO(entity));
        }

        return peliculaBasicDtoList;

    }

    public Pelicula peliculaEntityRefreshValues(Pelicula entity, PeliculaDTO dto){

        if(dto.getCalificacion()>0 && dto.getCalificacion()<=5){
            entity.setCalificacion(dto.getCalificacion());
        }

        if(dto.getTitulo()!=null && !dto.getTitulo().isEmpty()){
            entity.setTitulo(dto.getTitulo());
        }

        if(dto.getGeneroId()!=0){
            entity.setGeneroId(dto.getGeneroId());
        }

        if(dto.getImagen()!=null && !dto.getImagen().isEmpty()){
            entity.setImagen(dto.getImagen());
        }

        if(dto.getFechaCreacion()!=null){
            entity.setFechaCreacion(dto.getFechaCreacion());
        }
        if(dto.getPersonajes().size()!=0){
            entity.setPersonajes(dto.getPersonajes());
        }

       return entity;

    }

}
