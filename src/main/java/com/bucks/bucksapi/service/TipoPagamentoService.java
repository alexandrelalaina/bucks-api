package com.bucks.bucksapi.service;

import com.bucks.bucksapi.models.TipoPagamento;
import com.bucks.bucksapi.repository.TipoPagamentoRepository;
import com.bucks.bucksapi.service.exception.EntidadeEmUsoException;
import com.bucks.bucksapi.service.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagamentoService {

    @Autowired
    TipoPagamentoRepository repository;

    public List<TipoPagamento> findAll(){
        return repository.findAll();
    }

    public TipoPagamento getById(Integer id){
        return repository.getById(id);
    }

    public TipoPagamento add (TipoPagamento tipoPagamento) {
        tipoPagamento.setId(null);
        return repository.save(tipoPagamento);
    }

    public TipoPagamento update (TipoPagamento tipoPagamento) {
        return repository.save(tipoPagamento);
    }

    public void delete (Integer id){
        try {
            repository.delete(repository.getById(id));
        } catch (
        EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe tipo de pagamento com o id (%d)!", id));
        } catch (
        DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Tipo de pagamento (%d) não pode ser deletado!", id));
        }
    }

}
