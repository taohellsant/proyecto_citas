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
public class CitasControl implements ActionListener{
    
    Vista.RegCitasInternalFrame citasVista;
    Modelo.Citas citasModelo;
    
    Modelo.GestorCitas gestorCitasModelo;
    
    
    public CitasControl(Vista.RegCitasInternalFrame citasVista){
        
        this.citasVista=citasVista;
        gestorCitasModelo= new Modelo.GestorCitas();
    }
@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(citasVista.btnRegisCita)){
         String Numero_Citas=citasVista.txtNumCitas.getText();
         SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
         String fecha_citas=formato.format(citasVista.jdtFechaCita.getDate());
         String Hora_Citas=citasVista.txtHoraCita.getText();
         String Observaciones=citasVista.txtObserCita.getText();
         String Estado_Cita=citasVista.txtEstaCita.getText();
         String Iden_Medico=citasVista.txtIdenMedico.getText();
         String Codigo_Consultorio=citasVista.txtNumeConsultorio.getText();
         String Iden_Paciente=citasVista.txtIdenPaciente.getText();
          
           
        citasModelo=new Modelo.Citas(Numero_Citas, fecha_citas, Hora_Citas, Observaciones, Estado_Cita, Iden_Medico, Codigo_Consultorio, Iden_Paciente);

        gestorCitasModelo.RegistrarCitas(citasModelo);

        }

        if(e.getSource().equals(citasVista.btnNuevaCita)){
          citasVista.txtNumCitas.setText("");
          citasVista.jdtFechaCita.setDate(null);
          citasVista.txtHoraCita.setText("");
          citasVista.txtObserCita.setText("");
          citasVista.txtEstaCita.setText("");
          citasVista.txtIdenMedico.setText("");
          citasVista.txtNumeConsultorio.setText("");
          citasVista.txtIdenPaciente.setText("");
          
             }
        }
    
}
