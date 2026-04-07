package com.ricardo.controletarefas.service;

import com.ricardo.controletarefas.model.Tarefa;
import com.ricardo.controletarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public List<Tarefa> get() {
        return repository.findAll();
    }

    public Tarefa save(Tarefa tarefa) {
        return repository.save(tarefa);
    }
}
