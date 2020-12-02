/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

/**
 *
 * @author maria
 */
public class PacienteControl implements ActionListener {
    
    Vista.RegpacienteInternalFrame pacienteVista;
    Modelo.Paciente pacienteModelo;
    Modelo.GestorPaciente gestorPacienteModelo;
    
    
    public PacienteControl(Vista.RegpacienteInternalFrame pacienteVista){
        
        this.pacienteVista=pacienteVista;
        gestorPacienteModelo= new Modelo.GestorPaciente();
    }
@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(pacienteVista.jButton1)){
         String identificacion=pacienteVista.txtIdentificacion.getText();
         String nombre=pacienteVista.txtNombre.getText();
         String apellidos=pacienteVista.txtApellido.getText();
        SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
          String fecha_nacimiento=formato.format(pacienteVista.dtFechaNaci.getDate());
          String genero="";
           if(pacienteVista.rdb_masculino.isSelected()){
         genero="M";
                }
         if(pacienteVista.rdb_femenino.isSelected()){
         genero="F";
             }
           
        pacienteModelo=new Modelo.Paciente(identificacion, nombre, apellidos, fecha_nacimiento, genero);

        gestorPacienteModelo.RegistrarPaciente(pacienteModelo);

        }

        if(e.getSource().equals(pacienteVista.jButton2)){
          pacienteVista.txtIdentificacion.setText("");
          pacienteVista.txtNombre.setText("");
          pacienteVista.txtApellido.setText("");
          pacienteVista.dtFechaNaci.setDate(null);
          pacienteVista.rdb_masculino.setSelected(true);
          pacienteVista.rdb_femenino.setSelected(false);
          pacienteVista.txtIdentificacion.requestFocus();
             }
        }    
    
    
}
