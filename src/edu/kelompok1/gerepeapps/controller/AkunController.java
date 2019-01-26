/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.controller;

import edu.kelompok1.gerepeapps.model.AkunModel;
import edu.kelompok1.gerepeapps.view.Register;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class AkunController {
    
    private AkunModel model;

    public void setModel(AkunModel model) {
        this.model = model;
    }
    
    public void resetPelanggan(Register view){
        model.resetAkun();
        
    }
    
    public void insertAkun(Register view){
        String username = view.getBtnUsernameregister().getText();
        String email = view.getBtnEmailregister().getText();
        String password = view.getBtnPassregister().getText();
        
        if(username.trim().equals("")){
            JOptionPane.showMessageDialog(view, "Username Tidak Boleh Kosong");
        }else if(username.length()>255){
            JOptionPane.showMessageDialog(view, "Username Tidak Boleh lebih dari 255 karakter");
//        }else if(email.length()>12){
//            JOptionPane.showMessageDialog(view, "Email Tidak Boleh Kosong");
        }else if(!email.contains("@")||!email.contains(".")){
            JOptionPane.showMessageDialog(view, "Email tidak valid");
        }else{
            model.setUsername(username);
            model.setEmail(email);
            model.setPassword(password);
            
            try{
                
                model.InsertAkun();
                JOptionPane.showMessageDialog(view, "Akun Berhasil Ditambahkan");
                model.resetAkun();
            }catch (Throwable throwable){
                
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Eror di database dengan pesan", throwable.getMessage()});
                
            }
        }
    
}
}
