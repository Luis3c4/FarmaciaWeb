/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean registrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email, password) VALUES (?, ?, ?)";
        // se usa preparedStatement por que preconpila(solo se conpila una vez)
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getPassword());
            //si afecta una fila o varias retorna true
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(" Error al registrar usuario: " + e.getMessage());

            // cambiar en produccion
            e.printStackTrace();
            return false;
        }
    }

    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        // se usa Statement por que es una consulta estatica no recive valores
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                //se agrega a la lista todos los usuarios
                usuarios.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }
        } catch (Exception e) {
            //cambiar en produccion
            e.printStackTrace();
        }
        return usuarios;
    }
}
