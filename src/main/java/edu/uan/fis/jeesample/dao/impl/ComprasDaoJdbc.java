package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.ComprasDao;
import edu.uan.fis.jeesample.dto.Compras;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lenovo
 */

public class ComprasDaoJdbc implements ComprasDao {
    
    public Compras create(Compras compras) {
        // Sample code
        Connection conn = null;
         PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            // 3. Creates the compras in the database
            String insertData= "INSERT INTO `tbl_compras`(`id_cliente`, `id_product`)  VALUES (?,?)";
            stmt = conn.prepareStatement(insertData);
            
            stmt.setInt(1,compras.getClienteId());
            stmt.setInt(2,compras.getProductId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return compras;
    }
    
    public Compras update(Compras compras) {
        
         Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "UPDATE tbl_compras SET id_cliente = ? WHERE id_compra = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar compras en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.setInt(1,2);
            preparedStatement.setInt(2,1);
// execute insert SQL stetement
            preparedStatement .executeUpdate();
            //stmt.executeUpdate("INSERT INTO tbl_compras VALUES(" + compras.getComprasId() + ",'" + compras.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return compras;
    //}
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void delete(Compras compras) {
       Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "DELETE FROM tbl_compras WHERE id_compra = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar compras en la base de datos           
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 2);
// execute insert SQL stetement
            preparedStatement .executeUpdate();
            //stmt.executeUpdate("INSERT INTO tbl_compras VALUES(" + compras.getComprasId() + ",'" + compras.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Compras findById(Integer comprasId) {
        Compras compras=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "Select * FROM tbl_compras WHERE id_compra = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar compras en la base de datos
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 3);
// execute insert SQL stetement
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            compras=new Compras();
         
            int idcompras=rs.getInt("id_compra");                   
              int idproducto=rs.getInt("id_product");  
            compras.setComprasId(idcompras);
             System.out.println(idcompras);
            compras.setProductId(idproducto);
             System.out.println(idproducto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return compras;
    }
    
    public List<Compras> findAll() {
        Compras compras=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Compras> comprass = new ArrayList<Compras>();

        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "Select * FROM tbl_compras";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar compras en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            compras=new Compras();
            compras.setComprasId(rs.getInt("id_compra"));
            compras.setProductId(rs.getInt("id_product"));
            comprass.add(compras);
         
            int idcompras=rs.getInt("id_compra");             
            int idproducto=rs.getInt("id_product"); 
            int idcliente=rs.getInt("id_cliente");
            compras.setComprasId(idcompras);  
            compras.setClienteId(idcliente);
            compras.setProductId(idproducto);
             System.out.println("ID: "+idcompras+" ID Producto: "+idproducto+" ID Cliente: "+idcliente);
                 
            }
            //stmt.executeUpdate("INSERT INTO tbl_compras VALUES(" + compras.getComprasId() + ",'" + compras.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return comprass;
    }
}



