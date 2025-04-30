<%-- 
    Document   : listadoProductos
    Created on : 5 abr. 2025, 11:03:30 a. m.
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>listado productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .table img {
                border-radius: 8px;
                object-fit: cover;
            }
            .titulo {
                margin-top: 40px;
                margin-bottom: 30px;
            }
        </style>
    </head>
    <body>
        <div class="container">
        <h2 class="text-center text-primary titulo">🧪 Productos de Farmacia</h2>

        <div class="table-responsive">
            <table class="table table-bordered table-hover align-middle shadow-sm bg-white">
                <thead class="table-primary text-center">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Precio (S/)</th>
                        <th>Stock</th>
                        <th>Imagen</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${productos}" var="p">
                        <tr>
                            <td class="text-center">${p.id}</td>
                            <td>${p.nombre}</td>
                            <td>S/ ${p.precio}</td>
                            <td class="text-center">${p.stock}</td>
                            <td class="text-center">
                                <img src="${pageContext.request.contextPath}/resources/${p.image}" 
                                     alt="${p.image}" width="100" height="80" />
                            </td>
                            <td class="text-center">
                                <a href="EditarProductoServlet?id=${p.id}" class="btn btn-sm btn-warning me-2">
                                    <i class="bi bi-pencil-square"></i> Editar
                                </a>
                                <a href="EliminarProductoServlet?id=${p.id}" class="btn btn-sm btn-danger" 
                                   onclick="return confirm('¿Estás seguro de eliminar este producto?');">
                                    <i class="bi bi-trash"></i> Eliminar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    </body>
</html>
