/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 152096
 */
public class DAOTest {
    
    public DAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of cadastrarUsuario method, of class DAO.
     * While everything is empty. Expected = false.
     */
    @Test
    public void testCadastrarUsuario() {
        System.out.println("cadastrarUsuarioValores vazios");
        String nome = "";
        String senha = "";
        String email = "";
        String sexo = "Male";
        Connection conn = null;
        DAO instance = new DAO();
        conn = instance.connect();
        Boolean expResult = false;
        Boolean result = instance.cadastrarUsuario(nome, senha, email, sexo, conn);
        assertEquals(expResult, result);

    }
    /**
     * Test of cadastrarUsuario method, of class DAO.
     * With correct parameters. Expected = true;
     */
    @Test
    public void testCadastrarUsuario2(){
        System.out.println("cadastrarusuario Email errado");
        String nome = "William";
        String senha = "Itswednesdaymydudes";
        String email = "Jajalilidasd32@gmail.com";
        String sexo = "Male";
        
        Connection conn = null;
        DAO instance = new DAO();
        conn = instance.connect();
        Boolean expResult = true;
        Boolean result = instance.cadastrarUsuario(nome, senha, email, sexo, conn);
        assertEquals(expResult, result);                
    }
    /**
     * Test of cadastrarUsuario method, of class DAO.
     * With wrong email. Expected = false;
     */
    @Test
    public void testCadastrarUsuario3(){     
        String nome = "William";
        String senha = "lalala";
        String email = "email.com@gmail";
        String sexo = "Male";
        Connection conn = null;
        DAO instance = new DAO();
        conn = instance.connect();
        Boolean expResult = false;
        Boolean result = instance.cadastrarUsuario(nome, senha, email, sexo, conn);
        assertEquals(expResult, result);
    }
         
    
}
