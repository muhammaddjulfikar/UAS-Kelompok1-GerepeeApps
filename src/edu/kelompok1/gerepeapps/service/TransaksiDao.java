/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.service;

import edu.kelompok1.gerepeapps.entity.Transaksi;
import edu.kelompok1.gerepeapps.error.TransaksiException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface TransaksiDao {
    public void InsertTransaksi(Transaksi transaksi) throws TransaksiException;
    public void UpdateTransaksi(Transaksi transaksi) throws TransaksiException;
    public void DeleteTransaksi(Integer kodeTransaksi) throws TransaksiException;
    public Transaksi getTransaksi(Integer kodeTransaksi) throws TransaksiException;
    public Transaksi getTransaksi(String barang) throws TransaksiException;
    public List<Transaksi> selectAllTransaksi() throws TransaksiException;
    
}
