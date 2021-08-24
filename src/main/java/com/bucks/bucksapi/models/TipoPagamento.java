package com.bucks.bucksapi.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tipo_pagamento")
@Data
public class TipoPagamento implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_tipo_pagamento", sequenceName = "seq_tipo_pagamento")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_tipo_pagamento")
    private Integer id;

    @Column(name = "descr", nullable = false, length = 2000)
    private String descr;

    @Column(name = "dt_cad", nullable = false)
    private Date dtCad;

    @Column(name = "us_cad", nullable = false, length = 30)
    private String usCad;

    @Column(name = "dt_alt")
    private Date dtAlt;

    @Column(name = "us_alt", length = 30)
    private String usAlt;

}