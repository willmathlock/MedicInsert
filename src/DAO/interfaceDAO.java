/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

/**
 *
 * @author BruxoSagaz
 */
public interface interfaceDAO {
    
    public Connection connect();
    public Boolean cadastrarUsuario(String nome, String senha, String data, String sexo, Connection conn);
}
