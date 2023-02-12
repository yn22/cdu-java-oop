<%@ page import="com.example.lab8.servlet.MainServlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Store</title>
    <style>
        td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Woods</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>density</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${data.woods}" var="wood">
        <tr>
            <td><c:out value="${wood.id}"/></td>
            <td><c:out value="${wood.name}"/></td>
            <td><c:out value="${wood.density}"/></td>
            <td>
                <form action="${pageContext.request.contextPath}/wood" method="post">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${wood.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <form action="${pageContext.request.contextPath}/wood" method="post">
            <input type="hidden" name="action" value="save"/>
            <td></td>
            <td>
                <input type="text" name="name"/>
            </td>
            <td>
                <input type="text" name="density"/>
            </td>
            <td>
                <input type="submit" value="Add"/>
            </td>
        </form>
</table>
<h1>Products</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Type</th>
        <th>Wood Name</th>
        <th>Weight</th>
        <th>Volume</th>
        <th>Length</th>
        <th>Width</th>
        <th>Height</th>
        <th>Diameter</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${data.products}" var="product">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.type}"/></td>
            <td><c:out value="${product.wood.name}"/></td>
            <td><c:out value="${product.weight}"/></td>
            <td><c:out value="${product.volume}"/></td>
            <td><c:out value="${product.length}"/></td>
            <td><c:out value="${product.width}"/></td>
            <td><c:out value="${product.height}"/></td>
            <td><c:out value="${product.diameter}"/></td>
            <td>
                <form action="${pageContext.request.contextPath}/product" method="post">
                    <input type="hidden" name="id" value="${product.id}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <form action="${pageContext.request.contextPath}/product" method="post">
            <input type="hidden" name="action" value="save"/>
            <td></td>
            <td>
                <select name="type">
                    <option value="CYLINDER">Cylinder</option>
                    <option value="TIMBER">Timber</option>
                </select>
            </td>
            <td>
                <select name="woodId">
                    <c:forEach items="${data.woods}" var="wood">
                        <option value="${wood.id}">${wood.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td style="border: 1px dashed black;"></td>
            <td style="border: 1px dashed black;"></td>
            <td>
                <input type="text" name="length"/>
            </td>
            <td>
                <input type="text" name="width"/>
            </td>
            <td>
                <input type="text" name="height"/>
            </td>
            <td>
                <input type="text" name="diameter"/>
            </td>
            <td>
                <input type="submit" value="Add"/>
            </td>
        </form>
    </tr>
</table>
<h1>Waste (total weight: <c:out value="${data.wasteWeight}"/> kg)</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Weight</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${data.waste}" var="waste">
        <tr>
            <td><c:out value="${waste.id}"/></td>
            <td><c:out value="${waste.weight}"/></td>
            <td>
                <form action="${pageContext.request.contextPath}/waste" method="post">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="id" value="${waste.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
        </tr>
    </c:forEach>
    <tr>
        <form action="${pageContext.request.contextPath}/waste" method="post">
            <input type="hidden" name="action" value="save"/>
            <td></td>
            <td>
                <input type="text" name="weight"/>
            </td>
            <td>
                <input type="submit" value="Add"/>
            </td>
        </form>
    </tr>
</table>
</body>
</html>