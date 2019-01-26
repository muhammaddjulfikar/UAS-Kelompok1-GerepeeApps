/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.impl;

import com.mysql.jdbc.PreparedStatement;
import edu.kelompok1.gerepeapps.entity.Akun;
import edu.kelompok1.gerepeapps.error.AkunException;
import java.sql.Connection;
import java.util.List;
import edu.kelompok1.gerepeapps.service.AkunDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class AkunDaoImpl  implements AkunDao {
    
    private Connection connection;
    
    private final String insertAkun = "INSERT INTO AKUN (UserName,Email,Password) VALUES (?,?,?)";
    
    private final String updateAkun = "UPDATE AKUN SET UserName=?,Email=?,Password=? WHERE ID=?";

    private final String deleteAkun = "DELETE FROM AKUN WHERE ID=?";
    
    private final String getById = "SELECT * FROM AKUN WHERE ID=?";
    
    private final String getByUsername = "SELECT * FROM AKUN WHERE Email=?";
    
    private final String selectAll = "SELECT * FROM AKUN";
    
    public AkunDaoImpl(Connection connection) {
        this.connection = connection;
    } 

    @Override
    public void InsertAkun(Akun akun) throws AkunException {
        PreparedStatement statement = null;
       try{ 
           connection.setAutoCommit(false);
           statement = (PreparedStatement) connection.prepareStatement(insertAkun, Statement.RETURN_GENERATED_KEYS);
           statement.setString(1,akun.getUsername());
           statement.setString(2,akun.getEmail());
           statement.setString(3,akun.getPassword());
           statement.executeUpdate();
           
           ResultSet result = statement.getGeneratedKeys();
           if(result.next()){
               akun.setId(result.getInt(1));
               
           }
           
           connection.commit();
           }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new AkunException(e.getMessage());
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
    public void UpdateAkun(Akun akun) throws AkunException {
       PreparedStatement statement = null;
       try{
           connection.setAutoCommit(false);
           statement = (PreparedStatement) connection.prepareStatement(updateAkun);
           statement.setString(1,akun.getUsername());
           statement.setString(2,akun.getEmail());
           statement.setString(3,akun.getPassword());
           statement.setInt(4,akun.getId());
           statement.executeUpdate();
           connection.commit();
       }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new AkunException(e.getMessage());
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
    public void DeleteAkun(Integer Id) throws AkunException {
        PreparedStatement statement = null;
       try{
           connection.setAutoCommit(false);
           statement = (PreparedStatement) connection.prepareStatement(deleteAkun);
           statement.setInt(1,Id);
           statement.executeUpdate();
           connection.commit();
       }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new AkunException(e.getMessage());
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
    public Akun getAkun(Integer Id) throws AkunException {
       PreparedStatement statement = null;
       try{
           connection.setAutoCommit(false);
           statement = (PreparedStatement) connection.prepareStatement(getById);
           statement.setInt(1,Id);
           ResultSet result = statement.executeQuery();
           Akun akun = null;
           if(result.next()){
               akun = new Akun();
               akun.setId(result.getInt("ID"));
               akun.setUsername(result.getString("USERNAME"));
               akun.setEmail(result.getString("EMAIL"));
               akun.setPassword(result.getString("PASSWORD"));
           } else{
               throw new AkunException("Akun dengan id"+Id+"tidak ditemukan");
           }
           connection.commit();
           return akun;
       }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new AkunException(e.getMessage());
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
    public Akun getAkun(String Username) throws AkunException {
       PreparedStatement statement = null;
       try{
           connection.setAutoCommit(false);
           statement = (PreparedStatement) connection.prepareStatement(getByUsername);
           statement.setString(1,Username);
           ResultSet result = statement.executeQuery();
           Akun akun = null;
           if(result.next()){
               akun = new Akun();
               akun.setId(result.getInt("ID"));
               akun.setUsername(result.getString("USERNAME"));
               akun.setEmail(result.getString("EMAIL"));
               akun.setPassword(result.getString("PASSWORD"));
           } else{
               throw new AkunException("Akun dengan username"+Username+"tidak ditemukan");
           }
           connection.commit();
           return akun;
       }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new AkunException(e.getMessage());
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
    public List<Akun> selectAllAkun() throws AkunException {
        Statement statement = null;
        List<Akun> list = new ArrayList<Akun>();
       try{
           connection.setAutoCommit(false);
           statement =connection.createStatement();

           ResultSet result = statement.executeQuery(selectAll);
           Akun akun = null;
           while (result.next()){
               akun = new Akun();
               akun.setId(result.getInt("ID"));
               akun.setUsername(result.getString("USERNAME"));
               akun.setEmail(result.getString("EMAIL"));
               akun.setPassword(result.getString("PASSWORD"));
               list.add(akun);
           }
           connection.commit();
           return list;
       }catch(SQLException e){
               try{
                  connection.rollback();
               }catch(SQLException ex){   
               }
           throw new AkunException(e.getMessage());
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
