package com.Challenge.Alkemy.repository;


import com.Challenge.Alkemy.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
