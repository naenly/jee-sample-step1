package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.Compras;
import java.util.List;
import junit.framework.TestCase;

public class ComprasDaoJdbcTest extends TestCase {
    
    public ComprasDaoJdbcTest(String testName) {
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
        //System.out.println("create");
        //Compras compras = new Compras();
        //compras.setProductId(3);
        //compras.setClienteId(1);
        //ComprasDaoJdbc instance = new ComprasDaoJdbc();
        //Compras expResult = compras;
        //Compras result = instance.create(compras);
        //assertEquals(expResult, result);
           System.out.println("create");
        Compras compras = new Compras();
        compras.setProductId(3);
        compras.setClienteId(1);
        
        ComprasDaoJdbc instance = new ComprasDaoJdbc();
        Compras expResult = compras;
        Compras result = instance.create(compras);
        
        Compras compras1 = new Compras();
        compras1.setProductId(1);
        compras1.setClienteId(1);
        ComprasDaoJdbc instance1 = new ComprasDaoJdbc();
        Compras expResult1 = compras1;
        Compras result1 = instance1.create(compras1);
    }

    public void testUpdate() {
        System.out.println("update");
        Compras compras = null;
        ComprasDaoJdbc instance = new ComprasDaoJdbc();
        Compras expResult = null;
        Compras result = instance.update(compras);
       
    }

    public void testDelete() {
        System.out.println("delete");
        Compras compras = null;
        ComprasDaoJdbc instance = new ComprasDaoJdbc();
        instance.delete(compras);
        
    }

    public void testFindById() {
        System.out.println("findById");
        Integer comprasId = null;
        ComprasDaoJdbc instance = new ComprasDaoJdbc();
        Compras expResult = null;
        Compras result = instance.findById(comprasId);
      
    }

    public void testFindAll() {
        System.out.println("findAll");
        ComprasDaoJdbc instance = new ComprasDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
        
    }
}

