/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.controller;

import com.projeto.tcc.model.UserRequestDTO;
import com.projeto.tcc.model.UsuarioDTO;
import com.projeto.tcc.service.TokenService;
import com.projeto.tcc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public String login(@RequestBody UserRequestDTO request) {
        UsuarioDTO usuario = usuarioService.login(request);
        
        return tokenService.gerarToken(usuario);
    }
    
    @GetMapping("/me")
    public UsuarioDTO usuarioLogado(@RequestHeader("Authorization") String auth) {
        String token = auth.replace("Bearer ", "");
        
        if (!tokenService.validarToken(token)) {
        throw new ResponseStatusException(HttpStatusCode.valueOf(401), "Token inválido ou expirado");
        }
        
        return tokenService.extrairClaim(token);
    }

}