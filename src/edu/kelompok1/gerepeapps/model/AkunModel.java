/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.model;

import edu.kelompok1.gerepeapps.database.GerepeAppsDatabase;
import edu.kelompok1.gerepeapps.entity.Akun;
import edu.kelompok1.gerepeapps.error.AkunException;
import edu.kelompok1.gerepeapps.event.AkunListener;
import edu.kelompok1.gerepeapps.service.AkunDao;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class AkunModel {
    private int Id;
    private String Username;
    private String Email;
    private String Password;
    
   private AkunListener listener;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public AkunListener getAkunListener() {
        return listener;
    }

    public void setAkunListener(AkunListener listener) {
        this.listener = listener;
    }
    
     protected void fireOnInsert(Akun akun){
        if(listener!=null){
            listener.onInsert(akun);
        }
        
    }
        
    protected void fireOnUpdate(Akun akun){
        if(listener!=null){
            listener.onUpdate(akun);
        }
        
    }
    
    protected void fireOnDelete(){
        if(listener!=null){
            listener.onDelete();
        }
       
    }
    
    public void InsertAkun() throws SQLException, AkunException{
        AkunDao dao = GerepeAppsDatabase.getAkunDao();
        Akun akun  = new Akun();
        akun.setUsername(Username);
        akun.setEmail(Email);
        akun.setPassword(Password);
        dao.InsertAkun(akun);
        fireOnInsert(akun);
        
    }
    
    public void UpdateAkun() throws SQLException, AkunException{
        AkunDao dao = GerepeAppsDatabase.getAkunDao();
        Akun akun  = new Akun();
        akun.setUsername(Username);
        akun.setEmail(Email);
        akun.setPassword(Password);
        akun.setId(Id);
        
        dao.UpdateAkun(akun);
        fireOnUpdate(akun);
        
    }
    
    public void DeleteAkun() throws SQLException, AkunException{
        AkunDao dao = GerepeAppsDatabase.getAkunDao();
        
        dao.DeleteAkun(Id);
        fireOnDelete();
    }
    
    public void resetAkun(){
        setId(0);
        setUsername("");
        setEmail("");
        setPassword("");
    }
    
}
