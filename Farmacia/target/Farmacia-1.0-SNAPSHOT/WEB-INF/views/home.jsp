<%-- 
    Document   : home
    Created on : 7 may. 2025, 4:27:48 p. m.
    Author     : user
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home - Área Segura</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        header {
            background-color: #333;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .user-info {
            display: flex;
            align-items: center;
        }
        .user-name {
            margin-right: 15px;
        }
        .logout-btn {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
            border-radius: 3px;
            text-decoration: none;
        }
        .welcome-message {
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }
        h1 {
            color: #333;
        }
    </style>
</head>
<body>
    <%-- Verificar si el usuario está logueado --%>
    <c:if test="${empty sessionScope.usuario}">
        <c:redirect url="/login"/>
    </c:if>
    
    <header>
        <h2>Mi Aplicación</h2>
        <div class="user-info">
            <span class="user-name">Bienvenido, ${sessionScope.usuarioNombre}</span>
            <a href="${pageContext.request.contextPath}/logout" class="logout-btn">Cerrar Sesión</a>
        </div>
    </header>
    
    <div class="container">
        <div class="welcome-message">
            <h1>Bienvenido al área segura</h1>
            <p>Has iniciado sesión correctamente. Esta área está protegida y solo es accesible para usuarios autenticados.</p>
            
            <c:if test="${sessionScope.usuarioRol eq 'admin'}">
                <div class="admin-section">
                    <h3>Opciones de Administrador</h3>
                    <p>Tienes acceso a funciones de administración.</p>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/secured/admin/usuarios.jsp">Gestionar Usuarios</a></li>
                        <li><a href="${pageContext.request.contextPath}/secured/admin/configuracion.jsp">Configuración del Sistema</a></li>
                    </ul>
                </div>
            </c:if>
        </div>
    </div>
</body>
</html>
