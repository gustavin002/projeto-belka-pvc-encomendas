/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.controller;

import com.projeto.tcc.model.EntregaDTO;
import com.projeto.tcc.model.UsuarioDTO;
import com.projeto.tcc.service.EntregaService;
import com.projeto.tcc.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EntregaController {
    
    @Autowired
    private EntregaService entregaService;
    
    @Autowired
    private TokenService tokenService;
    
    @GetMapping("/listar/entregas/entregador")
    public List<EntregaDTO> listarEntregasDoEntregador(@RequestHeader("Authorization") String auth) {
        String token = auth.replace("Bearer ", "");
        
        if (!tokenService.validarToken(token)) {
        throw new ResponseStatusException(HttpStatusCode.valueOf(401), "Token inválido ou expirado");
        }

        UsuarioDTO usuario = tokenService.extrairClaim(token);        
        return entregaService.listarEntregasDoEntregador(usuario.getIdUsuario());
    }

}