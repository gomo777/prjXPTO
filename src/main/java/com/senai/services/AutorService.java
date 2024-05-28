package com.senai.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.entities.Autor;

import com.senai.repository.AutorRepository;
@Service
public class AutorService {
private final AutorRepository autorRepository;
    //construtor que recebe a dependencia
    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
            
    public Autor saveautor(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor getautorById(Long idAutor) {
        return autorRepository.findById(idAutor).orElse(null);
    }

    public List<Autor> getAllautor() {
        return autorRepository.findAll();
    }

    public void deleteautor(Long idAutor) {
    	autorRepository.deleteById(idAutor);
    }
}
