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
public class GestorCitasControl implements ActionListener{
    
     Modelo.GestorCitas citasModelo;
    Vista.ConsCitasInternalFrame consultaCitasVista;
    public GestorCitasControl(Vista.ConsCitasInternalFrame consultaCitasVista ){
        
        this.consultaCitasVista = consultaCitasVista;
        citasModelo= new Modelo.GestorCitas();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DefaultTableModel tmodelo;
        String valor=consultaCitasVista.txtValorCita.getText();
        int parametro=0;
        
        if(consultaCitasVista.jrNumeCita.isSelected()){
            
            parametro=1;
        }
        if(consultaCitasVista.jrHoraCita.isSelected()){
            
            parametro=2;
        }
        if(consultaCitasVista.jrObserCitas.isSelected()){
            
            parametro=3;
        }
        if(consultaCitasVista.jrEstaCitas.isSelected()){
            
            parametro=4;
        }
        if(consultaCitasVista.jrIdenMedico.isSelected()){
            
            parametro=5;
        }
        if(consultaCitasVista.jrCodiConsultorio.isSelected()){
            
            parametro=6;
        }
        if(consultaCitasVista.jrIdenPaciente.isSelected()){
            
            parametro=7;
        }
        
       LinkedList<Modelo.Citas>citas=citasModelo.getCitasbyParametro(parametro, valor);
            String registro[]=new String[8];
          
            String []Titulos = {"Numero cita","Fecha","Hora","Observaciones", "Estado", "Identificacion medico", "Codigo consultorio", "Identificacion paciente"};;
            
              tmodelo=new DefaultTableModel();
            tmodelo.setColumnIdentifiers(Titulos);
        for(Modelo.Citas c:citas){
          registro[0]=c.getNumeCita();
          registro[1]=c.getFechaCita();
          registro[2]=c.getHoraCita();
          registro[3]=c.getObserCita();
          registro[4]=c.getEstadoCita();
          registro[5]=c.getMeIdentificacion();
          registro[6]=c.getCodigoConsulCita();
          registro[7]=c.getPaIdentificacion();
          tmodelo.addRow(registro);
           }
          consultaCitasVista.jtCitas.setModel(tmodelo);
        
      }
    
}
