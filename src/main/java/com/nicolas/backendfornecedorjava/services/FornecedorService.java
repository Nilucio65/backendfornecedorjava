package com.nicolas.backendfornecedorjava.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.backendfornecedorjava.entities.Fornecedor;
import com.nicolas.backendfornecedorjava.repositories.FornecedorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository; 

    public Fornecedor getFornecedorById(int id){
        return fornecedorRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Fornecedor não encontrado")
        );
    }

    public List<Fornecedor> getFornecedores(){
        return fornecedorRepository.findAll();
    }

     public void deleteById(int id) {
      
        Fornecedor fornecedor = getFornecedorById(id);
        fornecedorRepository.delete(fornecedor);
        }

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void update(int id, Fornecedor fornecedor) {
        getFornecedorById(id);
        fornecedorRepository.save(fornecedor);
    }
}
