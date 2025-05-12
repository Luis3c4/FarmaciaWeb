/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //retorna null si no hay una sesion activa
        HttpSession session = request.getSession(false);
        // Si ya existe una sesión, redirigir a la página principal
        if (session != null && session.getAttribute("usuario") != null) {
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
            return;
        }
        // Si hay un mensaje de error, agregarlo al request
        String error = request.getParameter("error");
        if (error != null) {
            request.setAttribute("errorMessage", "Credenciales inválidas. Por favor intente de nuevo.");
        }
        // Redirigir a la página de login
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("password");
        if ("admin".equals(usuario) && "123".equals(clave)) {
            // Obtener o crear la sesión del usuario
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            session.setAttribute("rol", "admin");
            request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Credenciales inválidas. Por favor intente de nuevo.");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }

}
