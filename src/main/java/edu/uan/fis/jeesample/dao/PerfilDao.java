/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Perfil;
import java.util.List;

public interface PerfilDao {

    /**
     * Creates a new perfil. 
     * @param perfil
     * @return 
     */

package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Perfil;
import java.util.List;

public interface PerfilDao {
    Perfil create(Perfil perfil);

    /**
     * Updates an existing perfil. Perfil id can't be modified.
     * @param perfil
     * @return 
     */
    Perfil update(Perfil perfil);

    /**
     * Deletes an existing perfil
     * @param perfil 
     */
    void delete(Perfil perfil);

    /**
     * Find a perfil by id
     * @param perfilId
     * @return 
     */
    Perfil findById(Integer perfilId);

    /**
     * Returns all the perfils in the database
     * @return 
     */
    List<Perfil> findAll();
}

