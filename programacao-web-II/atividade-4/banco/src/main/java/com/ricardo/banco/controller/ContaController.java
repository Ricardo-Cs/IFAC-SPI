package com.ricardo.banco.controller;

import com.ricardo.banco.dto.request.ContaRequest;
import com.ricardo.banco.dto.request.TransferenciaRequest;
import com.ricardo.banco.dto.response.ContaResponse;
import com.ricardo.banco.model.Conta;
import com.ricardo.banco.service.ContaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/contas")
public class ContaController {
    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<ContaResponse> create(@RequestBody @Valid ContaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @PostMapping("/{id}/deposito")
    public ResponseEntity<ContaResponse> deposito(@PathVariable Long id,
                                                  @RequestParam @Positive BigDecimal valor) {
        return ResponseEntity.ok(service.deposito(id, valor));
    }

    @PostMapping("/{id}/saque")
    public ResponseEntity<ContaResponse> saque(@PathVariable Long id,
                                               @RequestParam @Positive BigDecimal valor) {
        return ResponseEntity.ok(service.saque(id, valor));
    }

    @PostMapping("/transferencia")
    public ResponseEntity<Void> transferencia(@RequestBody @Valid TransferenciaRequest request) {
        service.transferencia(request);
        return ResponseEntity.ok().build();
    }
}