<%-- 
    Document   : staff_approved
    Created on : Feb 29, 2024, 10:13:42 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
        <link rel="stylesheet" href="staff.css" type="text/css" >
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
                    <form action="StaffController" method="post" style="margin-top: 17px">
                        <button type="submit" value="staffjsp" name="action" >
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
                                ${sessionScope.staff.fullname} (STAFF)                
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
                            <a class="">Xét duyệt</a>
                            <ul class="menu-list-subnav">
                                <li>
                                    <a class="navbar-item">
                                        <form action="StaffController" method="post">
                                            <button type="submit" value="approve" name="action">
                                                <span>Danh sách đang xét duyệt</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                                <li>
                                    <a class="navbar-item">
                                        <form action="StaffController" method="post">
                                            <button type="submit" value="approved" name="action">
                                                <span>Danh sách đã xét duyệt</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>
                            </ul>
                            <a class="">Đấu giá</a>
                            <ul class="menu-list-subnav">
                                <li>
                                    <a class="navbar-item">
                                        <form action="StaffController" method="post">
                                            <button type="submit" value="approve" name="action">
                                                <span>Danh sách đảm nhận</span>
                                            </button>
                                        </form>
                                    </a>
                                </li>

                            </ul>
                        </li>
                    </ul>


                </aside>
            </div>

            <div>
                <p style="text-align: center; font-size: 25px; color: #D9AB73; margin-top: 25px;margin-bottom: 10px; ">THÔNG TIN ĐẤU GIÁ ĐÃ XÉT DUYỆT</p>
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

                <form id="searchForm" class="flex-center" action="StaffController">
                    <input type="hidden" name="txtSearchValue" value="${param.txtSearchValue}" />
                    <input type="hidden" name="action" value="searchAuctionApproved" />
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
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Image Folder ID</th>
                                    <!--                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Detail</th>-->
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Time Up</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Status</th>

                                    <!--            <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">ImageID</th>            -->
                                    <!--                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Xác nhận</th>
                                                                        <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Xóa</th>-->

                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${listRealEstate}" var="dto" varStatus="counter">
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
                                        <td class="startTime" style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.timeStart}
                                        </td>
                                        <td class="endTime" style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.timeEnd}
                                        </td>
                                        <td class="areaCell" style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.area}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.imageFolderID}
                                        </td>
                                        <!--                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                        ${dto.detail}
                                    </td>-->
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.timeUp}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.statusName}
                                        </td>

                                    </tr>
                                    </form> 
                                </c:forEach>


                            </tbody>
                        </table>

                    </c:if>
                    <c:if test="${empty listRealEstate}">
                        <h2>
                            No record is matched!!!
                        </h2>
                    </c:if>
                </div>
            </div>

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
