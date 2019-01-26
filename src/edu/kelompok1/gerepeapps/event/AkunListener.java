/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kelompok1.gerepeapps.event;

import edu.kelompok1.gerepeapps.entity.Akun;
import edu.kelompok1.gerepeapps.model.AkunModel;

/**
 *
 * @author Lenovo
 */
public interface AkunListener {
    
    public void onChange(AkunModel model);
    
    public void onInsert(Akun akun);
    
    public void onDelete();
    
    public void onUpdate(Akun akun);
    
}
