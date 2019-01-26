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
public class Pelanggan {
    private Integer idPelanggan;
    private String kodePelanggan;
    private String namaPelanggan;
    private String Telepon;
    private String Alamat;
    
    public Pelanggan(){
        
    }

    public Pelanggan( String kodePelanggan, String namaPelanggan, String Telepon, String Alamat) {
        this.kodePelanggan = kodePelanggan;
        this.namaPelanggan = namaPelanggan;
        this.Telepon = Telepon;
        this.Alamat = Alamat;
    }

    public Integer getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(Integer idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getKodePelanggan() {
        return kodePelanggan;
    }

    public void setKodePelanggan(String kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getTelepon() {
        return Telepon;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.idPelanggan);
        hash = 97 * hash + Objects.hashCode(this.kodePelanggan);
        hash = 97 * hash + Objects.hashCode(this.namaPelanggan);
        hash = 97 * hash + Objects.hashCode(this.Telepon);
        hash = 97 * hash + Objects.hashCode(this.Alamat);
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
        final Pelanggan other = (Pelanggan) obj;
        if (!Objects.equals(this.kodePelanggan, other.kodePelanggan)) {
            return false;
        }
        if (!Objects.equals(this.namaPelanggan, other.namaPelanggan)) {
            return false;
        }
        if (!Objects.equals(this.Telepon, other.Telepon)) {
            return false;
        }
        if (!Objects.equals(this.Alamat, other.Alamat)) {
            return false;
        }
        if (!Objects.equals(this.idPelanggan, other.idPelanggan)) {
            return false;
        }
        return true;
    }

    
}

    
