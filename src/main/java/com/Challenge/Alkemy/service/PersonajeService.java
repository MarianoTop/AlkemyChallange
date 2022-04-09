package com.Challenge.Alkemy.service;

import com.Challenge.Alkemy.dto.PersonajeBasicDTO;
import com.Challenge.Alkemy.dto.PersonajeDTO;

import java.util.List;

public interface PersonajeService {

    public List<PersonajeBasicDTO> getAllPersonajes();

    public PersonajeDTO save( PersonajeDTO dto);

    public PersonajeDTO update(Long id, PersonajeDTO dto);

    public PersonajeDTO findById(Long id);

    public void delete(Long id);

    public List<PersonajeDTO> getByFilters(String name, Integer age, Long idMovie);
}
