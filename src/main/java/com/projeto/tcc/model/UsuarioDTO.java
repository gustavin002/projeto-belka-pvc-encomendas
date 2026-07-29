/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role_usuario", discriminatorType = DiscriminatorType.STRING)
public class UsuarioDTO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "id_usuario")
    private Integer idUsuario;
 
    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;
 
    @Column(name = "email_usuario", nullable = false, unique = true)
    private String emailUsuario;
 
    @Column(name = "senha_usuario", nullable = false)
    private String senhaUsuario;
 
    @Column(name = "disponibilidade_usuario", nullable = false)
    private String disponibilidadeUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
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
        
        if (this instanceof EntregadorDTO) {
            return "entregador";
        }
        
        if (this instanceof OperadorLogisticoDTO) {
            return "operador logistico";
        }
        
        return "";
    }

    public String getDisponibilidadeUsuario() {
        return disponibilidadeUsuario;
    }

    public void setDisponibilidadeUsuario(String disponibilidadeUsuario) {
        this.disponibilidadeUsuario = disponibilidadeUsuario;
    }

}