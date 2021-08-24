package com.bucks.bucksapi.controllers;

import com.bucks.bucksapi.models.Conta;
import com.bucks.bucksapi.service.ContaService;
import com.bucks.bucksapi.service.exception.EntidadeEmUsoException;
import com.bucks.bucksapi.service.exception.EntidadeNaoEncontradaException;
import com.bucks.bucksapi.utils.Endpoint;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Endpoint.URL_CONTA) // por Default essa sera a URI atendida
public class ContaController {

    @Autowired
    private ContaService service;

    @GetMapping()
    public ResponseEntity<List<Conta>> findAll (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> getById(@PathVariable("id") Integer id){
        Conta conta = service.getById(id);
        if (conta!=null){
            return ResponseEntity.ok(conta);
        }
        return ResponseEntity.notFound().build();
    }

    //@RequestBody serve para recuperar o objeto passado e fazer o parse no objeto do param
    @PostMapping()
    public ResponseEntity<Conta> add(@RequestBody Conta conta){
        conta.setId(null);
        conta.setDtCad(new Date());
        conta.setUsCad("TODO");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(conta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conta> update (
            @PathVariable("id") Integer id,
            @RequestBody Conta conta){

        // buscar o que esta no banco
        Conta contaAtual = service.getById(id);

        if (contaAtual!=null) {
            // atualizar os atributos
            BeanUtils.copyProperties(conta, contaAtual, "id", "dtCad", "usCad");
            contaAtual.setDtAlt(new Date());
            contaAtual.setUsAlt("TODO");
            service.update(contaAtual);

            return ResponseEntity.ok(contaAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Conta> delete(
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

    @PutMapping("/{id}/{valorTransacao}/{cdTipo}")
    public ResponseEntity<Conta> atualizarSaldo(@PathVariable Integer id,
                                                @PathVariable BigDecimal valorTransacao,
                                                @PathVariable String cdTipo){
        // TODO - PAUSE - alterar para passar o titulo???? pensar melhor
        Conta conta = service.atualizarSaldo(id, valorTransacao, cdTipo);
        return ResponseEntity.ok(conta);
    }

}
