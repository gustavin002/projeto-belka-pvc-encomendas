/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.service;

import com.projeto.tcc.model.UserRequestDTO;
import com.projeto.tcc.model.UsuarioDTO;
import com.projeto.tcc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private JavaMailSender mailSender;

    public UsuarioDTO login(UserRequestDTO request) {
        UsuarioDTO usuario = usuarioRepository.findByEmailUsuarioAndSenhaUsuario(request.getEmail(), request.getSenha());

        if (usuario == null) {
        throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Email ou senha inválidos");
        }

        return usuario;
    }
    
    public UsuarioDTO buscarUsuarioLogado(Integer idUsuario) {
        UsuarioDTO usuario = usuarioRepository.findByIdUsuario(idUsuario);
        
        if (usuario == null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404), "Admin não encontrado");
        }
        
        return usuario;
    }

    public void enviarEmail(String destinatario, String assunto, String corpo) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(destinatario);
        mensagem.setSubject(assunto);
        mensagem.setText(corpo);

        try {
            mailSender.send(mensagem);
        } catch (MailException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(500), "Erro ao enviar e-mail");
        }
        
    }
    
}