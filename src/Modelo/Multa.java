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
    private long idMulta;
    private double valorMulta;
    private String fecha;
    private double totalPuntos;
    private String tipoMulta;
    private long idAgente;
    private long idPersona;
    private boolean estadoMulta;
    private String observaciones;
    private long idVehiculo;

    public Multa() {
    }

    public Multa(double valorMulta, String fecha, double totalPuntos, String tipoMulta, long idAgente, long idPersona) {
        this.valorMulta = valorMulta;
        this.fecha = fecha;
        this.totalPuntos = totalPuntos;
        this.tipoMulta = tipoMulta;
        this.idAgente = idAgente;
        this.idPersona = idPersona;
        this.idVehiculo = -1;
    }

    public Multa(double valorMulta, String fecha, double totalPuntos, String tipoMulta, String agente, long idPersona, String observaciones, long idVehiculo) {
        this.valorMulta = valorMulta;
        this.fecha = fecha;
        this.totalPuntos = totalPuntos;
        this.tipoMulta = tipoMulta;
        this.idAgente = idAgente;
        this.idPersona = idPersona;
        this.observaciones = observaciones;
        this.idVehiculo = idVehiculo;
    }

    public long getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(long idMulta) {
        this.idMulta = idMulta;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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

    public long getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(long idAgente) {
        this.idAgente = idAgente;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public boolean isEstadoMulta() {
        return estadoMulta;
    }

    public void setEstadoMulta(boolean estadoMulta) {
        this.estadoMulta = estadoMulta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
}
