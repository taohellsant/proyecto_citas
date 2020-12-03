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
public class Citas {
    
    private String NumeCita;
    private String FechaCita;
    private String HoraCita;
    private String ObserCita;
    private String EstadoCita;
    private String MeIdentificacion;
    
    private String CodigoConsulCita;
    private String PaIdentificacion;

    public Citas(String NumeCita, String FechaCita, String HoraCita, String ObserCita, String EstadoCita, String MeIdentificacion, String CodigoConsulCita, String PaIdentificacion) {
        this.NumeCita = NumeCita;
        this.FechaCita = FechaCita;
        this.HoraCita = HoraCita;
        this.ObserCita = ObserCita;
        this.EstadoCita = EstadoCita;
        this.MeIdentificacion = MeIdentificacion;
        this.CodigoConsulCita = CodigoConsulCita;
        this.PaIdentificacion = PaIdentificacion;
    }

    public Citas() {
    }

    public String getNumeCita() {
        return NumeCita;
    }

    public void setNumeCita(String NumeCita) {
        this.NumeCita = NumeCita;
    }

    public String getFechaCita() {
        return FechaCita;
    }

    public void setFechaCita(String FechaCita) {
        this.FechaCita = FechaCita;
    }

    public String getHoraCita() {
        return HoraCita;
    }

    public void setHoraCita(String HoraCita) {
        this.HoraCita = HoraCita;
    }

    public String getObserCita() {
        return ObserCita;
    }

    public void setObserCita(String ObserCita) {
        this.ObserCita = ObserCita;
    }

    public String getEstadoCita() {
        return EstadoCita;
    }

    public void setEstadoCita(String EstadoCita) {
        this.EstadoCita = EstadoCita;
    }

    public String getMeIdentificacion() {
        return MeIdentificacion;
    }

    public void setMeIdentificacion(String MeIdentificacion) {
        this.MeIdentificacion = MeIdentificacion;
    }

    public String getCodigoConsulCita() {
        return CodigoConsulCita;
    }

    public void setCodigoConsulCita(String CodigoConsulCita) {
        this.CodigoConsulCita = CodigoConsulCita;
    }

    public String getPaIdentificacion() {
        return PaIdentificacion;
    }

    public void setPaIdentificacion(String PaIdentificacion) {
        this.PaIdentificacion = PaIdentificacion;
    }
    
    
    
    
    
}
