/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

@Entity
@Table(name = "tb_usuario")
public class UsuarioDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name = "id_usuario")
    private int idUsuario;
    
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private String roleUsuario;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getRoleUsuario() {
        return roleUsuario;
    }

    public void setRoleUsuario(String roleUsuario) {
        if(roleUsuario.equalsIgnoreCase("operador") || roleUsuario.equalsIgnoreCase("entregador")){
            this.roleUsuario = roleUsuario;
        }else {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "ERRO!!! a role deve ser operador ou entregador");
        }
    }
    
}
