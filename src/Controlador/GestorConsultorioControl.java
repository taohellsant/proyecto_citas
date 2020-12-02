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
public class GestorConsultorioControl implements ActionListener{
    
     Modelo.GestorConsultorio consultorioModelo;
    Vista.ConsConsulInternalFrame consultaConsultorioVista;
    
    public GestorConsultorioControl(Vista.ConsConsulInternalFrame consultaConsultorioVista ){
        
        this.consultaConsultorioVista = consultaConsultorioVista;
        consultorioModelo = new Modelo.GestorConsultorio();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DefaultTableModel tmodelo;
        String valor=consultaConsultorioVista.txtConValor.getText();
        int parametro=0;
        
        if(consultaConsultorioVista.jrCodiConsulta.isSelected()){
            
            parametro=1;
        }
        
        if(consultaConsultorioVista.jrNomConsulta.isSelected()){
            
            parametro=2;
        }

       LinkedList<Modelo.Consultorio>consultorios=consultorioModelo.getConsultoriobyParametro(parametro, valor);
            String registro[]=new String[2];
          
            String []Titulos = {"Codigo","Nombre"};;
            
              tmodelo=new DefaultTableModel();
            tmodelo.setColumnIdentifiers(Titulos);
        for(Modelo.Consultorio co:consultorios){
          registro[0]=co.getCodiConsultorio();
          registro[1]=co.getNombConsultorio();
          tmodelo.addRow(registro);
           }
          consultaConsultorioVista.jtConsultorio.setModel(tmodelo);
      }
    
}
