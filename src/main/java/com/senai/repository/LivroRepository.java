package com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.senai.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>  {
	
}
