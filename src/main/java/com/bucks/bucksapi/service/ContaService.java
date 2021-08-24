package com.bucks.bucksapi.service;

import com.bucks.bucksapi.models.Conta;
import com.bucks.bucksapi.repository.ContaRepository;
import com.bucks.bucksapi.service.exception.EntidadeEmUsoException;
import com.bucks.bucksapi.service.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaRepository repository;

    public List<Conta> findAll(){
        return repository.findAll();
    }

    public Conta getById(Integer id){
        return repository.getById(id);
    }

    public Conta add (Conta conta){
        conta.setId(null);
        return repository.save(conta);
    }

    public Conta update (Conta conta){
        return repository.save(conta);
    }

    public void delete(Integer id){
        try {
            repository.delete(repository.getById(id));

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe conta com o id (%d)!", id));

        } catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                String.format("Conta (%d) não pode ser deletada!", id));
        }
    }

    public Conta atualizarSaldo(Integer id, BigDecimal valorTransacao, String cdTipo) {
        Conta conta = repository.getById(id);
//        BigDecimal aux = new BigDecimal(String.valueOf(valorTransacao));
        if (cdTipo.equals("D")){
            valorTransacao = valorTransacao.multiply(BigDecimal.valueOf(-1));
        }

        valorTransacao = conta.getVlSaldo().add(valorTransacao);
        conta.setVlSaldo(valorTransacao);
        return repository.save(conta);
    }




}
