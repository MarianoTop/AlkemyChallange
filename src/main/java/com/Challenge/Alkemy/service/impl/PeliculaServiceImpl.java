package com.Challenge.Alkemy.service.impl;

import com.Challenge.Alkemy.auxiliary.ErrorMessage;
import com.Challenge.Alkemy.dto.PeliculaBasicDTO;
import com.Challenge.Alkemy.dto.PeliculaDTO;
import com.Challenge.Alkemy.dto.PersonajeBasicDTO;
import com.Challenge.Alkemy.dto.PersonajeDTO;
import com.Challenge.Alkemy.entity.Pelicula;
import com.Challenge.Alkemy.entity.Personaje;
import com.Challenge.Alkemy.exception.ParamNotFound;
import com.Challenge.Alkemy.mapper.PeliculaMapper;
import com.Challenge.Alkemy.mapper.PersonajeMapper;
import com.Challenge.Alkemy.repository.PeliculaRepository;
import com.Challenge.Alkemy.repository.PersonajeRepository;
import com.Challenge.Alkemy.service.PeliculaService;
import com.Challenge.Alkemy.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaMapper peliculaMapper;
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public PeliculaDTO findById(Long id) {
        Pelicula entity= peliculaRepository.findById(id).orElse(null);
        if(entity==null){
            throw new ParamNotFound(String.format(ErrorMessage.OBJECT_DOESNT_EXIST,"Pelicula"));
        }
        PeliculaDTO dto=peliculaMapper.peliculaEntity2PeliculaDTO(entity,true);
        return dto;
    }

    @Override
    public void delete(Long id) {
        Pelicula entity= peliculaRepository.findById(id).orElse(null);
        if(entity==null){
            throw new ParamNotFound(String.format(ErrorMessage.OBJECT_DOESNT_EXIST,"Pelicula"));
        }

        peliculaRepository.deleteById(id);
    }





    @Override
    public List<PeliculaBasicDTO> getAllPeliculas() {

        List<Pelicula> peliculas = peliculaRepository.findAll();
        List<PeliculaBasicDTO> result= peliculaMapper.peliculaEntityList2BasicDTOList(peliculas);
        return result;
    }

    @Override
    public PeliculaDTO save(PeliculaDTO dto){
       Pelicula entity= peliculaMapper.peliculaDTO2Entity(dto);
       Pelicula entitySaved=peliculaRepository.save(entity);
       PeliculaDTO result= peliculaMapper.peliculaEntity2PeliculaDTO(entitySaved,true);
       return result;
    }

    @Override
    public PeliculaDTO update(Long id, PeliculaDTO dto) {
        Pelicula entitySearched= peliculaRepository.findById(id).orElse(null);


        if(entitySearched==null){
            throw new ParamNotFound(String.format(ErrorMessage.OBJECT_DOESNT_EXIST,"Pelicula"));
        }

        this.peliculaMapper.peliculaEntityRefreshValues(entitySearched,dto);
        Pelicula entityModified=peliculaRepository.save(entitySearched);
        PeliculaDTO result= peliculaMapper.peliculaEntity2PeliculaDTO(entityModified,true);

        return result;
    }

    @Override
    public void addPersonaje(Long id, Long idPersonaje) {

        Pelicula peliculaSearched= this.peliculaRepository.findById(id).orElse(null);

        if(peliculaSearched==null){
            throw new ParamNotFound(String.format(ErrorMessage.OBJECT_DOESNT_EXIST,"Pelicula"));
        }

        Personaje personajeSearched= this.personajeRepository.findById(idPersonaje).orElse(null);

        if (personajeSearched==null){
            throw new RuntimeException("Personaje was not found");
        }

        peliculaSearched.getPersonajes().add(personajeSearched);
        peliculaRepository.save(peliculaSearched);

    }
    @Override
    public void removePersonaje(Long id, Long idPersonaje) {

        Pelicula peliculaSearched= this.peliculaRepository.findById(id).orElse(null);

        if(peliculaSearched==null){
            throw new ParamNotFound(String.format(ErrorMessage.OBJECT_DOESNT_EXIST,"Pelicula"));
        }

        Personaje personajeSearched= this.personajeRepository.findById(idPersonaje).orElse(null);

        if (personajeSearched==null){
            throw new ParamNotFound(String.format(ErrorMessage.OBJECT_DOESNT_EXIST,"Personaje"));
        }

        peliculaSearched.getPersonajes().remove(personajeSearched);
        peliculaRepository.save(peliculaSearched);
    }





}
