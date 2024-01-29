<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Danh sách đấu giá</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="auctionList.css" type="text/css" >
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="index_1.jsp">
                    <img class="logo-header" src="image/logo.png" alt="" href="index.jsp" width="100" height="28" />
                </a>

                <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a>
            </div>

            <div id="navbarBasicExample" class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="index_1.jsp">
                        TRANG CHỦ
                    </a>

                    <a class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="news" name="action">
                                <span>TIN TỨC</span>
                            </button>
                        </form>
                    </a>

                    <a class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="rule" name="action">
                                <span>NỘI QUY</span>
                            </button>
                        </form>
                    </a>
                </div>

                <div class="navbar-end">
                    <div class="navbar-item">
                        <div class="navbar-container-1">
                            <form action="MainController" method="post">
                                <button class="navbar-1" type="submit" value="auctionList" name="action">
                                    <span>DS ĐẤU GIÁ</span>
                                </button>
                            </form>
                        </div>
                        <div class="navbar-container-1">
                            <form action="MainController" method="post">
                                <button class="navbar-1" type="submit" value="postNew" name="action">
                                    <span>ĐĂNG TIN</span>
                                </button>
                            </form>
                        </div>
                        <div class="navbar-container-1">
                            <a class="navbar-1">10.000.000</a>                  
                        </div>

                        <div class="navbar-item hover-down has-dropdown is-hoverable">
                            <a class="navbar-link navbar-1-list">
                                <c:choose>
                                    <c:when test="${not empty sessionScope.member}">
                                        ${sessionScope.member.fullname}
                                    </c:when>
                                    <c:when test="${not empty sessionScope.userGoogle}">
                                        ${sessionScope.userGoogle.given_name}
                                    </c:when>
                                    <c:otherwise>
                                        Guest
                                    </c:otherwise>
                                </c:choose>
                            </a>

                            <div class="fake-div"></div>

                            <div class="navbar-dropdown">
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="informationPage" name="action">
                                            <span>Thông tin tài khoản</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Danh mục đã đăng kí</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Lịch sử đấu giá</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Quản lí tin đăng</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="changePass" name="action">
                                            <span>Thay đổi mật khẩu</span>
                                        </button>
                                    </form>
                                </a>
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Thông tin thanh toán</span>
                                        </button>
                                    </form>
                                </a>

                                <hr class="navbar-divider">
                                <a class="navbar-item">
                                    <form action="MainController" method="post">
                                        <button type="submit" value="Logout" name="action">
                                            <span>Đăng xuất</span>
                                        </button>
                                    </form>
                                </a>

                            </div>
                        </div>



                    </div>
                </div>
            </div>
        </nav>

        <div class="list-auction-p-container" style="">
            <p class="list-auction-p">Danh sách đấu giá</p>
        </div>


        <c:if test="${empty auctions}">
            <p>No auctions available.</p>
        </c:if>

        <div class="register-modal-container">
            <c:if test="${not empty auctions}">
                <table class="table-container" border="1">
                    <thead>
                        <tr style="color: #fff;">
                            <th>STT</th>
                            <th>Tên dự án</th>
                            <th>Tỉnh, TP</th>
                            <th>Loại hình</th>
                            <th>Giá khởi điểm</th>
                            <th>Thời gian</th>
                            <th>Đăng kí</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:set var="rowNumber" value="1" />

                        <c:forEach var="listRE3" items="${requestScope.listRE3}">

                            <tr>
                                <td>${rowNumber}</td>
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
                                <c:set var="listRE3Status" value="Xem" />

                                <td>
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE3.realEstateID}">   
                                            <button id="button-xem">${listRE3Status}</button>
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </tr>

                            <c:set var="rowNumber" value="${rowNumber + 1}" />

                        </c:forEach>

                        <c:forEach var="listRE2" items="${requestScope.listRE2}">

                            <tr>
                                <td>${rowNumber}</td>
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

                                <c:set var="listRE2Status" value="Đăng Kí" />

                                <td>
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE2.realEstateID}">
                                            <button id="button-dangki">${listRE2Status}</button>
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </tr>

                            <c:set var="rowNumber" value="${rowNumber + 1}" />

                        </c:forEach>

                    </tbody>
                </table>
            </c:if>
        </div>
        <footer class="footer" style="margin-top: 10px"> 
            <div>
                <p class="footer_content1">CÔNG TY TNHH ĐẤU GIÁ BẤT ĐỘNG SẢN REAS</p>
                <div class="footer-container">
                    <div class="footer-left-content"> Liên hệ:<br/>
                        Email: reas@gmail.com<br/>
                        Điện thoại: +84 (24) 8888 9999<br/>
                        <br/>
                    </div>
                    <div class="footer-mid-content"> Trụ sở chính:<br/>
                        Lô E2a-7, Đường D1, Đ. D1, Long Thạnh Mỹ, Thành Phố Thủ Đức, Thành phố Hồ Chí Minh<br/>
                        <br/>
                    </div>
                    <img class="footer-right-content" src="image/bocongthuong.png" alt="" href="" width="100" height="28" />
                </div>
            </div>
        </footer>
    </body>
</html>
