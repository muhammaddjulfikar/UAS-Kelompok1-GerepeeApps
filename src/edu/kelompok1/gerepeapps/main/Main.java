/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.main;

import edu.kelompok1.gerepeapps.error.PelangganException;
import edu.kelompok1.gerepeapps.error.TransaksiException;
import edu.kelompok1.gerepeapps.view.Login;
import edu.kelompok1.gerepeapps.view.MainView;
import edu.kelompok1.gerepeapps.view.Register;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, PelangganException, TransaksiException {
        // TODO code application logic here
        
       new Login().show();
       new Register().show();
       new MainView().show();
    }
    
}
