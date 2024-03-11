<%-- 
    Document   : rulefix
    Created on : Mar 12, 2024, 2:14:45 AM
    Author     : TRUONG SON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rule Edit</title>
</head>
<body>
    <h1>Rules</h1>
    <table border="1">
        <tr>
            <th>Rule ID</th>
            <th>Rule Detail</th>
            <th>Account ID</th>
            <th>Modify Time</th>
        </tr>
        <c:forEach var="rule" items="${rulelist}">
            <tr>
                <td>${rule.ruleID}</td>
                <td>${rule.ruleDetail}</td>
                <td>${rule.accID}</td>
                <td>${rule.modifyTime}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
