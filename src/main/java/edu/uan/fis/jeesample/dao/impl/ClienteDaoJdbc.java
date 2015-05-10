/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.ClienteDao;
import edu.uan.fis.jeesample.dto.Cliente;
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

public class ClienteDaoJdbc implements ClienteDao {
    
    public Cliente create(Cliente cliente) {
        // Sample code
        Connection conn = null;
         PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            // 3. Creates the cliente in the database
            String insertData= "INSERT INTO `tbl_cliente`(`nom_cliente`, `user`, `password`)  VALUES (?,?,?)";
            stmt = conn.prepareStatement(insertData);
            //stmt.setInt(1,cliente.getClienteId());
            stmt.setString(1,cliente.getName());
            stmt.setString(2,cliente.getUser());
            stmt.setString(3,cliente.getPassword());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }
    
    public Cliente update(Cliente cliente) {
        
         Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "UPDATE tbl_cliente SET nom_cliente = ? WHERE id_cliente = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar cliente en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.setString(1, "Burn uno");
            preparedStatement.setInt(2, 4);
// execute insert SQL stetement
            preparedStatement .executeUpdate();
            //stmt.executeUpdate("INSERT INTO tbl_cliente VALUES(" + cliente.getClienteId() + ",'" + cliente.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    //}
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void delete(Cliente cliente) {
       Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "DELETE FROM tbl_cliente WHERE id_cliente = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar cliente en la base de datos           
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 5);
// execute insert SQL stetement
            preparedStatement .executeUpdate();
            //stmt.executeUpdate("INSERT INTO tbl_cliente VALUES(" + cliente.getClienteId() + ",'" + cliente.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Cliente findById(Integer clienteId) {
        Cliente cliente=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "Select * FROM tbl_cliente WHERE id_cliente = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar cliente en la base de datos
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 2);
// execute insert SQL stetement
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            cliente=new Cliente();
         
            int idcliente=rs.getInt("id_cliente");
             
            String nombre=rs.getString("nom_cliente");
               
            cliente.setClienteId(idcliente);
             System.out.println(idcliente);
            cliente.setName(nombre);
             System.out.println(nombre);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }
    
    public List<Cliente> findAll() {
        Cliente cliente=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "Select * FROM tbl_cliente";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar cliente en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            cliente=new Cliente();
            cliente.setClienteId(rs.getInt("id_cliente"));
            cliente.setName(rs.getString("nom_cliente"));
            clientes.add(cliente);
         
            int idcliente=rs.getInt("id_cliente");             
            String nombre=rs.getString("nom_cliente");
            String usuario=rs.getString("user");
            cliente.setName(nombre);  
            cliente.setUser(usuario);
            cliente.setClienteId(idcliente);
             System.out.println("ID: "+idcliente+" Nombre Cliente: "+nombre+" Nombre de Usuario: "+usuario);
                 
            }
            //stmt.executeUpdate("INSERT INTO tbl_cliente VALUES(" + cliente.getClienteId() + ",'" + cliente.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientes;
    }
}


