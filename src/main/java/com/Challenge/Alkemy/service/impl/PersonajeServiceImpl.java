package com.Challenge.Alkemy.service.impl;

import com.Challenge.Alkemy.auxiliary.ErrorMessage;
import com.Challenge.Alkemy.dto.PersonajeBasicDTO;
import com.Challenge.Alkemy.dto.PersonajeDTO;
import com.Challenge.Alkemy.dto.PersonajeFilterDTO;
import com.Challenge.Alkemy.entity.Personaje;
import com.Challenge.Alkemy.exception.ParamNotFound;
import com.Challenge.Alkemy.mapper.PersonajeMapper;
import com.Challenge.Alkemy.repository.PersonajeRepository;
import com.Challenge.Alkemy.repository.specifications.PersonajeSpecification;
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

    @Autowired
    private PersonajeSpecification personajeSpecification;


    @Override
    public PersonajeDTO findById(Long id) {
        Personaje entity= personajeRepository.findById(id).orElse(null);
        if(entity==null){
            throw new ParamNotFound(String.format(ErrorMessage.OBJECT_DOESNT_EXIST,"Personaje"));
        }
        PersonajeDTO dto=personajeMapper.personajeEntity2PersonajeDTO(entity,true);
        return dto;
    }

    @Override
    public void delete(Long id) {
        Personaje entity= personajeRepository.findById(id).orElse(null);
        if(entity==null){
            throw new ParamNotFound(String.format(ErrorMessage.OBJECT_DOESNT_EXIST,"Personaje"));
        }

        personajeRepository.deleteById(id);
    }

    /* No pude hacerlo funcionar*/
    @Override
    public List<PersonajeDTO> getByFilters(String name, int age, long idMovie) {
        PersonajeFilterDTO filtersDTO = new PersonajeFilterDTO(name,age,idMovie);

        List<Personaje> entities = this.personajeRepository.findAll(this.personajeSpecification.getByFilters(filtersDTO));
        List<PersonajeDTO> dtos = this.personajeMapper.personajeEntityList2DTOList(entities,true);
        return dtos;
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
       PersonajeDTO result= personajeMapper.personajeEntity2PersonajeDTO(entityGuardada,true);
       return result;
    }

    @Override
    public PersonajeDTO update(Long id, PersonajeDTO dto) {
        Personaje entitySearched= personajeRepository.findById(id).orElse(null);


        if(entitySearched==null){
            throw new ParamNotFound(String.format(ErrorMessage.OBJECT_DOESNT_EXIST,"Personaje"));
        }
        this.personajeMapper.personajeEntityRefreshValues(entitySearched,dto);
        Personaje entityModified=personajeRepository.save(entitySearched);
        PersonajeDTO result= personajeMapper.personajeEntity2PersonajeDTO(entityModified,true);

        return result;
    }





}
