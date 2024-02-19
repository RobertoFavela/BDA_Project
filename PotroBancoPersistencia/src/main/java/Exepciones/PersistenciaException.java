/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exepciones;

/**
 * Excepción personalizada para manejar errores relacionados con la persistencia de datos.
 * 
 * @author favel
 * @version 1.0
 */
public class PersistenciaException extends Exception {
    /**
     * Crea una nueva instancia de PersistenciaException sin mensaje de detalle.
     */
    public PersistenciaException() {
    }

    /**
     * Crea una nueva instancia de PersistenciaException con un mensaje de detalle.
     *
     * @param message El mensaje que describe el error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de PersistenciaException con un mensaje de detalle y una causa subyacente.
     *
     * @param message El mensaje que describe el error.
     * @param cause La causa subyacente del error.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Crea una nueva instancia de PersistenciaException con una causa subyacente.
     *
     * @param cause La causa subyacente del error.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Crea una nueva instancia de PersistenciaException con un mensaje de detalle, una causa subyacente,
     * la capacidad de suprimir o no la capacidad de generar una traza y la capacidad de ser o no modificable.
     *
     * @param message El mensaje que describe el error.
     * @param cause La causa subyacente del error.
     * @param enableSuppression Un indicador booleano que indica si la supresión está activada o no.
     * @param writableStackTrace Un indicador booleano que indica si la traza debe ser generada o no.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

