package edu.uniandes.ecos.psp1.app;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * Contador de Lineas de Código: programa que cuenta
 * las lineas físicas de código (LOC)a partir de la deducción
 * de las líneas en blanco y líneas de los comentarios. Cuenta
 * las partes del programa (clases) y los items (métodos).
 *
 * @author snaphuman
 * @version 1.0 02/14/2016
 * @license GNU/GPL v3
 * @type Part
 */
public class ContadorLOC {

    /**
     *
     * @type Item
     * @param args
     */
    public static void main( String[] args ) {

        String msg;
        String ruta;
        Scanner entrada;

        msg = "Bienvenido al contador LOC \n";
        System.out.println( msg );

        // Proceso de entrada de datos
        entrada = new Scanner( System.in );

        msg = "Ingrese la ruta absoluta donde se almacenan los archivos que \n";
        msg += "serán analizados: \n";
        msg += "> \n";
        System.out.println( msg );

        ruta = entrada.next();

        listaArchivos( ruta );
    }

    /**
     *
     * @type Item
     * @param ruta
     * @return
     */
    public static File[] listaArchivos( String ruta ) {

        File directorio = new File( ruta );

        // @see http://www.tutorialspoint.com/java/io/file_listfiles_filename_filter.htm
        FilenameFilter filtro = new FilenameFilter() {

            /**
             *
             * @type Item
             * @param ruta
             * @param name
             * @return
             */
            public boolean accept( File ruta, String name ) {
                if ( name.lastIndexOf( "." ) > 0 ) {
                    int lastIndex = name.lastIndexOf( "." );

                    String ext = name.substring( lastIndex );

                    if (ext.equals( ".java" ) ) {

                        return true;
                    }
                }

                return false;
            }

        };

        File[] archivos = directorio.listFiles( filtro );

        String msg = "\n";

        for ( File archivo : archivos ) {


            Archivo.lineas.clear();
            Archivo.blancos.clear();
            Archivo.abrir(archivo);
            Archivo.bloquesItem.clear();
            Archivo.reiniciarConteoComentario();

            msg += "\n";
            msg += "El archivo " + Archivo.nombre + " tiene " + Archivo.obtenerNumBloquesComentario() + " ";
            msg += "bloques de comentario y un total de " + Archivo.obtenerNumLineasComentario() + " líneas ";
            msg += "de cometario, incluyendo los comentarios de línea. Los bloques de comentario \n";
            msg += "identifican el tipo de bloque que lo precede (Item o Parte), por lo tanto, este archivo ";
            msg += "contiene " + Archivo.obtenerNumBloquesItem() + " métodos o items. \n";
            msg += "El conteo total de lineas en blanco es de " + Archivo.obtenerNumLineasBlanco() + " para un ";
            msg += "total de " + Archivo.obtenerNumLineasArchivo() + " Lineas de Código Físico (LOC). \n";
            msg += "\n";

        }

        msg += "El total de arcivos (Partes analizados): " + archivos.length;
        System.out.println(msg);

        return archivos;
    }
}
