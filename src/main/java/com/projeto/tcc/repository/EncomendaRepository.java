/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.repository;

import com.projeto.tcc.model.ClienteDTO;
import com.projeto.tcc.model.EncomendaDTO;
import com.projeto.tcc.model.OperadorLogisticoDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncomendaRepository extends JpaRepository<EncomendaDTO, Integer>{
    
    EncomendaDTO findByIdEncomenda(Integer idEncomenda);
    EncomendaDTO findByCodigoRastreioEncomenda(String codigoRastreioEncomenda);
    boolean existsByCodigoRastreioEncomenda(String codigo);
    List<EncomendaDTO> findByCliente(ClienteDTO cliente);
    List<EncomendaDTO> findByOperadorLogistico(OperadorLogisticoDTO operadorLogistico);

}