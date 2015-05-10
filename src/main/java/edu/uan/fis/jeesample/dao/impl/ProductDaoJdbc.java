package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.ProductDao;
import edu.uan.fis.jeesample.dto.Product;
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
 * Product DAO implementation using JDBC
 */
public class ProductDaoJdbc implements ProductDao {
    
    public Product create(Product product) {
        // Sample code
        Connection conn = null;
         PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            // 3. Creates the product in the database
            String insertData= "INSERT INTO `tbl_product`( `id_product`, `nom_product`)  VALUES (?,?)";
            stmt = conn.prepareStatement(insertData);
            stmt.setInt(1,product.getProductId());
            stmt.setString(2,product.getName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return product;
    }
    
    public Product update(Product product) {
        
         Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "UPDATE tbl_product SET nom_product = ? WHERE id_product = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar producto en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.setString(1, "Burn uno");
            preparedStatement.setInt(2, 4);
// execute insert SQL stetement
            preparedStatement .executeUpdate();
            //stmt.executeUpdate("INSERT INTO tbl_product VALUES(" + product.getProductId() + ",'" + product.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return product;
    //}
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void delete(Product product) {
       Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "DELETE FROM tbl_product WHERE id_product = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar producto en la base de datos           
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 5);
// execute insert SQL stetement
            preparedStatement .executeUpdate();
            //stmt.executeUpdate("INSERT INTO tbl_product VALUES(" + product.getProductId() + ",'" + product.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Product findById(Integer productId) {
        Product producto=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "Select * FROM tbl_product WHERE id_product = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar producto en la base de datos
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 2);
// execute insert SQL stetement
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            producto=new Product();
         
            int idproduct=rs.getInt("id_product");
             
            String nombre=rs.getString("nom_product");
               
            producto.setProductId(idproduct);
             System.out.println(idproduct);
            producto.setName(nombre);
             System.out.println(nombre);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return producto;
    }
    
    public List<Product> findAll() {
        Product producto=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Product> productos = new ArrayList<Product>();

        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "Select * FROM tbl_product";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar producto en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            producto=new Product();
            producto.setProductId(rs.getInt("id_product"));
            producto.setName(rs.getString("nom_product"));
            productos.add(producto);
         
            int idproduct=rs.getInt("id_product");
             
            String nombre=rs.getString("nom_product");
              producto.setName(nombre);   
            producto.setProductId(idproduct);
             System.out.println(idproduct+" "+nombre);
                 
            }
            //stmt.executeUpdate("INSERT INTO tbl_product VALUES(" + product.getProductId() + ",'" + product.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return productos;
    }
}
