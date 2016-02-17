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
    public static List<String> lineas = new ArrayList<String>();
    public static List<String> blancos = new ArrayList<String>();
    public static List<String> lineasBloqueComentario = new ArrayList<String>();
    public static List<String> bloquesComentario = new ArrayList<String>();

    /**
     *
     * @type Item
     * @param archivo
     */
    public static void abrir( File archivo ) {

        nombre = archivo.getAbsolutePath();
        String linea;

        try {

            BufferedReader lector = new BufferedReader (new FileReader(nombre));
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
    public static void obtenerNumLineasArchivo() {

        Integer numLineasA = lineas.size();

        System.out.println( "Num Lineas Archivo" );
        System.out.println( numLineasA );
    }

    /**
     *
     * @type Item
     */
    public static void obtenerNumLineasBlanco() {

        Integer numLineasB = blancos.size();

        System.out.println( "Num Lineas Blanco" );
        System.out.println( numLineasB );
    }

    /**
     *
     * @type Item
     */
    public static void obtenerNumLineasComentario() {

        Integer numLineas = Comentario.numLineas;

        System.out.println( "Num Lineas Comentario" );
        System.out.println( numLineas );
    }

    /**
     *
     * @type Item
     */
    public static void obtenerNumBloquesComentario() {

        Integer numBloques = Comentario.numBloques;

        System.out.println( "Bloques" );
        System.out.println( numBloques );
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
