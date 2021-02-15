/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.ListaSimple;
import Modelo.Licencia;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * Autor: Roy León
 */
public class LicenciaDAO extends AdaptadorDAO{
    private Licencia licencia;

    public LicenciaDAO(String direccion) {
        super(new Conexion(direccion), Licencia.class);
    }

    public Licencia getLicencia() {
        if(licencia == null)
            licencia = new Licencia();
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }
    
    /**
     * El siguiente método permite verificar que se ah guardado correctamente la licencia
     * @return 
     */
    public Boolean guardar(){
        try {
            this.getLicencia().setIdLicencia(Long.parseLong(String.valueOf(listar().tamanio() + 1)));
            this.getLicencia().setEstadoLicencia(true);
            this.guardar(this.getLicencia());
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error al guardar");
            return false;
        }
    }
    
    /**
     * El siguiente método permite obtener el identificador de la persona
     * @param idPersona
     * @return 
     */
    public Object obtenerPersona(long idPersona){
        Object dato = null;
        for (int i = 0; i < listar().tamanio(); i++) {
            Licencia aux = (Licencia)listar().obtenerPorPosicion(i);
            if (aux.getIdPersona() == idPersona) {
                dato = aux;
                break;
            }
        }
        return dato;
    }
    
    /**
     * El siguiente método permite editar los datos de ka persona
     * @param idPersona
     * @param dato
     * @return 
     */
    public Boolean editar(long idPersona, Object dato) {
        ListaSimple lista = listar();
        for (int i = 0; i < lista.tamanio(); i++) {
            Licencia aux = (Licencia) lista.obtenerPorPosicion(i);
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
