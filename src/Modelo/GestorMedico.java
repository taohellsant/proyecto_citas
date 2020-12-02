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
public class GestorMedico {
    
     private static LinkedList<Medico> medicos;
     Connection con;
     Conexion conectar= new Conexion();
    public GestorMedico(){
        medicos= new LinkedList<Medico>();   
    }
    public void RegistrarMedico(Medico medico){
        PreparedStatement pst;
        
        try{
            con =conectar.getConnection();
            pst = con.prepareStatement("Insert into medico values(?,?,?)");
            pst.setString(1, medico.getMeIdentificacion());
            pst.setString(2, medico.getMeNombre());
            pst.setString(3, medico.getMeApellido());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "medico registrado");
            
            
        }catch (SQLException ex){
            Logger.getLogger(GestorMedico.class.getName()).log(Level.SEVERE, null, ex);
   
        }

        medicos.add(medico);
    }
    public LinkedList <Medico> getMedicobyParametro(int parametro, String valor){
       con= conectar.getConnection();
     LinkedList <Medico> resultado = new LinkedList <Medico>();
      String sql="";
     
     for (Medico mec:medicos){
         switch(parametro){
             case 1: if(mec.getMeIdentificacion().equals(valor))
                 sql="Selecciono Identificacion del medico='"+valor+"'";
                 resultado.add(mec);
             break;
             
             case 2: if(mec.getMeNombre().equals(valor))
                 sql="Selecciono Nombre del  paciente='"+valor+"'";
                 resultado.add(mec);
             break;
             
             case 3: if(mec.getMeApellido().equals(valor))
                 sql="Selecciono Apellido del  paciente='"+valor+"'";
                 resultado.add(mec);
             break;
             
         }
    }
    try{
        try(Statement st = con.createStatement()){
            ResultSet rs =st.executeQuery(sql);
            
            while(rs.next()){
                
                resultado.add(new Medico(rs.getString("MecIdentificacion"),rs.getString("MecNombre"),rs.getString("MecApellido")));
            }
        }
        
        
    }catch (SQLException e){
        
        JOptionPane.showMessageDialog(null, e.getMessage());
        
    }
    return resultado;
    }
    
    
    
}
