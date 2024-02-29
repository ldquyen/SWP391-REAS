<%-- 
    Document   : index
    Created on : Jan 17, 2024, 11:02:09 PM
    Author     : ASUS
--%>

<%@page import="dto.UserGoogle"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Real Estate Auction System</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="informationPage.css" type="text/css" >
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
                            <a class="navbar-1">10.000.000</a>                  
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
                                    <form action="MainController" method="post">
                                        <button type="submit" value="aboutus" name="action">
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
                                        <button type="submit" value="aboutus" name="action">
                                            <span>Thông tin thanh toán</span>
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
        <div style="display: flex">
            <img class="background-login background-register" src="image/background-login.png" alt="background-login" />
            <div class="login-container">
                <div class="register-modal-container">
                    <header class="header-login">
                        <h1 style="font-size: 20px;padding-top: 20px">THÔNG TIN TÀI KHOẢN</h1>
                        <h2 style="color: greenyellow"> ${requestScope.SUCCESS} </h2>
                        <h2 style="color: red"> ${requestScope.ERROR} </h2>
                        <form action="MemberController" method="post">
                            <div style="display: flex; justify-content: center">
                                <div style="padding-right: 10px">
                                    <div>
                                        <p  class="title-single">Họ và tên: ${sessionScope.member.fullname}</p>
                                        <div style="display: flex;">
                                            <input class="input is-normal input-fullname" type="text" placeholder="Họ Và Tên(Chữ cái)" name="txtFullname">
                                            <button  class="button is-light submit-login-btn" type="submit" value="changeInfo" name="action" style="
                                                     background-color: transparent;
                                                     color: #D9AB73;
                                                     font-size: 16px;
                                                     margin-left: 8px;
                                                     font-family: Inter;
                                                     font-weight: 800;
                                                     word-wrap: break-word;
                                                     border-radius: 40px;
                                                     border: 3px solid #D9AB73" >
                                                <span>Chỉnh sửa</span>
                                            </button>
                                        </div>
                                    </div>
                                    <input type="hidden" name="txtAccID" value="${not empty sessionScope.member ? sessionScope.member.accID : ''}">
                                    <input type="hidden" name="txtUsername" value="${not empty sessionScope.member ? sessionScope.member.userName : ''}">
                                    <input type="hidden" name="txtPassword" value="${not empty sessionScope.member ? sessionScope.member.password : ''}">
                                    <div>
                                        <p class="title-single" >Email: ${sessionScope.member.email}</p>
                                        <div style="display: flex">
                                            <input class="input is-normal input-email" type="text" placeholder="Email" name="txtEmail">
                                            <button  class="button is-light submit-login-btn" type="submit" value="changeInfo" name="action" style="
                                                     background-color: transparent;
                                                     color: #D9AB73;
                                                     font-size: 16px;
                                                     margin-left: 8px;
                                                     font-family: Inter;
                                                     font-weight: 800;
                                                     word-wrap: break-word;
                                                     border-radius: 40px;
                                                     border: 3px solid #D9AB73" >
                                                <span>Chỉnh sửa</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div>
                                        <p class="title-single" >Số điện thoại: ${sessionScope.member.phone}</p>
                                        <div style="display: flex">
                                            <input class=" input is-normal input-phone" type="text" placeholder="Số điện thoại(10 chữ số)" name="txtPhone">
                                            <button  class="button is-light submit-login-btn" type="submit" value="changeInfo" name="action" style="
                                                     background-color: transparent;
                                                     color: #D9AB73;
                                                     font-size: 16px;
                                                     margin-left: 8px;
                                                     font-family: Inter;
                                                     font-weight: 800;
                                                     word-wrap: break-word;
                                                     border-radius: 40px;
                                                     border: 3px solid #D9AB73" >
                                                <span>Chỉnh sửa</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div>
                                        <p class="title-single" >Địa Chỉ: ${sessionScope.member.address}</p>
                                        <div style="display: flex">
                                            <input class="input is-normal input-address" type="text" placeholder="Địa Chỉ" name="txtAddress">
                                            <button  class="button is-light submit-login-btn" type="submit" value="changeInfo" name="action" style="
                                                     background-color: transparent;
                                                     color: #D9AB73;
                                                     font-size: 16px;
                                                     margin-left: 8px;
                                                     font-family: Inter;
                                                     font-weight: 800;
                                                     word-wrap: break-word;
                                                     border-radius: 40px;
                                                     border: 3px solid #D9AB73" >
                                                <span>Chỉnh sửa</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div>
                                        <p class="title-single" >Số CCCD: ${sessionScope.member.cccd}</p>
                                        <div style="display: flex">
                                            <input class=" input is-normal input-cccd" type="text" placeholder="Số CCCD(12 chữ số)" name="txtCCCD">
                                            <button  class="button is-light submit-login-btn" type="submit" value="changeInfo" name="action" style="
                                                     background-color: transparent;
                                                     color: #D9AB73;
                                                     font-size: 16px;
                                                     margin-left: 8px;
                                                     font-family: Inter;
                                                     font-weight: 800;
                                                     word-wrap: break-word;
                                                     border-radius: 40px;
                                                     border: 3px solid #D9AB73" >
                                                <span>Chỉnh sửa</span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <div style="padding-left: 10px">
                                    <div>
                                        <p class="title-single" >Nơi Cấp CCCD: ${sessionScope.member.placeOfReg}</p>
                                        <div style="display: flex">
                                            <input class=" input is-normal input-cccd" type="text" placeholder="Nơi cấp CCCD" name="txtCCCDRegplace">
                                            <button  class="button is-light submit-login-btn" type="submit" value="changeInfo" name="action" style="
                                                     background-color: transparent;
                                                     color: #D9AB73;
                                                     font-size: 16px;
                                                     margin-left: 8px;
                                                     font-family: Inter;
                                                     font-weight: 800;
                                                     word-wrap: break-word;
                                                     border-radius: 40px;
                                                     border: 3px solid #D9AB73" >
                                                <span>Chỉnh sửa</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div>
                                        <p class="title-single" >Ngày Cấp CCCD: ${sessionScope.member.dateOfReg}</p>
                                        <div style="display: flex">
                                            <input class=" input is-normal input-cccd" type="text" placeholder="Ngày cấp CCCD" name="txtCCCDRegdate">
                                            <button  class="button is-light submit-login-btn" type="submit" value="changeInfo" name="action" style="
                                                     background-color: transparent;
                                                     color: #D9AB73;
                                                     font-size: 16px;
                                                     margin-left: 8px;
                                                     font-family: Inter;
                                                     font-weight: 800;
                                                     word-wrap: break-word;
                                                     border-radius: 40px;
                                                     border: 3px solid #D9AB73" >
                                                <span>Chỉnh sửa</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div>
                                        <p class="title-single" >Tên Ngân Hàng: ${sessionScope.member.bankName}</p>
                                        <div style="display: flex">
                                            <input class=" input is-normal input-password" type="text" placeholder="Tên Ngân Hàng(Chữ cái)" name="txtBankname">
                                            <button  class="button is-light submit-login-btn" type="submit" value="changeInfo" name="action" style="
                                                     background-color: transparent;
                                                     color: #D9AB73;
                                                     font-size: 16px;
                                                     margin-left: 8px;
                                                     font-family: Inter;
                                                     font-weight: 800;
                                                     word-wrap: break-word;
                                                     border-radius: 40px;
                                                     border: 3px solid #D9AB73" >
                                                <span>Chỉnh sửa</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div>
                                        <p class="title-single" >Số tài khoản ngân hàng: ${sessionScope.member.bankCode}</p>
                                        <div style="display: flex">
                                            <input class=" input is-normal input-password" type="text" placeholder="Số tài khoản(Chữ số)" name="txtBankcode">
                                            <button  class="button is-light submit-login-btn" type="submit" value="changeInfo" name="action" style="
                                                     background-color: transparent;
                                                     color: #D9AB73;
                                                     font-size: 16px;
                                                     margin-left: 8px;
                                                     font-family: Inter;
                                                     font-weight: 800;
                                                     word-wrap: break-word;
                                                     border-radius: 40px;
                                                     border: 3px solid #D9AB73" >
                                                <span>Chỉnh sửa</span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                </div>
                </header>
            </div>
        </div>
    </div>






    <footer class="footer" style="position: inherit;"> 
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
