<%-- 
    Document   : index
    Created on : Jan 17, 2024, 11:02:09 PM
    Author     : ASUS
--%>

<%@page import="dao.WalletDAO"%>
<%@page import="dto.Wallet"%>
<%@page import="java.util.List"%>
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



        <!-- BODY -->
        <div>
            <p style="text-align: center; font-size: 25px; color: #D9AB73; margin-top: 10px;margin-bottom: 10px; ">Những bài đăng của tôi</p>

            <c:if test="${not empty requestScope.listRE}">
                <table style="border-collapse: collapse; border: 6px solid #D9AB73;background-color: black; color: white; margin: auto;">
                    <thead>
                        <tr>
                            <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Tên</th>                             
                            <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Ngày đăng</th>
                            <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Trạng thái</th>
                            <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Mua Ngay</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="r" items="${requestScope.listRE}">
                            <tr>
                                <td style="border: 1px solid #D9AB73; padding: 8px;">${r.realEstateName}</td>
                                <td class="endTimeNews" style="border: 1px solid #D9AB73; padding: 8px;">${r.timeUp}</td>
                                <c:forEach var="s" items="${requestScope.listStatus}"> 
                                    <c:if test="${s.statusID eq r.statusID}">

                                        <td style="border: 1px solid #D9AB73; padding: 8px;">${s.statusName}</td>
                                    </c:if>
                                </c:forEach>
                                <td style="border: 1px solid #D9AB73; padding: 8px;">
                                <a href="MainController?action=cusViewMuaNgayList&id=${r.realEstateID}">Xem danh sách
                                </td>

                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </c:if>

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


    </body>
</html>
