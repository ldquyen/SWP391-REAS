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
        <title>Login Page</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >

    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
<a class="navbar-item">
                <form action="MainController" method="post">
                    <button type="submit" value="homeindex" name="action">
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
                        <button type="submit" value="homeindex" name="action">
                            <span>TRANG CHỦ</span>
                        </button>
                    </form>
                </a>

                    <div class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="DN" name="action">
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
                        <h1 style="color: greenyellow">${requestScope.SUCCESS}</h1>
                        <div class="container-login">
                            <p class="register-if-dont-have-container">Bạn chưa có tài khoản?</p>
                            <form action="MainController" method="post" class="registration-form">
                                <button class="button is-light sign-up-in-login" type="submit" value="DK" name="action"
                                        <span>Đăng ký</span>
                                </button>
                            </form>
                            <p class="register-here">tại đây</p>
                        </div>
                        <h1 class="usernamepassnull">${sessionScope.USERNAMEPASSNULL}</h1>
                        <div class="form-login-container">
                            <form id="loginForm" action="MainController" method="post">
                                <input class="input is-normal input-username" type="text" placeholder="Tên đăng nhập" name="txtUsername" value="" form="loginForm">
                                <input class="input is-normal input-password" type="password" placeholder="Mật khẩu" name="txtPassword" value="" form="loginForm"></br>
                                <button class="button is-light forgot-password" type="submit" value="forgotPassword" name="action">
                                    <span>Quên mật khẩu?</span>
                                </button></br>
                                <button id="loginSubmitBtn" class="button is-light submit-login-btn" type="submit" value="Login" name="action" style="
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
                                <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8084/REAS/LoginGoogleServlet&response_type=code
                                   &client_id=741212369784-t2och2tr458etn9rb3tt3oiuo1tqhgsd.apps.googleusercontent.com&approval_prompt=force" class="button is-light submit-login-btn submit-with-gg-btn" type="submit" value="LoginGG" name="action" style="
                                   background-color: transparent;
                                   color: #D9AB73;
                                   font-size: 18px;
                                   border: 3px solid #D9AB73;
                                   margin-bottom: 30px;
                                   font-family: Inter;
                                   font-weight: 800;
                                   word-wrap: break-word;
                                   border-radius: 40px;
                                   padding: 5px 22px;
                                   " >
                                    <span><img  style="margin-right: 5px" class="logo-header" src="image/google.png" alt="" href="" ></img>Đăng nhập với Google</span></a>
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
                    <img class="footer-right-content" src="image/logofu.png" alt="" href="" width="100" height="28" />
                </div>
            </div>
        </footer>
    </body>

    <script>
        document.getElementById('loginForm').addEventListener('keydown', function (e) {
            if (e.key === 'Enter') {
                e.preventDefault();
                document.getElementById('loginSubmitBtn').click();
            }
        });

        // chuc nang nhap sai username password hein đỏ và ngược lại
        document.addEventListener("DOMContentLoaded", function () {
            var usernamePassNull = "${sessionScope.USERNAMEPASSNULL}";

            var usernameInput = document.querySelector('.input-username');
            var passwordInput = document.querySelector('.input-password');
            var h1UsernamePassNull = document.querySelector('.usernamepassnull');

            if (!(usernamePassNull === null || usernamePassNull === "")) {
                usernameInput.classList.add('is-danger');
                passwordInput.classList.add('is-danger');
            }

            function handleFocus() {
                // Remove 'is-danger' class from both input elements
                usernameInput.classList.remove('is-danger');
                passwordInput.classList.remove('is-danger');

                // Remove the error message if it exists
                if (h1UsernamePassNull) {
                    h1UsernamePassNull.remove();
                }
            }

            // Add event listener to both input elements
            usernameInput.addEventListener('focus', handleFocus);
            passwordInput.addEventListener('focus', handleFocus);
        });
    </script>

    <script>
        // Lấy giá trị của ggusername từ request
   <%--     var ggusername = '<%= session.getAttribute("ggusername")%>'; --%>
        var UsernameRegister = '<%= request.getAttribute("UsernameRegister")%>';

        // Đặt giá trị của ggusername vào trường input nếu có giá trị và khác null
//        document.addEventListener('DOMContentLoaded', function () {
//            var inputUsername = document.querySelector('.input-username');
//            if (inputUsername && ggusername !== null && ggusername !== 'null') {
//                inputUsername.value = ggusername;
//            }
//        });
        document.addEventListener('DOMContentLoaded', function () {
            var inputUsername = document.querySelector('.input-username');
            if (inputUsername && UsernameRegister !== null && UsernameRegister !== 'null') {
                inputUsername.value = UsernameRegister;
            }
        });
    </script>
</html>
