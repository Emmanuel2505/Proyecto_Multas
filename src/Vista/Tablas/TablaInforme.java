/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Tablas;

import Controlador.DAO.LicenciaDAO;
import Controlador.DAO.PersonaDAO;
import Controlador.DAO.VehiculoDAO;
import Controlador.ListaSimple;
import Controlador.Utilidades;
import Modelo.Licencia;
import Modelo.Multa;
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
 * @author ASUS
 */
public class TablaInforme extends AbstractTableModel{
    private ListaSimple listaMultas = new ListaSimple();
    private LicenciaDAO listaLicencia;
    private PersonaDAO personas;
    private VehiculoDAO vehiculos;

    public ListaSimple getListaMultas() {
        return listaMultas;
    }

    public void setListaMultas(ListaSimple listaMultas) {
        this.listaMultas = listaMultas;
    }

    public LicenciaDAO getListaLicencia() {
        return listaLicencia;
    }

    public void setListaLicencia(LicenciaDAO listaLicencia) {
        this.listaLicencia = listaLicencia;
    }

    public PersonaDAO getPersonas() {
        return personas;
    }

    public void setPersonas(PersonaDAO personas) {
        this.personas = personas;
    }

    public VehiculoDAO getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(VehiculoDAO vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public int getColumnCount() {
        return 16;
    }

    @Override
    public int getRowCount() {
        return listaMultas.tamanio();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Multa multa = (Multa)listaMultas.obtenerPorPosicion(rowIndex);
        Licencia licencia = (Licencia)listaLicencia.obtenerPersona(multa.getIdPersona());
        Persona persona = (Persona)personas.obtenerPersona(multa.getIdPersona());
        Persona agente = (Persona)personas.obtenerPersona(multa.getIdAgente());
        Vehiculo vehiculo = (Vehiculo)vehiculos.obtenerVehiculo(multa.getIdVehiculo());
        switch (columnIndex) {
            case 0: return persona.getCedula();
            case 1: return persona.getNombre();
            case 2: return persona.getApellido();
            case 3: return persona.getDireccion();
            case 4: return persona.getTelefono();
            case 5: return licencia.getNroLicencia();
            case 6: return Utilidades.obtenerStringTipos(licencia.getTipos());
            case 7: return vehiculo.getPlaca();
            case 8: return vehiculo.getModelo();
            case 9: return vehiculo.getColor();
            case 10: return agente.getNombre();
            case 11: return agente.getApellido();
            case 12: return multa.getTipoMulta();
            case 13: return multa.getValorMulta();
            case 14: return multa.getFecha();
            case 15: return multa.getObservaciones();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Cédula";
            case 1: return "Nombre";
            case 2: return "Apellido";
            case 3: return "Dirección";
            case 4: return "Teléfono";
            case 5: return "Nro Licencia";
            case 6: return "Tipos Licencia";
            case 7: return "Placa";
            case 8: return "Modelo";
            case 9: return "Color";
            case 10: return "Nombre Agente";
            case 11: return "Apellido Agente";
            case 12: return "Rubro";
            case 13: return "Monto Multa"; 
            case 14: return "Fecha Multa";
            case 15: return "Observaciones";
            default: return null;
        }
    }

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
