/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maria
 */
public class GestorTratamientoControl implements ActionListener{
    
     Modelo.GestorTratamiento tratamientoModelo;
    Vista.ConsTratamientoInternalFrame consultaTratamientoVista;
    public GestorTratamientoControl(Vista.ConsTratamientoInternalFrame consultaTratamientoVista ){
        
        this.consultaTratamientoVista = consultaTratamientoVista;
        tratamientoModelo= new Modelo.GestorTratamiento();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DefaultTableModel tmodelo;
        String valor=consultaTratamientoVista.txtTraValor.getText();
        int parametro=0;
        
        if(consultaTratamientoVista.jrCodiTratamiento.isSelected()){
            
            parametro=1;
        }
        
        if(consultaTratamientoVista.jrFeAsignacion.isSelected()){
            
            parametro=2;
        }
        
        if(consultaTratamientoVista.jrFeInicio.isSelected()){
            
            parametro=3;
        }
        if(consultaTratamientoVista.jrFeFinal.isSelected()){
            
            parametro=4;
        }
        if(consultaTratamientoVista.jrDesTratamiento.isSelected()){
            
            parametro=5;
        }
        if(consultaTratamientoVista.jrIdenPaciente.isSelected()){
            
            parametro=6;
        }
        
       LinkedList<Modelo.Tratamiento>tratamientos=tratamientoModelo.getTratamientobyParametro(parametro, valor);
            String registro[]=new String[6];
          
            String []Titulos = {"Codigo","Fecha asignada","Fecha inicio","Fecha final", "Descripcion","Identificacion paciente"};;
            
              tmodelo=new DefaultTableModel();
            tmodelo.setColumnIdentifiers(Titulos);
        for(Modelo.Tratamiento t:tratamientos){
          registro[0]=t.getCodiTratamiento();
          registro[1]=t.getFechaAsigTratamiento();
          registro[2]=t.getFechaIniTratamiento();
          registro[3]=t.getFechaFinTratamiento();
          registro[4]=t.getDescriTratamiento();
          registro[5]=t.getPaIdentificacion();
        tmodelo.addRow(registro);
           }
          consultaTratamientoVista.jtConsTratamiento.setModel(tmodelo);
        
      }
    
}
