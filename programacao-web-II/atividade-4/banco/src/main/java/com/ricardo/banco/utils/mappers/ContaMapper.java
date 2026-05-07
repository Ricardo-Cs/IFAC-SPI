package com.ricardo.banco.utils.mappers;

import com.ricardo.banco.dto.request.ContaRequest;
import com.ricardo.banco.dto.response.ContaResponse;
import com.ricardo.banco.model.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaMapper {

    public Conta toEntity(ContaRequest request) {
        Conta conta = new Conta();
        conta.setNomeTitular(request.nomeTitular());
        conta.setNumeroConta(request.numeroConta());
        conta.setSaldo(request.saldo());
        return conta;
    }

    public ContaResponse toResponse(Conta conta) {
        return new ContaResponse(conta.getId(), conta.getNomeTitular(), conta.getNumeroConta(),conta.getSaldo());
    }
}