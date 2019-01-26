/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.error;

/**
 *
 * @author Lenovo
 */
public class AkunException extends Exception {

    /**
     * Creates a new instance of <code>registerException</code> without detail
     * message.
     */
    public AkunException() {
    }

    /**
     * Constructs an instance of <code>registerException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public AkunException(String msg) {
        super(msg);
    }
}
