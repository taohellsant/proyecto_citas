/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class GestorConsultorio {
    
    private static LinkedList<Consultorio> consultorios;
     Connection con;
     Conexion conectar= new Conexion();
    public GestorConsultorio(){
        consultorios= new LinkedList<Consultorio>();   
    }
    public void RegistrarConsultorio(Consultorio consultorio){
        PreparedStatement pst;
        
        try{
            con =conectar.getConnection();
            pst = con.prepareStatement("Insert into consultorio values(?,?)");
            pst.setString(1, consultorio.getCodiConsultorio());
            pst.setString(2, consultorio.getNombConsultorio());
                        
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Consultorio registrado");
            
            
        }catch (SQLException ex){
            Logger.getLogger(GestorPaciente.class.getName()).log(Level.SEVERE, null, ex);
   
        }

        consultorios.add(consultorio);
    }
    public LinkedList <Consultorio> getConsultoriobyParametro(int parametro, String valor){
       con= conectar.getConnection();
     LinkedList <Consultorio> resultado = new LinkedList <Consultorio>();
      String sql="";
     
     for (Consultorio cons:consultorios){
         switch(parametro){
             case 1: if(cons.getCodiConsultorio().equals(valor))
                 sql="Selecciono codigo del consultorio='"+valor+"'";
                 resultado.add(cons);
             break;
             
             case 2: if(cons.getNombConsultorio().equals(valor))
                 sql="Selecciono Nombre del consultorio='"+valor+"'";
                 resultado.add(cons);
             break;
         }
    }
    try{
        try(Statement st = con.createStatement()){
            ResultSet rs =st.executeQuery(sql);
            
            while(rs.next()){
                
                resultado.add(new Consultorio(rs.getString("CodiConsultorio"),rs.getString("NomConsultorio")));
            }
        }
        
        
    }catch (SQLException e){
        
        JOptionPane.showMessageDialog(null, e.getMessage());
        
    }
    return resultado;
    }
    
}
