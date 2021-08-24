package com.bucks.bucksapi.repository;

import com.bucks.bucksapi.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
