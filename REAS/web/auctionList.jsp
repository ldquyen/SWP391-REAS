<%@page import="dto.Wallet"%>
<%@page import="dao.WalletDAO"%>
<%@page import="java.util.List"%>
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
                <a class="navbar-item">
                    <form action="MainController" method="post">
                        <button type="submit" value="homeindex_1" name="action">
                            <img class="logo-header" src="image/logo.png" alt="" href="" width="100" height="28" />
                        </button>
                    </form>
                </a>
                <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a>
            </div>

            <div id="navbarBasicExample" class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="homeindex_1" name="action">
                                <span>TRANG CHỦ</span>
                            </button>
                        </form>
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
                                    <span>DANH SÁCH ĐẤU GIÁ</span>
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
                            <form action="MainController" method="post">
                                <button class="navbar-1" type="submit" value="naptien" name="action">
                                    <span>NẠP TIỀN</span>
                                </button>
                            </form>
                        </div>
                        <%
                            List<Wallet> wallet = new WalletDAO().getWallet();
                            pageContext.setAttribute("walletAccount", wallet);
                        %>
                        <div class="navbar-container-1">
                            <a class="navbar-1">SỐ DƯ :
                                <c:forEach var="wallet" items="${walletAccount}">
                                    <c:if test="${wallet.accID eq member.accID}">
                                        <span class="list-auction-p-1">${wallet.accountBalance}</span>
                                    </c:if>
                                </c:forEach>
                                (xu)
                            </a>                  
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
                                    <form action="MemberController" method="post">
                                        <button type="submit" value="mypost" name="action">
                                            <input type="hidden" value="${sessionScope.member.accID}" name="mypostID">
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
                                        <button type="submit" value="lichsunaptien" name="action">
                                            <span>Lịch sử nạp tiền</span>
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
                            <th>Giá mua ngay</th>
                            <th>Thời gian bắt đầu</th>
                            <th>Thời gian kết thúc</th>
                            <th>Xem</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:set var="rowNumber" value="1" />

                        <c:forEach var="listRE3" items="${requestScope.listRE3}">

                            <tr>
                                <td>${rowNumber}</td>
                                <td>${fn:toUpperCase(listRE3.realEstateName)}</td>
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
                                <td>
                                    <script>
                                        var number = ${listRE3.priceFirst}; // Assuming auctions.lamda contains the number
                                        var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                        document.write(formattedNumber);
                                    </script>
                                </td>
                                <td class="test">
                                    <script>
                                        var number = ${listRE3.pricePaid}; // Assuming auctions.lamda contains the number
                                        var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                        document.write(formattedNumber);
                                    </script>
                                </td>
                                <td class="auctionTimeStart">
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE3.realEstateID}">
                                            <p style="display: none;">${auctions.timeStart}</p>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="auctionTimeEnd">
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE3.realEstateID}">
                                            <p style="display: none;">${auctions.timeEnd}</p>
                                        </c:if>
                                    </c:forEach>
                                </td>


                                <td>
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE3.realEstateID}">
                                            <form action="MemberController" method="post">
                                                <input type="hidden" name="idRE3" value="${listRE3.realEstateID}">
                                                <!--onclick="logCurrentTime()-->
                                                <button class="button-xem" type="submit" value="xemroom" name="action" ">
                                                    <span>Đấu giá</span>
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
                                <td>
                                    <script>
                                        var number = ${listRE2.priceFirst}; // Assuming auctions.lamda contains the number
                                        var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                        document.write(formattedNumber);
                                    </script>
                                </td>
                                <td class="test">
                                    <script>
                                        var number = ${listRE2.pricePaid}; // Assuming auctions.lamda contains the number
                                        var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                        document.write(formattedNumber);
                                    </script>
                                </td>
                                <td class="auctionTimeStart">
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE2.realEstateID}">
                                            <p style="display: none;">${auctions.timeStart}</p>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="auctionTimeEnd">
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE2.realEstateID}">
                                            <p style="display: none;">${auctions.timeEnd}</p>
                                        </c:if>
                                    </c:forEach>
                                </td>




                                <td>
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq listRE2.realEstateID}">
                                            <form action="MainController">
                                                <input type="hidden" name="id" value="${listRE2.realEstateID}">
                                                <button class="button-dangki" type="submit" value="viewPostRealEstate" name="action">
                                                    <span>Xem chi tiết</span>
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
        <%--
                <form class="auctionForm" action="MemberController" method="post">
                    <button id="submitButton" type="submit" value="stastus2tostatus3" name="action">
                        <c:if test="${not empty auctions}">
                            <c:forEach var="listRE2" items="${requestScope.listRE2}">
                                <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                    <c:if test="${auctions.realEstateID eq listRE2.realEstateID}">
                                        <input type="hidden" name="idAuction2to3" value="${auctions.realEstateID}">
                                        <p>Test</p>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </c:if> 
                    </button>
                </form>
        --%>

        <c:if test="${not empty auctions}">
            <c:forEach var="listRE2" items="${requestScope.listRE2}">
                <c:forEach var="auctions" items="${requestScope.auctions}"> 
                    <c:if test="${auctions.realEstateID eq listRE2.realEstateID}">
                        <form action="MemberController" method="post">
                            <button id="${auctions.realEstateID}" type="submit" value="stastus2tostatus3" name="action">
                                <input type="hidden" name="idAuction2to3" value="${auctions.realEstateID}">
                                <p>${auctions.auctionName}</p>
                            </button>
                        </form>
                        <script>
                            // Lưu giá trị của auctions.realEstateID vào một biến JavaScript
                            var auctionRealEstateID = "${auctions.realEstateID}";
                            // Sử dụng biến này ở đây hoặc đâu đó trong tập lệnh JavaScript của bạn
                            // Ví dụ:
                            console.log("auctionRealEstateID: ", auctionRealEstateID);
                        </script>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </c:if>




        <footer class="footer" style="margin-top: 10px; position: fixed"> 
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

        </script>

        <script>

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
//                        var buttonId = "button#" + auctionRealEstateID; // Construct the button id selector
//                        var button = document.querySelector(buttonId); // Find the button element
//                        if (button) {
//                            button.click(); // Trigger click event
//                        }
                    }
                }, 1000);
            }


//
            var auctionTimeStartElements = document.querySelectorAll(".auctionTimeStart");
//            console.log(auctionTimeStartElements);
////
//
            auctionTimeStartElements.forEach(function (element) {
                startCountdown(element);
            });





            function startCountdown2(element) {
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
                        element.innerHTML = "<span class='glow2' style='color: red;'>Đấu giá đã kết thúc</span>";
                    }
                }, 1000);
            }


            var auctionTimeEndElements = document.querySelectorAll(".auctionTimeEnd");

            auctionTimeEndElements.forEach(function (element) {
                startCountdown2(element);
            });

        </script>

        <script>
            // Định nghĩa một hàm để ghi lại thời gian hiện tại và hiển thị nó trong cửa sổ thông báo
            function logCurrentTime() {
                var currentTime = new Date(); // Lấy thời gian hiện tại
                var vietnamTime = new Date(currentTime.toLocaleString("en-US", {timeZone: "Asia/Ho_Chi_Minh"})); // Đặt múi giờ cho Việt Nam
                alert("Current time in Vietnam: " + vietnamTime.toLocaleString());
            }
        </script>
    </body>
</html>
