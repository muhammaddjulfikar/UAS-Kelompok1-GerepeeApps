/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.model;

import edu.kelompok1.gerepeapps.database.GerepeAppsDatabase;
import edu.kelompok1.gerepeapps.entity.Pelanggan;
import edu.kelompok1.gerepeapps.error.PelangganException;
import edu.kelompok1.gerepeapps.event.PelangganListener;
import edu.kelompok1.gerepeapps.service.PelangganDao;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class PelangganModel {

    private int idPelanggan;
    private String kodePelanggan;
    private String namaPelanggan;
    private String Telepon;
    private String Alamat;
    private PelangganListener listener;

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
        fireOnChange();
    }

    public String getKodePelanggan() {
        return kodePelanggan;
    }

    public void setKodePelanggan(String kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
        fireOnChange();
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
        fireOnChange();
    }

    public String getTelepon() {
        return Telepon;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
        fireOnChange();
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
        fireOnChange();
    }

    
    
    public PelangganListener getListener() {
        return listener;
    }

    
    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }

    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Pelanggan pelanggan) {
        if (listener != null) {
            listener.onInsert(pelanggan);
        }

    }

    protected void fireOnUpdate(Pelanggan pelanggan) {
        if (listener != null) {
            listener.onUpdate(pelanggan);
        }

    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }

    }

    public void InsertPelanggan() throws SQLException, PelangganException {
        PelangganDao dao = GerepeAppsDatabase.getPelangganDao();
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setKodePelanggan(kodePelanggan);
        pelanggan.setNamaPelanggan(namaPelanggan);
        pelanggan.setTelepon(Telepon);
        pelanggan.setAlamat(Alamat);
        dao.InsertPelanggan(pelanggan);
        fireOnInsert(pelanggan);
    }

    public void UpdatePelanggan() throws SQLException, PelangganException {
        PelangganDao dao = GerepeAppsDatabase.getPelangganDao();
        Pelanggan pelanggan  = new Pelanggan();
        pelanggan.setKodePelanggan(kodePelanggan);
        pelanggan.setNamaPelanggan(namaPelanggan);
        pelanggan.setTelepon(Telepon);
        pelanggan.setAlamat(Alamat);
        pelanggan.setIdPelanggan(idPelanggan);
        
        dao.UpdatePelanggan(pelanggan);
        fireOnUpdate(pelanggan);
        
    }

    public void deletePelanggan() throws SQLException, PelangganException {
       PelangganDao dao = GerepeAppsDatabase.getPelangganDao();
        
        dao.DeletePelanggan(idPelanggan);
        fireOnDelete();
    }

    public void resetPelanggan() {
        setIdPelanggan(0);
        setKodePelanggan("");
        setNamaPelanggan("");
        setTelepon("");
        setAlamat("");
    }

}
