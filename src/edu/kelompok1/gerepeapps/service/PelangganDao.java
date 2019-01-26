/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.service;

import edu.kelompok1.gerepeapps.entity.Pelanggan;
import edu.kelompok1.gerepeapps.error.PelangganException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface PelangganDao {
    public void InsertPelanggan(Pelanggan pelanggan) throws PelangganException;
    public void UpdatePelanggan(Pelanggan pelanggan) throws PelangganException;
    public void DeletePelanggan(Integer idPelanggan) throws PelangganException;
    public Pelanggan getPelanggan(Integer idPelanggan) throws PelangganException;
    public Pelanggan getPelanggan(String kodepelanggan) throws PelangganException;
    public List<Pelanggan> selectAllPelanggan() throws PelangganException;
    
}
