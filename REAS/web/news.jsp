<%-- 
    Document   : index
    Created on : Jan 17, 2024, 11:02:09 PM
    Author     : ASUS
--%>

<%@page import="dto.UserGoogle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Real Estate Auction System</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >

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
            <!-- BODY -->
            <div>

                <p style="text-align: center; font-size: 25px; color: #D9AB73; margin-top: 10px;margin-bottom: 10px; ">Những bất động sản đã trúng đấu giá </p>
                <div style="text-align: center; border-radius: 45px;">
                <c:if test="${not empty requestScope.listRealEstateInNews}">
                    <table style="border-collapse: collapse; border: 6px solid #D9AB73;background-color: black; color: white; margin: auto;">
                        <thead>
                            <tr>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Tên</th>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Địa chỉ</th>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Thành phố</th>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Loại hình BĐS</th>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Ngày trúng đấu giá</th>
                                <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Giá trúng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="r" items="${requestScope.listRealEstateInNews}">
                                <tr>
                                    <td style="border: 1px solid #D9AB73; padding: 8px;">${r.realEstateName}</td>
                                    <td style="border: 1px solid #D9AB73; padding: 8px;">${r.address}</td>
                                    <td style="border: 1px solid #D9AB73; padding: 8px;">
                                        <c:forEach var="cityList" items="${sessionScope.CITYLIST}"> 
                                            <c:if test="${cityList.cityID eq r.cityID}">
                                                ${cityList.cityName}
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                    <td style="border: 1px solid #D9AB73; padding: 8px;">
                                        <c:forEach var="catList" items="${sessionScope.CATEGORYLIST}"> 
                                            <c:if test="${catList.catID eq r.catID}">
                                                ${catList.catName}
                                            </c:if>
                                        </c:forEach>
                                    </td>
                                    <td class="endTimeNews" style="border: 1px solid #D9AB73; padding: 8px;">${r.timeDown}</td>
                                    <td style="border: 1px solid #D9AB73; padding: 8px;">
                                        <script>
                                            var number = ${r.pricePaid}; // Assuming auctions.lamda contains the number
                                            var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                            document.write(formattedNumber);
                                        </script>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </c:if>

                
            </div>
        </div>




        <footer class="footer"> 
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
            document.addEventListener("DOMContentLoaded", function () {
                var endTimeElements = document.querySelectorAll(".endTimeNews");

                endTimeElements.forEach(function (endTimeElement) {
                    // Format end time
                    var endTime = new Date(endTimeElement.innerText);
                    var formattedEndTime = formatTime(endTime);

                    // Update the HTML with the formatted time
                    endTimeElement.innerText = formattedEndTime;
                });
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
    </body>
</html>
