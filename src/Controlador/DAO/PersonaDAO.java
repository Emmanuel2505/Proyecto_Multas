/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.ListaSimple;
import Modelo.Persona;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class PersonaDAO extends AdaptadorDAO{
    private Persona persona;

    public PersonaDAO(String direccion) {
        super(new Conexion(direccion), Persona.class);
    }

    public Persona getPersona() {
        if(persona == null)
            persona = new Persona();
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Boolean guardar(){
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
    
    public Object obtenerPersona(long idPersona){
        Object dato = null;
        for (int i = 0; i < listar().tamanio(); i++) {
            Persona aux = (Persona)listar().obtenerPorPosicion(i);
            if (aux.getIdPersona()== idPersona) {
                dato = aux;
                break;
            }
        }
        return dato;
    }
    
    public Object obtenerPersona(String cedula){
        Object dato = null;
        for (int i = 0; i < listar().tamanio(); i++) {
            Persona aux = (Persona)listar().obtenerPorPosicion(i);
            if (aux.getCedula().equals(cedula)) {
                dato = aux;
                break;
            }
        }
        return dato;
    }
    
    public ListaSimple obtenerListaPersona(long idRol){
        ListaSimple lista = new ListaSimple();
        for (int i = 0; i < listar().tamanio(); i++) {
            Persona aux = (Persona)listar().obtenerPorPosicion(i);
            if (aux.getIdRol()== idRol) {
                lista.insertar(aux);
            }
        }
        return lista;
    }
}
