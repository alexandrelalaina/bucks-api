package com.bucks.bucksapi.models;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class ContratoPessoaId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "fk_contrato_id", nullable = false)
    private Contrato contratoId;

    @ManyToOne
    @JoinColumn(name = "fk_pessoa_id", nullable = false)
    private Pessoa pessoaId;
}
