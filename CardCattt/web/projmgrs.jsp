<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Product Maintenance</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
    </head>
    <body>
        <h1>Products</h1>
        <table>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th class="right">Price</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="p" items="${projects}">
            <tr>
                <td>${p.projid}</td>
                <td>${p.startdate}</td>
                <td class="right">${p.payplan}</td>
                <td>
                    <a href="<c:url value='/productMaint?action=displayProduct&productCode=${p.projid}'/>">Edit</a>
                </td>
                <td>
                    <a href="<c:url value='/productMaint?action=deleteProduct&productCode=${p.projid}'/>">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <form action="<c:url value='/productMaint'/>" method="get" class="pad_top">
            <input type="hidden" name="action" value="addProduct">
            <input type="submit" value="Add Product">
        </form>
    </body>
</html>