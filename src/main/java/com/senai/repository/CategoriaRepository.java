package com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
}
