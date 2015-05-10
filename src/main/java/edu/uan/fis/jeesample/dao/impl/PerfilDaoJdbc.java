
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.PerfilDao;
import edu.uan.fis.jeesample.dto.Perfil;
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
 * Perfil DAO implementation using JDBC
 */
public class PerfilDaoJdbc implements PerfilDao {
    
    public Perfil create(Perfil perfil) {
        // Sample code
        Connection conn = null;
         PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            // 3. Creates the perfil in the database
            String insertData= "INSERT INTO `tbl_perfil`( `id_perfil`, `nom_perfil`)  VALUES (?,?)";
            stmt = conn.prepareStatement(insertData);
            stmt.setInt(1,perfil.getPerfilId());
            stmt.setString(2,perfil.getName());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return perfil;
    }
    
    public Perfil update(Perfil perfil) {
        
         Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "UPDATE tbl_perfil SET nom_perfil = ? WHERE id_perfil = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar perfilo en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.setString(1, "Burn uno");
            preparedStatement.setInt(2, 4);
// execute insert SQL stetement
            preparedStatement .executeUpdate();
            //stmt.executeUpdate("INSERT INTO tbl_perfil VALUES(" + perfil.getPerfilId() + ",'" + perfil.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return perfil;
    //}
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void delete(Perfil perfil) {
       Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "DELETE FROM tbl_perfil WHERE id_perfil = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar perfilo en la base de datos           
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 5);
// execute insert SQL stetement
            preparedStatement .executeUpdate();
            //stmt.executeUpdate("INSERT INTO tbl_perfil VALUES(" + perfil.getPerfilId() + ",'" + perfil.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Perfil findById(Integer perfilId) {
        Perfil perfilo=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "Select * FROM tbl_perfil WHERE id_perfil = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar perfilo en la base de datos
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 2);
// execute insert SQL stetement
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            perfilo=new Perfil();
         
            int idperfil=rs.getInt("id_perfil");
             
            String nombre=rs.getString("nom_perfil");
               
            perfilo.setPerfilId(idperfil);
             System.out.println(idperfil);
            perfilo.setName(nombre);
             System.out.println(nombre);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return perfilo;
    }
    
    public List<Perfil> findAll() {
        Perfil perfilo=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Perfil> perfilos = new ArrayList<Perfil>();

        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "Select * FROM tbl_perfil";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar perfilo en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            perfilo=new Perfil();
            perfilo.setPerfilId(rs.getInt("id_perfil"));
            perfilo.setName(rs.getString("nom_perfil"));
            perfilos.add(perfilo);
         
            int idperfil=rs.getInt("id_perfil");
             
            String nombre=rs.getString("nom_perfil");
              perfilo.setName(nombre);   
            perfilo.setPerfilId(idperfil);
             System.out.println(idperfil+" "+nombre);
                 
            }
            //stmt.executeUpdate("INSERT INTO tbl_perfil VALUES(" + perfil.getPerfilId() + ",'" + perfil.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(PerfilDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return perfilos;
    }
}
