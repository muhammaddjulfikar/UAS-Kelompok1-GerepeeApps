/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.kelompok1.gerepeapps.impl.AkunDaoImpl;
import edu.kelompok1.gerepeapps.impl.PelangganDaoImpl;
import edu.kelompok1.gerepeapps.impl.TransaksiDaoImpl;
import edu.kelompok1.gerepeapps.service.AkunDao;
import edu.kelompok1.gerepeapps.service.PelangganDao;
import edu.kelompok1.gerepeapps.service.TransaksiDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class GerepeAppsDatabase {
    
    private static Connection connection;
    private static AkunDao akunDao;
    private static PelangganDao pelangganDao;
    private static TransaksiDao transaksiDao;
    
    public static Connection getConnection() throws SQLException{
        
        if (connection==null){
            
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/gerepeapps");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
        
    }
    
    public static AkunDao getAkunDao() throws SQLException{
        if(akunDao==null){
            akunDao = new AkunDaoImpl(getConnection());
        }
        return akunDao;
    }
    
     public static PelangganDao getPelangganDao() throws SQLException{
        if(pelangganDao==null){
            pelangganDao = new PelangganDaoImpl(getConnection());
        }
        return pelangganDao;
    }
     
     public static TransaksiDao getTransaksiDao() throws SQLException{
        if(transaksiDao==null){
            transaksiDao = new TransaksiDaoImpl(getConnection());
        }
        return (TransaksiDao) transaksiDao;
    }
}
