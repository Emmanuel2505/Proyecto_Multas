/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import Controlador.DAO.PersonaDAO;
import Controlador.DAO.VehiculoDAO;
import Controlador.ListaSimple;
import Controlador.Utilidades;
import Modelo.Persona;
import Modelo.Vehiculo;
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
public class TablaVehiculos extends AbstractTableModel{
    private ListaSimple listaVehiculos = new ListaSimple();
    private PersonaDAO listaPersona;

    public ListaSimple getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ListaSimple listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
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
        return 5;
    }

    /**
     * El siguiete método permite obtener las celdas de la tabla
     * @return 
     */
    @Override
    public int getRowCount() {
        return listaVehiculos.tamanio();
    }

    /**
     * El siguiete método permite obtener el contenido de la tabla
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehiculo vehiculo = (Vehiculo)listaVehiculos.obtenerPorPosicion(rowIndex);
        Persona persona = (Persona)listaPersona.obtenerPersona(vehiculo.getIdPersona());
        switch (columnIndex) {
            case 0: return persona.getCedula();
            case 1: return persona.getNombre();
            case 2: return vehiculo.getPlaca();
            case 3: return vehiculo.getModelo();
            case 4: return vehiculo.getColor();
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
            case 0: return "Cedula Propietario";
            case 1: return "Nombre Propietario";
            case 2: return "Placa";
            case 3: return "Modelo";
            case 4: return "Color";
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
