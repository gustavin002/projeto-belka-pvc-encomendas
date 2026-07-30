/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.controller;

import com.projeto.tcc.model.EncomendaDTO;
import com.projeto.tcc.model.UsuarioDTO;
import com.projeto.tcc.service.EncomendaService;
import com.projeto.tcc.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncomendaController {

    @Autowired
    private EncomendaService encomendaService;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/operador/encomendas/operador")
    public List<EncomendaDTO> listarEncomendasPorOperador(@RequestHeader("Authorization") String auth, Integer idOperadorLogistico) {
        String token = auth.replace("Bearer ", "");
        UsuarioDTO usuario = tokenService.extrairClaim(token);

        return encomendaService.listarEncomendasPorOperador(idOperadorLogistico);
    }

}