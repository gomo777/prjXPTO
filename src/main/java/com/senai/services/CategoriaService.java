package com.senai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.entities.Categoria;
import com.senai.repository.CategoriaRepository;


@Service
public class CategoriaService {
	private final CategoriaRepository categoriaRepository;
    //construtor que recebe a dependencia
    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
            
    public Categoria savecategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria getcategoriaById(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }

    public List<Categoria> getAllcategoria() {
        return categoriaRepository.findAll();
    }

    public void deletecategoria(Long idCategoria) {
    	categoriaRepository.deleteById(idCategoria);
    }
}
