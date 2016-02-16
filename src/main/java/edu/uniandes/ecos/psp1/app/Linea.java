package edu.uniandes.ecos.psp1.app;

import java.util.regex.Pattern;

/**
 *
 * @type Part
 * @author snaphuman
 * @version 1.0 02/14/2016
 * @license GNU/GPL v3
 */
public class Linea {

    static String regexComentario = "(^.*)\\*{1,2}|(^.*)\\*(.*)$|(^.*)//(.*)$";

    /**
     *
     * @type Item
     * @param linea
     */
    public static void procesar (String linea) {

        boolean esComentario = Pattern.matches(regexComentario, linea);

        if (esComentario) Comentario.construirBloque(linea);
    }
}

