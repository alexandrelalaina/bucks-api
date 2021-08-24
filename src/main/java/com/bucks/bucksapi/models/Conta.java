/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bucks.bucksapi.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author La Laina
 */

@Data // Getters Setters Equals ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // nao gerar pelo lombok
@Entity
@Table(name = "conta")
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_conta")
    private Integer id;

    @Column(name = "fk_conta_tipo_id", nullable = false)
    private Integer fkContaTipo; //pause...pensar se vou mudar para id ... acho boa a ideia de deixar sem id, pois é um objeto

    @Column(name = "descr", nullable = false, length = 100)
    private String descr;

    @Column(name = "vl_saldo")
    private BigDecimal vlSaldo;

    @Column(name = "cd_sit", nullable = false)
    private Integer cdSit;

    @Column(name = "dt_cad", nullable = false)
    private Date dtCad;

    @Column(name = "us_cad", nullable = false, length = 30)
    private String usCad;

    @Column(name = "dt_alt")
    private Date dtAlt;

    @Column(name = "us_alt", length = 30)
    private String usAlt;

    @Column(name = "obs", length = 2000)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String obs;

}
