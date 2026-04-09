package com.ricardo.controletarefas.service;

import com.ricardo.controletarefas.exception.RegraNegocioException;
import com.ricardo.controletarefas.model.Tarefa;
import com.ricardo.controletarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Tarefa get(Long id) { return repository.findById(id).orElse(null); }

    public Tarefa save(Tarefa tarefa) {
        if (tarefa.getData_criacao().isBefore(LocalDate.now())) {
            throw new RegraNegocioException("A data de criação não pode ser no passado.");
        }
        return repository.save(tarefa);
    }

    public Tarefa update(Tarefa tarefa) {
        if (!repository.existsById(tarefa.getId())) {
            throw new RegraNegocioException("Tarefa não encontrada.");
        }
        if (tarefa.getData_criacao().isBefore(LocalDate.now())) {
            throw new RegraNegocioException("A data de criação não pode ser no passado.");
        }
        return repository.save(tarefa);
    }

    public void delete(Long id) { repository.deleteById(id); }
}
