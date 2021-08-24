package com.bucks.bucksapi.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "titulo_grupo")
public class TituloGrupo implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_titulo_grupo", sequenceName = "seq_titulo_grupo")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_titulo_grupo")
    private Integer id;

    @Column(name = "descr", nullable = false, length = 2000)
    private String descr;

    @Column(name = "cd_tipo", nullable = false, length = 1)
    private String cdTipo;

    @Column(name = "cd_contabiliza", nullable = false, length = 1)
    private String cdContabiliza; // S = Sim / N = Não

    @Column(name = "dt_cad", nullable = false)
    private Date dtCad;

    @Column(name = "us_cad", nullable = false, length = 30)
    private String usCad;

    @Column(name = "dt_alt")
    private Date dtAlt;

    @Column(name = "us_alt", length = 30)
    private String usAlt;

}
