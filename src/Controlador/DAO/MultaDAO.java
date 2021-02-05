/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Modelo.Multa;
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
}
