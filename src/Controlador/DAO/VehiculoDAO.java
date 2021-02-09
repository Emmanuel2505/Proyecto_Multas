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
    
    public ListaSimple obtenerListaPersona(long idPersona, boolean estado) {
        ListaSimple lista = new ListaSimple();
        for (int i = 0; i < listar().tamanio(); i++) {
            Vehiculo aux = (Vehiculo) listar().obtenerPorPosicion(i);
            if (aux.getIdPersona()== idPersona && aux.isEstadoVehiculo() == estado) {
                System.out.println("hola");
                lista.insertar(aux);
            }
        }
        return lista;
    }
    
    public void cambiarEstado(long idVehiculo, String direccion) {
        ListaSimple lista = listar();
        boolean estado;
        for (int i = 0; i < listar().tamanio(); i++) {
            Vehiculo aux = (Vehiculo) listar().obtenerPorPosicion(i);
            if (aux.getIdVehiculo()== idVehiculo) {
                if (aux.isEstadoVehiculo()) {
                    estado = false;
                } else {
                    estado = true;
                }
                aux.setEstadoVehiculo(estado);
                lista.editar(i, aux);
            }
        }
        File fichero = new File(direccion);
        try {
            PrintWriter pw = new PrintWriter(fichero);
            pw.print("");
            pw.close();
        } catch (Exception e) {
        }
        for (int i = lista.tamanio() - 1; i >= 0; i--) {
            try {
                Vehiculo aux = (Vehiculo) lista.obtenerPorPosicion(i);
                this.guardar(aux);
            } catch (Exception e) {
                System.out.println("no se guardo");
            }
        }
    }
    
    public Boolean editar(long idPersona, Object dato, String direccion) {
        try {
            ListaSimple lista = listar();
            boolean estado;
            for (int i = 0; i < listar().tamanio(); i++) {
                Vehiculo aux = (Vehiculo) listar().obtenerPorPosicion(i);
                if (aux.getIdPersona() == idPersona) {
                    lista.editar(i, dato);
                }
            }
            File fichero = new File(direccion);
            try {
                PrintWriter pw = new PrintWriter(fichero);
                pw.print("");
                pw.close();
            } catch (Exception e) {
            }
            for (int i = lista.tamanio() - 1; i >= 0; i--) {
                try {
                    Vehiculo aux = (Vehiculo) lista.obtenerPorPosicion(i);
                    this.guardar(aux);
                } catch (Exception e) {
                    System.out.println("no se guardo");
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
