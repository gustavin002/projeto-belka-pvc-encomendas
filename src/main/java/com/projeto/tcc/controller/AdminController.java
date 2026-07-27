/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.controller;

import com.projeto.tcc.model.AdminDTO;
import com.projeto.tcc.model.EntregadorDTO;
import com.projeto.tcc.model.OperadorLogisticoDTO;
import com.projeto.tcc.model.UserRequestDTO;
import com.projeto.tcc.model.UsuarioDTO;
import com.projeto.tcc.service.AdminService;
import com.projeto.tcc.service.EntregadorService;
import com.projeto.tcc.service.OperadorLogisticoService;
import com.projeto.tcc.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private TokenService tokenService;

    @Autowired
    private EntregadorService entregadorService;
    
    @Autowired
    private OperadorLogisticoService operadorLogisticoService;
    
    @PostMapping("/login")
    public String login(@RequestBody UserRequestDTO request) {
        AdminDTO admin = adminService.login(request);
        
        return tokenService.gerarToken(admin);
    }
    
    @GetMapping("/me")
    public AdminDTO adminLogado(@RequestHeader("Authorization") String auth) {
        String token = auth.replace("Bearer ", "");
        Integer id = tokenService.extrairId(token);
        return adminService.buscarAdminPorId(id);
    }

    @PostMapping("/entregadores")
    public EntregadorDTO cadastrarEntregador(@RequestBody UsuarioDTO usuario) {
        return entregadorService.cadastrarEntregador(usuario.getNomeUsuario(), usuario.getEmailUsuario(), usuario.getSenhaUsuario());
    }

    @PostMapping("/operadores-logisticos")
    public OperadorLogisticoDTO cadastrarOperadorLogistico(@RequestBody UsuarioDTO usuario) {
        return operadorLogisticoService.cadastrarOperadorLogistico(usuario.getNomeUsuario(), usuario.getEmailUsuario(), usuario.getSenhaUsuario());
    }

    @GetMapping("/entregadores")
    public List<EntregadorDTO> listarEntregadores() {
        return entregadorService.listarEntregadores();
    }

    @GetMapping("/operadores-logisticos")
    public List<OperadorLogisticoDTO> listarOperadoresLogisticos() {
        return operadorLogisticoService.listarOperadoresLogisticos();
    }

}