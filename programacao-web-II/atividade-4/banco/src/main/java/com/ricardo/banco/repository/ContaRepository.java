package com.ricardo.banco.repository;


import com.ricardo.banco.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> { }
