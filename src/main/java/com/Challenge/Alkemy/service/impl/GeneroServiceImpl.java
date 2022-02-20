package com.Challenge.Alkemy.service.impl;

import com.Challenge.Alkemy.dto.GeneroDTO;
import com.Challenge.Alkemy.entity.Genero;
import com.Challenge.Alkemy.mapper.GeneroMapper;
import com.Challenge.Alkemy.repository.GeneroRepository;
import com.Challenge.Alkemy.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private GeneroRepository generoRepository;

    public GeneroDTO save(GeneroDTO dto){

        Genero genero= generoMapper.generoDTO2Entity(dto);
        Genero generoGuardado=generoRepository.save(genero);
        GeneroDTO result= generoMapper.generoEntity2DTO(generoGuardado);

        return result;
    }


    public List<GeneroDTO> getAllGeneros() {

        List <Genero> entities= generoRepository.findAll();
        List <GeneroDTO> result= generoMapper.generoEntityList2DTOList(entities);
        return result;
    }


    public GeneroDTO getById(Long id) {
        Genero entity= generoRepository.findById(id).orElse(null);
        GeneroDTO dto= generoMapper.generoEntity2DTO(entity);
        return dto;
    }
}
