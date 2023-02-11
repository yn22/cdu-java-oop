<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Waste List</title>
</head>
<body>
<h1>Waste List</h1>
<table border="1">
    <tr>
        <th>Weight</th>
    </tr>
    <c:forEach items="${waste}" var="wasteItem">
        <tr>
            <td>${wasteItem.weight}</td>
        </tr>
    </c:forEach>
</table>
<h2>Total Weight</h2>
<p>${totalWeight}</p>
</body>
</html>
