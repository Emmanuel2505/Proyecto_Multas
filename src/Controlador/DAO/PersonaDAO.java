/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.ListaSimple;
import Modelo.Persona;
import java.io.File;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 *
 * @author ASUS
 */
public class PersonaDAO extends AdaptadorDAO {

    private Persona persona;

    public PersonaDAO(String direccion) {
        super(new Conexion(direccion), Persona.class);
    }

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Boolean guardar() {
        try {
            this.getPersona().setIdPersona(Long.parseLong(String.valueOf(listar().tamanio() + 1)));
            this.getPersona().setEstadoPersona(true);
            this.guardar(this.getPersona());
            return true;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error al guardar");
            return false;
        }
    }

    public Object obtenerPersona(long idPersona) {
        Object dato = null;
        for (int i = 0; i < listar().tamanio(); i++) {
            Persona aux = (Persona) listar().obtenerPorPosicion(i);
            if (aux.getIdPersona() == idPersona) {
                dato = aux;
                break;
            }
        }
        return dato;
    }

    public Object obtenerPersona(String cedula) {
        Object dato = null;
        for (int i = 0; i < listar().tamanio(); i++) {
            Persona aux = (Persona) listar().obtenerPorPosicion(i);
            if (aux.getCedula().equals(cedula)) {
                dato = aux;
                break;
            }
        }
        return dato;
    }

    public ListaSimple obtenerListaPersona(long idRol) {
        ListaSimple lista = new ListaSimple();
        for (int i = 0; i < listar().tamanio(); i++) {
            Persona aux = (Persona) listar().obtenerPorPosicion(i);
            if (aux.getIdRol() == idRol) {
                lista.insertar(aux);
            }
        }
        return lista;
    }

    public ListaSimple obtenerListaPersona(long idRol, boolean estado) {
        ListaSimple lista = new ListaSimple();
        for (int i = 0; i < listar().tamanio(); i++) {
            Persona aux = (Persona) listar().obtenerPorPosicion(i);
            if (aux.getIdRol() == idRol && aux.isEstadoPersona() == estado) {
                lista.insertar(aux);
            }
        }
        return lista;
    }

    public ListaSimple obtenerListaPersona() {
        ListaSimple lista = new ListaSimple();
        for (int i = 0; i < listar().tamanio(); i++) {
            Persona aux = (Persona) listar().obtenerPorPosicion(i);
            if (aux.isEstadoPersona()) {
                lista.insertar(aux);
            }
        }
        return lista;
    }

    public void cambiarEstado(long idPersona) {
        ListaSimple lista = listar();
        boolean estado;
        for (int i = 0; i < lista.tamanio(); i++) {
            Persona aux = (Persona) lista.obtenerPorPosicion(i);
            if (aux.getIdPersona() == idPersona) {
                if (aux.isEstadoPersona()) {
                    estado = false;
                } else {
                    estado = true;
                }
                aux.setEstadoPersona(estado);
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

    public Boolean editar(long idPersona, Object dato) {
        ListaSimple lista = listar();
        for (int i = 0; i < lista.tamanio(); i++) {
            Persona aux = (Persona) lista.obtenerPorPosicion(i);
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
