package com.Challenge.Alkemy.repository.specifications;

import com.Challenge.Alkemy.dto.PeliculaFilterDto;
import com.Challenge.Alkemy.dto.PersonajeFilterDTO;
import com.Challenge.Alkemy.entity.Pelicula;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeliculaSpecification {

    public Specification<Pelicula> getByFilters(PeliculaFilterDto filtersDTO){

        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();


            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("titulo")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }

            if (filtersDTO.getGenreId()!=null) {
                predicates.add(criteriaBuilder.equal(root.get("generoId"),filtersDTO.getGenreId()

                ));
            }

            String orderByField="fechaCreacion";
            query.orderBy(
                    filtersDTO.isAsc()?
                            criteriaBuilder.asc(root.get(orderByField)):
                            criteriaBuilder.desc((root.get(orderByField)))
            );


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };


    }
}
