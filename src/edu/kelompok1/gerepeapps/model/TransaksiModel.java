/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.model;

import edu.kelompok1.gerepeapps.database.GerepeAppsDatabase;
import edu.kelompok1.gerepeapps.entity.Transaksi;
import edu.kelompok1.gerepeapps.error.TransaksiException;
import edu.kelompok1.gerepeapps.event.TransaksiListener;
import edu.kelompok1.gerepeapps.service.TransaksiDao;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class TransaksiModel {
    private int kodeTransaksi;
    private String barang;
    private String  jumlah;
    private String  hargaSatuan;
    private String total;
    
     private TransaksiListener listener;

    public int getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(int kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
        fireOnChange();
        
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
        fireOnChange();
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
        fireOnChange();
    }

    public String getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(String hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
        fireOnChange();
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
        fireOnChange();
    }

   
    

    public TransaksiListener getListener() {
        return listener;
    }

    public void setListener(TransaksiListener listener) {
        this.listener = listener;
    }
    
    
    
    
    
     protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }
    
     protected void fireOnInsert(Transaksi transaksi){
        if(listener!=null){
            listener.onInsert(transaksi);
        }
        
    }
        
    protected void fireOnUpdate(Transaksi transaksi){
        if(listener!=null){
            listener.onUpdate(transaksi);
        }
        
    }
    
    protected void fireOnDelete(){
        if(listener!=null){
            listener.onDelete();
        }
       
    }
    
    public void InsertTransaksi() throws SQLException, TransaksiException{
        TransaksiDao dao1 = GerepeAppsDatabase.getTransaksiDao();
        Transaksi transaksi  = new Transaksi();
        transaksi.setBarang(barang);
        transaksi.setJumlah(jumlah);
        transaksi.setHargaSatuan(hargaSatuan);
        transaksi.setTotal(total);
        
        dao1.InsertTransaksi(transaksi);
        fireOnInsert(transaksi);
        
    }
    
    public void UpdateTransaksi() throws SQLException, TransaksiException{
        TransaksiDao dao1 = (TransaksiDao) GerepeAppsDatabase.getTransaksiDao();
        Transaksi transaksi  = new Transaksi();
        transaksi.setBarang(barang);
        transaksi.setJumlah(jumlah);
        transaksi.setHargaSatuan(hargaSatuan);
        transaksi.setTotal(total);
        transaksi.setKodeTransaksi(kodeTransaksi);
        
        dao1.UpdateTransaksi(transaksi);
        fireOnUpdate(transaksi);
        
    }
    
    public void deleteTransaksi() throws SQLException, TransaksiException{
        TransaksiDao dao1 = (TransaksiDao) GerepeAppsDatabase.getTransaksiDao();
        
        dao1.DeleteTransaksi(kodeTransaksi);
        fireOnDelete();
    }
    
    public void resetTransaksi(){
        setKodeTransaksi(0);
        setBarang("");
        setJumlah("");
        setHargaSatuan("");
        setTotal("");
    }
}
