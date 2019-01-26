/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.impl;

import com.mysql.jdbc.PreparedStatement;
import edu.kelompok1.gerepeapps.entity.Transaksi;
import edu.kelompok1.gerepeapps.error.TransaksiException;
import edu.kelompok1.gerepeapps.service.TransaksiDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class TransaksiDaoImpl implements TransaksiDao{
     private Connection connection;
    
    private final String insertTransaksi = "INSERT INTO TRANSAKSI (Barang,Jumlah,HargaSatuan,TotalHarga) VALUES (?,?,?,?)";
    
    private final String updateTransaksi = "UPDATE TRANSAKSI SET Barang=?,Jumlah=?,HargaSatuan=?,TotalHarga=? WHERE KODETRANSAKSI=?";

    private final String deleteTransaksi = "DELETE FROM TRANSAKSI WHERE KODETRANSAKSI=?";
    
    private final String getByKodeTransaksi = "SELECT * FROM TRANSAKSI WHERE KODETRANSAKSI=?";
    
    private final String getByBarang = "SELECT * FROM TRANSAKSI WHERE Barang=?";
    
    private final String selectAll = "SELECT * FROM TRANSAKSI";
    
    public TransaksiDaoImpl(Connection connection) {
        this.connection = connection;
    } 

    @Override
    public void InsertTransaksi(Transaksi transaksi) throws TransaksiException {
    PreparedStatement statement = null;
       try{ 
           connection.setAutoCommit(false);
           statement = (PreparedStatement) connection.prepareStatement(insertTransaksi, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1,transaksi.getBarang());
           statement.setString(2,transaksi.getJumlah());
           statement.setString(3,transaksi.getHargaSatuan());
           statement.setString(4,transaksi.getTotal());
           statement.executeUpdate();
           
           ResultSet result = statement.getGeneratedKeys();
           if(result.next()){
               transaksi.setKodeTransaksi(result.getInt(1));
               
           }
           
           connection.commit();
           }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new TransaksiException(e.getMessage());
       }finally{
           try{
               connection.setAutoCommit(true);
           }catch(SQLException ex){
           }
           if(statement!=null){
               try {
               statement.close();
           }catch(SQLException e){   
           }
           } 
       }         
    }

    @Override
    public void UpdateTransaksi(Transaksi transaksi) throws TransaksiException {
    PreparedStatement statement = null;
       try{
           connection.setAutoCommit(false);
          statement = (PreparedStatement) connection.prepareStatement(updateTransaksi);
           statement.setString(1,transaksi.getBarang());
           statement.setString(2,transaksi.getJumlah());
           statement.setString(3,transaksi.getHargaSatuan());
           statement.setString(4,transaksi.getTotal());
           statement.setInt(5,transaksi.getKodeTransaksi());
           statement.executeUpdate();
           connection.commit();
       }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new TransaksiException(e.getMessage());
       }finally{
           try{
               connection.setAutoCommit(true);
           }catch(SQLException ex){
           }
           if(statement!=null){
               try {
               statement.close();
           }catch(SQLException e){   
           }
           } 
       }
    }

    @Override
    public void DeleteTransaksi(Integer KodeTransaksi) throws TransaksiException {
    PreparedStatement statement = null;
       try{
           connection.setAutoCommit(false);
           statement = (PreparedStatement) connection.prepareStatement(deleteTransaksi);
           statement.setInt(1,KodeTransaksi);
           statement.executeUpdate();
           connection.commit();
       }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new TransaksiException(e.getMessage());
       }finally{
           try{
               connection.setAutoCommit(true);
           }catch(SQLException ex){
           }
           if(statement!=null){
               try {
               statement.close();
           }catch(SQLException e){   
           }
           } 
       }
    }

    @Override
    public Transaksi getTransaksi(Integer KodeTransaksi) throws TransaksiException {
    PreparedStatement statement = null;
       try{
           connection.setAutoCommit(false);
           statement = (PreparedStatement) connection.prepareStatement(getByKodeTransaksi);
           statement.setInt(1,KodeTransaksi);
           ResultSet result = statement.executeQuery();
           Transaksi transaksi = null;
           if(result.next()){
               transaksi = new Transaksi();
               transaksi.setKodeTransaksi(result.getInt("KODETRANSAKSI"));
               transaksi.setBarang(result.getString("BARANG"));
               transaksi.setJumlah(result.getString("JUMLAH"));
               transaksi.setHargaSatuan(result.getString("HARGASATUAN"));
               transaksi.setTotal(result.getString("TOTALHARGA"));
           } else{
               throw new TransaksiException("Transaksi dengan  Kode Transaksi"+KodeTransaksi+"tidak ditemukan");
           }
           connection.commit();
           return transaksi;
       }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new TransaksiException(e.getMessage());
       }finally{
           try{
               connection.setAutoCommit(true);
           }catch(SQLException ex){
           }
           if(statement!=null){
               try {
               statement.close();
           }catch(SQLException e){   
           }
           } 
       }
    }

    @Override
    public Transaksi getTransaksi(String Barang) throws TransaksiException {
    PreparedStatement statement = null;
       try{
           connection.setAutoCommit(false);
           statement = (PreparedStatement) connection.prepareStatement(getByBarang);
           statement.setString(1,Barang);
           ResultSet result = statement.executeQuery();
           Transaksi transaksi = null;
           if(result.next()){
               transaksi = new Transaksi();
               transaksi.setKodeTransaksi(result.getInt("KODETRANSAKSI"));
               transaksi.setBarang(result.getString("BARANG"));
               transaksi.setJumlah(result.getString("JUMLAH"));
               transaksi.setHargaSatuan(result.getString("HARGASATUAN"));
               transaksi.setTotal(result.getString("TOTALHARGA"));
           } else{
               throw new TransaksiException("Transaksi dengan Nama Barang"+Barang+"tidak ditemukan");
           }
           connection.commit();
           return transaksi;
       }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new TransaksiException(e.getMessage());
       }finally{
           try{
               connection.setAutoCommit(true);
           }catch(SQLException ex){
           }
           if(statement!=null){
               try {
               statement.close();
           }catch(SQLException e){   
           }
           } 
       }
    }

    @Override
    public List<Transaksi> selectAllTransaksi() throws TransaksiException {
   Statement statement = null;
        List<Transaksi> list = new ArrayList<Transaksi>();
       try{
           connection.setAutoCommit(false);
           statement =connection.createStatement();

           ResultSet result = statement.executeQuery(selectAll);
           Transaksi transaksi = null;
           while (result.next()){
               transaksi = new Transaksi();
               transaksi.setKodeTransaksi(result.getInt("KODETRANSAKSI"));
               transaksi.setBarang(result.getString("BARANG"));
               transaksi.setJumlah(result.getString("JUMLAH"));
               transaksi.setHargaSatuan(result.getString("HARGASATUAN"));
               transaksi.setTotal(result.getString("TOTALHARGA"));
           }
           connection.commit();
           return list;
       }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new TransaksiException(e.getMessage());
       }finally{
           try{
               connection.setAutoCommit(true);
           }catch(SQLException ex){
           }
           if(statement!=null){
               try {
               statement.close();
           }catch(SQLException e){   
           }
           } 
       }      

    }
    
}
