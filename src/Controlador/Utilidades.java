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
 * @author ASUS
 */
public class Utilidades {
    public static TipoVehiculo[] tipoVehiculo(){
        return TipoVehiculo.values();
    }
    
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
    
    public static String obtenerStringTipos(ArrayList<String> tipos){
        String texto = "";
        for (int i = 0; i < tipos.size(); i++) {
            texto = texto + tipos.get(i) + " ";
        }
        return texto;
    }

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
    
    public ListaSimple ordenar(ListaSimple lista, String atributo) {
        ListaSimple temp = lista;
        temp = qsortInt(0, temp.tamanio() - 1, temp, atributo);
        return temp;
    }
    
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

    public static Boolean comparar(Object dato1, Object dato2, String atributoClase) {
        String uno = extraccionDato(dato1, atributoClase);
        String dos = extraccionDato(dato2, atributoClase);
        return (dos != null) ? uno.equals(dos.toString()) : false;
    }
    
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
    
    public  static double obtenerTotalMulta(ListaSimple lista){
        double multa = 0.0;
        for (int i = 0; i < lista.tamanio(); i++) {
            Multa m = (Multa)lista.obtenerPorPosicion(i);
            multa = multa + m.getValorMulta();
        }
        return multa;
    }
}
