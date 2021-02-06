/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.ListaSimple;
import Modelo.Vehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class VehiculoDAO extends AdaptadorDAO{
    private Vehiculo vehiculo;

    public VehiculoDAO(String direccion) {
        super(new Conexion(direccion), Vehiculo.class);
    }

    public Vehiculo getVehiculo() {
        if(vehiculo == null)
            vehiculo = new Vehiculo();
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public Boolean guardar(String NombreArchivo){
        try {
            this.guardar(this.getVehiculo());
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error al guardar");
            return false;
        }
    }
    
    public Object obtenerPersona(long idPersona){
        Object dato = null;
        for (int i = 0; i < listar().tamanio(); i++) {
            Vehiculo aux = (Vehiculo)listar().obtenerPorPosicion(i);
            if (aux.getIdPersona() == idPersona) {
                dato = aux;
                break;
            }
        }
        return dato;
    }
    
    public ListaSimple obtenerListaPersona(long idPersona){
        ListaSimple lista = new ListaSimple();
        for (int i = 0; i < listar().tamanio(); i++) {
            Vehiculo aux = (Vehiculo)listar().obtenerPorPosicion(i);
            if (aux.getIdPersona() == idPersona) {
                lista.insertar(aux);
            }
        }
        return lista;
    }
}
