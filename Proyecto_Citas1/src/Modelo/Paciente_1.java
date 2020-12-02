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
public class Paciente {
   
    private String Identificacion;
    private String Nombres;
    private String Apellidos;
    private String fechaNacimiento;
    private String Genero;

    public Paciente(String Identificacion, String Nombres, String Apellidos, String fechaNacimiento, String Genero) {
        this.Identificacion = Identificacion;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.Genero = Genero;
    }

    public Paciente() {
    }
    
 
    public String getNombre() {
        return Nombres;
    }
    
    public void setNombre(String nombre) {
        this.Nombres = nombre;
    }
  
    public String getApellido() {
        return Apellidos;
    }
  
    public void setApellido(String Apellido) {
        this.Apellidos = Apellido;
    }
    public String getIdentificacion() {
        return Identificacion;
    }
  
    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
    
}
