package com.Challenge.Alkemy.service;

import com.Challenge.Alkemy.dto.GeneroDTO;
import com.Challenge.Alkemy.dto.PeliculaDTO;

public interface GeneroService {

    public GeneroDTO save(GeneroDTO dto);

    public GeneroDTO findById(Long id);
}
