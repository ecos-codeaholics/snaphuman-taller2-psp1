package edu.uniandes.ecos.psp1.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @type Part
 * @author snaphuman
 * @version 1.0 02/14/2016
 * @license GNU/GPL v3
 */
public class Archivo {

    static String nombre;
    static String path;
    public static List<String> lineas = new ArrayList<String>();
    public static List<String> blancos = new ArrayList<String>();
    public static List<String> lineasBloqueComentario = new ArrayList<String>();
    public static List<String> bloquesComentario = new ArrayList<String>();
    public static List<String> bloquesItem = new ArrayList<String>();

    /**
     *
     * @type Item
     * @param archivo
     */
    public static void abrir( File archivo ) {

        path = archivo.getAbsolutePath();
        nombre = archivo.getName();
        String linea;

        try {

            BufferedReader lector = new BufferedReader (new FileReader(path));
            while ( ( linea = lector.readLine() ) != null ) {

                Linea.procesar(linea);
            }
        } catch ( FileNotFoundException e ) {

            e.printStackTrace();
        } catch ( IOException e ) {

            e.printStackTrace();
        }
    }

    /**
     *
     * @type Item
     */
    public static Integer obtenerNumLineasArchivo() {

        Integer numLineasA = lineas.size();

        return numLineasA;
    }

    /**
     *
     * @type Item
     */
    public static Integer obtenerNumLineasBlanco() {

        Integer numLineasB = blancos.size();

        return numLineasB;
    }

    /**
     *
     * @type Item
     */
    public static Integer obtenerNumLineasComentario() {

        Integer numLineas = Comentario.numLineas;

        return numLineas;
    }

    /**
     *
     * @type Item
     */
    public static Integer obtenerNumBloquesComentario() {

        Integer numBloques = Comentario.numBloques;

        return numBloques;
    }

    /**
     *
     * @type Item
     */
    public static Integer obtenerNumBloquesItem() {

        Integer numItems = Comentario.numBloquesItem;

        return numItems;
    }

    /**
     *
     * @type Item
     */
    public static void reiniciarConteoComentario () {

        lineasBloqueComentario.clear();
        bloquesComentario.clear();
    }
}
