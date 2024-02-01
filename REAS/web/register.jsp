<%-- 
    Document   : register
    Created on : Jan 18, 2024, 10:34:44 PM
    Author     : ASUS
--%>


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="register.css" type="text/css" >
    </head>
    <body>
        <nav class="navbar" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">


                <a class="navbar-item" href="index_1.jsp">
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
                    <a class="navbar-item" href="index.jsp">
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

        <div style="display: flex">
            <img class="background-login background-register" src="image/background-login.png" alt="background-login" />
            <div class="login-container">
                <div class="register-modal-container">
                    <header class="header-login">
                        <a class="navbar-item img-logo-login" href="" style="padding-top: 16px;" >
                            <img class="logo-header" src="image/logo.png" alt="" href="" width="100" height="28" style="max-height: 52px " />
                        </a>
                        <p style="font-size: 20px">KÍNH CHÀO QUÝ KHÁCH</p>
                        <h1 style="color: red">${requestScope.FAIL}</h1>
                        <h1 style="color: red">${requestScope.FAILCCCD}</h1>
                        <h1 style="color: red">${requestScope.FAILPHONEPATTERN}</h1>
                        <h1 style="color: red">${requestScope.FAILPASSWORDLENGTH}</h1>
                        <h1 style="color: red">${requestScope.FAILBANKNAMEPATTERN}</h1>
                        <h1 style="color: red">${requestScope.FAILFULLNAME}</h1>
                        <h1 style="color: red">${requestScope.FAILCCCDPATTERN}</h1>
                        <h1 style="color: red">${requestScope.FAILCCCDREGDATEPATTERN}</h1>
                        <h1 style="color: red">${requestScope.FAILBANKCODEPATTERN}</h1>
                        <h1 style="color: red">${requestScope.FAILEMAILSYMBOL}</h1>
                        <h1 style="color: red">${requestScope.FAILREPASSWORD}</h1>
                        <h1 style="color: red">${requestScope.FAILEMAIL}</h1>
                        <h1 style="color: red">${requestScope.FAILUSERNAME}</h1>
                        <h1 style="color: red">${requestScope.FAILPHONE}</h1>
                        <h1 style="color: red">${requestScope.SUCCESS}</h1>
                        <div class="container-login">
                            <p class="register-if-dont-have-container">Bạn đã có tài khoản?</p>
                            <form action="MainController" method="post" class="registration-form">
                                <button class="button is-light sign-up-in-login" type="submit" value="DN" name="action"
                                        <span>Đăng Nhập</span>
                                </button>
                            </form>
                            <p class="register-here">tại đây</p>
                        </div>
                        <div>
                            <form id="registerForm" action="MainController" method="post" onsubmit="return validateRegistration()">
                                <p><input class="input is-normal input-username" type="text" placeholder="Tên đăng nhập" name="txtUsername" value="" form="registerForm">
                                    <input class="input is-normal input-fullname" type="text" placeholder="Họ Và Tên(Chữ cái)" name="txtFullname" value="" form="registerForm"> </p>
                                </br>
                                <p>  <input class=" input is-normal input-phone" type="text" placeholder="Số Điện Thoại(10 chữ số)" name="txtPhone" value="" form="registerForm">
                                    <input class="input is-normal input-email" type="text" placeholder="Email" name="txtEmail" value="" form="registerForm">
                                    <input class="input is-normal input-address" type="text" placeholder="Địa chỉ" name="txtAddress" value="" form="registerForm"></p>
                                </br>
                                <p> <input class=" input is-normal input-cccd" type="text" placeholder="Số CCCD(12 chữ số)" name="txtCCCD" value="" form="registerForm">
                                    <input class="input is-normal input-cccd" type="text" placeholder="Nơi Cấp CCCD" name="txtCCCDRegplace" value="" form="registerForm"> 
                                    <input class=" input is-normal input-cccd" type="text" placeholder="Ngày Cấp(dd/mm/yyyy)" name="txtCCCDRegdate" value="" form="registerForm">  </p>
                                </br>
                                <p>  <input class=" input is-normal input-password" type="text" placeholder="Tên Ngân Hàng(Chữ cái)" name="txtBankname" value="" form="registerForm">
                                    <input class="input is-normal input-password" type="text" placeholder="Số tài khoản ngân hàng(Chữ số)" name="txtBankcode" value="" form="registerForm"> </p>
                                </br>
                                <p>  <input class=" input is-normal input-password" type="password" placeholder="Mật Khẩu(Từ 8 kí tự)" name="txtPassword" value="" form="registerForm">
                                    <input class="input is-normal input-password" type="password" placeholder="Nhập Lại Mật Khẩu" name="txtRepassword" value="" form="registerForm"> </p>
                                </br>
                                <div class="field" style="padding: 0px">
                                    <div class="control">
                                        <label class="checkbox rule-signup" style="display: flex; justify-content: center">
                                            <input type="checkbox" id="agreeCheckbox">
                                            <p style="font-size: 25px; margin-right: 5px; color: #D9AB73">Tôi đồng ý với</p>
                                            <button class="button is-light sign-up-in-login" style="font-size: 20px" type="submit" value="rule" name="action">
                                                <span>Điều Khoản Sử Dụng</span>
                                            </button>
                                        </label>
                                    </div>
                                </div>   
                                <button  class="button is-light submit-login-btn" type="submit" value="dangky" name="action" style="
                                         background-color: transparent;
                                         color: #D9AB73;
                                         font-size: 18px;
                                         font-family: Inter;
                                         font-weight: 800;
                                         word-wrap: break-word;
                                         border-radius: 40px;
                                         border: 3px solid #D9AB73" >
                                    <span>ĐĂNG KÝ</span>
                                </button>
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
        <script>
            function validateRegistration() {
                var checkBox = document.getElementById("agreeCheckbox");
                if (!checkBox.checked) {
                    alert("Vui lòng tick để đọc và đồng ý với Điều Khoản Sử Dụng để đăng ký.");
                    return false;
                }
                // Continue with form submission
                return true;
            }
        </script>

    </body>

    <script>
        document.getElementById('loginForm').addEventListener('keydown', function (e) {
            if (e.key === 'Enter') {
                e.preventDefault();
                document.getElementById('loginSubmitBtn').click();
            }
        });
    </script>

</html>
