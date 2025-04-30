<%-- 
    Document   : lista_usuarios
    Created on : 30 mar 2025, 1:49:58 p.m.
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.ConexionDB, dao.UsuarioDAO, modelo.Usuario, java.util.List, java.sql.Connection" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>lista de usuarios</title>
    </head>
    <body>
        <h2>Lista de Usuarios</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Email</th>
                </tr>
            </thead
            <%
                Connection conn = ConexionDB.conectar();
                UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
                List<Usuario> usuariosl = usuarioDAO.listar();
                for (Usuario u : usuariosl) {
            %>
            <tbody>
                <tr>
                    <td><%= u.getId() %></td>
                    <td><%= u.getNombre() %></td>
                    <td><%= u.getEmail() %></td>
                </tr>
            </tbody>
            <% } %>
        </table>

    </body>
</html>
