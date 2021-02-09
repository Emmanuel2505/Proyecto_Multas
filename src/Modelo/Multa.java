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
    private Date fecha;
    private double totalPuntos;
    private String tipoMulta;
    private String agente;
    private long idPersona;
    private boolean estadoMulta;
    private String placa;

    public Multa() {
    }

    public Multa(double valorMulta, Date fecha, double totalPuntos, String tipoMulta, String agente, long idPersona) {
        this.valorMulta = valorMulta;
        this.fecha = fecha;
        this.totalPuntos = totalPuntos;
        this.tipoMulta = tipoMulta;
        this.agente = agente;
        this.idPersona = idPersona;
        this.placa = "Multa Peatonal";
    }

    public Multa(double valorMulta, Date fecha, double totalPuntos, String tipoMulta, String agente, long idPersona, String placa) {
        this.valorMulta = valorMulta;
        this.fecha = fecha;
        this.totalPuntos = totalPuntos;
        this.tipoMulta = tipoMulta;
        this.agente = agente;
        this.idPersona = idPersona;
        this.placa = placa;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
