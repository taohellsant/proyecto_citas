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
public class GestorMedicoControl implements ActionListener{
    
     Modelo.GestorMedico medicoModelo;
     Vista.ConsMedicoInternalFrame consultaMedicoVista;
    
    public GestorMedicoControl(Vista.ConsMedicoInternalFrame consultaMedicoVista ){
        
        this.consultaMedicoVista = consultaMedicoVista;
        medicoModelo= new Modelo.GestorMedico();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DefaultTableModel tMemodelo;
        String valor=consultaMedicoVista.txtMeValor.getText();
        int parametro=0;
        
        if(consultaMedicoVista.jrMeIdentificacion.isSelected()){
            
            parametro=1;
        }
        
        if(consultaMedicoVista.jrMeNombre.isSelected()){
            
            parametro=2;
        }
        
        if(consultaMedicoVista.jrMeApellido.isSelected()){
            
            parametro=3;
        }

       LinkedList<Modelo.Medico>medicos= medicoModelo.getMedicobyParametro(parametro, valor);
            String registroMe[]=new String[3];
          
            String []Titulos = {"Identificacion","Nombres","Apelllidos"};
            
              tMemodelo=new DefaultTableModel();
            tMemodelo.setColumnIdentifiers(Titulos);
        for(Modelo.Medico m:medicos){
          registroMe[0]=m.getMeIdentificacion();
          registroMe[1]=m.getMeNombre();
          registroMe[2]=m.getMeApellido();
          tMemodelo.addRow(registroMe);
           }
          consultaMedicoVista.jtMedicos.setModel(tMemodelo);
        
      }
    
}
