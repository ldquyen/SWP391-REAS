<%-- Document : login Created on : Jan 18, 2024, 10:33:30 PM Author : ASUS --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css">
        <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css' rel='stylesheet'>
    </head>
    <style>
        .navbar {
            background-color: black;
        }

        .navbar-item {
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: Inter;
        }

        .navbar-item img {
            max-height: 45px;
            max-width: 85%;
        }

        .navbar-start .navbar-item button {
            color: #fff;
            background-color: #000;
            border: none;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: Inter;
            font-size: 16px;
        }

        .navbar-start .navbar-item button:hover {
            color: #D9AB73;
            background-color: #000;
        }

        .navbar-start a {
            color: #fff;
        }

        .navbar-start button {
            /*    color: #fff;
    background-color: #000;*/
        }

        a.navbar-item:hover {
            color: #D9AB73;
            background-color: #000;
        }

        .navbar-end .navbar-item .buttons button {
            color: #D9AB73;
            background-color: #000;
            margin-right: 0px;
            font-family: Inter;
        }

        .navbar-end .navbar-item .buttons button:hover {
            color: #fff;
        }

        .navbar-container-1 {
            padding: 0 5px;
        }

        .navbar-container-1 button {
            /*padding: 0 5px;*/
            background-color: #000;
        }

        .navbar-container-1 navbar-1 {
            padding: 5px 14px;
            color: #D9AB73;
            font-size: 18px;
            font-family: Inter;
            font-weight: 700;
            word-wrap: break-word;
            border-radius: 30px;
            border: 3px #D9AB73 solid
        }

        .navbar-container-1 button:hover {
            color: #fff;
        }

        .navbar-container-1 a:hover {
            color: #fff;
        }

        .navbar-1 {
            padding: 5px 14px;
            color: #D9AB73;
            font-size: 18px;
            font-family: Inter;
            font-weight: 700;
            word-wrap: break-word;
            border-radius: 30px;
            border: 3px #D9AB73 solid
        }

        .navbar-1-list {
            padding: 5px 14px;
            color: #D9AB73;
            font-size: 18px;
            font-family: Inter;
            font-weight: 700;
            word-wrap: break-word;
            border: 30px;
            border: 3px #D9AB73 solid;
        }

        .navbar-end .hover-down {
            background-color: #000;
            padding: 0 5px
        }

        .navbar-end .navbar-item .navbar-link:hover {
            background-color: #fff;
            color: #D9AB73;
        }

        .field {
            padding: 8px 0 0 0;
        }

        .search-bar {
            width: 80%;
            border: 3px solid #D9AB73;
            background: #FDF7FB;
        }

        .select:not(.is-multiple):not(.is-loading)::after {
            border-color: #000;
        }

        .select:not(.is-multiple):not(.is-loading):hover::after {
            border-color: #D9AB73;
        }

        .field .button-search {
            background: #000;
            width: 100%;
            color: #D9AB73;
            text-align: center;
            font-family: Inter;
            font-style: normal;
            font-weight: 600;
            line-height: normal;
        }

        .field .button-search:hover {
            color: #fff;
            background-color: #000;
        }

        .button-search-container {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 15%;
            background: #000;
            margin-left: 10px;
            border: 2px solid #FFF;

        }

        .button-search-container:hover {
            border: 2px solid #D9AB73;
        }

        .search-container {
            display: flex;
            justify-content: center;
            align-items: center;
            padding-top: 30px;
        }

        .search-wrap {
            width: 972px;
            height: 115px;
            flex-shrink: 0;
            background-color: #000;
            border: 2px solid #D9AB73;
            border-radius: 15px;
            /*border-color: #D9AB73;*/
        }

        .search-detail-container {
            display: flex;
            justify-content: center;
        }

        .search-container .field {
            display: flex;
            justify-content: center;
        }

        .search-detail-container .control .select:after {
            /*    content: '\25BC';  Unicode character for down arrow 
            font-size: 16px;
            color: #ff6600;  Change this to the desired arrow color 
            position: absolute;
            top: 50%;
            right: 5px;
            transform: translateY(-50%);*/
        }


        .realestate-quantity {
            width: 230px;
            height: 40px;
            flex-shrink: 0;
            color: #D9AB73;
            text-align: right;
            font-family: Inter;
            font-size: 22px;
            font-style: normal;
            font-weight: 800;
            line-height: normal;
            align-items: center;
            display: flex;
            justify-content: center;
        }

        .footer {
            position: fixed;
            width: 1440px;
            flex-shrink: 0;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: #000;
            color: white;
            padding: 15px 0 0 0
        }

        .footer-container {
            display: flex;
            justify-content: space-around;
            padding-top: 12px;
            max-height: 90px;
        }

        .footer_content1 {
            color: #D9AB73;
            font-family: Inter;
            font-size: 18px;
            font-style: normal;
            font-weight: 800;
            line-height: normal;
            text-align: center;
        }

        .footer-left-content {
            flex-shrink: 0;
            color: #FFF;
            font-family: Inter;
            font-size: 18px;
            font-style: normal;
            font-weight: 400;
            line-height: normal;
        }

        .footer-mid-content {
            width: 424px;
            flex-shrink: 0;
            color: #FFF;
            font-family: Inter;
            font-size: 18px;
            font-style: normal;
            font-weight: 400;
            line-height: normal;
        }

        .footer-right-content {
            width: 200px;
            height: 65px;
            flex-shrink: 0;
            max-height: 50%;
            background: lightgray 50% / cover no-repeat;
        }

        .buttons .button:not(:last-child):not(.is-fullwidth) {
            margin-right: 0px;
        }

        .buttons button {
            padding: 8px 10px;
        }


        /* login */
        .navbar-item .navbar-dropdown {
            right: 0;
            left: initial
        }

        button {
            background: initial;
            border: initial;
            color: initial;
            cursor: pointer;
        }

        .navbar-dropdown .navbar-item:hover {
            background-color: #000;
            color: #fff;
        }

        .navbar-dropdown .navbar-item button:hover {
            background-color: #000;
            color: #fff;
        }

        @media screen and (min-width: 1024px) {
            .navbar-dropdown a.navbar-item {
                padding-right: 16px !important;
                color: #fff;
            }
        }

        .navbar-dropdown {
            background-color: #000;
            border: 2px solid #D9AB73;
            margin-top: 5px;
        }

        .fake-div {
            height: 10px;
            width: 10px;
            background-color: transparent;
            font-size: .875rem;
            left: 0;
            min-width: 100%;
            position: absolute;
            top: 100%;
            z-index: 20;
        }

        .navbar-dropdown .navbar-item span {
            color: #fff;
        }

        .navbar-dropdown .navbar-item span:hover {
            color: #D9AB73 !important;
        }

        .navbar-item .navbar-link:focus {
            background-color: #000;
            color: #D9AB73;
        }

        .navbar-dropdown a.navbar-item:hover {
            background-color: initial;
            color: #D9AB73 !important;
        }

        .navbar-dropdown a.navbar-item:focus {
            background-color: #000 !important;
        }

        .navbar-link:not(.is-arrowless)::after {
            border-color: #D9AB73;
            ;
            /* Default border color */
        }

        /* Styles when .navbar-link is focused */
        .navbar-item .navbar-link:focus {
            background-color: #000;
            color: #fff;
        }


        .navbar-divider {
            background-color: #323232;
        }

        .navbar-link:not(.is-arrowless) {
            padding-right: 2.5em;
            max-height: 36px;
        }



        /*                                                           login                                                      */
        .background-login {
            width: 100%;
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: inherit;
            max-height: calc(100vh - 125px);
            min-height: calc(100vh - 125px);
            margin: 0;
            padding: 0;
        }

        .login-container {
            position: fixed;
            top: 13%;
            left: 0;
            right: 0;
            bottom: 0;
            /*background-color: rgba(0, 0, 0, 0.3);*/
            display: block;
            align-items: center;
            justify-content: center;
        }

        .login-modal-container {
            position: relative;
            width: 435px;
            margin: auto;
            border-radius: 57px;
            border: 3px solid #D9AB73;
            background: rgba(0, 0, 0, 0.70);
            flex-shrink: 0;
            min-height: 200px;
            max-width: calc(100% - 32px);
            animation: modalFadeIn ease 0.5s;

        }

        .login-modal-container header .navbar-item:hover {
            color: #D9AB73;
            background-color: initial;
        }

        .header-login {
            text-align: center;
            color: #D9AB73;
            font-family: Inter;
        }

        .header-login a {
            display: inline-block;
        }

        .header-login img {
            max-width: 100%;
            height: auto;
            vertical-align: middle;
        }

        .register-if-dont-have-container {
            display: flex;
        }

        .container login {
            text-align: center;
            /* Căn giữa nội dung trong container */
        }

        .register-if-dont-have-container,
        .register-here {
            display: inline-block;
        }

        .registration-form {
            display: inline-block;
        }

        .submit-login-btn:hover {
            color: #fff !important;
            /*border-color: rgba(0, 0, 0, 0.70) !important;*/
        }

        .sign-up-in-login {
            padding: 0;
            height: unset;
            background-color: transparent !important;
            color: #fff !important;
            line-height: 20px;
        }

        .sign-up-in-login:hover {
            text-decoration: underline;
        }

        .input-username {
            width: 70%;
            background-color: transparent;
            color: #fff;
            border-bottom: #D9AB73 3px solid;
            margin-top: 16px;
        }

        .form-login-container {
        }

        .input-username::placeholder {
            color: #fff;
        }

        .input-username:focus,
        .input-username:hover,
        .input-username:active {
            border-color: #000;
            border-bottom: #D9AB73 3px solid;
            box-shadow: initial;
        }

        .input-password {
            width: 70%;
            color: #fff;
            background-color: transparent;
            border-bottom: #D9AB73 3px solid;
            margin-top: 16px;
        }

        .input-password:focus,
        .input-password:hover,
        .input-password:active {
            border-color: #000;
            border-bottom: #D9AB73 3px solid;
            box-shadow: initial;
        }

        .input-password::placeholder {
            color: #fff;
        }

        .forgot-password:hover {
            text-decoration: underline;
        }

        .forgot-password {
            display: block;
            left: 15%;
            padding: 5px 0 0 0;
            height: unset;
            background-color: transparent !important;
            color: #fff !important;
            line-height: 20px;
        }

        .submit-with-gg-btn {
            color: #fff !important;
        }

        .submit-with-gg-btn:hover {
            color: #333 !important;
        }

        /*.img-logo-login {
max-width: 50px;
}*/

        .forgot {
            background-color: #fff;
            padding: 12px;
            border: 1px solid #dfdfdf
        }

        .padding-bottom-3x {
            padding-bottom: 72px !important
        }

        .card-footer {
            background-color: #fff
        }

        .btn {
            font-size: 13px
        }

        .form-control:focus {
            color: #495057;
            background-color: #fff;
            border-color: #76b7e9;
            outline: 0;
            box-shadow: 0 0 0 0px #28a745
        }



        .card-footer {
            display: flex;
            justify-content: space-between;
        }
        .rest-password-container {
            position: absolute;
            top: 20px;
            width: 100%;
        }
        .reset-password-form {
            background-color: rgba(0, 0, 0, 0.70);
            border-radius: 10px;
            border: 3px solid #D9AB73;
        }
        .reset-password-form-footer{
            background: none;
        }
    </style>

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
                    <div class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="DN" name="action">
                                <span>TIN TỨC</span>
                            </button>
                        </form>
                    </div>

                    <div class="navbar-item">
                        <form action="MainController" method="post">
                            <button type="submit" value="DN" name="action">
                                <span>NỘI QUY</span>
                            </button>
                        </form>
                    </div>


                </div>

                <div class="navbar-end">
                    <div class="navbar-item">
                        <div class="buttons">
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

        <div style="position: relative">
            <img class="background-login" src="image/background-login.png" alt="background-login" />
            <div class="row justify-content-center rest-password-container" >
                <div class="col-12 col-md-9 col-lg-7 col-xl-6 mt-5 ">
                    <!-- White Container -->
                    <div class="container  rounded mt-2 mb-2 px-0 reset-password-form">
                        <!-- Main Heading -->
                        <div class="row justify-content-center align-items-center pt-3">
                            <h1>
                                <strong style="color: white">Reset Password</strong>
                            </h1>
                        </div>
                        <div class="pt-3 pb-3 ">
                            <form class="form-horizontal" action="MainController" method="POST">
                                <!-- User Name Input -->
                                <div class="form-group row justify-content-center px-3">
                                    <div class="col-9 px-0">
                                        <input type="text" name="password" placeholder="&#xf084; &nbsp; New Password"
                                               class="form-control border-info placeicon">
                                    </div>
                                </div>
                                <!-- Password Input -->
                                <div class="form-group row justify-content-center px-3">
                                    <div class="col-9 px-0">
                                        <input type="password" name="confPassword"
                                               placeholder="&#xf084; &nbsp; Confirm New Password"
                                               class="form-control border-info placeicon">
                                    </div>
                                </div>

                                <!-- Log in Button -->
                                <div class="form-group row justify-content-center">
                                    <div class="col-6 px-3 mt-3">
                                        <button type="submit" value="resetPassword" name="action"
                                                class="btn btn-block btn-info">Reset password</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!-- Alternative Login -->
                        <div class="mx-0 px-0 reset-password-form-footer">

                            <!-- Horizontal Line -->
                            <div class="px-4 pt-5">
                                <hr>
                            </div>
                            <!-- Register Now -->
                            <div class="pt-2">
                                <div class="row justify-content-center" style="padding-bottom: 10px;">
                                    <h5 style="color: white">
                                        Don't have an Account?<span><a href="#"
                                                                       class="text-danger" style="font-weight: bold;"> Register Now!</a></span>
                                    </h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<footer class="footer">
    <div>
        <p class="footer_content1">CÔNG TY TNHH ĐẤU GIÁ BẤT ĐỘNG SẢN REAS</p>
        <div class="footer-container">
            <div class="footer-left-content"> Liên hệ:<br />
                Email: reas@gmail.com<br />
                Điện thoại: +84 (24) 8888 9999<br />
                <br />
            </div>
            <div class="footer-mid-content"> Trụ sở chính:<br />
                Lô E2a-7, Đường D1, Đ. D1, Long Thạnh Mỹ, Thành Phố Thủ Đức, Thành phố Hồ Chí Minh<br />
                <br />
            </div>
            <img class="footer-right-content" src="image/logofu.png" alt="" href="" width="100"
                 height="28" />
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
</script>
<script type='text/javascript'
src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js'></script>
<script type='text/javascript' src=''></script>
<script type='text/javascript' src=''></script>
<script type='text/Javascript'></script>

</html>