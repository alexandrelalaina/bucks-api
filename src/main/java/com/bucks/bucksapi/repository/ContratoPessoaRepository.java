package com.bucks.bucksapi.repository;

import com.bucks.bucksapi.models.ContratoPessoa;
import com.bucks.bucksapi.models.ContratoPessoaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoPessoaRepository extends JpaRepository<ContratoPessoa, ContratoPessoaId> {

}
