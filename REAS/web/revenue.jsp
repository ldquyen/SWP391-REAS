<%-- 
    Document   : admin
    Created on : Jan 22, 2024, 11:54:07 PM
    Author     : ASUS
--%>

<%@page import="dto.Wallet"%>
<%@page import="dao.WalletDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REAS-ADMIN PAGE</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
        <link rel="stylesheet" href="admin.css" type="text/css" >
        <style>
            .container {
                display: flex;
                flex-direction: column;
                height: 10vh;
            }

            .top-half {
                flex: 1;
                display: flex;            
                align-items: center;
                background-color: #f0f0f0;
            }

            .bottom-half {

                display: flex;
                justify-content: center;
                align-items: center;
                background-color: #e0e0e0;
            }

            .report-form button {
                border: 2px solid #ccc; /* Thay đổi màu và độ rộng của viền */
                padding: 1px 10px; /* Tùy chỉnh padding cho nút */
                cursor: pointer; /* Hiển thị con trỏ khi di chuyển qua nút */
                color: white;
                background-color: #007bff;
            }
            .report-form input[type="number"] {
                width: 100px;
            }


            .chart {
                width: 1300px;
                height: 460px;
                border: 1px solid #ccc;

                padding: 20px;
                box-sizing: border-box;
                position: relative;
            }

            .bar {
                width: 50px;
                background-color: #007bff;
                position: absolute;
                bottom: 0;
            }

        </style>
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
            </div

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
            <!--===============================================================-->
            <!-- BODY -->
            <div class="column" style="height: 100vh;">
                <div class="container">
                    <div class="top-half">
                        <form action="AdminController" method="post">
                            <div class="report-form">
                                <label style="margin-left: 10px" for="month" >Chọn tháng:</label>

                                <select name="month" id="month">
                                    <option value="" <c:if test="${month eq ''}">selected</c:if>>Toàn bộ</option>
                                    <option value="1" <c:if test="${month eq '1'}">selected</c:if>>Tháng 1</option>
                                    <option value="2" <c:if test="${month eq '2'}">selected</c:if>>Tháng 2</option>
                                    <option value="3" <c:if test="${month eq '3'}">selected</c:if>>Tháng 3</option>
                                    <option value="4" <c:if test="${month eq '4'}">selected</c:if>>Tháng 4</option>
                                    <option value="5" <c:if test="${month eq '5'}">selected</c:if>>Tháng 5</option>
                                    <option value="6" <c:if test="${month eq '6'}">selected</c:if>>Tháng 6</option>
                                    <option value="7" <c:if test="${month eq '7'}">selected</c:if>>Tháng 7</option>
                                    <option value="8" <c:if test="${month eq '8'}">selected</c:if>>Tháng 8</option>
                                    <option value="9" <c:if test="${month eq '9'}">selected</c:if>>Tháng 9</option>
                                    <option value="10" <c:if test="${month eq '10'}">selected</c:if>>Tháng 10</option>
                                    <option value="11" <c:if test="${month eq '11'}">selected</c:if>>Tháng 11</option>
                                    <option value="12" <c:if test="${month eq '12'}">selected</c:if>>Tháng 12</option>
                                    </select>
                                    <label style="margin-left: 10px" for="month" >2024</label>
                                    <button type="submit" value="searchRevenue" name="action">Tìm kiếm</button>
                                    <button type="submit" value="searchRefund" name="action">Xem số tiền của đấu giá</button>
                                    <br>


                                    <div class="report-data">
                                        <br>
                                        <label style="margin-left: 10px;" >Đấu giá</label>
                                        <br>
                                        <label style="margin-left: 10px;" for="fee">Số tiền phí thu được:</label>
                                        <input style="margin-left: 30px; margin-right: 10px" type="text" id="fee" name="fee" value="${requestScope.tienphi} xu" >

                                    <label for="auctions">Số cuộc đấu giá diễn ra:</label>
                                    <input style="margin-left: 60px; margin-right: 10px" type="text" id="auctions" name="auctions" value="${requestScope.sodaugia}">

                                    <label for="winning">Số tiền thắng đấu giá:</label>
                                    <input style="margin-left: 30px" type="text" id="winning" name="winning" value="${requestScope.sotienthang} xu">
                                    <br>
                                    <br>
                                    <label style="margin-left: 10px;" >Người dùng</label>
                                    <br>

                                    <label style="margin-left: 10px;" for="winning">Số giao dịch thực hiện:</label>
                                    <input style="margin-left: 16px; margin-right: 10px" type="text" id="winning" name="winning" value="${requestScope.sogiaodich}">

                                    <label for="winning">Số tiền giao dịch đã thực hiện:</label>
                                    <input style="margin-left: 15px; " type="text" id="winning" name="winning" value="${requestScope.sotiengiaodich} xu">
                                </div>
                            </div>
                        </form>
                    </div> 
                    <label style="margin-left: 10px; margin-top: 10px; color: #007bff; font-weight: bold" >Số tiền thắng của 10 cuộc đấu giá gần nhất</label>
                    <div class="bottom-half" style="margin-top: 10px">
                        <div class="chart">
                                <span style="position: absolute; left: 0px;">Số tiền:</span>

                            <c:forEach var="r" items="${requestScope.getListADH}" varStatus="loop">
                                
                                <span style="position: absolute; left: ${65 + (loop.index * 100)}px;">${r.quantity}</span>
                                <div class="bar" style="height: ${r.quantity}px; left: ${50 + (loop.index * 100)}px;"></div>
                            </c:forEach>

                            <!-- Số liệu -->
                            
                            <div style="position: absolute; bottom: -10px; left: 0; width: 100%; text-align: center;">
                                <span style="position: absolute; left: 0px;">ID:</span>
                                <c:forEach var="r" items="${requestScope.getListADH}" varStatus="loop">
                                <span style="position: absolute; left: ${65 + (loop.index * 100)}px;">${r.auctionID}</span>
                            </c:forEach>
                                
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>





    </body>
</html>