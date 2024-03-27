<%-- 
    Document   : admin
    Created on : Jan 22, 2024, 11:54:07 PM
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

                        <div class="navbar-item hover-down has-dropdown is-hoverable">
                            <a class="navbar-link navbar-1-list">
                                ${sessionScope.admin.fullname} (ADMIN)                
                            </a>

                            <div class="fake-div"></div>

                            <div class="navbar-dropdown">
                                <a class="navbar-item">
                                    <form action="AdminController" method="post">
                                        <button type="submit" value="informationOfAdmin" name="action">
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
                                            <button type="submit" value="aboutus" name="action">
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
                                            <button type="submit" value="aboutus" name="action">
                                                <span>Tổng doanh thu</span>
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
                                                <span>Thông tin ví tiền</span>
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
                <form action="AdminController" method="post">
                    <input type="text" placeholder="Nhập tên nhân viên" name="txtNameStaff" style="width: 400px; height: 30px" >
                    <button type="submit" value="searchNameStaff" name="action" style="background-color: black; color: #D9AB73; padding: 6px 20px; ">
                        <span style="font-size: 14px; font-weight: bold">Tìm kiếm</span>
                    </button>
                </form>

                <div style="margin-top: 20px">
                    <s:if test="${not empty requestScope.staffList}">
                        <table style="border-collapse: collapse; border: 6px solid #D9AB73;background-color: black; color: white;">
                            <thead>
                                <tr>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">ID</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Tên</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Email</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Số điện thoại</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">CCCD</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Địa chỉ</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Trạng thái</th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:forEach var="s" items="${requestScope.staffList}">
                                    <tr>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">${s.accID}</td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">${s.fullname}</td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">${s.email}</td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">${s.phone}</td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">${s.cccd}</td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">${s.address}</td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            <s:if test="${s.status eq false}">
                                                <form action="AdminController" method="post"> 
                                                    <input type="hidden" name="idBUB" value="${s.accID}">
                                                    <input type="hidden" name="statusBUB" value="${s.status}">
                                                    <button style="background-color: black; border: 2px solid red" type="submit" value="blockUnblock" name="action"> 
                                                        <span style="font-weight: bold; margin-right: 25px; color:red ">
                                                            Khóa TK
                                                        </span> 
                                                    </button> 
                                                </form>
                                            </s:if>

                                            <s:if test="${s.status eq true}">
                                                <form action="AdminController" method="post"> 
                                                    <input type="hidden" name="idBUB" value="${s.accID}">
                                                    <input type="hidden" name="statusBUB" value="${s.status}">
                                                    <button style="background-color: black; border: 2px solid green" type="submit" value="blockUnblock" name="action"> 
                                                        <span style="font-weight: bold; margin-right: 1px; color:green ">
                                                            Mở khóa TK
                                                        </span> 
                                                    </button> 
                                                </form>
                                            </s:if>
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            <form action="AdminController" method="post">
                                                <input type="hidden" name="idChinhSua" value="${s.accID}">
                                                <button style="background-color: black; border: 2px solid #D9AB73" type="submit" value="chinhsua" name="action"> 
                                                    <span style="font-weight: bold; color: #D9AB73 ">
                                                        Chỉnh sửa 
                                                    </span> 
                                                </button> 
                                            </form>
                                        </td>
                                    </tr>
                                </s:forEach>
                            </tbody>
                        </table>
                    </s:if>
                </div>

                <div>
                    <s:if test="${not empty requestScope.Fail}">
                        <p style="margin-top: 20px; font-size: 20px; font-weight: bold; color: red" >Không tìm thấy nhân viên, vui lòng thử lại.</p><br>
                    </s:if>
                </div>




            </div>
        </div>

        <!-- BODY -->



    </body>
</html>