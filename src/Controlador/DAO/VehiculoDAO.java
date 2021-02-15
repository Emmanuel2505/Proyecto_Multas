/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.ListaSimple;
import Modelo.Persona;
import Modelo.Vehiculo;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * Autor: Roy León
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
    
    /**
     * El siguiente método permite verificar que se ah guardado correctamente el vehículo
     * @param idPersona
     * @return 
     */
    public Boolean guardar(long idPersona){
        try {
            this.getVehiculo().setIdVehiculo(Long.parseLong(String.valueOf(listar().tamanio() + 1)));
            this.getVehiculo().setIdPersona(idPersona);
            this.getVehiculo().setEstadoVehiculo(true);
            this.guardar(this.getVehiculo());
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error al guardar");
            return false;
        }
    }
    
    /**
     * El siguiente método permite obtener el identirficador de la persona
     * @param idPersona
     * @return 
     */
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
    
    /**
     * El siguiente método permite obtener el identificador del vehículo
     * @param idVehiculo
     * @return 
     */
    public Object obtenerVehiculo(long idVehiculo){
        Object dato = null;
        for (int i = 0; i < listar().tamanio(); i++) {
            Vehiculo aux = (Vehiculo)listar().obtenerPorPosicion(i);
            if (aux.getIdVehiculo()== idVehiculo) {
                dato = aux;
                break;
            }
        }
        return dato;
    }
    
    /**
     * El siguiente método permite obtener la lista de personas por medio del identificador
     * @param idPersona
     * @return 
     */
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
    
    /**
     * El siguiente método permite obtener la lista de personas por medio del estado
     * @param estado
     * @return 
     */
    public ListaSimple obtenerListaPersona(boolean estado) {
        ListaSimple lista = new ListaSimple();
        for (int i = 0; i < listar().tamanio(); i++) {
            Vehiculo aux = (Vehiculo) listar().obtenerPorPosicion(i);
            if (aux.isEstadoVehiculo()== estado) {
                lista.insertar(aux);
            }
        }
        return lista;
    }
    
    /**
     * El siguiente método permite obtener la lista de personas por medio del identificador y el estado
     * @param idPersona
     * @param estado
     * @return 
     */
    public ListaSimple obtenerListaPersona(long idPersona, boolean estado) {
        ListaSimple lista = new ListaSimple();
        for (int i = 0; i < listar().tamanio(); i++) {
            Vehiculo aux = (Vehiculo) listar().obtenerPorPosicion(i);
            if (aux.getIdPersona()== idPersona && aux.isEstadoVehiculo() == estado) {
                lista.insertar(aux);
            }
        }
        return lista;
    }
    
    /**
     * El siguiente método permite cambiar el estado del vehículo
     * @param idVehiculo
     * @param direccion 
     */
    public void cambiarEstado(long idVehiculo, String direccion) {
        ListaSimple lista = listar();
        boolean estado;
        for (int i = 0; i < lista.tamanio(); i++) {
            Vehiculo aux = (Vehiculo) listar().obtenerPorPosicion(i);
            if (aux.getIdVehiculo()== idVehiculo) {
                if (aux.isEstadoVehiculo()) {
                    estado = false;
                } else {
                    estado = true;
                }
                aux.setEstadoVehiculo(estado);
                lista.editar(i, aux);
                break;
            }
        }
        try {
            this.modificar(lista);
            System.out.println("cambios");
        } catch (Exception e) {
            System.out.println("no se pudo modificar");
        }
    }
    
    /**
     * El siguiente método permite editar los datos del vehículo
     * @param idVehiculo
     * @param dato
     * @return 
     */
    public Boolean editar(long idVehiculo, Object dato) {
        ListaSimple lista = listar();
        for (int i = 0; i < lista.tamanio(); i++) {
            Vehiculo aux = (Vehiculo) lista.obtenerPorPosicion(i);
            if (aux.getIdVehiculo()== idVehiculo) {
                lista.editar(i, dato);
                break;
            }
        }
        try {
            this.modificar(lista);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * El siguiente método permite obtener la placa del vehículo
     * @param placa
     * @return 
     */
    public Object obtenerVehiculo(String placa){
        Object dato = null;
        for (int i = 0; i < listar().tamanio(); i++) {
            Vehiculo aux = (Vehiculo)listar().obtenerPorPosicion(i);
            if (aux.getPlaca().equals(placa)) {
                dato = aux;
                break;
            }
        }
        return dato;
    }
}
