/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.ListaSimple;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * Autor: Roy León
 */
public class AdaptadorDAO implements InterfazDAO{
    private  Conexion conexion;
    private Class clazz;

    public AdaptadorDAO(Conexion conexion, Class clazz) {
        this.conexion = conexion;
        this.clazz = clazz;
    }
    
    /**
     * El siguiente método permite listar los datos del archivo
     * @return 
     */
    @Override
    public ListaSimple listar() {
        ListaSimple lista = new ListaSimple();
        try {
            lista = (ListaSimple) conexion.getXtrStream().fromXML(new FileReader(conexion.getDireccion()+ File.separatorChar + clazz.getSimpleName() + ".json"));

        } catch (Exception e) {
            System.out.println("No se pudo listar " + e);
            e.printStackTrace();
        }
        return lista;
    }

    /**
     * El siguiente método permite guardar los datos del archivo
     * @param o
     * @throws Exception 
     */
    @Override
    public void guardar(Object o) throws Exception {
        ListaSimple lista = listar();
        lista.insertar(o);
        conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getDireccion()+ File.separatorChar + clazz.getSimpleName() + ".json"));
    }

    /**
     * El siguiente método permite modificar los datos del archivo
     * @param lista
     * @throws Exception 
     */
    @Override
    public void modificar(ListaSimple lista) throws Exception {
          conexion.getXtrStream().toXML(lista, new FileOutputStream(conexion.getDireccion()+ File.separatorChar + clazz.getSimpleName() + ".json"));
//        File fichero = new File(direccion);
//         try {
//             PrintWriter pw = new PrintWriter(fichero);
//             pw.print("");
//             pw.close();
//         } catch (Exception e) {
//         }
//            for (int i = 0; i < lista.tamanio(); i++) {
//                try {
//                    this.guardar(lista.obtenerPorPosicion(i));
//                } catch (Exception e) {
//                    System.out.println("no se modificar");
//                }
//            }
    }
}
