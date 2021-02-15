/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.ListaSimple;

/**
 *
 * Autor: Roy León
 */
public interface InterfazDAO {
    public void guardar(Object o)throws Exception;
    public void modificar(ListaSimple lista)throws Exception;
    public ListaSimple listar();
}
