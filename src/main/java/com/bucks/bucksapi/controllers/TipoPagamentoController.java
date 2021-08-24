package com.bucks.bucksapi.controllers;

import com.bucks.bucksapi.models.TipoPagamento;
import com.bucks.bucksapi.service.exception.EntidadeEmUsoException;
import com.bucks.bucksapi.service.exception.EntidadeNaoEncontradaException;
import com.bucks.bucksapi.service.TipoPagamentoService;
import com.bucks.bucksapi.utils.Endpoint;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Endpoint.URL_TIPO_PAGAMENTO)
public class TipoPagamentoController {

    @Autowired
    TipoPagamentoService service;

    @GetMapping()
    public ResponseEntity<List<TipoPagamento>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPagamento> getById(@PathVariable("id") Integer id){
        TipoPagamento tipoPagamento = service.getById(id);
        if (tipoPagamento == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tipoPagamento);
    }

    @PostMapping
    public ResponseEntity<TipoPagamento> add (@RequestBody TipoPagamento tipoPagamento) {
        tipoPagamento.setId(null);
        tipoPagamento.setDtCad(new Date());
        tipoPagamento.setUsCad("TODO");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(tipoPagamento));

    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPagamento> update(
            @PathVariable Integer id,
            @RequestBody TipoPagamento tipoPagamento){
        TipoPagamento tipoPagamentoAtual = service.getById(id);
        if (tipoPagamentoAtual != null){
            // atualizar os atributos
            BeanUtils.copyProperties(tipoPagamento, tipoPagamentoAtual, "id", "dtCad", "usCad");
            tipoPagamentoAtual.setDtAlt(new Date());
            tipoPagamentoAtual.setUsAlt("TODO");
            service.update(tipoPagamentoAtual);
            return ResponseEntity.ok(tipoPagamentoAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoPagamento> delete(
            @PathVariable("id") Integer id){
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
