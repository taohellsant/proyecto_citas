/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author maria
 */
public class Conexion {
    String url ="jdbc:mysql://localhost:3306/proyecto_citas";
    String user="root", pass="";
    Connection con;   
    
    public Connection getConnection(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null,"Conexion a la base de datos");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error de conexion");
            
        }return con;
    }
    
    
}
