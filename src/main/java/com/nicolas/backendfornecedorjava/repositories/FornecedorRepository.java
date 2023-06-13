package com.nicolas.backendfornecedorjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.backendfornecedorjava.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository <Fornecedor, Integer> {
    
}
