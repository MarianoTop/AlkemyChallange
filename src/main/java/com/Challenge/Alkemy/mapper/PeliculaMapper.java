package com.Challenge.Alkemy.mapper;

import com.Challenge.Alkemy.dto.PeliculaBasicDTO;
import com.Challenge.Alkemy.dto.PeliculaDTO;

import com.Challenge.Alkemy.entity.Pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PeliculaMapper {

    @Autowired
    PersonajeMapper personajeMapper;

    @Autowired
    GeneroMapper generoMapper;

    public Pelicula peliculaDTO2Entity(PeliculaDTO dto){

        Pelicula entity= new Pelicula();
        entity.setImagen(dto.getImagen());
        entity.setCalificacion(dto.getCalificacion());
       // entity.setGenero(this.generoMapper.generoDTO2Entity(dto.getGenero()));
        entity.setGeneroId(dto.getGeneroId());
        entity.setPersonajes(personajeMapper.personajeDTOSet2EntitySet(dto.getPersonajes()));
        entity.setTitulo(dto.getTitulo());
        entity.setFechaCreacion(dto.getFechaCreacion());
        return entity;
    }

    public PeliculaDTO peliculaEntity2PeliculaDTO(Pelicula entity, boolean loadCharacter){

        PeliculaDTO dto= new PeliculaDTO();
        dto.setImagen(entity.getImagen());
       // dto.setGenero(generoMapper.generoEntity2DTO(entity.getGenero()));
        dto.setGeneroId(entity.getGeneroId());
        dto.setCalificacion(entity.getCalificacion());
        if(loadCharacter){
            dto.setPersonajes(this.personajeMapper.personajeEntitySet2DTOSet(entity.getPersonajes(),false));
        }
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

    public List<PeliculaDTO> peliculaEntityList2DTOList(List<Pelicula> entities, boolean load){

        List<PeliculaDTO> peliculaDtoList= new ArrayList<>();

        for(Pelicula entity: entities){
            peliculaDtoList.add(this.peliculaEntity2PeliculaDTO(entity,load));
        }

        return peliculaDtoList;

    }

    public Set<PeliculaDTO> peliculaEntitySet2DTOSet(Set<Pelicula> entities, boolean loadCharacter){

        Set<PeliculaDTO> peliculaDtoSet= new HashSet<>();

        for(Pelicula entity: entities){
            peliculaDtoSet.add(this.peliculaEntity2PeliculaDTO(entity,loadCharacter));
        }

        return peliculaDtoSet;

    }


    public Set<Pelicula> peliculaDTOSet2EntitySet(Set<PeliculaDTO> dtos){

        Set<Pelicula> peliculaEntitySet= new HashSet<>();

        for(PeliculaDTO dto: dtos){
            peliculaEntitySet.add(this.peliculaDTO2Entity(dto));
        }

        return peliculaEntitySet;

    }

    public Pelicula peliculaEntityRefreshValues(Pelicula entity, PeliculaDTO dto){

        if(dto.getCalificacion()>0 && dto.getCalificacion()<=5){
            entity.setCalificacion(dto.getCalificacion());
        }

        if(dto.getTitulo()!=null && !dto.getTitulo().isEmpty()){
            entity.setTitulo(dto.getTitulo());
        }

        if(dto.getGenero()!=null){
            entity.setGenero(generoMapper.generoDTO2Entity(dto.getGenero()));
        }

        if(dto.getGeneroId()!=null && dto.getGeneroId()!=0){
            entity.setGeneroId(dto.getGeneroId());
        }

        if(dto.getImagen()!=null && !dto.getImagen().isEmpty()){
            entity.setImagen(dto.getImagen());
        }

        if(dto.getFechaCreacion()!=null){
            entity.setFechaCreacion(dto.getFechaCreacion());
        }
        /*  Consigna: Al momento del Update, es importante solo actualizar la Entidad
Película y no su listado de personajes
        if(dto.getPersonajes().size()!=0){
            entity.setPersonajes(personajeMapper.personajeDTOSet2EntitySet(dto.getPersonajes()));
        }*/

       return entity;

    }

}
