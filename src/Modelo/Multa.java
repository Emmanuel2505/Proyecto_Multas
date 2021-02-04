/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Multa {
    private double valorMulta;
    private Date fecha;
    private double totalPuntos;
    private String tipoMulta;
    private String agente;
    private String nombrePersona;

    public Multa(double valorMulta, Date fecha, double totalPuntos, String tipoMulta, String agente, String nombrePersona) {
        this.valorMulta = valorMulta;
        this.fecha = fecha;
        this.totalPuntos = totalPuntos;
        this.tipoMulta = tipoMulta;
        this.agente = agente;
        this.nombrePersona = nombrePersona;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(double totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    public String getTipoMulta() {
        return tipoMulta;
    }

    public void setTipoMulta(String tipoMulta) {
        this.tipoMulta = tipoMulta;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }
}
