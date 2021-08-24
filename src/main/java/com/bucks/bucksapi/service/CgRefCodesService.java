package com.bucks.bucksapi.service;

import com.bucks.bucksapi.models.CgRefCodes;
import com.bucks.bucksapi.repository.CgRefCodesRepository;
import com.bucks.bucksapi.service.exception.EntidadeEmUsoException;
import com.bucks.bucksapi.service.exception.EntidadeNaoEncontradaException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Log4j2
@Service
@RequiredArgsConstructor
public class CgRefCodesService {

    private final CgRefCodesRepository repository;

    public List<CgRefCodes> findAll() {
        try{
            return repository.findAll();

        }catch (Exception ex){

            log.error("getFilms > " + ex.getMessage());
            return Collections.emptyList();
        }
    }

    public CgRefCodes getById(Integer id) {
        try{
            Optional<CgRefCodes> cgRefCodes = repository.findById(id);
            return cgRefCodes.get();
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe registro com o id (%d)!", id));
        }catch (Exception ex){
            new Exception(ex);
        }
        return null;
    }

    public CgRefCodes add (CgRefCodes cgRefCodes){
        cgRefCodes.setId(null);
        return repository.save(cgRefCodes);
    }

    public CgRefCodes update (CgRefCodes cgRefCodes){
        return repository.save(cgRefCodes);
    }

    public void delete(Integer id) {
        try {
            repository.delete(getById(id));
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe registro com o id (%d)!", id));

        } catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Registro (%d) não pode ser deletado!", id));
        }
    }

}
