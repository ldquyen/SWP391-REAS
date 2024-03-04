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
                        </li>
                    </ul>


                </aside>
            </div>

            <div>
                <p style="text-align: center; font-size: 25px; color: #D9AB73; margin-top: 25px;margin-bottom: 10px; ">THÔNG TIN ĐẤU GIÁ ĐÃ XÉT DUYỆT</p>
                <form action="StaffController">
                    <input type="hidden" name="txtSearchValue" 
                           value="${param.txtSearchValue}" />
                    <!--                    <input type="submit" value="searchAuctionApproved" name="action" />-->
                    <button type="submit" value="searchAuctionApproved" name="action">Search</button>
                </form><br/>

                <div style="text-align: center; border-radius: 45px;">
                    <c:set var="listRealEstate" value="${requestScope.SEARCH_RESULT}"/>
                    <c:if test="${not empty listRealEstate}">
                        <table style="border-collapse: collapse; border: 6px solid #D9AB73;background-color: black; color: white; margin: auto;width: 90%">
                            <thead>
                                <tr>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">RE ID</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">RE Name</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">AccID</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">CityID</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">CatID</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">PriceFirst</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">TimeUp</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">TimeDown</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">PricePaid</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">StatusID</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Area</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Address</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Detail</th>
                                    <!--                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">ImageID</th>-->
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Xác nhận</th>
                                    <th style="border: 1px solid #D9AB73; padding: 8px; color: #D9AB73">Xóa</th>


                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${listRealEstate}" var="dto" varStatus="counter">
                                    <tr>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.realEstateID}
                                        </td>                               
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.realEstateName}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.accID}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.cityID}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.catID}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            <script>
                                                var number = ${dto.priceFirst}; // Assuming auctions.lamda contains the number
                                                var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                document.write(formattedNumber);
                                            </script>
                                        </td>
                                        <td class="startTime" style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.timeUp}
                                        </td>
                                        <td class="endTime" style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.timeDown}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            <script>
                                                var number = ${dto.pricePaid}; // Assuming auctions.lamda contains the number
                                                var formattedNumber = number.toLocaleString('en-US').replace(/,/g, '.');
                                                document.write(formattedNumber);
                                            </script>
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.statusID}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.area}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.address}
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.detail}
                                        </td>
                                        <%--
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            ${dto.imageFolderID}
                                        </td>
                                        --%>

                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            <form action="StaffController" method="post">
                                                <button style="color: #fff" type="submit" value="updateStatusButton" name="action">Xác nhận</button>
                                            </form>
                                        </td>
                                        <td style="border: 1px solid #D9AB73; padding: 8px;">
                                            <form action="StaffController" method="post">
                                                <button style="color: #fff"  type="submit" value="deleteRealEstateButton" name="action">Xóa</button>
                                            </form>
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

        </div>

        <!-- BODY -->

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var startTimeElements = document.querySelectorAll(".startTime");
                var endTimeElements = document.querySelectorAll(".endTime");

                // Loop through each startTimeElement
                startTimeElements.forEach(function (startTimeElement) {
                    var startTime = new Date(startTimeElement.innerText);
                    var formattedStartTime = formatTime(startTime);
                    startTimeElement.innerText = formattedStartTime;
                });

                // Loop through each endTimeElement
                endTimeElements.forEach(function (endTimeElement) {
                    var endTime = new Date(endTimeElement.innerText);
                    var formattedEndTime = formatTime(endTime);
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
