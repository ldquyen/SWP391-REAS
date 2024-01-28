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


                    <c:forEach var="listRE2" items="${requestScope.listRE2}">

                        <tr>
                            <td>${listRE2.realEstateID}</td>
                            <td>${listRE2.realEstateName}</td>
                            <td>
                                <c:forEach var="cityList" items="${requestScope.city}"> 
                                    <c:if test="${cityList.cityID eq listRE2.cityID}">
                                        ${cityList.cityName}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach var="catList" items="${requestScope.category}"> 
                                    <c:if test="${catList.catID eq listRE2.catID}">
                                        ${catList.catName}
                                    </c:if>
                                </c:forEach>
                            </td>


                            <td>${listRE2.priceFirst}</td>
                            
                             <td>
                                <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                    <c:if test="${auctions.realEstateID eq listRE2.realEstateID}">
                                        ${auctions.timeStart}
                                    </c:if>
                                </c:forEach>
                            </td>




                        </tr>
                    </c:forEach>

                    <c:forEach var="listRE3" items="${requestScope.listRE3}">

                        <tr>
                            <td>${listRE3.realEstateID}</td>
                            <td>${listRE3.realEstateName}</td>
                            <td>
                                <c:forEach var="cityList" items="${requestScope.city}"> 
                                    <c:if test="${cityList.cityID eq listRE3.cityID}">
                                        ${cityList.cityName}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>
                                <c:forEach var="catList" items="${requestScope.category}"> 
                                    <c:if test="${catList.catID eq listRE3.catID}">
                                        ${catList.catName}
                                    </c:if>
                                </c:forEach>
                            </td>

                            

                            <td>${listRE3.priceFirst}</td>

                            <td>
                                <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                    <c:if test="${auctions.realEstateID eq listRE3.realEstateID}">
                                        ${auctions.timeStart}
                                    </c:if>
                                </c:forEach>
                            </td>


                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

    </body>
</html>
