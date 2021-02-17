/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * Autor: Roy León
 */
public class ListaSimple {
    public Nodo cabecera;

    public ListaSimple() {
        this.cabecera = null;
    }
    
    public boolean estaVacia(){
        return (this.cabecera == null);
    }
    
    /**
     * Con el presente método se obtiene el tamaño de la lista
     * @return 
     */
    public int tamanio(){
        int tamanio = 0;
        if (!estaVacia()) {
            Nodo temp = cabecera;
            while (temp != null) {
                tamanio++;
                temp = temp.getSiguiente();
            }
        }
        return tamanio;
    }
    
    /**
     * Mediante el siguiente método permite insertar los datos dentro de la lista
     * @param dato 
     */
    public void insertar(Object dato){
        if (dato == null)
            new NullPointerException("Se debe ingresar un Objeto");
        Nodo temp = new Nodo(dato, null);
        temp.setSiguiente(cabecera);
        cabecera = temp;
    }
    
    /**
     * El método se utiliza para obtener la posición del dato en la lista
     * @param posicion
     * @return 
     */
    public Object obtenerPorPosicion(int posicion){
        Object dato = null;
        if (!estaVacia()) {
            Nodo temp = cabecera;
            for (int i = 0; i < posicion; i++) {
                temp = temp.getSiguiente();
                if (temp == null)
                    break;
            }
            if (temp != null)
                dato = temp.getDato();
        }
        return dato;
    }
    
    /**
     * Con el siguiente método permite presentar los datos de la lista
     */
    public void mostrarDatos(){
        if (!estaVacia()) {
            Nodo temp = cabecera;
            while (temp != null) {
                System.out.println(temp.getDato().toString());
                temp = temp.getSiguiente();
            }
        }
    }
    
    /**
     * Por el siguiente método permite editar los datos que se encuentran dentro de la lista
     * @param posicion
     * @param dato 
     */
    public void editar(int posicion, Object dato) {
        if (posicion >= 0 && posicion < tamanio()) {
            if (posicion == 0) {
                cabecera.setDato(dato);
            } else {
                Nodo aux = cabecera;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                aux.setDato(dato);
            }
        }
    }
}
