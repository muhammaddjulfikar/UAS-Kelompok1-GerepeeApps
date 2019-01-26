/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.event;

import edu.kelompok1.gerepeapps.entity.Transaksi;
import edu.kelompok1.gerepeapps.model.TransaksiModel;

/**
 *
 * @author Lenovo
 */
public interface TransaksiListener {

    public void onChange(TransaksiModel modelTransaksi);

    public void onInsert(Transaksi transaksi);

    public void onDelete();

    public void onUpdate(Transaksi transaksi);

}
