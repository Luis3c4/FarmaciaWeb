<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Test JSTL</title>
</head>
<body>
    <h1>JSTL Test</h1>
    <c:forEach var="i" begin="1" end="3">
        <p>Iteración ${i}</p>
    </c:forEach>
</body>
</html>