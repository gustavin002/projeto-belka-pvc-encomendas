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

@Entity
@Table(name = "tb_cliente")
public class ClienteDTO {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
 
    @Column(name = "id_cliente")
    private int id;
 
    private String nomeCliente;
    private String emailCliente;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNomeCliente() {
        return nomeCliente;
    }
 
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
 
    public String getEmailCliente() {
        return emailCliente;
    }
 
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
 
}