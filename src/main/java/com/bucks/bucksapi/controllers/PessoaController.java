package com.bucks.bucksapi.controllers;

import com.bucks.bucksapi.models.Pessoa;
import com.bucks.bucksapi.service.PessoaService;
import com.bucks.bucksapi.utils.Endpoint;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping(Endpoint.URL_PESSOA)
public class PessoaController {

    @Autowired
    PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById (@PathVariable Integer id){
        Pessoa pessoa = service.getById(id);
        if (pessoa!=null){
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pessoa> add (@RequestBody Pessoa pessoa) {
        pessoa.setId(null);
        pessoa.setDtCad(new Date());
        pessoa.setUsCad("TODO");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> udpate (
            @PathVariable Integer id,
            @RequestBody Pessoa pessoa) {
        Pessoa pessoaAtual = service.getById(id);

        BeanUtils.copyProperties(pessoa, pessoaAtual, "id", "dtCad", "usCad");
        pessoaAtual.setDtAlt(new Date());
        pessoaAtual.setUsAlt("TODO");
        service.update(pessoaAtual);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaAtual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> delete(@PathVariable Integer id){
        Pessoa pessoa = service.getById(id);
        if (pessoa==null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
