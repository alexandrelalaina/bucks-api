package com.bucks.bucksapi.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "login")
public class Login implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    
    @Column(name = "senha", nullable = false, length = 30)
    private String senha;

}
