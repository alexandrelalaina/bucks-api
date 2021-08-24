package com.bucks.bucksapi.controllers;

import com.bucks.bucksapi.models.TituloGrupo;
import com.bucks.bucksapi.service.TituloGrupoService;
import com.bucks.bucksapi.utils.Endpoint;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping(Endpoint.URL_TITULO_GRUPO)
public class TituloGrupoController {

    @Autowired
    TituloGrupoService service;

    @GetMapping
    public ResponseEntity<List<TituloGrupo>> findAll (){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TituloGrupo> getById (@PathVariable Integer id){
        TituloGrupo grupoTitulo = service.getById(id);
        if (grupoTitulo!=null){
            return ResponseEntity.ok(grupoTitulo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TituloGrupo> add (@RequestBody TituloGrupo grupoTitulo) {
        grupoTitulo.setId(null);
        grupoTitulo.setDtCad(new Date());
        grupoTitulo.setUsCad("TODO");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(grupoTitulo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TituloGrupo> update (
            @PathVariable Integer id,
            @RequestBody TituloGrupo grupoTitulo) {
        TituloGrupo tituloGrupoAtual = service.getById(id);

        BeanUtils.copyProperties(grupoTitulo, tituloGrupoAtual, "id", "dtCad", "usCad");
        tituloGrupoAtual.setDtAlt(new Date());
        tituloGrupoAtual.setUsAlt("TODO");
        service.update(tituloGrupoAtual);
        return ResponseEntity.ok(tituloGrupoAtual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TituloGrupo> delete(@PathVariable Integer id){
        TituloGrupo tituloGrupo = service.getById(id);
        if (tituloGrupo==null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
