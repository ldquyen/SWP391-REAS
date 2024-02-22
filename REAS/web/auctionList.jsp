<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


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
                                    <form action="MemberController" method="post">
                                        <button type="submit" value="dangkiroom" name="action">
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

        <form action="MemberController" method="post" style="margin: 0 auto; width: 40%; margin-top: 20px">
            <div class="field has-addons">
                <div class="search-detail-container">
                    <div class="control">
                        <div class="select">
                            <select class="custom-select" name="loaihinhbds">
                                <option value="">Loại hình BĐS</option>
                                <c:forEach var="locCategory" items="${sessionScope.CATEGORYLIST}">
                                    <option value="${locCategory.catID}" <c:if test="${loaihinhbds eq locCategory.catID}">selected</c:if>>${locCategory.catName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="select" >
                            <select class="custom-select" name="thanhpho">
                                <option value="">Thành phố</option>
                                <c:forEach var="locCity" items="${sessionScope.CITYLIST}">
                                    <option value="${locCity.cityID}" <c:if test="${thanhpho eq locCity.cityID }">selected</c:if>>${locCity.cityName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="select">
                            <select class="custom-select" name="mucgia">
                                <option value="">Mức giá</option>
                                <option value="ASC" <c:if test="${mucgia == 'ASC'}">selected</c:if>>Tăng dần</option>
                                <option value="DESC" <c:if test="${mucgia == 'DESC'}">selected</c:if>>Giảm dần</option>

                                </select>
                            </div>
                        </div>

                    </div>
                    <div class="control button-search-container">
                        <button class="button is-info button-search" type="submit" value="filterInNews" name="action">
                            Lọc
                        </button>
                    </div>
                </div>
            </form>

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
                            <th>Giá mua ngay</th>
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
                                <td class="test">${listRE3.pricePaid}</td>
                                <td class="auctionTimeStart">
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE3.realEstateID}">
                                            <p style="display: none;">${auctions.timeStart}</p>
                                        </c:if>
                                    </c:forEach>
                                </td>


                                <td>
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE3.realEstateID}">
                                            <form action="MemberController" method="post">
                                                <input type="hidden" name="idRE3" value="${auctions.realEstateID eq listRE3.realEstateID}">
                                                <button class="button-xem" type="submit" value="xemroom" name="action">
                                                    <span>Xem</span>
                                                </button>
                                            </form>
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
                                <td class="test">${listRE2.pricePaid}</td>
                                <td class="auctionTimeStart">
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE2.realEstateID}">
                                            <p style="display: none;">${auctions.timeStart}</p>
                                        </c:if>
                                    </c:forEach>
                                </td>




                                <td>
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE2.realEstateID}">
                                            <form action="MemberController" method="post">
                                                <button class="button-dangki" type="submit" value="dangkiroom" name="action">
                                                    <span>Đăng Kí</span>
                                                </button>
                                            </form>
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

        <script>
            var auctionTimeStartElements = document.querySelectorAll(".auctionTimeStart");

            function formatDateTime(originalDateTime) {
                // Remove leading and trailing quotes from the original datetime string
                originalDateTime = originalDateTime.replace(/^"|"$/g, '');

                // Parse the original datetime string
                var dateTimeParts = originalDateTime.split('T');
                var datePart = dateTimeParts[0];
                var timePart = dateTimeParts[1].split(':');

                var yearMonthDay = datePart.split('-');
                var year = parseInt(yearMonthDay[0]);
                var month = parseInt(yearMonthDay[1]);
                var day = parseInt(yearMonthDay[2]);

                // Check if year, month, or day parsing failed
                if (isNaN(year) || isNaN(month) || isNaN(day)) {
                    console.error("Failed to parse year, month, or day:", yearMonthDay);
                    return ""; // Return an empty string to indicate failure
                }

                var hours = parseInt(timePart[0]);
                var minutes = parseInt(timePart[1]);
                var seconds = 0; // Mặc định giây là 0
                if (timePart.length > 2 && timePart[2].length >= 2) {
                    seconds = parseInt(timePart[2].substring(0, 2)); // Extract seconds and convert to integer
                }


                // Get the month name
                var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
                var monthName = monthNames[month - 1]; // Month is 0-indexed in JavaScript

                // Format the datetime string
                var formattedDateTime = monthName + ' ' + day + ', ' + year + ' ' +
                        hours + ':' + minutes + ':' + seconds;

                return formattedDateTime;
            }

            function startCountdown(element) {
                var originalDateTime = '"' + element.textContent.trim() + '"';
                var formattedDateTime = formatDateTime(originalDateTime);
                var countDownDate = new Date(formattedDateTime).getTime();

                var x = setInterval(function () {
                    var now = new Date().getTime();
                    var distance = countDownDate - now;
                    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
                    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                    var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                    var countdownDisplay = "";
                    if (days > 0) {
                        countdownDisplay += days + " ngày ";
                    }
                    countdownDisplay += (hours < 10 ? "0" : "") + hours + ":" +
                            (minutes < 10 ? "0" : "") + minutes + ":" +
                            (seconds < 10 ? "0" : "") + seconds;

                    element.innerHTML = countdownDisplay;

                    if (distance <= 0) {
                        clearInterval(x);
                        element.innerHTML = "<span class='glow' style='color: #00ff00;'>Đấu giá đang diễn ra</span>";
                    }
                }, 1000);
            }

            auctionTimeStartElements.forEach(function (element) {
                startCountdown(element);
            });
        </script>
    </body>
</html>
