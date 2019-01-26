/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.model;

import edu.kelompok1.gerepeapps.entity.Transaksi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class TableTransaksiModel extends AbstractTableModel {

    private List<Transaksi> list = new ArrayList<Transaksi>();

    public void setList(List<Transaksi> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();

    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public boolean add(Transaksi e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public Transaksi get(int index) {
        return list.get(index);
    }

    public Transaksi set(int index, Transaksi element) {
     try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Transaksi remove(int index) {
        try{
            return list.remove(index);
        }finally{
            fireTableRowsDeleted(index, index);    
        }   
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "KODETRANSAKSI";
            case 1:
                return "BARANG";
            case 2:
                return "JUMLAH";
            case 3:
                return "HARGASATUAN";
            case 4:
                return "TOTALHARGA";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getKodeTransaksi();
            case 1:
                return list.get(rowIndex).getBarang();
            case 2:
                return list.get(rowIndex).getJumlah();
            case 3:
                return list.get(rowIndex).getHargaSatuan();
            case 4:
                return list.get(rowIndex).getTotal();
            default:
                return null;
        }
    }

}
