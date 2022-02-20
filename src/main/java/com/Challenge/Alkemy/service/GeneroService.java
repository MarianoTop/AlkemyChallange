package com.Challenge.Alkemy.service;

import com.Challenge.Alkemy.dto.GeneroDTO;
import com.Challenge.Alkemy.entity.Genero;

import java.util.List;
import java.util.Optional;

public interface GeneroService {

    public GeneroDTO save(GeneroDTO dto);

    public List<GeneroDTO> getAllGeneros();

    public GeneroDTO getById(Long id);
}
