/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import Controlador.DAO.CuentaDAO;
import Controlador.DAO.LicenciaDAO;
import Controlador.DAO.PersonaDAO;
import Controlador.ListaSimple;
import Controlador.Utilidades;
import Modelo.Cuenta;
import Modelo.Licencia;
import Modelo.Persona;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * Autores: Eutimio Arévalo, James Romero
 */
public class TablaLicencia extends AbstractTableModel{
    private ListaSimple listaLicencia = new ListaSimple();
    private PersonaDAO listaPersona;

    public ListaSimple getListaLicencia() {
        return listaLicencia;
    }

    public void setListaLicencia(ListaSimple listaLicencia) {
        this.listaLicencia = listaLicencia;
    }

    public PersonaDAO getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(PersonaDAO listaPersona) {
        this.listaPersona = listaPersona;
    }

    /**
     * El siguiete método permite obtener las columnas de la tabla
     * @return 
     */
    @Override
    public int getColumnCount() {
        return 11;
    }

    /**
     * El siguiete método permite obtener las celdas de la tabla
     * @return 
     */
    @Override
    public int getRowCount() {
        return listaLicencia.tamanio();
    }

    /**
     * El siguiete método permite obtener el contenido de la tabla
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Licencia licencia = (Licencia)listaLicencia.obtenerPorPosicion(rowIndex);
        Persona persona = (Persona)listaPersona.obtenerPersona(licencia.getIdPersona());
        switch (columnIndex) {
            case 0: return persona.getCedula();
            case 1: return persona.getNombre();
            case 2: return persona.getApellido();
            case 3: return persona.getDireccion();
            case 4: return persona.getTelefono();
            case 5: return (persona.isEstadoPersona() == true) ? "HABILTADO" : "DESHABILITADO";
            case 6: return licencia.getNroLicencia();
            case 7: return licencia.getPuntos();
            case 8: return licencia.getFechaCaducidad();
            case 9: return Utilidades.obtenerStringTipos(licencia.getTipos());
            case 10: return (licencia.isEstadoLicencia() == true) ? "HABILTADO" : "DESHABILITADO";
            default: return null;
        }
    }

    /**
     * El siguiete método permite nombrar las columnas de la tabla
     * @param column
     * @return 
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Cédula";
            case 1: return "Nombre";
            case 2: return "Apellido";
            case 3: return "Dirección";
            case 4: return "Teléfono";
            case 5: return "Estado Persona";
            case 6: return "Nro Licencia";
            case 7: return "Puntos";
            case 8: return "Fecha Caducidad";
            case 9: return "Tipos de Licencia";
            case 10: return "Estado Licencia";
            default: return null;
        }
    }

    /**
     * El siguiete método permite ajustar la tabla al contenido que tiene cada celda
     * @param tabla 
     */
    public void ajustarTabla(JTable tabla){
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            DefaultTableColumnModel colModelo = (DefaultTableColumnModel) tabla.getColumnModel();
            TableColumn col = colModelo.getColumn(i);
            int ancho = 0;
            
            TableCellRenderer renderizador = col.getHeaderRenderer();
            for (int j = 0; j < tabla.getRowCount(); j++) {
                renderizador = tabla.getCellRenderer(j, i);
                Component comp = renderizador.getTableCellRendererComponent(tabla, tabla.getValueAt(j, i), false, false, j, i);
                ancho = Math.max(ancho, comp.getPreferredSize().width);
            }
            col.setPreferredWidth(ancho + 2);
        }
    }
}
