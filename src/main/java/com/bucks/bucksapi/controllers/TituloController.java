package com.bucks.bucksapi.controllers;

import com.bucks.bucksapi.models.Titulo;
import com.bucks.bucksapi.service.TituloService;
import com.bucks.bucksapi.utils.Endpoint;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Endpoint.URL_TITULO)
public class TituloController {

    @Autowired
    TituloService service;

    @GetMapping()
    public ResponseEntity<List<Titulo>> findAll(){
        List<Titulo> titulos = service.findAll();
        if (titulos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(titulos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Titulo> getById(Integer id){
        Titulo titulo = service.getById(id);
        if (titulo==null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(titulo);
    }

    @PostMapping()
    public ResponseEntity<Titulo> add(@RequestBody Titulo titulo){
        titulo.setId(null);
        titulo.setDtCad(new Date());
        titulo.setUsCad("TODO");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(titulo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Titulo> update(
            @PathVariable("id") Integer id,
            @RequestBody Titulo titulo){
        Titulo tituloBanco = service.getById(id);

        BeanUtils.copyProperties(titulo, tituloBanco, "id", "dtCad", "usCad");
        tituloBanco.setDtAlt(new Date());
        tituloBanco.setUsAlt("TODO");
        service.update(tituloBanco);

        return ResponseEntity.ok(tituloBanco);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Titulo> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
