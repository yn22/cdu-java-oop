<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="products" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="woods" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="waste" class="java.util.ArrayList" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<%--    include styles.css--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <title>Product Store</title>
</head>
<body>

<h1>Woods</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>density</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${woods}" var="wood">
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
<table border="1">
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
    <c:forEach items="${products}" var="product">
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
                    <c:forEach items="${woods}" var="wood">
                        <option value="${wood.id}">${wood.name}</option>
                    </c:forEach>
                </select>
            </td>
            <td class="dashed"></td>
            <td class="dashed"></td>
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
<h1>Waste (total weight: <c:out value="${wasteWeight}"/> kg)</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Weight</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${waste}" var="waste">
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