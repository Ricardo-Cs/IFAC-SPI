package com.ricardo.banco.dto.response;

import java.math.BigDecimal;

public record ContaResponse(
        Long id,
        String nomeTitular,
        String numeroConta,
        BigDecimal saldo
) {
}
