package com.bucks.bucksapi.service;

import com.bucks.bucksapi.models.Pessoa;
import com.bucks.bucksapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public List<Pessoa> findAll(){
        return repository.findAll();
    }

    public Pessoa getById(Integer id){
        return repository.getById(id);
    }

    public Pessoa add(Pessoa pessoa){
        pessoa.setId(null);
        return repository.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public void delete(Integer id){
        repository.delete(repository.getById(id));
    }

}
