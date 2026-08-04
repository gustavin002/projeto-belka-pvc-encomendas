/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.service;

import com.projeto.tcc.model.AdminDTO;
import com.projeto.tcc.model.UserRequestDTO;
import com.projeto.tcc.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {

    @Autowired
        private AdminRepository adminRepository;

    public AdminDTO login(UserRequestDTO request) {
        AdminDTO admin = adminRepository.findByEmailAdminAndSenhaAdmin(request.getEmail(), request.getSenha());

        if (admin == null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(401), "Email ou senha inválidos");
        }

        return admin;
    }
    
    public AdminDTO buscarAdminLogado(Integer idAdmin) {
        AdminDTO admin = adminRepository.findByIdAdmin(idAdmin);
        
        if (admin == null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Admin não encontrado");
        }
        
        return admin;
    }

}