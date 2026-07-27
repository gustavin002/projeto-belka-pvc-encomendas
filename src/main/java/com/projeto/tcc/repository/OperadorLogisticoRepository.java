/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.repository;

import com.projeto.tcc.model.OperadorLogisticoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorLogisticoRepository extends JpaRepository<OperadorLogisticoDTO, Integer> {

    OperadorLogisticoDTO findByIdUsuario(Integer idOperador);
    
}