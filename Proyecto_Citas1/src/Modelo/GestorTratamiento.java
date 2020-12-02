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
public class GestorTratamiento {
    
    private static LinkedList<Tratamiento> tratamientos;
     Connection con;
     Conexion conectar= new Conexion();
    public GestorTratamiento(){
        tratamientos= new LinkedList<Tratamiento>();   
    }
    public void RegistrarTratamiento(Tratamiento tratamiento){
        PreparedStatement pst;
        
        try{
            con =conectar.getConnection();
            pst = con.prepareStatement("Insert into tratamiento values(?,?,?,?,?,?)");
            pst.setString(1, tratamiento.getCodiTratamiento());
            pst.setString(2, tratamiento.getFechaAsigTratamiento());
            pst.setString(3, tratamiento.getFechaIniTratamiento());
            pst.setString(4, tratamiento.getFechaFinTratamiento());
            pst.setString(5, tratamiento.getDescriTratamiento());
            pst.setString(6, tratamiento.getPaIdentificacion());
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Tratamiento registrado");
            
            
        }catch (SQLException ex){
            Logger.getLogger(GestorPaciente.class.getName()).log(Level.SEVERE, null, ex);
   
        }

        tratamientos.add(tratamiento);
    }
    public LinkedList <Tratamiento> getTratamientobyParametro(int parametro, String valor){
       con= conectar.getConnection();
     LinkedList <Tratamiento> resultado = new LinkedList <Tratamiento>();
      String sql="";
     
     for (Tratamiento tra:tratamientos){
         switch(parametro){
             case 1: if(tra.getCodiTratamiento().equals(valor))
                 sql="I select treatment code='"+valor+"'";
                 resultado.add(tra);
             break;
             
             case 2: if(tra.getDescriTratamiento().equals(valor))
                 sql="I select treatment description='"+valor+"'";
                 resultado.add(tra);
             break;
             
             case 3: if(tra.getPaIdentificacion().equals(valor))
                 sql="I select the patient's identification='"+valor+"'";
                 resultado.add(tra);
             break;
         }
    }
    try{
        try(Statement st = con.createStatement()){
            ResultSet rs =st.executeQuery(sql);
            
            while(rs.next()){
                
                resultado.add(new Tratamiento(rs.getString("CodiTratamiento"),rs.getString("FechaAsignada"),rs.getString("FechaInicio"),rs.getString("FechaFinal"),rs.getString("DescripTratamiento"),rs.getString("IdenPaciente")));
            }
        }
        
        
    }catch (SQLException e){
        
        JOptionPane.showMessageDialog(null, e.getMessage());
        
    }
    return resultado;
    }
    
}
