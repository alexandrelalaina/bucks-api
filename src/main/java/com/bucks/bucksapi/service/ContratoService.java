package com.bucks.bucksapi.service;

import com.bucks.bucksapi.models.Contrato;
import com.bucks.bucksapi.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService {

    @Autowired
    ContratoRepository repository;

    public List<Contrato> findAll(){
        return repository.findAll();
    }

    public Contrato getById(Integer id){
        return repository.getById(id);
    }

    public Contrato add(Contrato contrato){
        contrato.setId(null);
        return repository.save(contrato);
    }

    public Contrato update(Contrato contrato){
        return repository.save(contrato);
    }

    public void delete(Integer id){
        repository.delete(repository.getById(id));
    }

}
