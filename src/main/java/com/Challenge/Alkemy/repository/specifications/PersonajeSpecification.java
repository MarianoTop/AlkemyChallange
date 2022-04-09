package com.Challenge.Alkemy.repository.specifications;

import com.Challenge.Alkemy.dto.PersonajeFilterDTO;
import com.Challenge.Alkemy.entity.Pelicula;
import com.Challenge.Alkemy.entity.Personaje;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component

/*Anotacion: No pude realizar esta parte.  */
public class PersonajeSpecification {
    public Specification<Personaje> getByFilters(PersonajeFilterDTO filtersDTO) {

        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getName())) {
                predicates.add(criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nombre")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }

               /*https://stackoverflow.com/questions/48647847/jpa-specifications-by-example */
            if (filtersDTO.getAge()!=null) {
                predicates.add(criteriaBuilder.equal(root.get("edad"),filtersDTO.getAge()

                ));
            }

            if ( !CollectionUtils.isEmpty(filtersDTO.getIdMovies())) {
                Join<Personaje, Pelicula> join= root.join ( "peliculas" , JoinType.INNER);
                Expression<String> peliculasId= join.get("id");
                predicates.add(peliculasId.in((filtersDTO.getIdMovies())));
                //predicates.add(criteriaBuilder.equal(root.get("pelicula_id"),filtersDTO.getIdMovie()));
            }


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };


    }
}
