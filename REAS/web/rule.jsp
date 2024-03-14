<%-- 
    Document   : rule
    Created on : Jan 19, 2024, 11:38:53 AM
    Author     : ASUS
--%>

<%@page import="dto.Wallet"%>
<%@page import="dao.WalletDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Real Estate Auction System</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
        <style>
            body {
                background-image: url(image/rulebg.png);
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                margin: 0; 
                padding: 0; 
            }
        </style>
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
                            <button type="submit" value="ruleedit" name="action">
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
    </table>
    <h1 style="text-align: center; font-size: 36px; color: #D9AB73; margin-top: 30px ;">NỘI QUY</h1>
    <h2 style="text-align: center; font-size: 24px; color: #D9AB73;">CHƯƠNG I</h2>
    <h3 style="text-align: center; color: #D9AB73;"> NHỮNG QUY ĐỊNH CHUNG</h3>
    <p style="margin-left: 20px; font-weight: bold; color: white">Điều 1. Đối tượng áp dụng</p>
    <p style="margin-left: 35px; color: white">
    <table  style="margin-left: 35px; color: white">
        <c:forEach var="rule" items="${rulelist}">
            <tr >
                <td>${rule.ruleDetail}</td>
            </tr>
        </c:forEach>
    </table>
</p>

<p style="margin-left: 20px; font-weight: bold; color: white">Điều 2. Nguyên tắc hoạt động </p>
<p style="margin-left: 35px; color: white">
<table  style="margin-left: 35px; color: white">
    <c:forEach var="rule" items="${rulelist2}">
        <tr >
            <td>${rule.ruleDetail}</td>
        </tr>
    </c:forEach>
</table>
</p>


<p style="margin-left: 20px; font-weight: bold; color: white">Điều 3. Giải thích từ ngữ</p>
<p style="margin-left: 35px; color: white">
<table  style="margin-left: 35px; color: white">
    <c:forEach var="rule" items="${rulelist3}">
        <tr >
            <td>${rule.ruleDetail}</td>
        </tr>
    </c:forEach>
</table>
</p>


<p style="margin-left: 20px; font-weight: bold; color: white">Điều 4. Quyền tiếp cận thông tin đối với Trang thông tin đấu giá trực tuyến biển số.</p>
<p style="margin-left: 35px; color: white">
   <table  style="margin-left: 35px; color: white">
    <c:forEach var="rule" items="${rulelist4}">
        <tr >
            <td>${rule.ruleDetail}</td>
        </tr>
    </c:forEach>
</table>
</p>

<h2 style="text-align: center; font-size: 24px; color: #D9AB73;">CHƯƠNG II</h2>
<h3 style="text-align: center; color: #D9AB73;">TRÌNH TỰ, THỦ TỤC ĐẤU GIÁ BẤT ĐỘNG SẢN</h3>


<p style="margin-left: 20px; font-weight: bold; color: white">Điều 5. Trình tự thực hiện phiên đấu giá bất động sản bằng hình thức đấu giá trực tuyến.</p>
<p style="margin-left: 35px; color: white">
   <table  style="margin-left: 35px; color: white">
    <c:forEach var="rule" items="${rulelist5}">
        <tr >
            <td>${rule.ruleDetail}</td>
        </tr>
    </c:forEach>
</table>
</p>


<p style="margin-left: 20px; font-weight: bold; color: white">Điều 6. Thông báo kết quả đấu giá trực tuyến bất động sản</p>
<p style="margin-left: 35px ; color: white">
   <table  style="margin-left: 35px; color: white">
    <c:forEach var="rule" items="${rulelist6}">
        <tr >
            <td>${rule.ruleDetail}</td>
        </tr>
    </c:forEach>
</table>
</p>


<p style="margin-left: 20px; font-weight: bold; color: white"> Điều 7. Biên bản cuộc đấu giá trực tuyến bất động sản</p>
<p style="margin-left: 35px; color: white">
   <table  style="margin-left: 35px; color: white">
    <c:forEach var="rule" items="${rulelist7}">
        <tr >
            <td>${rule.ruleDetail}</td>
        </tr>
    </c:forEach>
</table>
</p>



<h2 style="text-align: center; font-size: 24px; color: #D9AB73;">CHƯƠNG III</h2>
<h3 style="text-align: center; color: #D9AB73;">QUY TRÌNH THANH TOÁN</h3>


<p style="margin-left: 20px; font-weight: bold; color: white">Điều 8. Quy trình thanh toán</p>
<p style="margin-left: 35px; color: white">
  <table  style="margin-left: 35px; color: white">
    <c:forEach var="rule" items="${rulelist8}">
        <tr >
            <td>${rule.ruleDetail}</td>
        </tr>
    </c:forEach>
</table>
</p>


<p style="margin-left: 20px; font-weight: bold; color: white"> Điều 9. Phương thức hoàn trả tiền đặt trước</p>
<p style="margin-left: 35px; color: white">
   <table  style="margin-left: 35px; color: white">
    <c:forEach var="rule" items="${rulelist9}">
        <tr >
            <td>${rule.ruleDetail}</td>
        </tr>
    </c:forEach>
</table>
</p>

<footer class="footer" style="position: inherit; margin-top: 30px"> 
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
