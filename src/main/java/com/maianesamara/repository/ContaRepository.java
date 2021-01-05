package com.maianesamara.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maianesamara.entidade.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
