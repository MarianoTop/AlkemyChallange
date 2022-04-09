package com.Challenge.Alkemy.repository.specifications;

import com.Challenge.Alkemy.dto.PeliculaFilterDto;
import com.Challenge.Alkemy.dto.PersonajeFilterDTO;
import com.Challenge.Alkemy.entity.Pelicula;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaSpecification {

    public Specification<Pelicula> getByFilters(PeliculaFilterDto filtersDTO){

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };


    }
}
