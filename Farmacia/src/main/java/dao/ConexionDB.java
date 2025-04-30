/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
//JNDI todavía permanece en javax.*
import javax.sql.DataSource;            
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ConexionDB {
    public static Connection getConnection() throws SQLException {
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/farmaciaDB");
            return ds.getConnection(); // Usa el pool de conexiones
        } catch (Exception e) {
            throw new SQLException("Error al conectar con JNDI", e);
        }
    }
}
