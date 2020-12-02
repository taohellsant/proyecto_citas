/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author maria
 */
public class Medico {
    
    private String MeIdentificacion;
    private String MeNombre;
    private String MeApellido;

    public Medico(String MeIdentificacion, String MeNombre, String MeApellido) {
        this.MeIdentificacion = MeIdentificacion;
        this.MeNombre = MeNombre;
        this.MeApellido = MeApellido;
    }

    public Medico() {
    }

    public String getMeIdentificacion() {
        return MeIdentificacion;
    }

    public void setMeIdentificacion(String MeIdentificacion) {
        this.MeIdentificacion = MeIdentificacion;
    }

    public String getMeNombre() {
        return MeNombre;
    }

    public void setMeNombre(String MeNombre) {
        this.MeNombre = MeNombre;
    }

    public String getMeApellido() {
        return MeApellido;
    }

    public void setMeApellido(String MeApellido) {
        this.MeApellido = MeApellido;
    }
    
    
    
            
}
