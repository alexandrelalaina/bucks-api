package com.bucks.bucksapi.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "cg_ref_codes")
public class CgRefCodes implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "seq_cg_ref_codes", sequenceName = "seq_cg_ref_codes")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_cg_ref_codes")
  private Integer id;

  @Column(name = "rv_low_value", nullable = false, length = 300)
  private String rvLowValue;

  @Column(name = "rv_high_value", length = 300)
  private String rvHighValue;

  @Column(name = "rv_abreviation", length = 300)
  private String rvAbreviation;

  @Column(name = "rv_domain", nullable = false, length = 300)
  private String rvDomain;

  @Column(name = "rv_meaning", length = 300)
  private String rvMeaning;

}
