/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.controller;

import com.projeto.tcc.model.EncomendaDTO;
import com.projeto.tcc.model.EntregaDTO;
import com.projeto.tcc.service.EncomendaService;
import com.projeto.tcc.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {
    
    @Autowired
    private EntregaService entregaService;
    
    @Autowired
    private EncomendaService encomendaService;
    
    @GetMapping("/entregas/{idEntrega}")
    public EntregaDTO buscarEntregaPorId(@PathVariable Integer idEntrega) {
        return entregaService.buscarEntregaPorId(idEntrega);
    }

    @PutMapping("/{idEntrega}/status")
    public EncomendaDTO atualizarStatus(@PathVariable Integer idEntrega, @RequestParam String novoStatus) {
        return encomendaService.atualizarStatus(idEntrega, novoStatus);
    }

     @PutMapping("/{idEntrega}/local")
    public EncomendaDTO atualizarLocalAtual(@PathVariable Integer idEntrega, @RequestParam String novoLocal) {
        return encomendaService.atualizarLocalAtual(idEntrega, novoLocal);
    }

    @PostMapping("/{idEntrega}/validar-otp")
    public EntregaDTO validarOTP(@PathVariable Integer idEntrega, @RequestParam String otpDigitado) {
        return entregaService.validarOTP(idEntrega, otpDigitado);
    }

}