/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

/**
 *
 * @author lenovo
 */

import edu.uan.fis.jeesample.dto.Cliente;
import java.util.List;
import junit.framework.TestCase;

public class ClienteDaoJdbcTest extends TestCase {
    
    public ClienteDaoJdbcTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreate() {
        System.out.println("create");
        Cliente cliente = new Cliente();
        cliente.setName("Nuevo Cliente");
        cliente.setUser("User Cliente");
        cliente.setPassword("Password");
        ClienteDaoJdbc instance = new ClienteDaoJdbc();
        Cliente expResult = cliente;
        Cliente result = instance.create(cliente);
        
        Cliente cliente1 = new Cliente();
        cliente1.setName("Nuevo Cliente 1");
        cliente1.setUser("User Cliente 1");
        cliente1.setPassword("Password 1");
        ClienteDaoJdbc instance1 = new ClienteDaoJdbc();
        Cliente expResult1 = cliente1;
        Cliente result1 = instance1.create(cliente1);
        
    }

    public void testUpdate() {
        System.out.println("update");
        Cliente cliente = null;
        ClienteDaoJdbc instance = new ClienteDaoJdbc();
        Cliente expResult = null;
        Cliente result = instance.update(cliente);
                 }

    public void testDelete() {
        System.out.println("delete");
        Cliente cliente = null;
        ClienteDaoJdbc instance = new ClienteDaoJdbc();
        instance.delete(cliente);
            }

    public void testFindById() {
        System.out.println("findById");
        Integer clienteId = null;
        ClienteDaoJdbc instance = new ClienteDaoJdbc();
        Cliente expResult = null;
        Cliente result = instance.findById(clienteId);      
    }

    public void testFindAll() {
        System.out.println("findAll");
        ClienteDaoJdbc instance = new ClienteDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
     
    }
}