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
public class Normativa {
    private String rubro;
    private String descripcion;
    private String tipoFalta;

    public Normativa() {
    }

    public Normativa(String rubro, String descripcion, String tipoFalta) {
        this.rubro = rubro;
        this.descripcion = descripcion;
        this.tipoFalta = tipoFalta;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoFalta() {
        return tipoFalta;
    }

    public void setTipoFalta(String tipoFalta) {
        this.tipoFalta = tipoFalta;
    }
}
