package edu.uniandes.ecos.psp1.app;

import java.io.File;

/**
 * Created by snaphuman on 2/14/16.
 */

public class Archivo {

    static String nombre;

    public static void abrir( File archivo ) {

        nombre = archivo.getAbsolutePath();
        System.out.println(nombre);

    }
}
