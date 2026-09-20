package com.ricardo.banco.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ContaRequest(

        @NotBlank
        @Size(min = 3, max = 100)
        String nomeTitular,

        @NotBlank
        @Pattern(regexp = "\\d{6,20}")
        String numeroConta,

        @NotNull
        @Digits(integer = 10, fraction = 2)
        @PositiveOrZero
        BigDecimal saldo

) {
}
