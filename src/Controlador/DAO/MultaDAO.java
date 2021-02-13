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
    
    public ListaSimple obtenerPersona(long idPersona){
        ListaSimple lista = new ListaSimple();
        for (int i = 0; i < listar().tamanio(); i++) {
            Multa aux = (Multa)listar().obtenerPorPosicion(i);
            if (aux.getIdPersona() == idPersona && aux.isEstadoMulta()) {
                lista.insertar(aux);
            }
        }
        return lista;
    }
    
    public void cambiarEstado(long idMulta) {
        ListaSimple lista = listar();
        boolean estado;
        for (int i = 0; i < lista.tamanio(); i++) {
            Multa aux = (Multa) lista.obtenerPorPosicion(i);
            if (aux.getIdMulta()== idMulta) {
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
        try {
            ListaSimple lista = listar();
            boolean estado;
            for (int i = 0; i < listar().tamanio(); i++) {
                Multa aux = (Multa) listar().obtenerPorPosicion(i);
                if (aux.getIdPersona() == idPersona) {
                    lista.editar(i, dato);
                    break;
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
                    Multa aux = (Multa) lista.obtenerPorPosicion(i);
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
