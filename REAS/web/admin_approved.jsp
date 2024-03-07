<%-- 
    Document   : admin_approved
    Created on : Mar 2, 2024, 11:46:27 AM
    Author     : ADMIN
--%>


<%@page import="dto.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@page import="dao.AccountDAO" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REAS-ADMIN PAGE</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
        <link rel="stylesheet" href="admin.css" type="text/css" >
        <!--        <link rel="stylesheet" href="staff.css" type="text/css" >-->

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

                        <div class="navbar-container-1">
                            <a class="navbar-1">10.000.000</a>                  
                        </div>

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
                                            <button type="submit" value="searchStaff" name="action">
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
                </aside>
            </div>

            <!--===============================================================-->
            <%
                ArrayList<Account> staffList = AccountDAO.getAllAccountByRole("S");
                pageContext.setAttribute("staffList", staffList);
            %>
            <div>
                <div class="h1-staff-header">
                    <h1>XÉT DUYỆT ĐƠN ĐĂNG KÍ THÔNG TIN ĐẤU GIÁ</h1></br> 
                </div>

                <form class="flex-center" action="AdminController">
                    <input type="hidden" name="txtSearchValue" 
                           value="${param.txtSearchValue}" />

                    <button class="button-search-staff" type="submit" value="adminSearchAuctionApproved" name="action">Search</button>

                </form><br/>

                <div class="register-modal-container">
                    <c:set var="listRealEstate" value="${requestScope.SEARCH_RESULT}"/>
                    <c:if test="${not empty listRealEstate}">
                        <table class="table-container" border="1">
                            <thead>
                                <tr>
                                    <th>Real Estate ID</th>
                                    <th>Real Estate Name</th>
                                    <th>Account</th>
                                    <th>Address</th>
                                    <th>City</th>
                                    <th>Price First</th>
                                    <th>Price Paid</th>
                                    <th>Lambda</th>
                                    <th>Time Start</th>
                                    <th>Time End</th>
                                    <th>Area(m²)</th>
                                    <th>Image Folder ID</th>
                                    <th>Detail</th>
                                    <th>Time Up</th>
                                    <th>Staff</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${listRealEstate}" var="dto" varStatus="counter">

                                <form action="AdminController" method="post">
                                    <tr>
                                        <td>
                                            ${dto.realEstateID}
                                        </td>                               
                                        <td>
                                            ${dto.realEstateName}
                                        </td>
                                        <td>
                                            ${dto.userName}
                                        </td>
                                        <td>
                                            ${dto.address}
                                        </td>
                                        <td>
                                            ${dto.catName}
                                        </td>
                                        <td class="priceFirstCell">
                                            ${dto.priceFirst}
                                        </td>
                                        <td class="pricePaidCell">
                                            ${dto.pricePaid}
                                        </td>
                                        <td class="lamdaCell">
                                            ${dto.lamda}
                                        </td>
                                        <td>
                                            ${dto.timeStart}
                                        </td>
                                        <td>
                                            ${dto.timeEnd}
                                        </td>
                                        <td class="areaCell">
                                            ${dto.area}
                                        </td>
                                        <td>
                                            ${dto.imageFolderID}
                                        </td>
                                        <td>
                                            ${dto.detail}
                                        </td>
                                        <td>
                                            ${dto.timeUp}
                                        </td>
                                        <td>
                                            ${dto.accID}
                                        </td>
                                        <td>

                                            <c:forEach items="${staffList}" var="staff">
                                                <c:if test="${dto.accID eq staff.accID}">
                                                    <div>
                                                        <div>
                              
                                                            <p>${staff.fullname}</p>
                                                            
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:forEach>


                                        </td>
                                        <!--                                        <td>
                                                                                    <input type="hidden" name="realEstateID" value="${dto.realEstateID}">
                                                                                    <input type="hidden" name="txtSearchValue" value="${searchValue}" />
                                                                                    <button type="submit" value="updateStatusButton" name="action">Xác nhận</button>
                                                                                </td>-->
                                    </tr>
                                </form>
                            </c:forEach>

                            </tbody>
                        </table>
                        <c:if test="${empty listRealEstate}">
                            <h2>
                                No record is matched!!!
                            </h2>
                        </c:if>
                    </c:if>
                </div>
            </div>


            <!--         ==============       -->
        </div>

        <!-- BODY -->

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var priceFirstCells = document.querySelectorAll('.priceFirstCell');
                var pricePaidCells = document.querySelectorAll('.pricePaidCell');
                var lamdaCells = document.querySelectorAll('.lamdaCell');
                var areaCells = document.querySelectorAll('.areaCell');

                priceFirstCells.forEach(function (cell) {
                    cell.textContent = numberWithCommas(cell.textContent);
                });

                pricePaidCells.forEach(function (cell) {
                    cell.textContent = numberWithCommas(cell.textContent);
                });

                lamdaCells.forEach(function (cell) {
                    cell.textContent = numberWithCommas(cell.textContent);
                });

                areaCells.forEach(function (cell) {
                    cell.textContent = numberWithCommas(cell.textContent);
                });
            });

            function numberWithCommas(x) {
                return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            }
        </script>

    </body>
</html>
