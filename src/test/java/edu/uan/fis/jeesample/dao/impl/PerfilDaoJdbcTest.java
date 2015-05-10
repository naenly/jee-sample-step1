package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dto.Perfil;
import java.util.List;
import junit.framework.TestCase;

public class PerfilDaoJdbcTest extends TestCase {
    
    public PerfilDaoJdbcTest(String testName) {
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
        Perfil perfil = new Perfil();
        perfil.setName("Administrador");
        PerfilDaoJdbc instance = new PerfilDaoJdbc();
        Perfil expResult = perfil;
        Perfil result = instance.create(perfil);
        
        Perfil perfil1 = new Perfil();
        perfil1.setName("usuario1");
        PerfilDaoJdbc instance1 = new PerfilDaoJdbc();
        Perfil expResult1 = perfil1;
        Perfil result1 = instance1.create(perfil1);
        
    }

    public void testUpdate() {
        System.out.println("update");
        Perfil perfil = null;
        PerfilDaoJdbc instance = new PerfilDaoJdbc();
        Perfil expResult = null;
        Perfil result = instance.update(perfil);
                 }

    public void testDelete() {
        System.out.println("delete");
        Perfil perfil = null;
        PerfilDaoJdbc instance = new PerfilDaoJdbc();
        instance.delete(perfil);
            }

    public void testFindById() {
        System.out.println("findById");
        Integer perfilId = null;
        PerfilDaoJdbc instance = new PerfilDaoJdbc();
        Perfil expResult = null;
        Perfil result = instance.findById(perfilId);      
    }

    public void testFindAll() {
        System.out.println("findAll");
        PerfilDaoJdbc instance = new PerfilDaoJdbc();
        List expResult = null;
        List result = instance.findAll();
     
    }
}
