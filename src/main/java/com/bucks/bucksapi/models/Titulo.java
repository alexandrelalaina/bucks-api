package com.bucks.bucksapi.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "titulo")
public class Titulo implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_titulo", sequenceName = "seq_titulo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_titulo")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_conta_id", nullable = false)
    private Conta fkContaId;

    @ManyToOne
    @JoinColumn(name = "fk_titulo_grupo_id", nullable = false)
    private TituloGrupo fkTituloGrupoId;

    @ManyToOne
    @JoinColumn(name = "fk_tipo_pagamento_id", nullable = false)
    private TipoPagamento fkTipoPagamentoId;

    @ManyToOne
    @JoinColumn(name = "fk_contrpes_contrato_id", nullable = true)
    private Contrato fkContratoId;

    @ManyToOne
    @JoinColumn(name = "fk_contrpes_pessoa_id", nullable = true)
    private Pessoa fkPessoaId;

    @Column(name = "descr", nullable = false, length = 200)
    private String descr;

    @Column(name = "us_cad", nullable = false, length = 30)
    private String usCad;

    @Column(name = "dt_cad", nullable = false)
    private Date dtCad;

    @Column(name = "dt_vcto", nullable = false)
    private Date dtVcto;

    @Column(name = "dt_pgto")
    private Date dtPgto;

    @Column(name = "vl", nullable = false)
    private Double vl;

    @Column(name = "parcela", nullable = false)
    private Integer parcela;

    @Column(name = "parcela_total", nullable = false)
    private Integer parcelaTotal;

    @Column(name = "us_alt", length = 30)
    private String usAlt;

    @Column(name = "dt_alt")
    private Date dtAlt;

    @Column(name = "obs", length = 2000)
    private String obs;

}
