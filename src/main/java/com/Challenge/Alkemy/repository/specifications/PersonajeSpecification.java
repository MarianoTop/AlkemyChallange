package com.Challenge.Alkemy.repository.specifications;

import com.Challenge.Alkemy.dto.PersonajeFilterDTO;
import com.Challenge.Alkemy.entity.Personaje;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
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


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };


    }
}
