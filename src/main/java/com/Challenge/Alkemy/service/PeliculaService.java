package com.Challenge.Alkemy.service;

import com.Challenge.Alkemy.dto.PeliculaBasicDTO;
import com.Challenge.Alkemy.dto.PeliculaDTO;
import com.Challenge.Alkemy.dto.PersonajeBasicDTO;
import com.Challenge.Alkemy.dto.PersonajeDTO;

import java.util.List;
import java.util.Set;

public interface PeliculaService {

    public List<PeliculaBasicDTO> getAllPeliculas();

    public PeliculaDTO save(PeliculaDTO dto);

    public PeliculaDTO update(Long id, PeliculaDTO dto);

    public PeliculaDTO findById(Long id);

    public void delete(Long id);

    public void addPersonaje(Long id, Long idPersonaje);

    public void removePersonaje(Long id, Long idPersonaje);

    public List<PeliculaDTO> getByFilters(String name, Long idGenre, String order);
}
