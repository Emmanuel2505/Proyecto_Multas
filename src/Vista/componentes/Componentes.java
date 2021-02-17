/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.componentes;

import Controlador.ListaSimple;
import Controlador.Utilidades;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * Autores: Eutimio Arévalo, James Romero
 */
public class Componentes extends JFrame {

    /**
     * El siguiente método permite cargar el combo box llamando una lista simple mediante un dato perteneciente a la clase de un modelo que se desee buscar
     * @param cbx
     * @param lista
     * @param atributoClase 
     */
    public static void cargarCombo(JComboBox cbx, ListaSimple lista, String atributoClase) {
        cbx.removeAllItems();
        int tamanio = lista.tamanio();
        cbx.addItem("");
        for (int i = 0; i < tamanio; i++) {
                String dato = Utilidades.extraccionDato(lista.obtenerPorPosicion(i), atributoClase);
                cbx.addItem(dato);
        }
    }
    
    /**
     * El siguiente método permite cargar el combo box que se llene automáticamente mediante las coincidencias que tenga el mensaje 
     * @param cbx
     * @param lista
     * @param atributoClase
     * @param mensaje 
     */
    public static void cargarCombo(JComboBox cbx, ListaSimple lista, String atributoClase, String mensaje) {
        cbx.removeAllItems();
        int tamanio = lista.tamanio();
        cbx.addItem(mensaje);
        for (int i = 0; i < tamanio; i++) {
                String dato = Utilidades.extraccionDato(lista.obtenerPorPosicion(i), atributoClase);
                cbx.addItem(dato);
        }
    }
    
    /**
     * El siguiente método permite cargar el combo box con la clase enum de los tipos de vehículo
     * @param cb 
     */
    public static void cargarCombo(JComboBox cb){
        cb.removeAllItems();
        cb.addItem("");
        for (int i = 0; i < Utilidades.tipoVehiculo().length; i++) {
            cb.addItem(Utilidades.tipoVehiculo()[i]);
        }
    }
    
    /**
     * El siguiente método permite cargar el combo box enviando una Lista simple
     * @param cb
     * @param lista 
     */
    public static void cargarCombo(JComboBox cb, ListaSimple lista){
        cb.removeAllItems();
        int tamanio = lista.tamanio();
        cb.addItem("");
        for (int i = 0; i < tamanio; i++) {
                String dato = (String)lista.obtenerPorPosicion(i);
                cb.addItem(dato);
        }
    }
    
    /**
     * El siguiente método permite cargar el combo box para no cargar los datos del agente al hacer una multa
     * @param cbx
     * @param lista
     * @param atributoClase
     * @param dato 
     */
    public static void cargarComboRestriccion(JComboBox cbx, ListaSimple lista, String atributoClase, String dato) {
        cbx.removeAllItems();
        int tamanio = lista.tamanio();
        cbx.addItem("");
        for (int i = 0; i < tamanio; i++) {
                String aux = Utilidades.extraccionDato(lista.obtenerPorPosicion(i), atributoClase);
                if(!aux.equals(dato)){
                    cbx.addItem(aux);
                }
        }
    }
    
    /**
     * El siguiente método permite cargar el combo box  para no cargar los datos del agente al hacer una multa y que se llene automáticamente con las coincidencias del mensaje
     * @param cbx
     * @param lista
     * @param atributoClase
     * @param dato
     * @param mensaje 
     */
    public static void cargarComboRestriccion(JComboBox cbx, ListaSimple lista, String atributoClase, String dato, String mensaje) {
        cbx.removeAllItems();
        int tamanio = lista.tamanio();
        cbx.addItem(mensaje);
        for (int i = 0; i < tamanio; i++) {
                String aux = Utilidades.extraccionDato(lista.obtenerPorPosicion(i), atributoClase);
                if(!aux.equals(dato)){
                    cbx.addItem(aux);
                }
        }
    }
}
