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
public class TratamientoControl implements ActionListener {
    
    Vista.RegTratamientoInternalFrame tratamientoVista;
    Modelo.Tratamiento tratamientoModelo;
    Modelo.GestorTratamiento gestorTratamientoModelo;
    
    
    public TratamientoControl(Vista.RegTratamientoInternalFrame tratamientoVista){
        
        this.tratamientoVista=tratamientoVista;
        gestorTratamientoModelo= new Modelo.GestorTratamiento();
    }
@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(tratamientoVista.btnRegTratamiento)){
         String CodiTratameinto=tratamientoVista.txtCodiTratamiento.getText();
         SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
          String fecha_Asignada=formato.format(tratamientoVista.jdFeAsignada.getDate());
          String fecha_Inicio=formato.format(tratamientoVista.jdFeInicio.getDate());
          String fecha_Final=formato.format(tratamientoVista.jdFeFinal.getDate());
          String DescripTratamiento=tratamientoVista.txtDesTratamiento.getText();
          String IdenPaciente=tratamientoVista.txtIdenPaciente.getText();
          
           
        tratamientoModelo=new Modelo.Tratamiento(CodiTratameinto, fecha_Asignada, fecha_Inicio, fecha_Final, DescripTratamiento, IdenPaciente);

        gestorTratamientoModelo.RegistrarTratamiento(tratamientoModelo);

        }

        if(e.getSource().equals(tratamientoVista.btnNuevTratamiento)){
          tratamientoVista.txtCodiTratamiento.setText("");
          tratamientoVista.jdFeAsignada.setDate(null);
          tratamientoVista.jdFeInicio.setDate(null);
          tratamientoVista.jdFeFinal.setDate(null);
          tratamientoVista.txtDesTratamiento.setText("");
          tratamientoVista.txtIdenPaciente.setText("");
          tratamientoVista.txtCodiTratamiento.requestFocus();
             }
        }
    
}
