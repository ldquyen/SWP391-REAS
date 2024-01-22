<%-- 
    Document   : login
    Created on : Jan 18, 2024, 10:33:30 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">


                <a class="navbar-item" href="">
                    <img class="logo-header" src="image/logo.png" alt="" href="" width="100" height="28" />
                </a>

                <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                    <span aria-hidden="true"></span>
                </a>
            </div>

            <div id="navbarBasicExample" class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="">
                        TRANG CHỦ
                    </a>

                    <div class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="news" name="action">
                                <span>TIN TỨC</span>
                            </button>
                        </form>
                    </div>

                    <div class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="rule" name="action">
                                <span>NỘI QUY</span>
                            </button>
                        </form>
                    </div>


                </div>

                <div class="navbar-end">
                    <div class="navbar-item">
                        <div class="buttons" >
                            <form action="MainController" method="post">
                                <button class="button is-light" type="submit" value="DN" name="action">
                                    <span>ĐĂNG NHẬP</span>
                                </button>
                            </form>
                            <form action="MainController" method="post">
                                <button class="button is-light" type="submit" value="DK" name="action">
                                    <span>ĐĂNG KÝ</span>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </nav>

        <div>
            <img class="background-login" src="image/background-login.png" alt="background-login" />
            <div class="login-container">
                <div class="login-modal-container">
                    <header class="header-login">
                        <a class="navbar-item img-logo-login" href="" style="padding-top: 16px;" >
                            <img class="logo-header" src="image/logo.png" alt="" href="" width="100" height="28" style="max-height: 52px " />
                        </a>
                        <p style="font-size: 20px">KÍNH CHÀO QUÝ KHÁCH</p>

                        <div class="container-login">
                            <p class="register-if-dont-have-container">Bạn chưa có tài khoản?</p>
                            <form action="MainController" method="post" class="registration-form">
                                <button class="button is-light sign-up-in-login" type="submit" value="DK" name="action"
                                        <span>Đăng ký</span>
                                </button>
                            </form>
                            <p class="register-here">tại đây</p>
                        </div>

                        <div class="form-login-container">
                            <form action="MainController" method="post">
                                <input class="input is-normal input-username" type="text" placeholder="Tên đăng nhập" name="txtUsername" value="">
                                <input class="input is-normal input-password" type="password" placeholder="Mật khẩu" name="txtPassword" value=""></br>
                                <button class="button is-light forgot-password" type="submit" value="changePass" name="action"
                                        <span>Quên mật khẩu?</span>
                                </button></br>
                                <button class="button is-light submit-login-btn" type="submit" value="Login" name="action" style="
                                        background-color: transparent;
                                        color: #D9AB73;
                                        font-size: 18px;
                                        font-family: Inter;
                                        font-weight: 800;
                                        word-wrap: break-word;
                                        border-radius: 40px;
                                        border: 3px solid #D9AB73" >
                                    <span>ĐĂNG NHẬP</span>
                                </button>
                                <p style="font-size: 18px;
                                   padding: 15px 0;
                                   color: #fff;">
                                    ------------------------------Hoặc------------------------------
                                </p>
                                <button class="button is-light submit-login-btn submit-with-gg-btn" type="submit" value="Login" name="btAction" style="
                                        background-color: transparent;
                                        color: #D9AB73;
                                        font-size: 18px;
                                        font-family: Inter;
                                        font-weight: 600;
                                        word-wrap: break-word;
                                        border-radius: 40px;
                                        border: 3px solid #D9AB73;
                                        margin-bottom: 30px;" >
                                    <span><img  style="margin-right: 5px" class="logo-header" src="image/google.png" alt="" href="" ></img>Đăng nhập với Google</span>
                                </button>
                            </form>
                        </div>

                    </header>
                </div>
            </div>
        </div>

        <footer class="footer"> 
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
