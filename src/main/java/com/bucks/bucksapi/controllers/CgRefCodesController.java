package com.bucks.bucksapi.controllers;

import com.bucks.bucksapi.models.CgRefCodes;
import com.bucks.bucksapi.service.CgRefCodesService;
import com.bucks.bucksapi.utils.Endpoint;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.URL_CGREFCODES)
public class CgRefCodesController {

    @Autowired
    CgRefCodesService service;

    @GetMapping()
    public ResponseEntity<List<CgRefCodes>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CgRefCodes> getById(@PathVariable("id") Integer id){
        CgRefCodes cgRefCodes = service.getById(id);
        if (cgRefCodes!=null){
            return ResponseEntity.ok(cgRefCodes);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<CgRefCodes> add(@RequestBody CgRefCodes cgRefCodes){
        cgRefCodes.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.add(cgRefCodes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CgRefCodes> update(
            @PathVariable("id") Integer id,
            @RequestBody CgRefCodes cgRefCodes){
        CgRefCodes cgRefCodesAtual = service.getById(id);
        if (cgRefCodes==null){
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(cgRefCodes, cgRefCodesAtual, "id");
        service.update(cgRefCodesAtual);
        return ResponseEntity.ok(cgRefCodesAtual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CgRefCodes> delete(@PathVariable("id") Integer id){
        CgRefCodes cgRefCodes = service.getById(id);
        if (cgRefCodes==null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
