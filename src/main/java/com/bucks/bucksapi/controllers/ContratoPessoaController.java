package com.bucks.bucksapi.controllers;

import com.bucks.bucksapi.models.ContratoPessoa;
import com.bucks.bucksapi.service.ContratoPessoaService;
import com.bucks.bucksapi.utils.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(Endpoint.URL_CONTRATO_PESSOA)
public class ContratoPessoaController {

    @Autowired
    ContratoPessoaService service;

    @GetMapping()
    public ResponseEntity<List<ContratoPessoa>> findAll(){
        List<ContratoPessoa> contratoPessoa = service.findAll();
        if (contratoPessoa.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(contratoPessoa);
    }

    @GetMapping("/{contratoId}/{pessoaId}")
    public ResponseEntity<ContratoPessoa> getByContratoIdPessoaId(
            @PathVariable("contratoId") Integer contratoId,
            @PathVariable("pessoaId") Integer pessoaId){
        return ResponseEntity.ok(service.getById(contratoId, pessoaId));
    }

    @PostMapping()
    public ResponseEntity<ContratoPessoa> add(@RequestBody ContratoPessoa contratoPessoa){
        if (contratoPessoa.getContratoPessoaId().getContratoId()==null){
            System.out.println("Contrato deve ser informado!");
        }
        if (contratoPessoa.getContratoPessoaId().getPessoaId()==null){
            System.out.println("Pessoa deve ser informada!");
        }
        contratoPessoa.setDtCad(new Date());
        contratoPessoa.setUsCad("TODO");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(contratoPessoa));

    }

}
