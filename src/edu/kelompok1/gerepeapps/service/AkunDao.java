/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.service;

import edu.kelompok1.gerepeapps.entity.Akun;
import edu.kelompok1.gerepeapps.error.AkunException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface AkunDao {

    public void InsertAkun(Akun akun) throws AkunException;
    public void UpdateAkun(Akun akun) throws AkunException;
    public void DeleteAkun(Integer Id) throws AkunException;
    public Akun getAkun(Integer Id) throws AkunException;
    public Akun getAkun(String Username) throws AkunException;
    public List<Akun> selectAllAkun() throws AkunException;

}
