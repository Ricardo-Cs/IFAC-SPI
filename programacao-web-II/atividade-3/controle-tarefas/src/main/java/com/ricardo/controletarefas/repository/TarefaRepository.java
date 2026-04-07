package com.ricardo.controletarefas.repository;

import com.ricardo.controletarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> { }
