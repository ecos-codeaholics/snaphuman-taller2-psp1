package edu.uniandes.ecos.psp1.app;

import java.util.regex.Pattern;

/**
 *
 * @type Part
 * @author snaphuman
 * @version 1.0 02/14/2016
 * @license GNU/GPL v3
 */
public class Comentario {

    static Integer numLineas;
    static Integer numBloques;
    static Integer numBloquesItem;
    static String tipo;

    /**
     *
     * @type Item
     * @param linea
     */
    public static Integer contarLineas ( String linea ) {

        Archivo.lineasBloqueComentario.add( linea );

        numLineas = Archivo
                .lineasBloqueComentario.size();

        return numLineas;
    }

    /**
     *
     * @type Item
     * @param linea
     * @return
     */
    public static Integer contarBloques ( String linea ) {
        String regex = "^(.*)/\\*{1,2}";

        boolean esInicio = Pattern.matches( regex, linea );

        if ( esInicio ) {

            Archivo.bloquesComentario.add( linea );
        }

        numBloques = Archivo.bloquesComentario.size();

        return numBloques;
    }

    /**
     *
     * @type Item
     * @param linea
     * @return
     */
    public static String obtenerTipo ( String linea ) {

        String regex = "(^.*)(\\*\\p{Space}@\\btype\\b)(.*)$";
        String reemplazo = "(\\p{Space}\\*\\p{Space}@\\btype\\b)(\\p{Space}\\bItem\\b)";
        boolean tieneTipo = Pattern.matches( regex, linea );

        if ( tieneTipo ) {

            tipo = linea.replaceAll(reemplazo, "").trim();
            Archivo.bloquesItem.add( tipo );

        }

        numBloquesItem = Archivo.bloquesItem.size();

        return tipo;
    }
}
