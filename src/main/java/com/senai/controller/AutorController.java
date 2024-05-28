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

import com.senai.entities.Autor;
import com.senai.services.AutorService;



@RestController
@RequestMapping("/Autor")
public class AutorController {
	private final AutorService  autorService;
	@Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping("/")
	public ResponseEntity<Autor> insertautorControl(@RequestBody Autor autor) {
    	Autor novoautor = autorService.saveautor(autor);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoautor);
	}


    @GetMapping("/{idAutor}")
    public Autor getAutor(@PathVariable Long idAutor) {
        return autorService.getautorById(idAutor);
    }
    @GetMapping
    public List<Autor> getAlLCategoria() {
        return autorService.getAllautor();
    }

    @DeleteMapping("/{idAutor}")
    public void deleteautor(@PathVariable Long idAutor) {
    	autorService.deleteautor(idAutor);
    }
}
