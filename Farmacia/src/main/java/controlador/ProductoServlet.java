/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import modelo.Producto;

@WebServlet(name="ProductoServlet",urlPatterns = {"/productos"})
public class ProductoServlet extends HttpServlet{
    private ProductoDAO productoDAO = new ProductoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Producto> productos= productoDAO.listar();
        //Se guarda la lista de productos en el objeto request
        req.setAttribute("productos", productos);
        //Se indica la ruta del archivo JSP que va a renderizar (mostrar) la información.
        req.getRequestDispatcher("/WEB-INF/views/listadoProductos.jsp").forward(req, resp);
    }
    
    
}
