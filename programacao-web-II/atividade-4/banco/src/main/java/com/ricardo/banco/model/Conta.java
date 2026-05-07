package com.ricardo.banco.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nomeTitular;

    @Column(nullable = false, unique = true)
    private String numeroConta;

    @Column(nullable = false, precision = 10, scale = 2)
    @PositiveOrZero
    private BigDecimal saldo;
}
