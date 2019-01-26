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
public class Transaksi {
    private Integer kodeTransaksi;
    private String barang;
    private String jumlah;
    private String hargaSatuan;
    private String total;
    
    
    public Transaksi(){
        
    }

    public Transaksi( String barang, String jumlah, String hargaSatuan, String total) {
        this.barang = barang;
        this.jumlah = jumlah;
        this.hargaSatuan = hargaSatuan;
        this.total = total;
    }

    public Integer getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(Integer kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(String hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.kodeTransaksi);
        hash = 97 * hash + Objects.hashCode(this.barang);
        hash = 97 * hash + Objects.hashCode(this.jumlah);
        hash = 97 * hash + Objects.hashCode(this.hargaSatuan);
        hash = 97 * hash + Objects.hashCode(this.total);
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
        final Transaksi other = (Transaksi) obj;
        if (!Objects.equals(this.barang, other.barang)) {
            return false;
        }
        if (!Objects.equals(this.jumlah, other.jumlah)) {
            return false;
        }
        if (!Objects.equals(this.hargaSatuan, other.hargaSatuan)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.kodeTransaksi, other.kodeTransaksi)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}