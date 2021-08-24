package com.bucks.bucksapi.service;

import com.bucks.bucksapi.models.TituloExtrato;
import com.bucks.bucksapi.repository.TituloExtratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TituloExtratoService {

    @Autowired
    TituloExtratoRepository repository;

    public List<TituloExtrato> findAll(){
        return repository.findAll();
    }

    public TituloExtrato findById(Integer id){
        return repository.getById(id);
    }

    public TituloExtrato add(TituloExtrato tituloExtrato){
        tituloExtrato.setId(null);
        return repository.save(tituloExtrato);
    }

    public void delete(Integer id){
        repository.delete(repository.getById(id));
    }
}
