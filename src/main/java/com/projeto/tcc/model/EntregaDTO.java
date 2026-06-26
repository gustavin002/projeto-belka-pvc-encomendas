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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
 
@Entity
@Table(name = "tb_entrega")
public class EntregaDTO {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
 
    @Column(name = "id_entrega")
    private int id;
 
    private LocalDateTime dataEntrega;
    private String codigoOtpEntrega;
 
    @ManyToOne
    @JoinColumn(name = "tb_encomenda", referencedColumnName = "id_encomenda", nullable = false)
    private EncomendaDTO encomenda;
 
    @ManyToOne
    @JoinColumn(name = "tb_usuario", referencedColumnName = "id_usuario", nullable = false)
    private UsuarioDTO usuario;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }
 
    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
 
    public String getCodigoOtpEntrega() {
        return codigoOtpEntrega;
    }
 
    public void setCodigoOtpEntrega(String codigoOtpEntrega) {
        this.codigoOtpEntrega = codigoOtpEntrega;
    }
 
    public EncomendaDTO getEncomenda() {
        return encomenda;
    }
 
    public void setEncomenda(EncomendaDTO encomenda) {
        this.encomenda = encomenda;
    }
 
    public UsuarioDTO getUsuario() {
        return usuario;
    }
 
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
 
}