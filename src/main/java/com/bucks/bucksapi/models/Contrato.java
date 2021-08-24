package com.bucks.bucksapi.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "contrato")
public class Contrato implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_contrato", sequenceName = "seq_contrato")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contrato")
    private Integer id;

    @Column(name = "fk_contrato_tipo_id", nullable = false)
    private Integer fkContratoTipoId;
//    @Enumerated
//    private ContratoTipoEnum contratoTipo; // pause...refatorar

    @Column(name = "descr", nullable = false, length = 100)
    private String descr;

    @Column(name = "dt_base", nullable = false)
    private Date dtBase;

    @Column(name = "vl_base")
    private Double vlBase;

    @Column(name = "dt_cad", nullable = false)
    private Date dtCad;

    @Column(name = "us_cad", nullable = false, length = 30)
    private String usCad;

    @Column(name = "dt_alt")
    private Date dtAlt;

    @Column(name = "us_alt", length = 30)
    private String usAlt;

    @Column(name = "obs", length = 2000)
    private String obs;

}
