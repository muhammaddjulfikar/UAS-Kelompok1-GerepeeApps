/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.model;

import edu.kelompok1.gerepeapps.entity.Pelanggan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class TablePelangganModel extends AbstractTableModel{
    private List<Pelanggan> list = new ArrayList<Pelanggan>();

    public void setList(List<Pelanggan> list) {
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
     
    public boolean add(Pelanggan e) {
        try{
            return list.add(e);
        }finally{
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
  }
     public Pelanggan get(int index) {
         return list.get(index);
    }

    public Pelanggan set(int index, Pelanggan element) {
        try{
            return list.set(index, element); 
        }finally{
            fireTableRowsUpdated(index, index);        
        }      
    }
    
    public Pelanggan remove(int index) {
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
                return "ID_PELANGGAN";
            case 1:
                return "KODE_PELANGGAN";
            case 2:
                return "NAMA_PELANGGAN";
            case 3:
                return "TELEPON";
            case 4:
                return "ALAMAT";
            default:
                return null;
        }
    }
    
    


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIdPelanggan();
            case 1:
                return list.get(rowIndex).getKodePelanggan();
            case 2:
                return list.get(rowIndex).getNamaPelanggan();
            case 3:
                return list.get(rowIndex).getTelepon();
            case 4:
                return list.get(rowIndex).getAlamat();
            default:
                return null;
        }
    }
    
    
}
