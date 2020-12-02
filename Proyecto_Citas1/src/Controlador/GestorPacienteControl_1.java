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
public class GestorPacienteControl implements ActionListener{
    
     Modelo.GestorPaciente pacientesModelo;
    Vista.ConsPacienteInternalFrame consultaPacienteVista;
    public GestorPacienteControl(Vista.ConsPacienteInternalFrame consultaPacienteVista ){
        
        this.consultaPacienteVista = consultaPacienteVista;
        pacientesModelo= new Modelo.GestorPaciente();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DefaultTableModel tmodelo;
        String valor=consultaPacienteVista.txtValor.getText();
        int parametro=0;
        
        if(consultaPacienteVista.jrIdentificacion.isSelected()){
            
            parametro=1;
        }
        
        if(consultaPacienteVista.jrNombre.isSelected()){
            
            parametro=2;
        }
        
        if(consultaPacienteVista.jrApellido.isSelected()){
            
            parametro=3;
        }
        if(consultaPacienteVista.jrSexo.isSelected()){
            
            parametro=4;
        }
        
       LinkedList<Modelo.Paciente>pacientes=pacientesModelo.getPacientebyParametro(parametro, valor);
            String registro[]=new String[5];
          
            String []Titulos = {"Identificacion","Nombres","Apelllidos","Fecha Nacimiento", "Genero"};;
            
              tmodelo=new DefaultTableModel();
            tmodelo.setColumnIdentifiers(Titulos);
        for(Modelo.Paciente p:pacientes){
          registro[0]=p.getIdentificacion();
          registro[1]=p.getNombre();
          registro[2]=p.getApellido();
          registro[3]=p.getFechaNacimiento();
          registro[4]=p.getGenero();
        tmodelo.addRow(registro);
           }
          consultaPacienteVista.tblDatos.setModel(tmodelo);
        
      }
    
}
