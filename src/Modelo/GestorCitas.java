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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */


public class GestorCitas {
    private static LinkedList<Citas> citas;
     Connection con;
     Conexion conectar= new Conexion();
     Vector<Medico> listaMedico;
     private String sql;
    public GestorCitas(){
        citas= new LinkedList<Citas>();   
    }
    public void RegistrarCitas(Citas cita){
        PreparedStatement pst;
        
        try{
            con =conectar.getConnection();
            pst = con.prepareStatement("Insert into citas values(?,?,?,?,?,?,?,?)");
            pst.setString(1, cita.getNumeCita());
            pst.setString(2, cita.getFechaCita());
            pst.setString(3, cita.getHoraCita());
            pst.setString(4, cita.getObserCita());
            pst.setString(5, cita.getEstadoCita());
            pst.setString(6, cita.getMeIdentificacion());
            pst.setString(7, cita.getCodigoConsulCita());
            pst.setString(8, cita.getPaIdentificacion());

            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cita registrada");
            
            
        }catch (SQLException ex){
            Logger.getLogger(GestorCitas.class.getName()).log(Level.SEVERE, null, ex);
   
        }

        citas.add(cita);
    }

    public LinkedList <Citas> getCitasbyParametro(int parametro, String valor){
       con= conectar.getConnection();
     LinkedList <Citas> resultado = new LinkedList <Citas>();
      String sql="";
     
     for (Citas cit:citas){
         switch(parametro){
             case 1: if(cit.getNumeCita().equals(valor))
                 sql="Selecciono Numero de cita='"+valor+"'";
                 resultado.add(cit);
             break;
 
             case 2: if(cit.getHoraCita().equals(valor))
                 sql="Selecciono hora de cita='"+valor+"'";
                 resultado.add(cit);
             break;
             
             case 3: if(cit.getObserCita().equals(valor))
                 sql="Selecciono observaciones de cita='"+valor+"'";
                 resultado.add(cit);
             break;
             
             case 4: if(cit.getEstadoCita().equals(valor))
                 sql="Selecciono estado de cita='"+valor+"'";
             resultado.add(cit);
              break;
             
             case 5: if(cit.getMeIdentificacion().equals(valor))
                 sql="Selecciono identificacion del medico='"+valor+"'";
                 resultado.add(cit);
                  break;
                 
             case 6: if(cit.getCodigoConsulCita().equals(valor))
                 sql="Selecciono codigo de consultorioa='"+valor+"'";
                 resultado.add(cit);
              break;
              
             case 7: if(cit.getPaIdentificacion().equals(valor))  
                 sql="Selecciono identificacion del paciente='"+valor+"'";
                 resultado.add(cit);
                  break;
             
         
         }
    }
    try{
        try(Statement st = con.createStatement()){
            ResultSet rs =st.executeQuery(sql);
            
            while(rs.next()){
                
                resultado.add(new Citas(rs.getString("NumeCita"),rs.getString("FechaCita"),rs.getString("HoraCita"),rs.getString("ObserCita"),rs.getString("EstadoCita"),rs.getString("MeIdentificacion"),rs.getString("CodigoConsulCita"),rs.getString("PaIdentificacion")));
            }
        }
        
        
    }catch (SQLException e){
        
        JOptionPane.showMessageDialog(null, e.getMessage());
        
    }
    return resultado;
    }
}
