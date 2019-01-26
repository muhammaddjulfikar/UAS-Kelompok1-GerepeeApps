/*    
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.controller;

import edu.kelompok1.gerepeapps.model.PelangganModel;
import edu.kelompok1.gerepeapps.view.MainView;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class PelangganController {

   private PelangganModel model;

    public void setModel(PelangganModel model) {
        this.model = model;
    }

    public void resetPelanggan(MainView view) {
        model.resetPelanggan();

    }

    public void insertPelanggan(MainView view) {
        String kodePelanggan = view.getKodePelanggan().getText();
        String namaPelanggan = view.getNamaPelanggan().getText();
        String telepon = view.getTelepon().getText();
        String alamat = view.getAlamat().getText();

        if (kodePelanggan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode Pelanggan Masih Kosong");
        } else if (kodePelanggan.length() > 25) {
            JOptionPane.showMessageDialog(view, "Kode Pelanggan TakBoleh kosong");
        } else if (namaPelanggan.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama Depan tak boleh lebih dari 255");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Number telepon tak boleh lebih dari 12 digit");
        } else if (alamat.length() > 255) {
            JOptionPane.showMessageDialog(view, "Alamat tak boleh lebih dari 255");
        } else {
            model.setKodePelanggan(kodePelanggan);
            model.setNamaPelanggan(namaPelanggan);
            model.setTelepon(telepon);
            model.setAlamat(alamat);

            try {

                model.InsertPelanggan();
                JOptionPane.showMessageDialog(view, "Daftar Pelanggan Berhasil Ditambahkan");
                model.resetPelanggan();
            } catch (Throwable throwable) {

                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Eror di database dengan pesan", throwable.getMessage()});

            }
        }

    }

    public void updatePelanggan(MainView view) {

        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTabelPelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan diubah");
            return;
        }
        
        Integer idPelanggan = Integer.parseInt(view.getIdPelanggan().getText());

        String kodePelanggan = view.getKodePelanggan().getText();
        String namaPelanggan = view.getNamaPelanggan().getText();
        String telepon = view.getTelepon().getText();
        String alamat = view.getAlamat().getText();

        if (kodePelanggan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Kode Pelanggana Masih Kosong");
        } else if (kodePelanggan.length() > 25) {
            JOptionPane.showMessageDialog(view, "Kode Pelanggan TakBoleh kosong");
        } else if (namaPelanggan.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama Depan tak boleh lebih dari 255");
        } else if (telepon.length() > 12) {
            JOptionPane.showMessageDialog(view, "Number telepon tak boleh lebih dari 12 digit");
        } else if (alamat.length() > 255) {
            JOptionPane.showMessageDialog(view, "Alamat tak boleh lebih dari 255");
        } else {
            model.setIdPelanggan(idPelanggan);
            model.setKodePelanggan(kodePelanggan);
            model.setNamaPelanggan(namaPelanggan);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            try {
                model.UpdatePelanggan();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Di Ubah");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

    public void deletePelanggan(MainView view) {

        //jika tidak ada yang diseleksi kasih peringatan
        if (view.getTabelPelanggan().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Silahkan Seleksi baris data yang akan dihapus");
            return;
        }

        if (JOptionPane.showConfirmDialog(view, "Anda yakin akan menghapus?")
                == JOptionPane.OK_OPTION) {
            Integer id = Integer.parseInt(view.getIdPelanggan().getText());
            model.setIdPelanggan(id);

            try {
                model.deletePelanggan();
                JOptionPane.showMessageDialog(view, "Data Pelanggan Berhasil Di Hapus");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{
                    "Terjadi error di database dengan pesan ", throwable.getMessage()
                });
            }
        }
    }

}
