package com.senai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senai.entities.Autor;


public interface AutorRepository extends JpaRepository<Autor, Long>{
	@Query(value = "SELECT * FROM  autor l  WHERE lower (l.nome) LIKE%:nome%", nativeQuery = true)
	List<Autor> buscarPorNome(@Param("nome") String nome);
}
