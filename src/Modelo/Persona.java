/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * Autores: Eutimio Arévalo, James Romero, Roy León
 */
public class Persona {
    private long idPersona;
    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private boolean estadoPersona;
    private int idRol;

    public Persona() {
    }

    public Persona(String Cedula, String nombre, String apellido, String direccion, String telefono, int idRol) {
        this.cedula = Cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idRol = idRol;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String Cedula) {
        this.cedula = Cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstadoPersona() {
        return estadoPersona;
    }

    public void setEstadoPersona(boolean estadoPersona) {
        this.estadoPersona = estadoPersona;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString() {
        return (cedula + " " + nombre + " " + apellido + " " + direccion + " " + telefono + " " + idRol);
    }  
}
