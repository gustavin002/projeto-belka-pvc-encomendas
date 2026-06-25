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

@Entity
@Table(name = "tb_encomenda")
public class EncomendaDTO {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
 
    @Column(name = "id_encomenda")
    private int id;
 
    private String codigoRastreioEncomenda;
    private String destinatarioEncomenda;
    private String enderecoAtualEncomenda;
    private String statusEncomenda;
    
    @ManyToOne
    @JoinColumn(name = "tb_encomenda", referencedColumnName = "id_cliente", nullable = false)
    private EncomendaDTO cliente;
    
    @ManyToOne
    @JoinColumn(name = "tb_encomenda", referencedColumnName = "id_usuario", nullable = false)
    private EncomendaDTO usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoRastreioEncomenda() {
        return codigoRastreioEncomenda;
    }

    public void setCodigoRastreioEncomenda(String codigoRastreioEncomenda) {
        this.codigoRastreioEncomenda = codigoRastreioEncomenda;
    }

    public String getDestinatarioEncomenda() {
        return destinatarioEncomenda;
    }

    public void setDestinatarioEncomenda(String destinatarioEncomenda) {
        this.destinatarioEncomenda = destinatarioEncomenda;
    }

    public String getEnderecoAtualEncomenda() {
        return enderecoAtualEncomenda;
    }

    public void setEnderecoAtualEncomenda(String enderecoAtualEncomenda) {
        this.enderecoAtualEncomenda = enderecoAtualEncomenda;
    }

    public String getStatusEncomenda() {
        return statusEncomenda;
    }

    public void setStatusEncomenda(String statusEncomenda) {
        this.statusEncomenda = statusEncomenda;
    }

    public EncomendaDTO getCliente() {
        return cliente;
    }

    public void setCliente(EncomendaDTO cliente) {
        this.cliente = cliente;
    }

    public EncomendaDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(EncomendaDTO usuario) {
        this.usuario = usuario;
    }
    
}
