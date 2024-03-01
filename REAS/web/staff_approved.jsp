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


                </aside>                    </ul>

            </div>

            <div>
                <div class="h1-staff-header">
                    <h1>ĐƠN ĐĂNG KÍ THÔNG TIN ĐẤU GIÁ ĐÃ XÉT DUYỆT</h1></br> 
                </div>
                           
                <form class="flex-center" action="StaffController">
                    <input type="hidden" name="txtSearchValue" 
                           value="${param.txtSearchValue}" />
                    <!--                    <input type="submit" value="searchAuctionApprove" name="action" />-->
                    <button class="button-search-staff" type="submit" value="searchAuctionApproved" name="action">Search</button>

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
                                <th>Area</th>
                                <th>Image Folder ID</th>
                                <th>Detail</th>
                                <th>Time Up</th>
                                <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${listRealEstate}" var="dto" varStatus="counter">
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
                                    <td>
                                        ${dto.priceFirst}
                                    </td>
                                    <td>
                                        ${dto.pricePaid}
                                    </td>
                                    <td>
                                        ${dto.lamda}
                                    </td>
                                    <td>
                                        ${dto.timeStart}
                                    </td>
                                    <td>
                                        ${dto.timeEnd}
                                    </td>
                                    <td>
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
                                        ${dto.statusName}
                                    </td>
                                    

                                    <td>
                                        <form action="StaffController" method="post">
                                            <input type="hidden" name="realEstateID" value="${dto.realEstateID}">
                                            <input type="hidden" name="txtSearchValue" value="${searchValue}" />
                                            <button type="submit" value="updateStatusButton" name="action">Xác nhận</button>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="StaffController" method="post">
                                            <input type="hidden" name="realEstateID" value="${dto.realEstateID}">
                                            <input type="hidden" name="txtSearchValue" value="${searchValue}" />
                                            <button type="submit" value="deleteRealEstateButton" name="action">Xóa</button>
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



    </body>
</html>
