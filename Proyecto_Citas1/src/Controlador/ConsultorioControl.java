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
public class ConsultorioControl implements ActionListener {
    
    Vista.RegConsulInternalFrame consultorioVista;
    Modelo.Consultorio consultorioModelo;
    Modelo.GestorConsultorio gestorConsultorioModelo;
    
    
    public ConsultorioControl(Vista.RegConsulInternalFrame consultorioVista){
        
        this.consultorioVista=consultorioVista;
        gestorConsultorioModelo= new Modelo.GestorConsultorio();
    }
@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(consultorioVista.btnRegiConsultorio)){
         String CodiConsultorio=consultorioVista.txtCodiConsultorio.getText();
         String NombConsultorio=consultorioVista.txtNomConsultorio.getText();

        consultorioModelo=new Modelo.Consultorio(CodiConsultorio, NombConsultorio);

        gestorConsultorioModelo.RegistrarConsultorio(consultorioModelo);

        }

        if(e.getSource().equals(consultorioVista.btnNueConsultorio)){
          consultorioVista.txtCodiConsultorio.setText("");
          consultorioVista.txtNomConsultorio.setText("");
          consultorioVista.txtCodiConsultorio.requestFocus();
             }
        }
    
}
