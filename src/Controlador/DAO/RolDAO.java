/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.ListaSimple;
import Modelo.Persona;
import Modelo.Rol;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class RolDAO extends AdaptadorDAO{
    private Rol rol;
    
    public RolDAO(String direccion){
        super(new Conexion(direccion), Rol.class);
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public Boolean guardar() {
        try {
            this.guardar(this.getRol());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar rol " + e);
            return false;
        }
    }

    public void crearRoles() {
        if (listar().tamanio()== 0) {
            Rol admin = new Rol(1,"Administrador","Tiene acceso a todo el programa");
            setRol(admin);
            guardar();
            setRol(null);
            Rol agen = new Rol(2,"Agente","Tiene acceso solo a consultar multa como ingresarla");
            setRol(agen);
            guardar();
            setRol(null);
            Rol part = new Rol(3,"Particular","Solo tiene acceso a consultar multa");
            setRol(part);
            guardar();
            setRol(null);
        }
    }    
}

