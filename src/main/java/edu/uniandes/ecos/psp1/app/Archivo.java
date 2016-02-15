package edu.uniandes.ecos.psp1.app;

import java.io.File;

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

    }
}
