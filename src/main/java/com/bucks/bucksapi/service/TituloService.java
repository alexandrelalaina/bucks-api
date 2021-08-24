package com.bucks.bucksapi.service;

import com.bucks.bucksapi.models.Titulo;
import com.bucks.bucksapi.repository.TituloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TituloService {

    @Autowired
    TituloRepository repository;

    public List<Titulo> findAll() {
        return repository.findAll();
    }

    public Titulo getById(Integer id) {
        return repository.getById(id);
    }

    public Titulo add(Titulo titulo) {
        titulo.setId(null);
        return repository.save(titulo);
    }

    public Titulo update(Titulo titulo) {
        return repository.save(titulo);
    }

    public void delete(Integer id) {
        Titulo titulo = getById(id);
        repository.delete(titulo);
    }
}
