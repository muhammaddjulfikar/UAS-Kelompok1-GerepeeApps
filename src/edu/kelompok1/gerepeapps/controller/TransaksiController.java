/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.controller;

import edu.kelompok1.gerepeapps.model.TransaksiModel;
import edu.kelompok1.gerepeapps.view.MainView;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class TransaksiController {

    private TransaksiModel modelTransaksi;

    public void setModel(TransaksiModel modelTransaksi) {
        this.modelTransaksi = modelTransaksi;
    }

    public void resetTransaksi(MainView view) {
        modelTransaksi.resetTransaksi();

    }

    public void insertTransaksi(MainView view) {
        String Barang = view.getBarang().getText();
        String Jumlah = view.getJumlah().getText();
        String HargaSatuan = view.getHargaSatuan().getText();
        String TotalHarga = view.getTotal().getText();

        if (Barang.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Barang Masih Kosong");
        }else if (Barang.length() > 25) {
            JOptionPane.showMessageDialog(view, "Nama Barang TakBoleh kosong");
        } else if (Jumlah.length() > 255) {
            JOptionPane.showMessageDialog(view, "");
        } else if (HargaSatuan.length() > 12) {
            JOptionPane.showMessageDialog(view, "");
        } else if (TotalHarga.length() > 255) {
            JOptionPane.showMessageDialog(view, "");   
        }else{
            modelTransaksi.setBarang(Barang);
            modelTransaksi.setJumlah(Jumlah);
            modelTransaksi.setHargaSatuan(HargaSatuan);
            modelTransaksi.setTotal(TotalHarga);

            try {

                modelTransaksi.InsertTransaksi();
                JOptionPane.showMessageDialog(view, "Data Transaksi Berhasil Ditambahkan");
                modelTransaksi.resetTransaksi();
            } catch (Throwable throwable) {

                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Eror di database dengan pesan", throwable.getMessage()});

            }
        }

    }

    public void updateTransaksi(MainView view) {
        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTabelTransaksi().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }
        
        Integer kodeTransaksi = Integer.parseInt(view.getKodeTransaksi().getText());

        String Barang = view.getBarang().getText();
        String Jumlah = view.getJumlah().getText();
        String HargaSatuan = view.getHargaSatuan().getText();
        String TotalHarga = view.getTotal().getText();

        if (Barang.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Barang Masih Kosong");
        }else if (Barang.length() > 25) {
            JOptionPane.showMessageDialog(view, "Nama Barang TakBoleh kosong");
        } else if (Jumlah.length() > 255) {
            JOptionPane.showMessageDialog(view, "");
        } else if (HargaSatuan.length() > 12) {
            JOptionPane.showMessageDialog(view, "");
        } else if (TotalHarga.length() > 255) {
            JOptionPane.showMessageDialog(view, "");   
        }else{
            modelTransaksi.setKodeTransaksi(kodeTransaksi);
            modelTransaksi.setBarang(Barang);
            modelTransaksi.setJumlah(Jumlah);
            modelTransaksi.setHargaSatuan(HargaSatuan);
            modelTransaksi.setTotal(TotalHarga);
            

            try {
                modelTransaksi.UpdateTransaksi();
                JOptionPane.showMessageDialog(view, "Data Transaksi Berhasil Di Ubah");
                modelTransaksi.resetTransaksi();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void deleteTransaksi(MainView view1) {

        if (view1.getTabelTransaksi().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view1, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view1, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {

           
          Integer kodetransaksi = Integer.parseInt(view1.getKodeTransaksi().getText());
            modelTransaksi.setKodeTransaksi(kodetransaksi);

            try {
                modelTransaksi.deleteTransaksi();
                JOptionPane.showMessageDialog(view1, "Data Transaksi Berhasil Di Hapus");
                modelTransaksi.resetTransaksi();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view1, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }
}
