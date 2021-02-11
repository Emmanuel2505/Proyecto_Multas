/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.ListaSimple;
import Modelo.Cuenta;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author ASUS
 */
public class CuentaDAO extends AdaptadorDAO{
    private Cuenta cuenta;
    
    public CuentaDAO(String direccion){
        super(new Conexion(direccion), Cuenta.class);
    }

    public Cuenta getCuenta() {
        if (cuenta == null) 
            cuenta = new Cuenta();
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    public Boolean guardar() {
        try {
            this.getCuenta().setIdCuenta(Long.parseLong(String.valueOf(listar().tamanio() + 1)));
            this.getCuenta().setEstadoCuenta(true);
            this.guardar(this.getCuenta());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar cuenta " + e);
            return false;
        }
    }
    public Object obtenerPersona(long idPersona){
        Object dato = null;
        for (int i = 0; i < listar().tamanio(); i++) {
            Cuenta aux = (Cuenta)listar().obtenerPorPosicion(i);
            if (aux.getIdPersona() == idPersona) {
                dato = aux;
                break;
            }
        }
        return dato;
    }
    
    public Boolean editar(long idPersona, Object dato) {
        ListaSimple lista = listar();
        boolean estado;
        for (int i = 0; i < lista.tamanio(); i++) {
            Cuenta aux = (Cuenta) lista.obtenerPorPosicion(i);
            if (aux.getIdPersona() == idPersona) {
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
}
