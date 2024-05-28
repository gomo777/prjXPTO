package com.senai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.entities.Livro;
import com.senai.repository.LivroRepository;
@Service
public class LivroService {
	private final LivroRepository livroRepository;
	
    //construtor que recebe a dependencia
    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
            
    public Livro savelivro(Livro Livro) {
        return livroRepository.save(Livro);
    }

    public Livro getlivroById(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    public List<Livro> getAlllivro() {
        return livroRepository.findAll();
    }

    public void deletelivro(Long id) {
    	livroRepository.deleteById(id);
    }
}
