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
public class Consultorio {
    
    private String CodiConsultorio;
    private String NombConsultorio;

    public Consultorio(String CodiConsultorio, String NombConsultorio) {
        this.CodiConsultorio = CodiConsultorio;
        this.NombConsultorio = NombConsultorio;
    }

    public Consultorio() {
    }

    public String getCodiConsultorio() {
        return CodiConsultorio;
    }

    public void setCodiConsultorio(String CodiConsultorio) {
        this.CodiConsultorio = CodiConsultorio;
    }

    public String getNombConsultorio() {
        return NombConsultorio;
    }

    public void setNombConsultorio(String NombConsultorio) {
        this.NombConsultorio = NombConsultorio;
    }
    
    
    
}
