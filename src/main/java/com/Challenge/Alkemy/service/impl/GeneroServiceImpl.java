package com.Challenge.Alkemy.service.impl;

import com.Challenge.Alkemy.dto.GeneroDTO;
import com.Challenge.Alkemy.dto.PeliculaDTO;
import com.Challenge.Alkemy.entity.Genero;
import com.Challenge.Alkemy.entity.Pelicula;
import com.Challenge.Alkemy.mapper.GeneroMapper;
import com.Challenge.Alkemy.repository.GeneroRepository;
import com.Challenge.Alkemy.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroMapper generoMapper;

    @Autowired
    GeneroRepository generoRepository;


    @Override
    public GeneroDTO save(GeneroDTO dto) {

        Genero genero = this.generoMapper.generoDTO2Entity(dto);
        Genero generoSaved= this.generoRepository.save(genero);
        GeneroDTO result= this.generoMapper.generoEntity2DTO(generoSaved);

        return result;
    }

    @Override
    public GeneroDTO findById(Long id) {

        Genero genero = generoRepository.findById(id).orElse(null);
        if(genero==null){
            throw new RuntimeException("Genero no encontrado");
        }
        GeneroDTO dto= generoMapper.generoEntity2DTO(genero);
        return dto;

    }


}
