/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import Controlador.DAO.LicenciaDAO;
import Controlador.DAO.PersonaDAO;
import Controlador.ListaSimple;
import Modelo.Licencia;
import Modelo.Multa;
import Modelo.Persona;
import java.awt.Component;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * Autores: Eutimio Arévalo, James Romero
 */
public class TablaMultas extends AbstractTableModel{
    private ListaSimple listaMultas = new ListaSimple();
    private LicenciaDAO listaLicencia;
    private PersonaDAO personas;    

    public void setListaMultas(ListaSimple listaMultas) {
        this.listaMultas = listaMultas;
    }

    public void setListaLicencia(LicenciaDAO listaLicencia) {
        this.listaLicencia = listaLicencia;
    }

    public void setPersonas(PersonaDAO personas) {
        this.personas = personas;
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
        return listaMultas.tamanio();
    }

    /**
     * El siguiete método permite obtener el contenido de la tabla
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Multa multa = (Multa)listaMultas.obtenerPorPosicion(rowIndex);
        Licencia licencia = (Licencia)listaLicencia.obtenerPersona(multa.getIdPersona());
        Persona persona = (Persona)personas.obtenerPersona(multa.getIdPersona());
        Persona agente = (Persona)personas.obtenerPersona(multa.getIdAgente());
        switch (columnIndex) {
            case 0: return multa.getTipoMulta();
            case 1: return multa.getValorMulta();
            case 2: return agente.getNombre();
            case 3: return agente.getApellido();
            case 4: return multa.getObservaciones();
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
            case 0: return "Rubro";
            case 1: return "Monto Multa";
            case 2: return "Nombre Agente";
            case 3: return "Apellido Agente";
            case 4: return "Observaciones";
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
