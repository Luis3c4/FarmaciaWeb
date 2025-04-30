<%-- 
    Document   : lista_usuarios
    Created on : 30 mar 2025, 1:44:13 p.m.
    Author     : luis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro usuario</title>
    </head>
    <body>
        <h2>Registro de Usuario</h2>
        <form action="UsuarioServlet" method="post">
            <label>Nombre:</label>
            <input type="text" name="nombre" required> <br>
            <label>email:</label>
            <input type="text" name="email" required><br>
            <label>contraseña:</label>
            <input type="text" name="password" required>
            <input type="submit" value="Registrar">
            <button onclick="window.location.href='UsuarioServlet'">Probar Servlet</button>
        </form>
    </body>
</html>
