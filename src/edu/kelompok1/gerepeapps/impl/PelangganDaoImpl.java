/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.impl;

import com.mysql.jdbc.PreparedStatement;
import edu.kelompok1.gerepeapps.entity.Pelanggan;
import edu.kelompok1.gerepeapps.error.PelangganException;
import edu.kelompok1.gerepeapps.service.PelangganDao;
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
public class PelangganDaoImpl implements PelangganDao {

    private Connection connection;

    private final String insertPelanggan = "INSERT INTO PELANGGAN (KODE_PELANGGAN,NAMA_PELANGGAN,TELEPON,ALAMAT) VALUES (?,?,?,?)";

    private final String updatePelanggan = "UPDATE PELANGGAN SET KODE_PELANGGAN=?,NAMA_PELANGGAN=?,TELEPON=?, ALAMAT=? WHERE ID_PELANGGAN=?";

    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID_PELANGGAN=?";

    private final String getById_Pelanggan = "SELECT * FROM PELANGGAN WHERE ID_PELANGAN=?";

    private final String getByKode_Pelanggan = "SELECT * FROM PELANGGAN WHERE KODE_PELANGGAN=?";

    private final String selectAll = "SELECT * FROM PELANGGAN";

    public PelangganDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void InsertPelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = (PreparedStatement) connection.prepareStatement(insertPelanggan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pelanggan.getKodePelanggan());
            statement.setString(2, pelanggan.getNamaPelanggan());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getAlamat());
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                pelanggan.setIdPelanggan(result.getInt(1));

            }

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void UpdatePelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = (PreparedStatement) connection.prepareStatement(updatePelanggan);
            statement.setString(1, pelanggan.getKodePelanggan());
            statement.setString(2, pelanggan.getNamaPelanggan());
            statement.setString(3, pelanggan.getTelepon());
            statement.setString(4, pelanggan.getAlamat());
            statement.setInt(5, pelanggan.getIdPelanggan());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void DeletePelanggan(Integer Id_Pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = (PreparedStatement) connection.prepareStatement(deletePelanggan);
            statement.setInt(1, Id_Pelanggan);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public Pelanggan getPelanggan(Integer Id_pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = (PreparedStatement) connection.prepareStatement(getById_Pelanggan);
            statement.setInt(1, Id_pelanggan);
            ResultSet result = statement.executeQuery();
            Pelanggan pelanggan = null;
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setIdPelanggan(result.getInt("ID_PELANGGAN"));
                pelanggan.setKodePelanggan(result.getString("KODE_PELANGGAN"));
                pelanggan.setNamaPelanggan(result.getString("NAMA_PELANGGAN"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
            } else {
                throw new PelangganException("Pelanggan dengan id" + Id_pelanggan + "tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
         Statement statement = null;
        List<Pelanggan> list = new ArrayList<Pelanggan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            Pelanggan pelanggan = null;
            while (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setIdPelanggan(result.getInt("ID_PELANGGAN"));
                pelanggan.setKodePelanggan(result.getString("KODE_PELANGGAN"));
                pelanggan.setNamaPelanggan(result.getString("NAMA_PELANGGAN"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                list.add(pelanggan);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }

    }

    @Override
    public Pelanggan getPelanggan(String kode_pelanggan) throws PelangganException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = (PreparedStatement) connection.prepareStatement(getByKode_Pelanggan);
            statement.setString(1, kode_pelanggan);
            ResultSet result = statement.executeQuery();
            Pelanggan pelanggan = null;
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setIdPelanggan(result.getInt("ID_PELANGGAN"));
                pelanggan.setKodePelanggan(result.getString("KODE_PELANGGAN"));
                pelanggan.setNamaPelanggan(result.getString("NAMA_PELANGGAN"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setTelepon(result.getString("ALAMAT"));
            } else {
                throw new PelangganException("Pelanggan dengan Kode_Pelanggan" + kode_pelanggan + "tidak ditemukan");
            }
            connection.commit();
            return pelanggan;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException eexception) {
                }
            }
        }

    }

}
