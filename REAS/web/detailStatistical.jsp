<%-- 
    Document   : admin
    Created on : Jan 22, 2024, 11:54:07 PM
    Author     : ASUS
--%>

<%@page import="dto.Wallet"%>
<%@page import="dao.WalletDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                            <button type="submit" value="detailStatistical" name="action">
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
                <form action="AdminController" method="post">
                    <p>Chọn năm/tháng/ngày</p>
                    <select name="year">
                        <%
                            // Generate options for years
                            int currentYear = LocalDate.now().getYear();
                            for (int year = currentYear; year >= currentYear - 10; year--) {
                        %>
                        <option value="<%= year%>"><%= year%></option>
                        <%
                            }
                        %>
                    </select>
                    <select name="month">
                        <%
                            // Generate options for months
                            for (int month = 1; month <= 12; month++) {
                        %>
                        <option value="<%= month%>"><%= month%></option>
                        <%
                            }
                        %>
                    </select>
                    <select name="day">
                        <%
                            // Generate options for days
                            for (int day = 1; day <= 31; day++) {
                        %>
                        <option value="<%= day%>"><%= day%></option>
                        <%
                            }
                        %>
                    </select>
                    <button type="submit" value="detailStatistical" name="action">
                        <span>Xem thống kê người đăng nhập</span>
                    </button> 
                    <div></div>
                    <p>
                        ${requestScope.totalLoginYear}
                    </p>
                    <p>
                        ${requestScope.totalLoginMonth}
                    </p>
                    <p>
                        ${requestScope.totalLoginDay}
                    </p>
                    <p>
                        ${requestScope.totalLoginDate}
                    </p>

                </form>

                <form action="AdminController" method="post">
                    <p>Chọn năm/tháng/ngày</p>
                    <select name="registeryear">
                        <%
                            // Generate options for years
                            int currentYearRegister = LocalDate.now().getYear();
                            for (int year = currentYear; year >= currentYear - 10; year--) {
                        %>
                        <option value="<%= year%>"><%= year%></option>
                        <%
                            }
                        %>
                    </select>
                    <select name="registermonth">
                        <%
                            // Generate options for months
                            for (int month = 1; month <= 12; month++) {
                        %>
                        <option value="<%= month%>"><%= month%></option>
                        <%
                            }
                        %>
                    </select>
                    <select name="registerday">
                        <%
                            // Generate options for days
                            for (int day = 1; day <= 31; day++) {
                        %>
                        <option value="<%= day%>"><%= day%></option>
                        <%
                            }
                        %>
                    </select>
                    <button type="submit" value="detailStatistical" name="action">
                        <span>Xem thống kê người đăng kí</span>
                    </button> 
                    <div></div>
                    <p>
                        ${requestScope.totalRegisterYear}
                    </p>
                    <p>
                        ${requestScope.totalRegisterMonth}
                    </p>
                    <p>
                        ${requestScope.totalRegisterDay}
                    </p>
                    <p>
                        ${requestScope.totalRegisterDate}
                    </p>
                </form>
                <form action="AdminController" method="post">
                    <select name="catid">
                        <option value="cc">Chung cư</option>
                        <option value="no">Nhà</option>
                        <option value="bt">Biệt thự</option>
                        <option value="dn">Đất</option>
                    </select>
                    <button type="submit" value="detailStatistical" name="action">
                        <span>Xem thống kê bất động sản</span>
                    </button>   

                </form>
                    <table style="margin-left: 35px; color: white">
                        <tr>
                            <th>Real Estate ID</th>
                            <th>Acc ID</th>
                            <th>Cat ID</th>
                            <th>City ID</th>
                            <th>Real Estate Name</th>
                            <th>Price First</th>
                            <th>Price Paid</th>
                            <th>Area</th>
                            <th>Address</th>
                            <th>Detail</th>
                        </tr>
                        <c:forEach var="realEstate" items="${realEstate}">
                            <tr>
                                <td>${realEstate.realEstateID}</td>
                                <td>${realEstate.accID}</td>
                                <td>${realEstate.catID}</td>
                                <td>${realEstate.cityID}</td>
                                <td>${realEstate.realEstateName}</td>
                                <td>${realEstate.priceFirst}</td>
                                <td>${realEstate.pricePaid}</td>
                                <td>${realEstate.area}</td>
                                <td>${realEstate.address}</td>
                                <td>${realEstate.detail}</td>
                            </tr>
                        </c:forEach>
                    </table>            
            </div> 
        </div>

        <!-- BODY -->



    </body>
</html>