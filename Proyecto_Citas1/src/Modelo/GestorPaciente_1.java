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
public class GestorPaciente {
    
    private static LinkedList<Paciente> pacientes;
     Connection con;
     Conexion conectar= new Conexion();
    public GestorPaciente(){
        pacientes= new LinkedList<Paciente>();   
    }
    public void RegistrarPaciente(Paciente paciente){
        PreparedStatement pst;
        
        try{
            con =conectar.getConnection();
            pst = con.prepareStatement("Insert into paciente values(?,?,?,?,?)");
            pst.setString(1, paciente.getIdentificacion());
            pst.setString(2, paciente.getNombre());
            pst.setString(3, paciente.getApellido());
            pst.setString(4, paciente.getFechaNacimiento());
            pst.setString(5, paciente.getGenero());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Paciente registrado");
            
            
        }catch (SQLException ex){
            Logger.getLogger(GestorPaciente.class.getName()).log(Level.SEVERE, null, ex);
   
        }

        pacientes.add(paciente);
    }
    public LinkedList <Paciente> getPacientebyParametro(int parametro, String valor){
       con= conectar.getConnection();
     LinkedList <Paciente> resultado = new LinkedList <Paciente>();
      String sql="";
     
     for (Paciente pac:pacientes){
         switch(parametro){
             case 1: if(pac.getIdentificacion().equals(valor))
                 sql="Selecciono Identificacion del  paciente='"+valor+"'";
                 resultado.add(pac);
             break;
             
             case 2: if(pac.getNombre().equals(valor))
                 sql="Selecciono Nombre del  paciente='"+valor+"'";
                 resultado.add(pac);
             break;
             
             case 3: if(pac.getApellido().equals(valor))
                 sql="Selecciono Apellido del  paciente='"+valor+"'";
                 resultado.add(pac);
             break;
             
             case 4: if(pac.getGenero().equals(valor))
                 sql="Selecciono Genero del  paciente='"+valor+"'";
                 resultado.add(pac);
             break;
             
         
         }
    }
    try{
        try(Statement st = con.createStatement()){
            ResultSet rs =st.executeQuery(sql);
            
            while(rs.next()){
                
                resultado.add(new Paciente(rs.getString("PacIdentificacion"),rs.getString("PacNombre"),rs.getString("PacApellido"),rs.getString("PacFechaNaci"),rs.getString("PacGenero")));
            }
        }
        
        
    }catch (SQLException e){
        
        JOptionPane.showMessageDialog(null, e.getMessage());
        
    }
    return resultado;
    }
    
}
