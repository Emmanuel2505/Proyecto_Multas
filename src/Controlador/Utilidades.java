/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Multa;
import Modelo.TipoVehiculo;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * Autor: Roy León
 */
public class Utilidades {
    public static TipoVehiculo[] tipoVehiculo(){
        return TipoVehiculo.values();
    }
    
    /**
     * El método siguiente permite leer el porcentaje de la multa mediante el archivo
     * @return 
     */
    public String leerTxtProcetajeMulta(){
        String dato = "";
        try {
            FileReader ficheroEntrada = new FileReader("Componentes/porcentajeMulta.txt");
            BufferedReader buffer = new BufferedReader(ficheroEntrada);
            String temp = "";
            while (temp != null) {
                temp = buffer.readLine();
                if (temp == null)
                    break;
                dato = dato + "\n" + temp;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return dato;
    }
    
    /**
     * El siguiente método permite obtener una sublista
     * @param lista
     * @param AtributoClase
     * @param palabra
     * @return 
     */
    public static ListaSimple obtenerSubLista(ListaSimple lista, String AtributoClase, String palabra){
        ListaSimple aux = new ListaSimple();
        if (!lista.estaVacia()) {
            for (int i = 0; i < lista.tamanio(); i++) {
                String dato = extraccionDato(lista.obtenerPorPosicion(i), AtributoClase);
                if (dato.startsWith(palabra)) {
                    aux.insertar(lista.obtenerPorPosicion(i));
                }
            }
        }
        return aux;
    }
    
    /**
     * El siguiente método permite obtener la lista completa
     * @param lista
     * @param AtributoClase
     * @param palabra
     * @return 
     */
    public static ListaSimple obtenerLista(ListaSimple lista, String AtributoClase, String palabra){
        ListaSimple aux = new ListaSimple();
        if (!lista.estaVacia()) {
            for (int i = 0; i < lista.tamanio(); i++) {
                String dato = extraccionDato(lista.obtenerPorPosicion(i), AtributoClase);
                if (dato.equalsIgnoreCase(palabra)) {
                    aux.insertar(lista.obtenerPorPosicion(i));
                }
            }
        }
        return aux;
    }
    
    /**
     * El siguiente método permite obtener datos de la lista
     * @param lista
     * @param AtributoClase
     * @param palabra
     * @return 
     */
    public static Object obtenerDato(ListaSimple lista, String AtributoClase, String palabra){
        Object aux = null;
        if (!lista.estaVacia()) {
            for (int i = 0; i < lista.tamanio(); i++) {
                String dato = extraccionDato(lista.obtenerPorPosicion(i), AtributoClase);
                if (dato.equals(palabra)) {
                    aux = lista.obtenerPorPosicion(i);
                    break;
                }
            }
        }
        return aux;
    }
    
    /**
     * El siguiente método permite obtener texto
     * @param tipos
     * @return 
     */
    public static String obtenerStringTipos(ArrayList<String> tipos){
        String texto = "";
        for (int i = 0; i < tipos.size(); i++) {
            texto = texto + tipos.get(i) + " ";
        }
        return texto;
    }
    
    /**
     * El siguiente método permite extraer un dato 
     * @param obj
     * @param atributoClase
     * @return 
     */
    public static String extraccionDato(Object obj, String atributoClase) {
        Class clase = obj.getClass();
        Field atributo = null;
        Object informacion = null;
        for (Field f : clase.getDeclaredFields()) {
            if (f.getName().toString().equalsIgnoreCase(atributoClase)) {
                atributo = f;
            }
        }
        if (atributo != null) {
            //  Method metodo = null;
            for (Method metodoAux : clase.getMethods()) {
                if (metodoAux.getName().startsWith("get")) {
                    if (metodoAux.getName().toLowerCase().endsWith(atributo.getName())) {
                        try {
                            informacion = metodoAux.invoke(obj);
                            break;
                        } catch (Exception e) {
                            System.out.println("Error de metodo " + e);
                        }
                    }
                }
            }
        }
        return (informacion != null) ? informacion.toString() : null;
    }
    
    /**
     * El siguiente método permite ordenar la lista
     * @param lista
     * @param atributo
     * @return 
     */
    public ListaSimple ordenar(ListaSimple lista, String atributo) {
        ListaSimple temp = lista;
        temp = qsortInt(0, temp.tamanio() - 1, temp, atributo);
        return temp;
    }
    
    /**
     * El siguiente método permite ordenar la lista por medio de quicksort
     * @param izq
     * @param der
     * @param lista
     * @param atributo
     * @return 
     */
    public ListaSimple qsortInt(int izq, int der, ListaSimple lista, String atributo){
        int ult, m; 
        Object temp;
        if (izq >= der)
            return lista;
        temp = lista.obtenerPorPosicion(izq);
        m = (izq + der)/2;
        lista.editar(izq, lista.obtenerPorPosicion(m));
        lista.editar(m, temp);
        ult = izq;
        for (int i = izq+1; i <= der; i++) {
            if (Utilidades.comparar(lista.obtenerPorPosicion(i), lista.obtenerPorPosicion(izq), atributo)) {
                temp = lista.obtenerPorPosicion(++ult);
                lista.editar(ult, lista.obtenerPorPosicion(i));
                lista.editar(i, temp);
            }
        }
        temp = lista.obtenerPorPosicion(izq);
        lista.editar(izq, lista.obtenerPorPosicion(ult));
        lista.editar(ult, temp);
        qsortInt(izq, ult-1, lista, atributo);
        qsortInt(ult+1, der, lista, atributo);
        return lista;
    }

    /**
     * El siguiente método permite comparar los tipos de dato
     * @param dato1
     * @param dato2
     * @param atributoClase
     * @return 
     */
    public static Boolean comparar(Object dato1, Object dato2, String atributoClase) {
        String uno = extraccionDato(dato1, atributoClase);
        String dos = extraccionDato(dato2, atributoClase);
        return (dos != null) ? uno.equals(dos.toString()) : false;
    }
    
    /**
     * El siguiente método permite verificar si existe un dato repetido en el archivo
     * @param lista
     * @param atributoClase
     * @param dato
     * @return 
     */
    
    public static Boolean datoRepetido(ListaSimple lista, String atributoClase, String dato){
        Boolean existe = false;
        if (!lista.estaVacia()) {
            for (int i = 0; i < lista.tamanio(); i++) {
                String aux = Utilidades.extraccionDato(lista.obtenerPorPosicion(i), atributoClase);
                if (aux.equalsIgnoreCase(dato)) {
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }
    
    /**
     * El siguiente método permite verificar si existe un dato repetido en la lista
     * @param lista
     * @param dato
     * @return 
     */
    public static Boolean datoRepetido(ListaSimple lista, String dato){
        Boolean existe = false;
        if (!lista.estaVacia()) {
            for (int i = 0; i < lista.tamanio(); i++) {
                String aux = (String)lista.obtenerPorPosicion(i);
                if (aux.equalsIgnoreCase(dato)) {
                    existe = true;
                    break;
                }
            }
        }
        return existe;
    }
    
    /**
     * El siguiente método permite listar las fechas de la lista
     * @param lista
     * @return 
     */
    public static ListaSimple listaFechas(ListaSimple lista){
        ListaSimple ls = new ListaSimple();
        for (int i = 0; i < lista.tamanio(); i++) {
            Multa dato = (Multa)lista.obtenerPorPosicion(i);
            if (!datoRepetido(ls, dato.getFecha())) {
                ls.insertar(dato.getFecha());
            }
        }
        return ls;
    }
    
    /**
     * El siguiente método permite listar las fechas de las multas
     * @param lista
     * @param fecha
     * @return 
     */
    public static ListaSimple listaFechas(ListaSimple lista, String fecha){
        ListaSimple ls = new ListaSimple();
        for (int i = 0; i < lista.tamanio(); i++) {
            Multa dato = (Multa)lista.obtenerPorPosicion(i);
            if (dato.getFecha().equals(fecha)) {
                ls.insertar(dato);
            }
        }
        return ls;
    }
    
    /**
     * El siguiente método permite calcular y describir la multa
     * @param tipoFalta
     * @return 
     */
    public static double montoMulta(String tipoFalta){
        double monto = 0.00;
        double sueldoBasico = 400.00;
        if (tipoFalta.equalsIgnoreCase("Leve de primera clase")) {
            monto = sueldoBasico * 0.05;
        }else if(tipoFalta.equalsIgnoreCase("Leve de segunda clase")){
            monto = sueldoBasico * 0.1;
        }else if (tipoFalta.equalsIgnoreCase("Leve de tercera clase")) {
            monto = sueldoBasico * 0.15;
        }else if(tipoFalta.equalsIgnoreCase("Grave de primera clase")){
            monto = sueldoBasico * 0.3;
        }else if (tipoFalta.equalsIgnoreCase("Grave de segunda clase")) {
            monto = sueldoBasico * 0.4;
        }else if(tipoFalta.equalsIgnoreCase("Grave de tercera clase")){
            monto = sueldoBasico * 0.5;
        }else if (tipoFalta.equalsIgnoreCase("Muy grave")) {
            monto = sueldoBasico;
        }
        return monto;
    }
    
    /**
     * El siguiente método permite quitar los puntos de la licencia
     * @param tipoFalta
     * @return 
     */
    public static double puntosQuitar(String tipoFalta){
        double puntos = 0.00;
        if (tipoFalta.equalsIgnoreCase("Leve de primera clase")) {
            puntos = 1.5;
        }else if(tipoFalta.equalsIgnoreCase("Leve de segunda clase")){
            puntos = 3;
        }else if (tipoFalta.equalsIgnoreCase("Leve de tercera clase")) {
            puntos = 4.5;
        }else if(tipoFalta.equalsIgnoreCase("Grave de primera clase")){
            puntos = 6;
        }else if (tipoFalta.equalsIgnoreCase("Grave de segunda clase")) {
            puntos = 7.5;
        }else if(tipoFalta.equalsIgnoreCase("Grave de tercera clase")){
            puntos = 9;
        }else if (tipoFalta.equalsIgnoreCase("Muy grave")) {
            puntos = 10;
        }
        return puntos;
    }
    
    /**
     * El siguiente método permite obtener la posicion donde se encuentra ubicado un dato de la lista
     * @param lista
     * @param AtributoClase
     * @param palabra
     * @return 
     */
    public static int obtenerPosicionDato(ListaSimple lista, String AtributoClase, String palabra){
        int aux = -1;
        if (!lista.estaVacia()) {
            for (int i = 0; i < lista.tamanio(); i++) {
                String dato = extraccionDato(lista.obtenerPorPosicion(i), AtributoClase);
                if (dato.equals(palabra)) {
                    aux = i;
                    break;
                }
            }
        }
        return aux;
    }
    
    /**
     * El siguiente método permite obtener el total de la multa
     * @param lista
     * @return 
     */
    public  static double obtenerTotalMulta(ListaSimple lista){
        double multa = 0.0;
        for (int i = 0; i < lista.tamanio(); i++) {
            Multa m = (Multa)lista.obtenerPorPosicion(i);
            multa = multa + m.getValorMulta();
        }
        return multa;
    }
}
