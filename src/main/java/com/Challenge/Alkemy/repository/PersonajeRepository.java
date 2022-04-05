package com.Challenge.Alkemy.repository;


import com.Challenge.Alkemy.entity.Personaje;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long>, JpaSpecificationExecutor<Personaje> {

    List<Personaje> findAll(Specification<Personaje> spec);
}
