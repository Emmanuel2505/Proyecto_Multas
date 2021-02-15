/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * Autores: Eutimio Arévalo, James Romero, Roy León
 */
public class Licencia {
    private long idLicencia;
    private String NroLicencia;
    private float puntos;
    private long idPersona;
    private boolean estadoLicencia;
    private String fechaCaducidad;
    private ArrayList<String> tipos = new ArrayList<>();

    public Licencia() {
    }

    public Licencia(String NroLicencia, float puntos, long idPersona, String fechaCaducidad) {
        this.NroLicencia = NroLicencia;
        this.puntos = puntos;
        this.idPersona = idPersona;
        this.fechaCaducidad = fechaCaducidad;
    }

    public long getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(long idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getNroLicencia() {
        return NroLicencia;
    }

    public void setNroLicencia(String NroLicencia) {
        this.NroLicencia = NroLicencia;
    }

    public float getPuntos() {
        return puntos;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public boolean isEstadoLicencia() {
        return estadoLicencia;
    }

    public void setEstadoLicencia(boolean estadoLicencia) {
        this.estadoLicencia = estadoLicencia;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public ArrayList<String> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<String> tipos) {
        this.tipos = tipos;
    }

    @Override
    public String toString() {
        return (NroLicencia + " " + fechaCaducidad + " " + tipos.toString());
    }
}
