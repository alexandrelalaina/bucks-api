package com.bucks.bucksapi.service;

import com.bucks.bucksapi.models.Contrato;
import com.bucks.bucksapi.models.ContratoPessoa;
import com.bucks.bucksapi.models.ContratoPessoaId;
import com.bucks.bucksapi.models.Pessoa;
import com.bucks.bucksapi.repository.ContratoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoPessoaService {

    @Autowired
    ContratoPessoaRepository repository;

    public List<ContratoPessoa> findAll() {
        return repository.findAll();
    }

    public ContratoPessoa getById(Integer contratoId, Integer pessoaId) {
        ContratoPessoaId contratoPessoaId = retornarContratoPessoaId(contratoId, pessoaId);
        return repository.getById(contratoPessoaId);
    }

    public ContratoPessoa add(ContratoPessoa contratoPessoa) {
        return repository.save(contratoPessoa);
    }

    public void delete(Integer contratoId, Integer pessoaId) {
        ContratoPessoa contratoPessoa = getById(contratoId, pessoaId);
        repository.delete(contratoPessoa);
    }

    private ContratoPessoaId retornarContratoPessoaId(Integer contratoId, Integer pessoaId){
        ContratoPessoaId contratoPessoaId = new ContratoPessoaId();
        Contrato contrato = new Contrato();
        Pessoa pessoa = new Pessoa();

        contratoPessoaId.setContratoId(contrato);
        contratoPessoaId.setPessoaId(pessoa);

        return contratoPessoaId;
    }

}
