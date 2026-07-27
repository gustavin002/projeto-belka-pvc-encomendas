/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.repository;

import com.projeto.tcc.model.EntregaDTO;
import com.projeto.tcc.model.EntregadorDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<EntregaDTO, Integer>{
    
    EntregaDTO findByIdEntrega(Integer idEntrega);
    List<EntregaDTO> findByEntregador(EntregadorDTO entregador);
    
}