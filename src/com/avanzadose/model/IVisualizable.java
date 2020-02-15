package com.avanzadose.model;

import java.util.Date;

/**
 *
 * < h1>IVisualizable</h1>
 * Interfaz IVisualizable
 *
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 15 de febrero del 2020
 */
public interface IVisualizable {

    /**
     * *
     * Este metodo captura el tiempo exacto de inicio de visualizacion
     *
     * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto
     * @return Devuelve la fecha y hora capturada.
     */
    Date startToSee(Date dateI);

    /**
     * *
     * Este metodo captura el tiempo exacto de inicio y final de visualizacion
     *
     * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto
     * @param dateF Es un objeto {@code Date} con el tiempo de final exacto
     */
    void stopToSee(Date dateI, Date dateF);
}
