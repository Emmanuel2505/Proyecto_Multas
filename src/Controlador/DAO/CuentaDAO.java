/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Modelo.Cuenta;

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
            this.guardar(this.getCuenta());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar cuenta " + e);
            return false;
        }
    }
}
