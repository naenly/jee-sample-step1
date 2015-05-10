/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Compras;
import java.util.List;

public interface ComprasDao {

    /**
     * Creates a new compras. 
     * @param compras
     * @return 
     */
    Compras create(Compras compras);

    /**
     * Updates an existing compras. Compras id can't be modified.
     * @param compras
     * @return 
     */
    Compras update(Compras compras);

    /**
     * Deletes an existing compras
     * @param compras 
     */
    void delete(Compras compras);

    /**
     * Find a compras by id
     * @param comprasId
     * @return 
     */
    Compras findById(Integer comprasId);

    /**
     * Returns all the comprass in the database
     * @return 
     */
    List<Compras> findAll();
}