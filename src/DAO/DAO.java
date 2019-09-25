/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author BruxoSagaz
 */
public class DAO implements interfaceDAO{

    @Override
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/database", "postgres", "masterkey");
            //JOptionPane.showMessageDialog(null, "Connected");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getCause());
        }
        return conn;
    }

    @Override
    public Boolean cadastrarUsuario(String nome, String senha, String email, String sexo, Connection conn) {
        PreparedStatement pstmt = null;
        String SQL = null;
        ResultSet rs = null;
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";        
        if(nome.equals("") || senha.equals("") || email.equals("")){
            JOptionPane.showMessageDialog(null, "Favor preencher todos os campos");
            return false;
        }
        if(!email.matches(regex)){
            JOptionPane.showMessageDialog(null, "COLOCA O EMAIL CERTO O SUA ANTA");
            return false;
        }
        SQL = "INSERT INTO usuarios(name, sexo, email, pw) values(?, ?, ?, ?)";             
        try {
            pstmt=conn.prepareStatement(SQL);
            pstmt.setString(1, nome);
            pstmt.setString(2, sexo);
            pstmt.setString(3, email);
            pstmt.setString(4, senha);
            
            pstmt.addBatch();
            pstmt.executeBatch();
            
            JOptionPane.showMessageDialog(null, "Paciente Cadastrado");
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getNextException());
            return false;
        }              
    }
    
    
}

/**
 * CREATE TABLE usuarios(
 * id SERIAL primary key not null,
 * name TEXT not null,
 * sexo TEXT not null,
 * email TEXT unique not null,
 * pw TEXT not null
 * )
 */
