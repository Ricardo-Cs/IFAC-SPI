package com.ricardo.controletarefas.controller;

import com.ricardo.controletarefas.model.Tarefa;
import com.ricardo.controletarefas.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Tarefa>> get() {
        List<Tarefa> tarefas = service.get();
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Tarefa> save(@RequestBody Tarefa tarefa) {
        Tarefa registro = service.save(tarefa);
        return new ResponseEntity<>(registro, HttpStatus.CREATED);
    }
}
