package com.bucks.bucksapi.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "titulo_extrato")
public class TituloExtrato implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_titulo_extrato", sequenceName = "seq_titulo_extrato")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_titulo_extrato")
    private Integer id;

    @JoinColumn(name = "fk_titulo_id", nullable = true, referencedColumnName = "num")
    @Column(name = "fk_titulo_id")
    private Integer fkTituloId;

    @Column(name = "vl", nullable = false)
    private Double vl;

    @Column(name = "vl_saldo_ant", nullable = false)
    private Double vlSaldoAnt;

    @Column(name = "vl_saldo_atu", nullable = false)
    private Double vlSaldoAtu;

    @Column(name = "us_cad", nullable = false, length = 30)
    private String usCad;

    @Column(name = "dt_cad", nullable = false)
    private Date dtCad;

    @Column(name = "us_alt", length = 30)
    private String usAlt;

    @Column(name = "dt_alt")
    private Date dtAlt;

}
