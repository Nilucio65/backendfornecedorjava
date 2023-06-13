package com.nicolas.backendfornecedorjava.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nicolas.backendfornecedorjava.entities.Fornecedor;
import com.nicolas.backendfornecedorjava.services.FornecedorService;

@RestController
@CrossOrigin
@RequestMapping("supplier")
public class FornecedorController {
    
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("{id}")
    public Fornecedor getFornecedor(@PathVariable int id){
        return fornecedorService.getFornecedorById(id);
    }

     @GetMapping()
    public List<Fornecedor> getFornecedores(){
       return fornecedorService.getFornecedores();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletefornecedor(@PathVariable int id){
        fornecedorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> editFornecedor(@PathVariable int id,@RequestBody Fornecedor fornecedor){
        fornecedorService.update(id,fornecedor);
        return ResponseEntity.ok().build();
    }


    @PostMapping
    public ResponseEntity<Fornecedor> saveFornecedor(@RequestBody Fornecedor fornecedor){
        Fornecedor newFornecedor = fornecedorService.save(fornecedor);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(fornecedor.getId())
        .toUri();
        
        return ResponseEntity.created(location).body(newFornecedor);
    }
}
