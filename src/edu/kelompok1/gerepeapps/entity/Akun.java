/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.entity;

import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class Akun {
    private int Id;
    private String Username;
    private String Email;
    private String Password;
    
    public Akun(){
        
    }

    public Akun(int Id, String Username, String Email, String Password) {
        this.Id = Id;
        this.Username = Username;
        this.Email = Email;
        this.Password = Password;
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

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.Id;
        hash = 97 * hash + Objects.hashCode(this.Username);
        hash = 97 * hash + Objects.hashCode(this.Email);
        hash = 97 * hash + Objects.hashCode(this.Password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Akun other = (Akun) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Username, other.Username)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        if (!Objects.equals(this.Password, other.Password)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
