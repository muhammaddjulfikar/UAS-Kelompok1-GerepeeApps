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
public class TransaksiException extends Exception {

    /**
     * Creates a new instance of <code>TransaksiException</code> without detail
     * message.
     */
    public TransaksiException() {
    }

    /**
     * Constructs an instance of <code>TransaksiException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public TransaksiException(String msg) {
        super(msg);
    }
}
