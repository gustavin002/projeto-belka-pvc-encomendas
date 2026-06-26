/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.service;

import com.projeto.tcc.model.UsuarioDTO;
import com.projeto.tcc.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired 
    private UsuarioRepository repository;
    
    public void criar(UsuarioDTO usuario) {
        repository.save(usuario);
    }
    
    public List<UsuarioDTO> listarTodos() {
        return repository.findAll();
    }
    
    public void editar(int idUsuario, UsuarioDTO usuario){
        repository.save(usuario);
    }
    
    public void deletar(int idUsuario){
        repository.deleteById(idUsuario);
    }
    
}
