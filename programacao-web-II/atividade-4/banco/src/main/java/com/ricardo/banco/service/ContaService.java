package com.ricardo.banco.service;

import com.ricardo.banco.dto.request.ContaRequest;
import com.ricardo.banco.dto.request.TransferenciaRequest;
import com.ricardo.banco.dto.response.ContaResponse;
import com.ricardo.banco.exception.ContaNaoEncontradaException;
import com.ricardo.banco.exception.NegocioException;
import com.ricardo.banco.model.Conta;
import com.ricardo.banco.repository.ContaRepository;
import com.ricardo.banco.utils.mappers.ContaMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContaService {

    private final ContaRepository repository;
    private final ContaMapper mapper;

    public ContaService(ContaRepository repository, ContaMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ContaResponse get(Long id) {
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ContaNaoEncontradaException(id));
    }

    public ContaResponse save(ContaRequest request) {
        Conta conta = mapper.toEntity(request);
        Conta salvo = repository.save(conta);
        return mapper.toResponse(salvo);
    }

    public ContaResponse deposito(Long id, BigDecimal valor) {
        Conta conta = repository.findById(id)
                .orElseThrow(() -> new ContaNaoEncontradaException(id));

        conta.setSaldo(conta.getSaldo().add(valor));
        return mapper.toResponse(repository.save(conta));
    }

    public ContaResponse saque(Long id, BigDecimal valor) {
        Conta conta = repository.findById(id)
                .orElseThrow(() -> new ContaNaoEncontradaException(id));

        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new NegocioException("Saldo insuficiente");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));
        return mapper.toResponse(repository.save(conta));
    }

    @Transactional
    public void transferencia(TransferenciaRequest request) {
        Conta origem = repository.findById(request.origemId())
                .orElseThrow(() -> new ContaNaoEncontradaException(request.origemId()));

        Conta destino = repository.findById(request.destinoId())
                .orElseThrow(() -> new ContaNaoEncontradaException(request.destinoId()));

        if (origem.getSaldo().compareTo(request.valor()) < 0) {
            throw new NegocioException("Saldo insuficiente para transferência");
        }

        origem.setSaldo(origem.getSaldo().subtract(request.valor()));
        destino.setSaldo(destino.getSaldo().add(request.valor()));

        repository.save(origem);
        repository.save(destino);
    }
}