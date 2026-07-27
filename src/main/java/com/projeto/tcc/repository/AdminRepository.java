/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.repository;

import com.projeto.tcc.model.AdminDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminDTO, Integer> {
    
    AdminDTO findByEmailAdminAndSenhaAdmin(String emailAdmin, String senhaAdmin);
    AdminDTO findByIdAdmin(Integer idAdmin);
    
}