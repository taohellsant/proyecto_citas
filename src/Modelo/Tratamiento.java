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
public class Tratamiento {
    
    private String CodiTratamiento;
    private String FechaAsigTratamiento;
    private String FechaIniTratamiento;
    private String FechaFinTratamiento;
    private String DescriTratamiento;
    private String PaIdentificacion;

    public Tratamiento(String CodiTratamiento, String FechaAsigTratamiento, String FechaIniTratamiento, String FechaFinTratamiento, String DescriTratamiento, String PaIdentificacion) {
        this.CodiTratamiento = CodiTratamiento;
        this.FechaAsigTratamiento = FechaAsigTratamiento;
        this.FechaIniTratamiento = FechaIniTratamiento;
        this.FechaFinTratamiento = FechaFinTratamiento;
        this.DescriTratamiento = DescriTratamiento;
        this.PaIdentificacion = PaIdentificacion;
    }

    public Tratamiento() {
    }

    public String getCodiTratamiento() {
        return CodiTratamiento;
    }

    public void setCodiTratamiento(String CodiTratamiento) {
        this.CodiTratamiento = CodiTratamiento;
    }

    public String getFechaAsigTratamiento() {
        return FechaAsigTratamiento;
    }

    public void setFechaAsigTratamiento(String FechaAsigTratamiento) {
        this.FechaAsigTratamiento = FechaAsigTratamiento;
    }

    public String getFechaIniTratamiento() {
        return FechaIniTratamiento;
    }

    public void setFechaIniTratamiento(String FechaIniTratamiento) {
        this.FechaIniTratamiento = FechaIniTratamiento;
    }

    public String getFechaFinTratamiento() {
        return FechaFinTratamiento;
    }

    public void setFechaFinTratamiento(String FechaFinTratamiento) {
        this.FechaFinTratamiento = FechaFinTratamiento;
    }

    public String getDescriTratamiento() {
        return DescriTratamiento;
    }

    public void setDescriTratamiento(String DescriTratamiento) {
        this.DescriTratamiento = DescriTratamiento;
    }

    public String getPaIdentificacion() {
        return PaIdentificacion;
    }

    public void setPaIdentificacion(String PaIdentificacion) {
        this.PaIdentificacion = PaIdentificacion;
    }
    
    
    
}
