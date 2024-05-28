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

import com.senai.entities.Categoria;
import com.senai.services.CategoriaService;


@RestController
@RequestMapping("/Categoria")
public class CategoriaController {
	private final CategoriaService  categoriaService;
	@Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/")
	public ResponseEntity<Categoria> insertcategoriaControl(@RequestBody Categoria categoria) {
    	Categoria novocategoria = categoriaService.savecategoria(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(novocategoria);
	}


    @GetMapping("/{idCategoria}")
    public Categoria getCategoria(@PathVariable Long idCategoria) {
        return categoriaService.getcategoriaById(idCategoria);
    }
    @GetMapping
    public List<Categoria> getAlLCategoria() {
        return categoriaService.getAllcategoria();
    }

    @DeleteMapping("/{idCategoria}")
    public void deletecategoria(@PathVariable Long idCategoria) {
    	categoriaService.deletecategoria(idCategoria);
    }
	
}
