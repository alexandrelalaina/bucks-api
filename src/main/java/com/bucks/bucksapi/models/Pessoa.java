package com.bucks.bucksapi.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pessoa")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

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
