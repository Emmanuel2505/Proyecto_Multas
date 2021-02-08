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
 * @author ASUS
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
    
    public void cambiarEstado(long idPersona, String direccion) {
        ListaSimple lista = listar();
        boolean estado;
        for (int i = 0; i < listar().tamanio(); i++) {
            Licencia aux = (Licencia) listar().obtenerPorPosicion(i);
            if (aux.getIdPersona()== idPersona) {
                if (aux.isEstadoLicencia()) {
                    estado = false;
                } else {
                    estado = true;
                }
                aux.setEstadoLicencia(estado);
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
                Licencia aux = (Licencia) lista.obtenerPorPosicion(i);
                this.guardar(aux);
            } catch (Exception e) {
                System.out.println("no se guardo");
            }
        }
    }
}
