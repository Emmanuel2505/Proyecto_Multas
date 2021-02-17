/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import Controlador.DAO.LicenciaDAO;
import Controlador.ListaSimple;
import Controlador.Utilidades;
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
public class TablaPersona extends AbstractTableModel{
    private ListaSimple listaPersona = new ListaSimple();
    private LicenciaDAO listaLicencia;

    public ListaSimple getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(ListaSimple listaPersona) {
        this.listaPersona = listaPersona;
    }

    public LicenciaDAO getListaLicencia() {
        return listaLicencia;
    }

    public void setListaLicencia(LicenciaDAO listaLicencia) {
        this.listaLicencia = listaLicencia;
    }

    /**
     * El siguiete método permite obtener las columnas de la tabla
     * @return 
     */
    @Override
    public int getColumnCount() {
        return 9;
    }

    /**
     * El siguiete método permite obtener las celdas de la tabla
     * @return 
     */
    @Override
    public int getRowCount() {
        return listaPersona.tamanio();
    }
    
    /**
     * El siguiete método permite obtener el contenido de la tabla
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona persona = (Persona)listaPersona.obtenerPorPosicion(rowIndex);
        Licencia licencia = (Licencia)listaLicencia.obtenerPersona(persona.getIdPersona());
        if (licencia == null) {
            licencia = new Licencia("", 0, -1, "");
        }
        switch (columnIndex) {
            case 0: return persona.getCedula();
            case 1: return persona.getNombre();
            case 2: return persona.getApellido();
            case 3: return persona.getDireccion();
            case 4: return persona.getTelefono();
            case 5: return licencia.getNroLicencia();
            case 6: return licencia.getPuntos();
            case 7: return licencia.getFechaCaducidad();
            case 8: return Utilidades.obtenerStringTipos(licencia.getTipos());
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
            case 5: return "Nro Licencia";
            case 6: return "Puntos";
            case 7: return "Fecha Caducidad";
            case 8: return "Tipos de Licencia";
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
