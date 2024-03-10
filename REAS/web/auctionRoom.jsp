<%@page import="dto.Account"%>
<%@page import="dao.AccountDAO"%>
<%@page import="dao.AccountDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
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
        <link rel="stylesheet" href="auctionRoom.css" type="text/css" >
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


        <div class="columns" style="padding: 0px 50px;">
            <div class="column is-two-thirds"style="padding-top: 30px;padding-right: 35px">

                <div class="register-modal-container">
                    <div class="container">
                        <c:forEach items="${requestScope.listimgauction}" var="i">
                            <div class="mySlides fade">
                                <div class="numbertext">1 / 3</div>
                                <img src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image1)}" alt="Image" style="width:100%;min-height: 300px; max-height: 300px;object-fit: cover;">

                            </div>

                            <div class="mySlides fade">
                                <div class="numbertext">2 / 3</div>
                                <img src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image2)}" alt="Image" style="width:100%;min-height: 300px; max-height: 300px;object-fit: cover;">

                            </div>

                            <div class="mySlides fade">
                                <div class="numbertext">3 / 3</div>
                                <img src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image3)}" alt="Image" style="width:100%;min-height: 300px; max-height: 300px;object-fit: cover;">

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

                        <!--                         Image text 
                                                <div class="caption-container">
                                                    <p id="caption"></p>
                                                </div>-->

                        <!-- Thumbnail images -->
                        <div class="row">
                            <c:forEach items="${requestScope.listimgauction}" var="i">


                                <div class="column">
                                    <img class="demo cursor" src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image1)}" style="width:100%; min-height: 100px;max-height: 100px;object-fit: cover;" onclick="currentSlide(1)" alt="Image">
                                </div>
                                <div class="column">
                                    <img class="demo cursor" src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image2)}" style="width:100%; min-height: 100px;max-height: 100px;object-fit: cover;" onclick="currentSlide(2)" alt="Image">
                                </div>
                                <div class="column">
                                    <img class="demo cursor" src="data:image/jpeg;base64,${fn:escapeXml(i.base64Image3)}" style="width:100%; min-height: 100px;max-height: 100px;object-fit: cover;" onclick="currentSlide(3)" alt="Image">
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
                        <c:if test="${not empty auctions}">
                            <c:forEach var="REGETBYID" items="${requestScope.REGETBYID}">
                                <c:forEach var="imageforauction" items="${requestScope.imageforauction}"> 
                                    <c:if test="${imageforauction.imageFolderID eq REGETBYID.imageFolderID}">
                                        ${imageforauction.imageFolderID}
                                    </c:if>
                                </c:forEach>
                                <h1 class="flex-center h1-text-mid">${REGETBYID.realEstateName} - <c:forEach var="cityList" items="${requestScope.city}"> 
                                        <c:if test="${cityList.cityID eq REGETBYID.cityID}">
                                            ${cityList.cityName}
                                        </c:if>
                                    </c:forEach> - ${REGETBYID.area} m2</h1>
                                <div class="columns">
                                    <div class="column" style="padding: 1.2rem 2.75rem;">
                                        <h1 class="flex-center h1-text-left-right">Thông tin bất động sản</h1>
                                        <div style="padding-top: 8px;">
                                            <p class="bold-text">Diện tích: <span>${REGETBYID.area} m2</span></p>
                                            <c:forEach var="catList" items="${requestScope.category}"> 
                                                <c:if test="${catList.catID eq REGETBYID.catID}">
                                                    <p class="bold-text">Loại hình: <span>${catList.catName}</span></p>
                                                </c:if>
                                            </c:forEach>
                                            <p class="bold-text">Địa chỉ: <span> ${REGETBYID.address}</span></p>
                                            <p class="bold-text">Mô tả: <span> ${REGETBYID.detail}</span></p>
                                        </div>
                                    </div>
                                    <div class="divider"></div>
                                    <div class="column" style="padding: 1.2rem 2.75rem;">
                                        <h1 class="flex-center h1-text-left-right">Thông tin đấu giá cơ bản</h1>
                                        <div style="padding-top: 8px;">
                                            <p class="bold-text">Giá khởi điểm: <span>
                                                    <script>
                                                        var number = ${REGETBYID.priceFirst}; // Assuming auctions.lamda contains the number
                                                        var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                        document.write(formattedNumber);
                                                    </script> VND</span></p>
                                            <p class="bold-text">Giá mua ngay: <span class="test"><script>
                                                var number = ${REGETBYID.pricePaid}; // Assuming auctions.lamda contains the number
                                                var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                document.write(formattedNumber);
                                                    </script> VND</span>
                                            <p class="bold-text">Bước giá: <span>
                                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                                        <c:if test="${auctions.realEstateID eq REGETBYID.realEstateID}">
                                                            <script>
                                                                var number = ${auctions.lamda}; // Assuming auctions.lamda contains the number
                                                                var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                                document.write(formattedNumber);
                                                            </script>
                                                        </c:if>
                                                    </c:forEach>
                                                    VND</span></p>
                                            <p class="bold-text">Thời gian bắt đầu: <span id="startTime">${REGETBYID.timeUp}</span></p>
                                            <p class="bold-text">Thời gian kết thúc: <span id="endTime">${REGETBYID.timeDown}</span></p>

                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <%
                    ArrayList<Account> staffList = AccountDAO.getAllAccountByRole("S");
                    pageContext.setAttribute("staffList", staffList);
                %>
                <div style="width: 100%; display: flex; justify-content: center">
                    <div class="list-auction-p-container" style="">
                        <c:if test="${not empty auctions}">
                            <c:forEach var="REGETBYID" items="${requestScope.REGETBYID}">
                                <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                    <c:if test="${auctions.realEstateID eq REGETBYID.realEstateID}">
                                        <p class="list-auction-p-1">Đấu giá viên:</p>
                                        <c:set var="listRealEstate" value="${requestScope.SEARCH_RESULT}"/>
                                        <c:forEach items="${listRealEstate}" var="dto" >
                                                   <c:forEach items="${staffList}" var="staff">
                                                <c:if test="${dto.accID eq staff.accID}">
                                                    <div>
                                                        <div>

                                                            <p class="list-auction-p-1">${staff.fullname}</p>

                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>
                                        <div class="auctionTimeEnd list-auction-p-2">
                                            <p style="display: none;">${auctions.timeEnd}</p>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="column" style="padding-top: 30px">
                <div class="register-modal-container">
                    <h1 style="font-size: 22px; padding: 4px 0px;">Diễn biến cuộc đấu giá</h1>
                    <div class="number-price-container">
                        <p style="color: #D9AB73; font-size: 22px">
                            <c:if test="${not empty auctions}">
                                <c:forEach var="REGETBYID" items="${requestScope.REGETBYID}">
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq REGETBYID.realEstateID}">                            
                                            <span class="price-now">
                                                <script>
                                                    var number = ${auctions.priceNow}; // Assuming auctions.lamda contains the number
                                                    var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                    document.write(formattedNumber);
                                                </script>
                                                VND
                                            </span>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </c:if> 
                        </p>
                        <p>50.210.000.000 VND</p>
                        <p>50.215.000.000 VND</p>
                        <p>50.205.000.000 VND</p>
                        <p>50.200.000.000 VND</p>
                    </div>
                </div>

                <div class="register-modal-container" style="margin-top: 25px">
                    <h1 style="display: flex; justify-content: center;font-size: 20px; padding: 4px 0px;color: #D9AB73;font-weight: bold;">
                        <c:if test="${not empty auctions}">
                            <c:forEach var="REGETBYID" items="${requestScope.REGETBYID}">
                                <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                    <c:if test="${auctions.realEstateID eq REGETBYID.realEstateID}">
                                        <p>Giá hiện tại: 
                                            <span id="price-now">
                                                <script>
                                                    var number = ${auctions.priceNow}; // Assuming auctions.lamda contains the number
                                                    var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                    document.write(formattedNumber);
                                                </script>
                                                VND
                                            </span>
                                        </p>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </c:if> 
                    </h1>
                    </h1>
                    <div class="number-price-container number-price-container-bellow">
                        <p class="number-price-bellow-1">
                            <c:if test="${not empty auctions}">
                                <c:forEach var="REGETBYID" items="${requestScope.REGETBYID}">
                                    <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                        <c:if test="${auctions.realEstateID eq REGETBYID.realEstateID}">
                                            <script>
                                                var number = ${auctions.lamda}; // Assuming auctions.lamda contains the number
                                                var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                document.write(formattedNumber);
                                            </script>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </c:if>
                        </p>

                        <p class="number-price-bellow-2">X</p>
                        <p id="quantity-field">
                            <button id="down" onclick="setQuantity('down');" style="color: #fff">-</button>
                            <input type="text" id="quantity" value="1" style="background-color: #000; color: #fff;width: 52%; border: 3px #fff solid;padding: 2px 10px;font-family: Inter;
                                   font-size: 20px;
                                   font-style: normal;
                                   font-weight: 400;
                                   line-height: normal;
                                   text-align: center" onkeypress="handleKeyPress(event)">
                            <button id="up" onclick="setQuantity('up');" style="color: #fff">+</button>
                        </p>
                        <p class="number-price-bellow-2">=</p>
                        <p class="number-price-bellow-1">
                            <span id="total-price"></span>
                        </p>
                    </div>
                    <div style="display: flex; justify-content: center">
                        <form action="MemberController" method="post">
                            <button type="submit" value="tragia" name="action">
                                <h1  style="display: flex;justify-content: center;font-size: 20px; padding: 6px 50px;color: #D9AB73;font-weight: bold;border: 3px #D9AB73 solid;margin-top: 8px">
                                    <c:if test="${not empty auctions}">
                                        <c:forEach var="REGETBYID" items="${requestScope.REGETBYID}">
                                            <c:forEach var="auctions" items="${requestScope.auctions}"> 
                                                <c:if test="${auctions.realEstateID eq REGETBYID.realEstateID}">
                                                    <input type="hidden" name="idAuctionBID" value="${auctions.realEstateID}">
                                                    <input type="hidden" name="priceNowBid" id="priceNowBid" value="Pricevalue">
                                                    <p>Trả giá:  
                                                        <span id="total-price-bid">
                                                            <script>
                                                                var number = ${auctions.priceNow}; // Assuming auctions.lamda contains the number
                                                                var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                                document.write(formattedNumber);
                                                            </script>
                                                            VND
                                                        </span>
                                                    </p>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>
                                    </c:if> 
                                </h1>
                            </button>
                            <!--                                                        <p id="text-price"></p>-->
                        </form>
                    </div>
                </div>
                <div style="display: flex; justify-content: center; width: 100%; text-align: center;">

                    <button type="submit" value="tragia" name="action">
                        <h1  style="background: #D9AB73; display: flex;justify-content: center;font-size: 20px; padding: 6px 50px;color: #D9AB73;font-weight: bold;border: 3px #000 solid;margin-top: 8px">
                            <a id="total-price-bid" href="MemberController?action=registerAuction&auctionId=${auction.auctionID}">
                                Dang ki dau gia
                            </a>
                        </h1>
                    </button>
                </div>

            </div>
        </div>

        <form class="auctionForm" action="MemberController" method="post">
            <button id="submitButton" type="submit" value="resultAuction" name="action">
                <c:if test="${not empty auctions}">
                    <c:forEach var="REGETBYID" items="${requestScope.REGETBYID}">
                        <c:forEach var="auctions" items="${requestScope.auctions}"> 
                            <c:if test="${auctions.realEstateID eq REGETBYID.realEstateID}">
                                <input type="hidden" name="idAuctionResult" value="${auctions.realEstateID}">
                                <p>Test</p>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </c:if> 
            </button>
        </form>




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
                    <img class="footer-right-content" src="image/bocongthuong.png" alt="" href="" width="100" height="28" />
                </div>
            </div>
        </footer>

        <script>
            function chuyenSoTienSangChu(soTien) {
                const motDenChin = ['không', 'một', 'hai', 'ba', 'bốn', 'năm', 'sáu', 'bảy', 'tám', 'chín'];
                const muoiDenHaiMuoi = ['', 'mười', 'hai mươi', 'ba mươi', 'bốn mươi', 'năm mươi', 'sáu mươi', 'bảy mươi', 'tám mươi', 'chín mươi'];

                function chuyenHangChuc(so) {
                    const donVi = so % 10;
                    const hangChuc = Math.floor(so / 10);
                    if (donVi === 0) {
                        return muoiDenHaiMuoi[hangChuc];
                    } else if (hangChuc === 1) {
                        return 'mười ' + motDenChin[donVi];
                    } else {
                        return muoiDenHaiMuoi[hangChuc] + ' ' + motDenChin[donVi];
                    }
                }

                function chuyenSoLonHonHaiChuSo(so) {
                    const tram = Math.floor(so / 100);
                    const phanDu = so % 100;
                    if (tram === 0) {
                        return chuyenHangChuc(phanDu);
                    } else if (phanDu === 0) {
                        return motDenChin[tram] + ' trăm';
                    } else {
                        return motDenChin[tram] + ' trăm ' + chuyenHangChuc(phanDu);
                    }
                }

                const ty = Math.floor(soTien / 1000000000);
                const trieu = Math.floor((soTien % 1000000000) / 1000000);
                const ngan = Math.floor((soTien % 1000000) / 1000);
                const dong = Math.floor(soTien % 1000);

                let chuoiChu = '';
                if (ty > 0) {
                    chuoiChu += chuyenSoLonHonHaiChuSo(ty) + ' tỷ ';
                }
                if (trieu > 0) {
                    chuoiChu += chuyenSoLonHonHaiChuSo(trieu) + ' triệu ';
                }
                if (ngan > 0) {
                    chuoiChu += chuyenSoLonHonHaiChuSo(ngan) + ' nghìn ';
                }
                if (dong > 0) {
                    chuoiChu += chuyenSoLonHonHaiChuSo(dong);
                }

                return chuoiChu.trim() + ' đồng';
            }

            function setQuantity(upordown) {
                var quantityElement = document.getElementById('quantity');
                var quantity = parseInt(quantityElement.value);

                if (quantity > 1 || upordown === 'up') {
                    if (upordown === 'up') {
                        quantity += 1;
                    } else if (upordown === 'down') {
                        quantity -= 1;
                    }
                } else {
                    quantity = 1;
                }

                quantityElement.value = quantity;

                // Update total price based on the new quantity
                updateTotalPrice();
            }

            function handleKeyPress(event) {
                if (event.keyCode === 13) {
                    // If Enter key is pressed, update the total price
                    updateTotalPrice();
                }
            }

            document.addEventListener('keydown', function (event) {
                // Check if the pressed key is the arrow up key (key code 38)
                if (event.keyCode === 38) {
                    // Simulate a click on the button with id 'up'
                    document.getElementById('up').click();
                    // Prevent the default behavior (scrolling up)
                    event.preventDefault();
                }
                // Check if the pressed key is the arrow down key (key code 40)
                else if (event.keyCode === 40) {
                    // Simulate a click on the button with id 'down'
                    document.getElementById('down').click();
                    // Prevent the default behavior (scrolling down)
                    event.preventDefault();
                }
            });

            // Function to update the total price based on quantity
            function updateTotalPrice() {
                var quantity = parseInt(document.getElementById('quantity').value);
                var priceNow = parseFloat(document.querySelector('.price-now').innerText.replace(/\./g, '').replace(',', '.'));
                // You need to replace '.number-price-bellow-1' with the appropriate selector
                var pricePerUnit = parseFloat(document.querySelector('.number-price-bellow-1').innerText.replace(/\./g, '').replace(',', '.'));
                var totalPrice = quantity * pricePerUnit;
                var totalPriceBid = priceNow + totalPrice;

                document.getElementById('total-price').innerText = totalPrice.toLocaleString('vi-VN');
                document.getElementById('total-price-bid').innerText = totalPriceBid.toLocaleString('vi-VN');


                var Pricevalue = document.getElementById('priceNowBid').value = totalPriceBid;
                console.log(Pricevalue);



                // Convert total price to words using chuyenSoTienSangChu function
                var totalPriceInWords = chuyenSoTienSangChu(totalPriceBid);
                document.getElementById('text-price').innerText = totalPriceInWords.charAt(0).toUpperCase() + totalPriceInWords.slice(1); // Render total price in words with the first letter capitalized
            }

            // Initialize total price based on default quantity and price per unit
            updateTotalPrice();
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
            var auctionTimeEndElements = document.querySelectorAll(".auctionTimeEnd");

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
                        element.innerHTML = "<span class='glow' style='color: red;'>Đấu giá đã kết thúc</span>";
                        // Trigger click event on the submit button to submit the form
                        var submitButton = document.getElementById('submitButton');
                        submitButton.click();
                    }
                }, 1000);
            }

            // Attach event listener to submit button
            var submitButton = document.getElementById('submitButton');
            submitButton.addEventListener('click', function () {
                var form = document.querySelector('.auctionForm');
                form.submit();
            });

            auctionTimeEndElements.forEach(function (element) {
                startCountdown(element);
            });
        </script>

        <script>
            let slideIndex = 1;
            showSlides(slideIndex);

            // Next/previous controls
            function plusSlides(n) {
                // Disable transition temporarily
                let slidesContainer = document.querySelector('.container');
                slidesContainer.style.transitionDuration = '0ms';

                // Move to the next slide
                showSlides(slideIndex += n);

                // Enable transition after a short delay (10ms for example)
                setTimeout(() => {
                    slidesContainer.style.transitionDuration = '';
                }, 10);
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
    </body>
</html>
