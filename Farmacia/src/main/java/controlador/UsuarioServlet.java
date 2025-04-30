/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.ConexionDB;
import dao.UsuarioDAO;
import modelo.Usuario;

import java.io.IOException;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name="UsuarioServlet",urlPatterns = {"/usuarios"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Solicitud recibida en UsuarioServlet"); 

        //obtenemos los valores del los imputs enviados por el cliente
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        // nos conectamos a la base de datos
        Connection conn = null;
        try {
            conn = ConexionDB.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conn == null) {
            System.out.println(" ERROR: No se pudo conectar a la base de datos");
        } else {
            System.out.println(" Conexión exitosa a la base de datos");
        }
        // creamos una instancia de UsuarioDAO
        UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
        // creamos una instancia de Usuario
        Usuario usuario = new Usuario(0, nombre, email, password);

        if (usuarioDAO.registrar(usuario)) {
            //Esta línea redirige al usuario a otra página web (lista_usuarios.jsp) y envía un mensaje como parámetro en la URL.
            response.sendRedirect("lista_usuarios.jsp?mensaje=Registro exitoso");
        } else {
            response.sendRedirect("lista_usuarios.jsp?error=Error al registrar");
        }
    }
}
