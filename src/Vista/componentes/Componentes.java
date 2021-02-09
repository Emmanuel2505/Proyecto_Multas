/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.componentes;

import Controlador.DAO.MarcaDAO;
import Controlador.DAO.NormativaDAO;
import Controlador.DAO.TipoLicenciaDAO;
import Controlador.ListaSimple;
import Controlador.Utilidades;
import Modelo.Normativa;
import Modelo.Marca;
import Modelo.TipoLicencia;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 *
 * @author timoa
 */
public class Componentes extends JFrame {

    //JButton consultar, biblioteca, registrarM, registrarA, generarI;
    
    public static void cargarCombo(JComboBox cbx, ListaSimple lista, String atributoClase) {
        cbx.removeAllItems();
        int tamanio = lista.tamanio();
        cbx.addItem("");
        for (int i = 0; i < tamanio; i++) {
                String dato = Utilidades.extraccionDato(lista.obtenerPorPosicion(i), atributoClase);
                cbx.addItem(dato);
        }
    }
    
    
    public static void cargarCombo(JComboBox cbx, ListaSimple lista, String atributoClase, String mensaje) {
        cbx.removeAllItems();
        int tamanio = lista.tamanio();
        cbx.addItem(mensaje);
        for (int i = 0; i < tamanio; i++) {
                String dato = Utilidades.extraccionDato(lista.obtenerPorPosicion(i), atributoClase);
                cbx.addItem(dato);
        }
    }
    
    public static void cargarCombo(JComboBox cb){
        cb.removeAllItems();
        cb.addItem("");
        for (int i = 0; i < Utilidades.tipoVehiculo().length; i++) {
            cb.addItem(Utilidades.tipoVehiculo()[i]);
        }
    }
    
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
