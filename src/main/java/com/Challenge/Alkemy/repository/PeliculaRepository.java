package com.Challenge.Alkemy.repository;


import com.Challenge.Alkemy.entity.Pelicula;
import com.Challenge.Alkemy.entity.Personaje;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>, JpaSpecificationExecutor<Pelicula> {
    List<Pelicula> findAll(Specification<Pelicula> spec);
}
