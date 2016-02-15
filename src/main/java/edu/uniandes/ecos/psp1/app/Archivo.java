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

    /**
     *
     * @type Item
     * @param archivo
     */
    public static void abrir( File archivo ) {

        nombre = archivo.getAbsolutePath();
        String linea;
        List<String> lineas = new ArrayList<String>();

        try {
            BufferedReader lector = new BufferedReader (new FileReader(nombre));

            while ( ( linea = lector.readLine() ) != null ) {
                lineas.add(linea);
                Linea.procesar(linea);
            }
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }
}
