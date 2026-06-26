/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.service;
import com.projeto.tcc.model.EncomendaDTO;
import com.projeto.tcc.repository.EncomendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncomendaService {
    
    @Autowired 
    private EncomendaRepository repository;
    
    public void criar(EncomendaDTO encomenda) {
        repository.save(encomenda);
    }
    
    public List<EncomendaDTO> listarTodos() {
        return repository.findAll();
    }
    
    public void editar(int idEncomenda, EncomendaDTO encomenda){
        repository.save(encomenda);
    }
    
    public void deletar(int idEncomenda){
        repository.deleteById(idEncomenda);
    }
    
}