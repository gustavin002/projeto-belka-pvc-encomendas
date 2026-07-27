/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.service;

import com.projeto.tcc.model.ClienteDTO;
import com.projeto.tcc.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public ClienteDTO cadastrarCliente(ClienteDTO clienteRequest) {
        ClienteDTO cliente = clienteRepository.findByEmailCliente(clienteRequest.getEmailCliente());

        if (cliente != null) {
            return cliente;
        }

    return clienteRepository.save(clienteRequest);
}
    
    public ClienteDTO buscarClientePorId(Integer idCliente){
        ClienteDTO cliente = clienteRepository.findByIdCliente(idCliente);
        
        if (cliente == null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Cliente não encontrado");
        }
        
        return cliente;
    }
    
}