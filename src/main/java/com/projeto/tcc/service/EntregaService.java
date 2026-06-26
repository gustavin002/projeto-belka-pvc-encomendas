/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.service;

import com.projeto.tcc.model.EntregaDTO;
import com.projeto.tcc.repository.EntregaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaService {
    
    @Autowired
    private EntregaRepository repository;
    
    public void criar(EntregaDTO entrega) {
        repository.save(entrega);
    }
    
    public List<EntregaDTO> listarTodos() {
        return repository.findAll();
    }
    
    public void editar(int idEntrega, EntregaDTO entrega){
        repository.save(entrega);
    }
    
    public void deletar(int idEntrega){
        repository.deleteById(idEntrega);
    }
    
}
