<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Client Maintenance</title>
        <link rel="stylesheet" href="<c:url value='/styles/main.css'/> ">
    </head>
    <body>
        <h1>Clients</h1>
        <table>
            <tr>
                <th>Code</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Address</th>
                <th>Phone Number</th>
                <th>Insurance Carrier</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="c" items="${clients}">
            <tr>
                <td>${c.clientID}</td>
                <td>${c.firstName}</td>
                <td>${c.lastName}</td>
                <td>${c.emailAddress}</td>
                <td>${c.phoneNumber}</td>
                <td>${c.insuranceCarrier}</td>
                <td>
                    <a href="<c:url value='/clientMaint?action=displayClient&clientID=${c.clientID}'/>">Edit</a>
                </td>
                <td>
                    <a href="<c:url value='/clientMaint?action=deleteClient&clientID=${c.clientID}'/>">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <form action="<c:url value='/clientMaint'/>" method="get" class="pad_top">
            <input type="hidden" name="action" value="addClient">
            <input type="submit" value="Add Client">
        </form>
    </body>
</html>