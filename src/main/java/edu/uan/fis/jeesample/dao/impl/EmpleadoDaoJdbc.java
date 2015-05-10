package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.EmpleadoDao;
import edu.uan.fis.jeesample.dto.Empleado;
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

public class EmpleadoDaoJdbc implements EmpleadoDao {
    
    public Empleado create(Empleado empleado) {
        // Sample code
        Connection conn = null;
         PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            // 3. Creates the empleado in the database
            String insertData= "INSERT INTO `tbl_empleado`(`nom_empleado`, `user`, `password`,`id_perfil`)  VALUES (?,?,?,?)";
            stmt = conn.prepareStatement(insertData);
            
            stmt.setString(1,empleado.getName());
            stmt.setString(2,empleado.getUser());
            stmt.setString(3,empleado.getPassword());
            stmt.setInt(4,empleado.getEmpleadoId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleado;
    }
    
    public Empleado update(Empleado empleado) {
        
         Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "UPDATE tbl_empleado SET nom_empleado = ? WHERE id_empleado = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar empleado en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.setString(1, "Empleado mes");
            preparedStatement.setInt(2, 4);
// execute insert SQL stetement
            preparedStatement .executeUpdate();
            //stmt.executeUpdate("INSERT INTO tbl_empleado VALUES(" + empleado.getEmpleadoId() + ",'" + empleado.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleado;
    //}
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void delete(Empleado empleado) {
       Connection conn = null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "DELETE FROM tbl_empleado WHERE id_empleado = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar empleado en la base de datos           
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 5);
// execute insert SQL stetement
            preparedStatement .executeUpdate();
            //stmt.executeUpdate("INSERT INTO tbl_empleado VALUES(" + empleado.getEmpleadoId() + ",'" + empleado.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Empleado findById(Integer empleadoId) {
        Empleado empleado=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "Select * FROM tbl_empleado WHERE id_empleado = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar empleado en la base de datos
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            //preparedStatement.setString(1, 1);
            preparedStatement.setInt(1, 2);
// execute insert SQL stetement
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            empleado=new Empleado();
         
            int idempleado=rs.getInt("id_empleado");
             
            String nombre=rs.getString("nom_empleado");
               
            empleado.setEmpleadoId(idempleado);
             System.out.println(idempleado);
            empleado.setName(nombre);
             System.out.println(nombre);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleado;
    }
    
    public List<Empleado> findAll() {
        Empleado empleado=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Empleado> empleados = new ArrayList<Empleado>();

        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/catalogotienda?" + "user=root&password=admin");
            String updateTableSQL = "Select * FROM tbl_empleado";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar empleado en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            empleado=new Empleado();
            empleado.setEmpleadoId(rs.getInt("id_empleado"));
            empleado.setName(rs.getString("nom_empleado"));
            empleados.add(empleado);
         
            int idempleado=rs.getInt("id_empleado");             
            String nombre=rs.getString("nom_empleado");
            String usuario=rs.getString("user");
            int idperfil=rs.getInt("id_perfil"); 
            empleado.setName(nombre);  
            empleado.setUser(usuario);
            empleado.setEmpleadoId(idempleado);
            empleado.setPerfilId(idperfil);
             System.out.println("ID: "+idempleado+" Nombre Empleado: "+nombre+" Nombre de Usuario: "+usuario+" Perfil: "+idperfil);
                 
            }
            //stmt.executeUpdate("INSERT INTO tbl_empleado VALUES(" + empleado.getEmpleadoId() + ",'" + empleado.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empleados;
    }
}



