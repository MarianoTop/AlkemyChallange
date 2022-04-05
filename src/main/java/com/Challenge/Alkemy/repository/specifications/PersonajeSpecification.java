package com.Challenge.Alkemy.repository.specifications;

import com.Challenge.Alkemy.dto.PersonajeFilterDTO;
import com.Challenge.Alkemy.entity.Personaje;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PersonajeSpecification {
    public Specification<Personaje> getByFilters(PersonajeFilterDTO filtersDTO) {

        return (root, query, criteriaBuilder)->{
            List
        }


    }
}
