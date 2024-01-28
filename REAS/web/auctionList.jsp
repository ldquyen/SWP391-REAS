<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Auctions</title>
</head>
<body>

    <h2>List of Auctions</h2>

    <c:if test="${empty auctions}">
        <p>No auctions available.</p>
    </c:if>

    <c:if test="${not empty auctions}">
        <table border="1">
            <thead>
                <tr>
                    <th>Auction ID</th>
                    <th>Real Estate ID</th>
                    <th>Auction Name</th>
                    <th>Price Now</th>
                    <th>Lamda</th>
                    <th>Time Start</th>
                    <th>Time End</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="auction" items="${auctions}">
                    <tr>
                        <td>${auction.auctionID}</td>
                        <td>${auction.realEstateID}</td>
                        <td>${auction.auctionName}</td>
                        <td>${auction.priceNow}</td>
                        <td>${auction.lamda}</td>
                        <td>${auction.timeStart}</td>
                        <td>${auction.timeEnd}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

</body>
</html>
