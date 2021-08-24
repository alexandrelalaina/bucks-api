package com.bucks.bucksapi.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "contrato_pessoa")
public class ContratoPessoa implements Serializable {

    @EmbeddedId
    private ContratoPessoaId contratoPessoaId;

    @Column(name = "dt_cad", nullable = false)
    private Date dtCad;

    @Column(name = "us_cad", nullable = false, length = 30)
    private String usCad;

}
