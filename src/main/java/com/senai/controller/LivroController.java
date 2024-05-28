package com.senai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.entities.Livro;
import com.senai.services.LivroService;


@RestController
@RequestMapping("/livro")
public class LivroController {
	private final LivroService  livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping("/")
	public ResponseEntity<Livro> insertLivrosControl(@RequestBody Livro Livro) {
		Livro novolivro = livroService.savelivro(Livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(novolivro);
	}


    @GetMapping("/{id}")
    public Livro getlivro(@PathVariable Long id) {
        return livroService.getlivroById(id);
    }
    @GetMapping
    public List<Livro> getAlllivro() {
        return livroService.getAlllivro();
    }

    @DeleteMapping("/{id}")
    public void deletelivro(@PathVariable Long id) {
    	livroService.deletelivro(id);
    }
    
    
}
