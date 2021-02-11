/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.ListaSimple;
import Modelo.Multa;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MultaDAO extends AdaptadorDAO{
    private Multa multa;

    public MultaDAO(String direccion) {
        super(new Conexion(direccion), Multa.class);
    }

    public Multa getMulta() {
        if (multa == null)
            multa = new Multa();
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }
    
    public Boolean guardar(){
        try {
            this.getMulta().setIdMulta(Long.parseLong(String.valueOf(listar().tamanio() + 1)));
            this.getMulta().setEstadoMulta(true);
            this.guardar(this.getMulta());
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error al guardar");
            return false;
        }
    }
    
    public Object obtenerPersona(long idPersona){
        Object dato = null;
        for (int i = 0; i < listar().tamanio(); i++) {
            Multa aux = (Multa)listar().obtenerPorPosicion(i);
            if (aux.getIdPersona() == idPersona) {
                dato = aux;
                break;
            }
        }
        return dato;
    }
    
    public void cambiarEstado(long idPersona, String direccion) {
        ListaSimple lista = listar();
        boolean estado;
        for (int i = 0; i < lista.tamanio(); i++) {
            Multa aux = (Multa) lista.obtenerPorPosicion(i);
            if (aux.getIdPersona() == idPersona) {
                if (aux.isEstadoMulta()) {
                    estado = false;
                } else {
                    estado = true;
                }
                aux.setEstadoMulta(estado);
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
    
    public Boolean editar(long idPersona, Object dato, String direccion) {
        ListaSimple lista = listar();
        for (int i = 0; i < lista.tamanio(); i++) {
            Multa aux = (Multa) lista.obtenerPorPosicion(i);
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
