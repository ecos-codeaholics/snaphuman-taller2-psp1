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
     * @param valor
     */
    public static void procesar (String valor) {

        boolean esComentario = Pattern.matches(regexComentario, valor);

        if (esComentario) comentario(valor);
    }

    /**
     *
     * @type Item
     *
     */
    public static Bloque comentario (String valor) {

        Bloque comentario = new Bloque();

        comentario.tipo(valor);

        return comentario;
    }

}

