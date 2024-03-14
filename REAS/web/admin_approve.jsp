<%-- 
    Document   : admin_approve
    Created on : Mar 2, 2024, 11:46:14 AM
    Author     : ADMIN
--%>

<%@page import="dto.Wallet"%>
<%@page import="dao.WalletDAO"%>
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
                                                <span>Đơn nạp tiền</span>
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

            <!--===============================================================-->
            <%
                ArrayList<Account> staffList = AccountDAO.getAllAccountByRole("S");
                pageContext.setAttribute("staffList", staffList);
            %>
            <div>
                <div style="text-align: center; display: block; font-size: 25px; color: #D9AB73; margin-top: 25px; margin-bottom: 10px; ">
                    <h1>XÉT DUYỆT ĐƠN ĐĂNG KÍ THÔNG TIN ĐẤU GIÁ</h1></br> 
                </div>

                <!--                <form class="flex-center" action="AdminController">
                                    <input type="hidden" name="txtSearchValue" 
                                           value="${param.txtSearchValue}" />
                
                                    <button class="button-search-staff" type="submit" value="adminSearchAuctionApprove" name="action">VIEW</button>
                
                                </form><br/>-->
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
                    };
                </script>

                <form id="searchForm" class="flex-center" action="AdminController">
                    <input type="hidden" name="txtSearchValue" value="${param.txtSearchValue}" />
                    <input type="hidden" name="action" value="adminSearchAuctionApprove" />
                </form>

                <div style="text-align: center; border-radius: 45px;">
                    <c:set var="listRealEstate" value="${requestScope.SEARCH_RESULT}"/>
                    <c:if test="${not empty listRealEstate}">
                        <table style="border-collapse: collapse; border: 6px solid #D9AB73;background-color: black; color: white; margin: auto;width: 90%">
                            <thead>
                                <tr>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Real Estate ID</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Real Estate Name</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Account</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Address</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">City</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Cat Name</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Price First</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Price Paid</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Lambda</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Time Start</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Time End</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Area(m²)</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Time Up</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Staff</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Action</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${listRealEstate}" var="dto" varStatus="counter">

                                <form action="AdminController" method="post">
                                    <tr>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            <a href="StaffController?action=viewPostRealEstate&id=${dto.realEstateID}">${dto.realEstateID}
                                        </td>                               
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.realEstateName}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.userName}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.address}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.cityName}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.catName}
                                        </td>
                                        <td class="priceFirstCell" style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.priceFirst}
                                        </td>
                                        <td class="pricePaidCell" style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.pricePaid}
                                        </td>
                                        <td class="lamdaCell" style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.lamda}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.timeStart}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.timeEnd}
                                        </td>
                                        <td class="areaCell" style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.area}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.timeUp}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            <select id="accID" name="accID" required>
                                                <option value="" disabled selected hidden>-- Chọn --</option>
                                                <c:forEach items="${staffList}" var="staff">
                                                    <option value="${staff.accID}">${staff.fullname}</option>
                                                </c:forEach>
                                            </select>

                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            <input type="hidden" name="realEstateID" value="${dto.realEstateID}">
                                            <input type="hidden" name="txtSearchValue" value="${searchValue}" />
                                            <button style="color: #fff" type="submit" value="updateStatusButton" name="action">Xác nhận</button>
                                        </td>

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
