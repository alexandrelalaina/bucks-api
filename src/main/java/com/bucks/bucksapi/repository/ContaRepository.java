package com.bucks.bucksapi.repository;

import com.bucks.bucksapi.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

// aqui o Spring Data ja implementa tudo com o Extends (JpaRepository)
public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
