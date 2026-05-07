package com.ricardo.banco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ContaRequest(
        @NotBlank
        String nomeTitular,

        @NotBlank
        String numeroConta,

        @PositiveOrZero
        BigDecimal saldo

) {
}
