
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-primary mb-4">✏️ Editar Producto</h2>
    <form action="EditarProductoServlet" method="post">
        <input type="hidden" name="id" value="${producto.id}"/>

        <div class="mb-3">
            <label class="form-label">Nombre:</label>
            <input type="text" name="nombre" class="form-control" value="${producto.nombre}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Precio:</label>
            <input type="number" step="0.01" name="precio" class="form-control" value="${producto.precio}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Stock:</label>
            <input type="number" name="stock" class="form-control" value="${producto.stock}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Imagen:</label>
            <input type="text" name="imagen" class="form-control" value="${producto.image}">
        </div>

        <button type="submit" class="btn btn-success">Guardar Cambios</button>
        <a href="/WEB-INF/views/listadoProductos.jsp" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>
