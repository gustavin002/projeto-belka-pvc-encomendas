/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3307/db_sistema_web";
 
    private static final String user = "root";

    private static final String senha = "";
    // Objeto de conexão reutilizável (implementa padrão Singleton)
    // Mantém uma única conexão aberta durante a vida da aplicação
    private static Connection conn = null;

    public Conexao () {}

    // Método para obter uma conexão com o banco de dados de forma sincronizada
    // O synchronized garante que apenas uma thread acesse este método por vez
    // Previne condições de corrida (race conditions) ao criar múltiplas conexões
    // Retorna: objeto Connection para executar comandos SQL
    public static synchronized Connection conectar() {
        try {

            if(conn == null || conn.isClosed()) {

                conn = DriverManager.getConnection(url, user, senha);
            }
        } catch(SQLException e ) {

            e.printStackTrace();
        }

        return conn;
    }
    
}