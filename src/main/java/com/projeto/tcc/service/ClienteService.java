/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.service;

import com.projeto.tcc.model.ClienteDTO;
import com.projeto.tcc.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired 
    private ClienteRepository repository;
    
    public void criar(ClienteDTO encomenda) {
        repository.save(encomenda);
    }
    
    public List<ClienteDTO> listarTodos() {
        return repository.findAll();
    }
    
    public void editar(int idCliente, ClienteDTO cliente){
        repository.save(cliente);
    }
    
    public void deletar(int idCliente){
        repository.deleteById(idCliente);
    }
    
}
