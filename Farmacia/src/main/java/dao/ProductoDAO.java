/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author user
 */
public class ProductoDAO {

    public List<Producto> listar() {
        //aqui guardaremos los porductos que obtendremos de la consulta sql
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery();) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setImage(rs.getString("image"));
                productos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;

    }
    // conuslta sql para obetener un producto por el id y poder enviar a un nuevo formulario
    public Producto obtenerPorId(int id) {
        Producto producto = null;
        String sql = "SELECT * FROM productos WHERE id=?";
        try (Connection con = ConexionDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getInt("stock"),
                            rs.getString("image")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return producto;
    }
    
    public void actualizarProducto(Producto p){
        
    }
    
    public void eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";

        try (Connection con = ConexionDB.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}
