/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

/**
 *
 * @author 152096
 */
public class test {
    
    public static void main(String args[]){
        DAO d = new DAO();
        
        Connection conn = d.connect();
        Boolean flag = d.cadastrarUsuario("William", "bfaeumlixo", "blabla", "Male", conn);
    }
    
}
