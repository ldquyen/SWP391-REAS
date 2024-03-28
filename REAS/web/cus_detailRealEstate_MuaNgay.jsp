<%-- 
    Document   : staff_detailRealEstate
    Created on : Mar 12, 2024, 11:13:52 AM
    Author     : ADMIN
--%>

<%@page import="dto.Wallet"%>
<%@page import="dao.WalletDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="java.util.List" %>
<%@ page import="dto.RealEstateInfo" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="detailRealEstate.css" type="text/css" >
        <c:if test="${not empty requestScope.Not_Request}">
            <script>
                // Hàm hiển thị cửa sổ thông báo
                function showErrorAlert(message) {
                    alert(message);
                }
                // Gọi hàm hiển thị cửa sổ thông báo với thông điệp từ attribute "Not_Request"
                showErrorAlert("${requestScope.Not_Request}");
            </script>
        </c:if>
        <style>
            .test {
                font-weight:bold;
                -webkit-animation: my 1000ms infinite;
                -moz-animation: my 1000ms infinite; 
                -o-animation: my 1000ms infinite; 
                animation: my 1000ms infinite;
            }
        </style>
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item">
                    <form action="MainController" method="post">
                        <button type="submit" value="homeindex" name="action">
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




        <div class="columns">
            <div class="column is-two-thirds" style="padding-top: 30px;display: flex;justify-content: end;">

                <div class="container-full-left">
                    <!-- Container for the image gallery -->
                    <div class="container">
                        <c:forEach items="${requestScope.listimg}" var="i">
                            <div class="mySlides fade">
                                <div class="numbertext">1 / 3</div>
                                <img src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image1)}" alt="Image" style="width:100%;min-height: 300px; max-height: 300px;">

                            </div>

                            <div class="mySlides fade">
                                <div class="numbertext">2 / 3</div>
                                <img src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image2)}" alt="Image" style="width:100%;min-height: 300px; max-height: 300px;">

                            </div>

                            <div class="mySlides fade">
                                <div class="numbertext">3 / 3</div>
                                <img src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image3)}" alt="Image" style="width:100%;min-height: 300px; max-height: 300px;">

                            </div>
                        </c:forEach>
                        <!-- Full-width images with number text -->

                        <!--
                                                <div class="mySlides">
                                                    <div class="numbertext">4 / 6</div>
                                                    <img src="image/img_lights_wide.jpg" style="width:100%">
                                                </div>
                        
                                                <div class="mySlides">
                                                    <div class="numbertext">5 / 6</div>
                                                    <img src="image/img_nature_wide.jpg" style="width:100%">
                                                </div>
                        
                                                <div class="mySlides">
                                                    <div class="numbertext">6 / 6</div>
                                                    <img src="image/img_snow_wide.jpg" style="width:100%">
                                                </div>-->

                        <!-- Next and previous buttons -->
                        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                        <a class="next" onclick="plusSlides(1)">&#10095;</a>

                        <!-- Image text -->
                        <!--                        <div class="caption-container">
                                                    <p id="caption"></p>
                                                </div>-->

                        <!-- Thumbnail images -->
                        <div class="row">
                            <c:forEach items="${requestScope.listimg}" var="i">


                                <div class="column">
                                    <img class="demo cursor" src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image1)}" style="width:100%; min-height: 100px;max-height: 100px;" onclick="currentSlide(1)" alt="Image">
                                </div>
                                <div class="column">
                                    <img class="demo cursor" src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image2)}" style="width:100%; min-height: 100px;max-height: 100px;" onclick="currentSlide(2)" alt="Image">
                                </div>
                                <div class="column">
                                    <img class="demo cursor" src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image3)}" style="width:100%; min-height: 100px;max-height: 100px;" onclick="currentSlide(3)" alt="Image">
                                </div>
                            </c:forEach>
                            <!--                            <div class="column">
                                                            <img class="demo cursor" src="image/img_lights_wide.jpg" style="width:100%; min-height: 100px" onclick="currentSlide(4)" alt="Northern Lights">
                                                        </div>
                                                        <div class="column">
                                                            <img class="demo cursor" src="image/img_nature_wide.jpg" style="width:100%; min-height: 100px" onclick="currentSlide(5)" alt="Nature and sunrise">
                                                        </div>
                                                        <div class="column">
                                                            <img class="demo cursor" src="image/img_snow_wide.jpg" style="width:100%; min-height: 100px" onclick="currentSlide(6)" alt="Snowy Mountains">
                                                        </div>-->
                        </div>
                    </div>
                    <div class="container-full-bellow">
                        <h1 class="flex-center h1-text-mid">Dự án: ${fn:toUpperCase(realEstate.realEstateName)} - <c:forEach var="cityList" items="${requestScope.city}"> 
                                <c:if test="${cityList.cityID eq realEstate.cityID}">
                                    ${cityList.cityName}
                                </c:if>
                            </c:forEach> - ${realEstate.area} m2</h1>
                        <div class="columns">
                            <div class="column" style="padding: 1.2rem 2.75rem;">
                                <h1 class="flex-center h1-text-left-right">Thông tin bất động sản</h1>
                                <div style="padding-top: 8px;">
                                    <p class="bold-text">Diện tích: <span>${realEstate.area} m²</span></p>
                                    <p class="bold-text">Loại hình: <span>${realEstate.category}</span></p>
                                    <p class="bold-text">Địa chỉ: <span> ${realEstate.address}</span></p>
                                    <p class="bold-text">Mô tả: <span> ${realEstate.detail}</span></p>

                                    <%-- <p class="bold-text">Mô tả: <span> ${Auctions.realEstateID}</span></p> --%>
                                </div>
                            </div>
                            <div class="divider"></div>
                            <div class="column" style="padding: 1.2rem 2.75rem;">
                                <h1 class="flex-center h1-text-left-right">Thông tin đấu giá cơ bản</h1>
                                <div style="padding-top: 8px;">
                                    <p class="bold-text">Giá khởi điểm: <span>
                                            <script>
                                                var number = ${realEstate.priceFirst}; // Assuming auctions.lamda contains the number
                                                var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                document.write(formattedNumber);
                                            </script> Xu</span></p></span></p>
                                    <p class="bold-text">Giá mua ngay: <span class="test"><script>
                                        var number = ${realEstate.pricePaid}; // Assuming auctions.lamda contains the number
                                        var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                        document.write(formattedNumber);
                                            </script> Xu</span>
                                    <p class="bold-text">Bước giá: <span>
                                            <c:forEach var="Auctions" items="${requestScope.Auctions}"> 
                                                <c:if test="${Auctions.realEstateID eq realEstate.realEstateID}">
                                                    <script>
                                                        var number = ${Auctions.lamda}; // Assuming auctions.lamda contains the number
                                                        var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                        document.write(formattedNumber);
                                                    </script>
                                                </c:if>
                                            </c:forEach>
                                            Xu</span></p>
    <!--                                    <p class="bold-text">Thời gian bắt đầu: <span id="startTime">${realEstate.timeUp}</span></p>
                                    <p class="bold-text">Thời gian kết thúc: <span id="endTime">${realEstate.timeDown}</span></p>-->
                                    <c:set var="listRealEstate" value="${requestScope.SEARCH_RESULT}"/>
                                    <c:forEach items="${listRealEstate}" var="dto" varStatus="counter">
                                        <c:if test="${dto.realEstateID eq realEstate.realEstateID}">
                                            <p class="bold-text">Thời gian bắt đầu: <span id="startTime">${dto.timeStart}</span></p>
                                            <p class="bold-text">Thời gian kết thúc: <span id="endTime">${dto.timeEnd}</span></p>
                                            </c:if>
                                        </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="column" style="padding-top: 30px">
                <div class="container-full-right flex-center text-center">
                    <div>
                        <form id="rejectForm" action="MainController" method="post">
                            <input type="hidden" name="realEstateID" value="${realEstate.realEstateID}" />
                            <input type="hidden" name="action" value="rejectRequestMuaNgay">
                            <button type="button" onclick="confirmReject()">
                                <p class="h1-text-mid" style="color: #fff;">Từ chối bán ngay</p>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
            <script>
                function confirmReject() {
                    if (confirm("Bạn có chắc chắn muốn từ chối bán ngay?")) {
                        document.getElementById('rejectForm').submit();
                    }
                }
            </script>
        </div>

        <div>
            <p style="text-align: center; font-size: 25px; color: #D9AB73; margin-top: 25px;margin-bottom: 10px; ">DANH SÁCH ĐĂNG KÍ MUA NGAY</p>
            <script>
                window.onload = function () {
                    // Kiểm tra xem trang đã được reload trước đó hay không
                    if (!localStorage.getItem('pageReloaded')) {
                        // Nếu chưa, thực hiện submit form
                        document.forms['searchForm'].submit();
                        // Đánh dấu rằng trang đã được reload
                        localStorage.setItem('pageReloaded', 'true');
                    } else {
                        // Nếu đã được reload trước đó, xóa dấu hiệu reload để cho lần reload tiếp theo
                        localStorage.removeItem('pageReloaded');
                    }
                }
                ;
            </script>
            <c:set var="listRealEstate" value="${requestScope.SEARCH_RESULT}"/>
            <form id="searchForm" class="flex-center" action="MainController" method="post">
                <input type="hidden" name="realEstateID" value="${realEstate.realEstateID}" />
                <input type="hidden" name="txtSearchValue" value="${param.txtSearchValue}" />
                <input type="hidden" value="cusSearchMuaNgayList" name="action" />   
            </form>

            <div style="text-align: center; border-radius: 45px;">
                <c:set var="listRequestMuaNgay" value="${requestScope.LIST_REQUEST}"/>
                <c:if test="${not empty listRequestMuaNgay}">
                    <table style="border-collapse: collapse; border: 6px solid #D9AB73;background-color: black; color: white; margin: auto;width: 90%">
                        <thead>
                            <tr>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Acc ID</th>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">PricePaid</th>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Date And Time</th>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Status</th>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Action</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${listRequestMuaNgay}" var="dto" varStatus="counter">
                                <tr>                   
                                    <td style="border: 1px solid #D9AB73; padding: 8px;">
                                        ${dto.accID}
                                    </td>
                                    <td class="pricePaid" style="border: 1px solid #D9AB73; padding: 8px;">
                                        ${dto.pricePaid}
                                    </td>
                                    <td class="dateAndTime" style="border: 1px solid #D9AB73; padding: 8px;">
                                        ${dto.timeRequest}
                                    </td>
                                    <td style="border: 1px solid #D9AB73; padding: 8px;">
                                        ${dto.requestStatusName}
                                    </td>
                                    <td style="border: 1px solid #D9AB73; padding: 8px;">
                                        <form id="purchaseForm" action="MainController" method="post" onsubmit="return confirmSubmit()">
                                            <input type="hidden" name="realEstateID" value="${dto.realEstateID}">
                                            <input type="hidden" name="accID" value="${dto.accID}">
                                            <input type="hidden" name="pricePaid" value="${dto.pricePaid}">
                                            <button id="submitButton" style="color: #fff" type="submit" value="xacNhanMuaNgay" name="action">
                                                <span class="test">Bán Ngay</span>
                                            </button>
                                        </form>
                                    </td>

                                </tr>
                                </form> 
                            </c:forEach>

                        </tbody>
                    </table>

                </c:if>
                <c:if test="${empty listRequestMuaNgay}">
                    <h2>
                        KHÔNG CÓ YÊU CẦU MUA NGAY!!!
                    </h2>
                </c:if>

            </div>
        </div>

        <footer class="footer" style="margin-top: 20px;position: initial"> 
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
                    <img class="footer-right-content" src="image/logofu.png" alt="" href="" width="100" height="28" />
                </div>
            </div>
        </footer>

        <script>
            let slideIndex = 1;
            showSlides(slideIndex);

            // Next/previous controls
            function plusSlides(n) {
                showSlides(slideIndex += n);
            }

            // Thumbnail image controls
            function currentSlide(n) {
                showSlides(slideIndex = n);
            }

            function showSlides(n) {
                let i;
                let slides = document.getElementsByClassName("mySlides");
                let dots = document.getElementsByClassName("demo");
                let captionText = document.getElementById("caption");
                if (n > slides.length) {
                    slideIndex = 1
                }
                if (n < 1) {
                    slideIndex = slides.length
                }
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.display = "none";
                }
                for (i = 0; i < dots.length; i++) {
                    dots[i].className = dots[i].className.replace(" active", "");
                }
                slides[slideIndex - 1].style.display = "block";
                dots[slideIndex - 1].className += " active";
                captionText.innerHTML = dots[slideIndex - 1].alt;
            }
        </script>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var startTimeElement = document.getElementById("startTime");
                var endTimeElement = document.getElementById("endTime");

                // Format start time
                var startTime = new Date(startTimeElement.innerText);
                var formattedStartTime = formatTime(startTime);

                // Format end time
                var endTime = new Date(endTimeElement.innerText);
                var formattedEndTime = formatTime(endTime);

                // Update the HTML with the formatted time
                startTimeElement.innerText = formattedStartTime;
                endTimeElement.innerText = formattedEndTime;
            });

            // Function to format the time
            function formatTime(time) {
                var year = time.getFullYear();
                var month = padZero(time.getMonth() + 1);
                var date = padZero(time.getDate());
                var hours = padZero(time.getHours());
                var minutes = padZero(time.getMinutes());
                var seconds = padZero(time.getSeconds());
                var formattedTime = year + "-" + month + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
                return formattedTime;
            }

            // Function to pad zero to single digit numbers
            function padZero(number) {
                return number < 10 ? '0' + number : number;
            }
        </script>
        <script>
            function confirmSubmit() {
                // Hiển thị hộp thoại xác nhận và lưu kết quả vào biến confirmed
                var confirmed = confirm("Bạn có xác nhận sẽ bán?");
                // Nếu người dùng đã xác nhận
                if (confirmed) {
                    // Thay đổi văn bản của nút
                    document.getElementById('submitButton').innerText = "Đã bán";
                    // Vô hiệu hóa nút sau khi nhấn
                    document.getElementById('submitButton').disabled = true;

                }
                // Trả về giá trị confirmed để xác định liệu form có nên gửi đi hay không
                return confirmed;
            }
        </script>
    </body>
</html>
