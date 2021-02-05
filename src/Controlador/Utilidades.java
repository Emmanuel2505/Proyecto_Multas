/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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

    public String leerTxtProcetajeMulta() {
        String dato = "";
        try {
            FileReader ficheroEntrada = new FileReader("Componentes/porcentajeMulta.txt");
            BufferedReader buffer = new BufferedReader(ficheroEntrada);
            String temp = "";
            while (temp != null) {
                temp = buffer.readLine();
                if (temp == null) {
                    break;
                }
                dato = dato + "\n" + temp;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return dato;
    }

    public static int compareTo(Object o, Object o1, String atributoClase) {
        int i = 0;
        if (o instanceof Integer && o1 instanceof Integer) {
            Integer uno = (Integer) o;
            Integer dos = (Integer) o1;
            if (uno > dos) {
                i = 1;
            } else if (uno < dos) {
                i = -1;
            }

        } else {
            String uno = extraccionDato(o, atributoClase);
            String dos = extraccionDato(o1, atributoClase);
            if (uno != null && dos != null) {
                if (uno.toUpperCase().compareTo(dos.toUpperCase()) > 0) {
                    i = 1;
                } else {
                    i = -1;
                }
            }
        }
        return i;
    }

    public static ListaSimple obtenerSubLista(ListaSimple lista, String AtributoClase, String palabra) {
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

    public static ListaSimple obtenerLista(ListaSimple lista, String AtributoClase, String palabra) {
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

    public static Object obtenerDato(ListaSimple lista, String AtributoClase, String palabra) {
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

    public static Boolean comparar(String uno, Object obj, String atributoClase) {
        String dos = extraccionDato(obj, atributoClase);
        return (dos != null) ? uno.equals(dos.toString()) : false;
    }

    public static int comparareTo(String uno, Object obj, String atributoClase) {
        String dos = extraccionDato(obj, atributoClase);
        System.out.println("COMPARAR DATOS " + uno + "   " + dos);
        return (dos != null) ? uno.compareTo(dos.toString()) : -1;
    }

    public Boolean compararRigido(String uno, String dos) {
        return uno.equals(dos);
    }

    public static String obtenerStringTipos(ArrayList<String> tipos) {
        String texto = "";
        for (int i = 0; i < tipos.size(); i++) {
            texto = texto + tipos.get(i) + " ";
        }
        return texto;
    }

    public static Boolean datoRepetido(ListaSimple lista, String atributoClase, String dato) {
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

    public static double montoMulta(String tipoFalta) {
        double monto = 0.00;
        double sueldoBasico = 400.00;
        if (tipoFalta.equalsIgnoreCase("Leve de primera clase")) {
            monto = sueldoBasico * 0.05;
        } else if (tipoFalta.equalsIgnoreCase("Leve de segunda clase")) {
            monto = sueldoBasico * 0.1;
        } else if (tipoFalta.equalsIgnoreCase("Leve de tercera clase")) {
            monto = sueldoBasico * 0.15;
        } else if (tipoFalta.equalsIgnoreCase("Grave de primera clase")) {
            monto = sueldoBasico * 0.3;
        } else if (tipoFalta.equalsIgnoreCase("Grave de segunda clase")) {
            monto = sueldoBasico * 0.4;
        } else if (tipoFalta.equalsIgnoreCase("Grave de tercera clase")) {
            monto = sueldoBasico * 0.5;
        } else if (tipoFalta.equalsIgnoreCase("Muy grave")) {
            monto = sueldoBasico;
        }
        return monto;
    }

    public static double puntosQuitar(String tipoFalta) {
        double puntos = 0.00;
        if (tipoFalta.equalsIgnoreCase("Leve de primera clase")) {
            puntos = 1.5;
        } else if (tipoFalta.equalsIgnoreCase("Leve de segunda clase")) {
            puntos = 3;
        } else if (tipoFalta.equalsIgnoreCase("Leve de tercera clase")) {
            puntos = 4.5;
        } else if (tipoFalta.equalsIgnoreCase("Grave de primera clase")) {
            puntos = 6;
        } else if (tipoFalta.equalsIgnoreCase("Grave de segunda clase")) {
            puntos = 7.5;
        } else if (tipoFalta.equalsIgnoreCase("Grave de tercera clase")) {
            puntos = 9;
        } else if (tipoFalta.equalsIgnoreCase("Muy grave")) {
            puntos = 10;
        }
        return puntos;
    }
}
