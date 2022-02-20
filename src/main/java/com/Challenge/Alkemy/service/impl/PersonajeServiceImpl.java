package com.Challenge.Alkemy.service.impl;

import com.Challenge.Alkemy.dto.PersonajeBasicDTO;
import com.Challenge.Alkemy.dto.PersonajeDTO;
import com.Challenge.Alkemy.entity.Personaje;
import com.Challenge.Alkemy.mapper.PersonajeMapper;
import com.Challenge.Alkemy.repository.PersonajeRepository;
import com.Challenge.Alkemy.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeMapper personajeMapper;
    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public PersonajeDTO findById(Long id) {
        Personaje entity= personajeRepository.findById(id).orElse(null);
        if(entity==null){
            throw new RuntimeException("Personaje no encontrado");
        }
        PersonajeDTO dto=personajeMapper.personajeEntity2PersonajeDTO(entity);
        return dto;
    }

    @Override
    public void delete(Long id) {
        personajeRepository.deleteById(id);
    }

    @Override
    public List<PersonajeBasicDTO> getAllPersonajes() {

        List<Personaje> personajes = personajeRepository.findAll();
        List<PersonajeBasicDTO> result= personajeMapper.personajeEntityList2BasicDTOList(personajes);
        return result;
    }

    @Override
    public PersonajeDTO save(PersonajeDTO dto){
       Personaje entity= personajeMapper.personajeDTO2Entity(dto);
       Personaje entityGuardada=personajeRepository.save(entity);
       PersonajeDTO result= personajeMapper.personajeEntity2PersonajeDTO(entityGuardada);
       return result;
    }

    @Override
    public PersonajeDTO update(Long id, PersonajeDTO dto) {
        Personaje entitySearched= personajeRepository.findById(id).orElse(null);

        if(entitySearched==null){
            throw new RuntimeException("Personaje no encontrado");
        }
        this.personajeMapper.personajeEntityRefreshValues(entitySearched,dto);
        Personaje entityModified=personajeRepository.save(entitySearched);
        PersonajeDTO result= personajeMapper.personajeEntity2PersonajeDTO(entityModified);

        return result;
    }





}
