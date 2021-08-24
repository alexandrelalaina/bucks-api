package com.bucks.bucksapi.controllers;

import com.bucks.bucksapi.models.Contrato;
import com.bucks.bucksapi.service.ContratoService;
import com.bucks.bucksapi.utils.Endpoint;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping(Endpoint.URL_CONTRATO)
public class ContratoController {

    @Autowired
    ContratoService service;

    @GetMapping
    public ResponseEntity<List<Contrato>> findAll (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> getById (@PathVariable Integer id){
        Contrato contrato = service.getById(id);
        if (contrato!=null){
            return ResponseEntity.ok(contrato);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Contrato> add (@RequestBody Contrato contrato) {
        contrato.setId(null);
        contrato.setDtCad(new Date());
        contrato.setUsCad("TODO");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(contrato));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> update (
            @PathVariable Integer id,
            @RequestBody Contrato contrato) {
        Contrato contratoBanco = service.getById(id);

        BeanUtils.copyProperties(contrato, contratoBanco, "id", "dtCad", "usCad");
        contratoBanco.setDtAlt(new Date());
        contratoBanco.setUsAlt("TODO");
        service.update(contratoBanco);
        return ResponseEntity.status(HttpStatus.OK).body(contratoBanco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contrato> delete(@PathVariable Integer id){
        Contrato contrato = service.getById(id);
        if (contrato==null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
