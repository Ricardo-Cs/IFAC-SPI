package com.ricardo.banco.service;

import com.ricardo.banco.model.Conta;
import com.ricardo.banco.repository.ContaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    private final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public Conta save(Conta conta) {
        return repository.save(conta);
    }
}
