/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author maria
 */
public class MedicoControl implements ActionListener{
    
    Vista.RegMedicoInternalFrame medicoVista;
    Modelo.Medico medicoModelo;
    Modelo.GestorMedico gestorMedicoModelo;
    
    
    public MedicoControl(Vista.RegMedicoInternalFrame medicoVista){
        
        this.medicoVista=medicoVista;
        gestorMedicoModelo= new Modelo.GestorMedico();
    }
@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(medicoVista.btnRegistroMe)){
         String identificacion= medicoVista.txtMeIdentificacion.getText();
         String nombre= medicoVista.txtMeNombre.getText();
         String apellidos=medicoVista.txtMeApellido.getText();
 
         medicoModelo=new Modelo.Medico(identificacion, nombre, apellidos);

        gestorMedicoModelo.RegistrarMedico(medicoModelo);

        }

        if(e.getSource().equals(medicoVista.btnMeNuevo)){
          medicoVista.txtMeIdentificacion.setText("");
          medicoVista.txtMeNombre.setText("");
          medicoVista.txtMeApellido.setText("");
          medicoVista.txtMeIdentificacion.requestFocus();
             }
        }    
    
    
}
