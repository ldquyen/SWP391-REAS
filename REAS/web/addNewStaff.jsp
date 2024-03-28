<%-- 
    Document   : changeInfoStaff
    Created on : Feb 5, 2024, 2:05:06 PM
    Author     : ASUS
--%>

<%@page import="dto.Wallet"%>
<%@page import="dao.WalletDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REAS-ADMIN PAGE</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
        <link rel="stylesheet" href="admin.css" type="text/css" >
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item" href="admin.jsp">
                    <img class="logo-header" src="image/logo.png" alt="" href="admin.jsp" width="100" height="28" />
                </a>

                <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a>
            </div>

            <div id="navbarBasicExample" class="navbar-menu">
                <div class="navbar-start">
                    <form action="AdminController" method="post" style="margin-top: 17px">
                        <button type="submit" value="adminjsp" name="action" >
                            <span style="color: white">TRANG CHỦ</span>
                        </button>
                    </form>
                </div>

                <div class="navbar-end">
                    <div class="navbar-item">

                        <%
                            List<Wallet> wallet = new WalletDAO().getWallet();
                            pageContext.setAttribute("walletAccount", wallet);
                        %>
                        <div class="navbar-container-1">
                            <a class="navbar-1">SỐ DƯ :
                                <c:forEach var="wallet" items="${walletAccount}">
                                    <c:if test="${wallet.accID eq admin.accID}">
                                        <span class="list-auction-p-1">${wallet.accountBalance}</span>
                                    </c:if>
                                </c:forEach>
                                (xu)
                            </a>                  
                        </div>

                        <div class="navbar-item hover-down has-dropdown is-hoverable">
                            <a class="navbar-link navbar-1-list">
                                ${sessionScope.admin.fullname} (ADMIN)                
                            </a>

                            <div class="fake-div"></div>

                            <div class="navbar-dropdown">
                                <a class="navbar-item">
                                    <form action="AdminController" method="post">
                                        <button type="submit" value="adminInformationPage" name="action">
                                            <span>Thông tin tài khoản</span>
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
            <div class="column is-one-fifth" style="background-color: #D9D9D9; height: 100vh;">
                <aside class="menu">
                    <p class="menu-label">
                        General
                    </p>
                    <ul class="menu-list">
                        <li>
                            <a class="">Thống kê</a>
                            <ul class="menu-list-subnav">
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="aboutus" name="action">
                                                <span>Biểu đồ</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="detailStatisticalJSP" name="action">
                                                <span>Chi tiết</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="menu-list">
                        <li>
                            <a class="">Xét duyệt</a>
                            <ul class="menu-list-subnav">
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="approve" name="action">
                                                <span>Danh sách chờ</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="approved" name="action">
                                                <span>Đã xét duyệt</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="menu-list">
                        <li>
                            <a class="">Nạp tiền</a>
                            <ul class="menu-list-subnav">
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="approve_order" name="action">
                                                <span>Đợi xét duyệt</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="approved_order" name="action">
                                                <span>Đã xét duyệt</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="reject_order" name="action">
                                                <span>Đã từ chối</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <p class="menu-label">
                        Administration
                    </p>
                    <ul class="menu-list">
                        <li>
                            <a class="">Nhân viên</a>
                            <ul class="menu-list-subnav">
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="searchStaff" name="action">
                                                <span>Tìm kiếm</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="addStaff" name="action">
                                                <span>Thêm mới</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="menu-list">
                        <li>
                            <a class="">Thành viên</a>
                            <ul class="menu-list-subnav">
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="searchMember" name="action">
                                                <span>Tìm kiếm</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>                                
                            </ul>
                        </li>
                    </ul>
                    <ul class="menu-list">
                        <li>
                            <a class="">Doanh thu</a>
                            <ul class="menu-list-subnav">
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="revenue" name="action">
                                                <span>Xem chi tiết</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>

                            </ul>
                        </li>
                    </ul>


                    <p class="menu-label">
                        Transactions
                    </p>
                    <ul class="menu-list">
                        <li>
                            <a class="">Ví tiền</a>
                            <ul class="menu-list-subnav">
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="aboutus" name="action">
                                                <a href="AdminController?action=userWalletPage">Thông tin ví tiền</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>

                            </ul>
                        </li>
                    </ul>
                    <p class="menu-label">
                        Khác
                    </p>
                    <ul class="menu-list">
                        <li>
                            <a class="">Luật lệ</a>
                            <ul class="menu-list-subnav">
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="fixrule" name="action">
                                                <span>Chỉnh sửa luật lệ</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                                <li>
                                    <a class="navbar-item">
                                        <form action="AdminController" method="post">
                                            <button type="submit" value="addStaff" name="action">
                                                <span>Danh sách luật chỉnh sửa</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                                <li>
                                    <a class="navbar-item">
                                        <form action="MainController" method="post">
                                            <button type="submit" value="rule" name="action">
                                                <span>Xem luật lệ</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                            </ul>                           
                        </li>
                    </ul>


                </aside>
            </div>
            <div class="column" style="height: 100vh;">
                <span style="font-weight: bold; margin-right: 1px; color: #D9AB73; font-size: 20px">
                    Thêm nhân viên mới
                </span>  
                <div style="margin-top: 10px">
                    <form action="AdminController" method="post">
                        <table style="border-collapse: collapse; border: 3px solid #D9AB73;background-color: black; color: white;">
                            <tbody>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">Tên:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="fullName" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">Tài khoản:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="userName" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">Mật khẩu:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="password" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">Email:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="email" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">SĐT:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="phone" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">Địa chỉ:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="address" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">CCCD:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="cccd" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">Nơi cấp CCCD:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="placeOfReg" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">Ngày cấp CCCD:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="dateOfReg" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">Tên ngân hàng:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="bankName" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                                <tr>
                                    <td style=" padding: 8px; font-weight: bold; color: #D9AB73;">Số tài khoản:</td>
                                    <td style=" padding: 8px;"> <input type="text" name="bankCode" style="background-color: black; color: white; font-size: 15px"> </td>
                                </tr>
                            </tbody>
                        </table>
                        <input type="hidden" name="ID" value="${s.accID}">
                        <button type="submit" value="addNewStaff" name="action" style="background-color: black; border: 3px solid #D9AB73; color: #D9AB73; padding: 6px 20px; margin-top: 10px">
                            <span style="font-size: 14px; font-weight: bold">Thêm mới</span>
                        </button>
                    </form>


                </div>
            </div>
            <div class="column" style="height: 100vh;">
                <s:if test="${not empty requestScope.ADDOKE}">
                    <span style="font-weight: bold; margin-right: 1px; color:green ">
                        Thêm mới thành công
                    </span>  
                </s:if>
                <s:if test="${not empty requestScope.ADDnotOKE}">
                    <span style="font-weight: bold; margin-right: 1px; color: red ">
                        Thêm mới thất bại
                    </span> 
                </s:if>
                <s:if test="${not empty requestScope.THIEUTT}">
                    <span style="font-weight: bold; margin-right: 1px; color: red ">
                        Vui lòng nhập đầy đủ thông tin
                    </span>  
                </s:if>
            </div>

        </div>        
    </body>
</html>
