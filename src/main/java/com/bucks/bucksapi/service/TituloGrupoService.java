package com.bucks.bucksapi.service;

import com.bucks.bucksapi.models.TituloGrupo;
import com.bucks.bucksapi.repository.TituloGrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TituloGrupoService {

    @Autowired
    TituloGrupoRepository repository;

    public List<TituloGrupo> findAll(){
        return repository.findAll();
    }

    public TituloGrupo getById(Integer id){
        return repository.getById(id);
    }

    public TituloGrupo add(TituloGrupo tituloGrupo){
        tituloGrupo.setId(null);
        return repository.save(tituloGrupo);
    }

    public TituloGrupo update(TituloGrupo tituloGrupo){
        return repository.save(tituloGrupo);
    }

    public void delete(Integer id){
        repository.delete(repository.getById(id));
    }
}
