<%-- 
    Document   : postRealEstate
    Created on : Jan 22, 2024, 11:24:00 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Real Estate Auction System</title>
        <link rel="icon" type="image/x-icon" href="image/logo.png">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
        <link rel="stylesheet" href="style.css" type="text/css" >
        <link rel="stylesheet" href="postRealEstate.css" type="text/css" >
        <style>
            /* Style cho form */

            .form-post-real-estate {
                width: 700px; /* Điều chỉnh chiều rộng form */
                margin: 0 auto;
                padding: 30px;
                background-color: #D9D9D9;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); /* Đổ bóng cho form */
                font-family: Arial, sans-serif;
            }

            /* Style cho tiêu đề */
            .TieuDe h1 {
                text-align: center;
                color: #333;
                margin-bottom: 20px;
                font-size: 40px; /* Kích thước font chữ */
                font-weight: bold; /* Chữ in đậm */
            }

            /* Style cho label */
            label {
                font-weight: bold;
                font-size: 20px;
                margin-bottom: 5px;
                display: block; 
            }
            .form-post-real-estate ::placeholder {
                font-size: 16;
                color: #333;
                font-style: normal;
            }

            /* Style cho input và select */
            input[type="text"],
            input[type="datetime-local"],
            select,option {
                width: 100%;
                padding: 10px;
                border: 2px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-bottom: 15px;
                margin-left: 0px;
                font-size: 14px;
                resize: vertical;
                
            }

            .form-container textarea {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-bottom: 15px;
                font-size: 14px;
                resize: vertical; /* Cho phép resize theo chiều dọc */
            }

            /* Style cho nút submit */
            button.btn-submit {
                text-align: center;
                display: block;
                margin: 0 auto;
                background-color: #000; 
                color: white;
                padding: 15px 24px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 20px;
                font-weight: bold;
                transition: background-color 0.3s ease;
                margin-top: 20px;
            }

            button.btn-submit:hover {
                background-color: #D9AB73; /* Màu đậm hơn khi di chuột qua */
            }

            input[type="file"] {
                width: 200px;
                display: inline-block;
                padding: 8px 12px;
                background-color: #f2f2f2;
                border: 2px solid #ccc;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
                color: #333;
                transition: background-color 0.3s ease;
                
            }

            input[type="file"]:hover {
                background-color: #e6e6e6;
                border: 2px solid #ccc;
            }

            input[type="file"]:focus {
                outline: none;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
                border: 2px solid #ccc;
            }

            .checkbox-container {
                display: flex;
                align-items: center;
                justify-content: center; /* Căn giữa theo chiều ngang */
                margin-top: 10px; /* Khoảng cách từ checkbox và label đến các trường form */
            }

            .checkbox-container input[type="checkbox"] {
                margin-right: 10px; /* Khoảng cách giữa checkbox và label */
            }

            .checkbox-container label {
                font-size: 16px; /* Kích thước font chữ */
                color: #333; /* Màu chữ */
            }

            .form-control {
                border: 2px solid #ccc;
                display: block;
                width: 100%;
                padding: .375rem .75rem;
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                color: var(--bs-body-color);
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                background-color: #ffffff;
                background-clip: padding-box;
                border: var(--bs-border-width) solid var(--bs-border-color);
                border-radius: var(--bs-border-radius);
                transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;
            }
            textarea {
                resize: vertical;
                min-height: calc(1.5em + .75rem + calc(var(--bs-border-width)* 2));
                border: 2px solid #ccc;
            }
            div {
                display: block;
            }
            option{
                font-size: 16px;
            }

        </style>
        <script>
            // Hàm hiển thị cửa sổ thông báo
            function showErrorMessage(message) {
                alert(message);
            }
            // Kiểm tra và hiển thị thông báo nếu có
            <c:if test="${not empty requestScope.Success}">
            showErrorMessage("${requestScope.Success}");
            </c:if>
            <c:if test="${not empty requestScope.Fail}">
            showErrorMessage("${requestScope.Fail}");
            </c:if>
            <c:if test="${not empty requestScope.Wrong_Area}">
            showErrorMessage("${requestScope.Wrong_Area}");
            </c:if>
            <c:if test="${not empty requestScope.Wrong_Area_Nummeric}">
            showErrorMessage("${requestScope.Wrong_Area_Nummeric}");
            </c:if>
            <c:if test="${not empty requestScope.Wrong_PriceFirst}">
            showErrorMessage("${requestScope.Wrong_PriceFirst}");
            </c:if>
        </script>
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
                                    <form action="MemberController" method="post">
                                        <button type="submit" value="mypost" name="action">
                                            <input type="hidden" value="${sessionScope.member.accID}" name="mypostID">
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
                                        <button type="submit" value="Logout" name="action" >
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
        <div class="BodyForm">
            <div class="TieuDe">
                <h1>
                    ĐĂNG KÍ THÔNG TIN ĐẤU GIÁ
                </h1>
            </div>

            <div class="form-post-real-estate" >
                <form action="MainController" method="post" enctype="multipart/form-data">
                    <input type="hidden" id="accID" name="accID" value="${sessionScope.member.accID}">
                    <!--                    <input type="text" id="realEstateID" name="realEstateID" required/></br>-->
                    <div class="form-element">
                        <label>1. Tên tài sản đấu giá</label>
                        <input type="text" class="form-control" id="realEstateName" name="realEstateName" required></br>
                    </div>
                    <div class="form-element">
                        <label>2. Địa chỉ</label>
                        <input type="text" class="form-control" id="address" name="address" required></br>
                    </div>
                    <div class="form-element">
                        <label>3. Loại</label>
                        <select id="loaiTaiSan" class="form-control" name="catID" required></br>
                            <option value="" disabled selected hidden>-- Chọn --</option>
                            <option value="no">Nhà </option>
                            <option value="dn">Đất </option>
                            <option value="cc">Chung cư</option>
                            <option value="bt">Biệt thự</option>
                        </select></br>
                    </div>
                    <div class="form-element">
                        <label>4. Thành phố</label>
                        <select id="cityID" class="form-control" name="cityID" required>
                            <option value="" disabled selected hidden>-- Chọn --</option>
                            <option value="1">An Giang</option>
                            <option value="2">Bà Rịa - Vũng Tàu</option>
                            <option value="3">Bắc Giang</option>
                            <option value="4">Bắc Kạn</option>
                            <option value="5">Bạc Liêu</option>
                            <option value="6">Bắc Ninh</option>
                            <option value="7">Bến Tre</option>
                            <option value="8">Bình Định</option>
                            <option value="9">Bình Bương</option>
                            <option value="10">Bình Phước</option>
                            <option value="11">Bình Thuận</option>
                            <option value="12">Cà Mau</option>
                            <option value="13">Cao Bằng</option>
                            <option value="14">Cần Thơ</option>
                            <option value="15">Đà Nẵng</option>
                            <option value="16">Đắk Lắk</option>
                            <option value="17">Đắk Nông</option>
                            <option value="18">Điện Biên</option>
                            <option value="19">Đồng Nai</option>
                            <option value="20">Đồng Tháp</option>
                            <option value="21">Gia Lai</option>
                            <option value="22">Hà Giang</option>
                            <option value="23">Hà Nam</option>
                            <option value="24">Hà Tĩnh</option>
                            <option value="25">Hà Nội</option>
                            <option value="26">Hải Dương</option>
                            <option value="27">Hải Phòng</option>
                            <option value="28">Hậu Giang</option>
                            <option value="29">Hòa Bình</option>
                            <option value="30">Hưng Yên</option>
                            <option value="31">Khánh Hòa</option>
                            <option value="32">Kiên Giang</option>
                            <option value="33">Kon Tum</option>
                            <option value="34">Lai Châu</option>
                            <option value="35">Lâm Đồng</option>
                            <option value="36">Lạng Sơn</option>
                            <option value="37">Lào Cai</option>
                            <option value="38">Long An</option>
                            <option value="39">Nam Định</option>
                            <option value="40">Nghệ An</option>
                            <option value="41">Ninh Bình</option>
                            <option value="42">Ninh Thuận</option>
                            <option value="43">Phú Thọ</option>
                            <option value="44">Phú Yên</option>
                            <option value="45">Quảng Bình</option>
                            <option value="46">Quảng Nam</option>
                            <option value="47">Quảng Ngãi</option>
                            <option value="48">Quảng Ninh</option>
                            <option value="49">Quảng Trị</option>
                            <option value="50">Sóc Trăng</option>
                            <option value="51">Sơn La</option>
                            <option value="52">Tây Ninh</option>
                            <option value="53">Thái Bình</option>
                            <option value="54">Thái Nguyên</option>
                            <option value="55">Thanh Hóa</option>
                            <option value="56">Thừa Thiên Huế</option>
                            <option value="57">Tiền Giang</option>
                            <option value="58">Hồ Chí Minh</option>
                            <option value="59">Trà Vinh</option>
                            <option value="60">Tuyên Quang</option>
                            <option value="61">Vĩnh Long</option>
                            <option value="62">Vĩnh Phúc</option>
                            <option value="63">Yên Bái</option>
                        </select></br>
                    </div>
                    <div class="form-element">
                        <label>5. Giá       
                            <span style="font-size: 14px; color: red; margin-top: 5px;" >1 Xu = 1.000.000VNĐ (1 triệu VNĐ)</span>
                        </label>
                        <input type="text" class="form-control" id="priceFirst" name="priceFirst" placeholder="Xu" oninput="formatCurrency(this)" required></br>
                    </div>
                    <div class="form-element">
                        <label>6. Thời gian bắt đầu</label>
                        <input type="datetime-local" class="form-control" id="timeStart" name="timeStart"  required></br>
                        <script>
                            // Lấy ngày và giờ hiện tại
                            var currentDate = new Date();

                            // Thêm 3 ngày vào thời gian hiện tại
                            currentDate.setDate(currentDate.getDate() + 3);

                            // Chuyển đổi ngày hiện tại thành chuỗi định dạng ISO (yyyy-mm-ddThh:mm)
                            var currentDateTime = currentDate.toISOString().slice(0, 16);


                            // Thiết lập thuộc tính min cho các trường datetime-local
                            document.getElementById("timeStart").min = currentDateTime;
                        </script>
                    </div>
                    <div class="form-element">
                        <label>7. Thời gian kết thúc</label>
                        <input type="datetime-local" class="form-control" id="timeEnd" name="timeEnd"  required></br>
                        <script>
                            // Lấy ngày và giờ hiện tại
                            var currentDate = new Date();

                            // Thêm 3 ngày vào thời gian hiện tại
                            currentDate.setDate(currentDate.getDate() + 10);

                            // Chuyển đổi ngày hiện tại thành chuỗi định dạng ISO (yyyy-mm-ddThh:mm)
                            var currentDateTime = currentDate.toISOString().slice(0, 16);

                            // Thiết lập thuộc tính min cho các trường datetime-local
                            document.getElementById("timeEnd").min = currentDateTime;

                            // Tính toán thời gian kết thúc tối đa (30 ngày sau thời gian bắt đầu)
                            var maxEndDate = new Date(currentDate.getTime() + (30 * 24 * 60 * 60 * 1000));

                            // Chuyển đổi ngày kết thúc tối đa thành chuỗi định dạng ISO (yyyy-mm-ddThh:mm)
                            var maxEndDateTime = maxEndDate.toISOString().slice(0, 16);

                            // Thiết lập thuộc tính max cho thời gian kết thúc là 30 ngày sau thời gian bắt đầu
                            document.getElementById("timeEnd").max = maxEndDateTime;
                        </script>

                        <script>
                            // Lấy thẻ input của thời gian bắt đầu và thời gian kết thúc
                            var timeStartInput = document.getElementById("timeStart");
                            var timeEndInput = document.getElementById("timeEnd");

                            // Sử dụng sự kiện onchange để kiểm tra thời gian kết thúc sau khi thời gian bắt đầu đã thay đổi
                            timeStartInput.addEventListener("change", function () {
                                // Lấy giá trị thời gian bắt đầu và thời gian kết thúc
                                var startTime = new Date(timeStartInput.value);
                                var endTime = new Date(timeEndInput.value);

                                // Kiểm tra nếu thời gian kết thúc nhỏ hơn thời gian bắt đầu
                                if (endTime <= startTime) {
                                    // Thiết lập giá trị của thời gian kết thúc bằng thời gian bắt đầu + 1 giây
                                    endTime = new Date(startTime.getTime() + 86400);
                                    // Cập nhật giá trị của thời gian kết thúc trong thẻ input
                                    timeEndInput.value = endTime.toISOString().slice(0, 16);
                                }
                            });

                            // Sử dụng sự kiện onchange để kiểm tra thời gian bắt đầu sau khi thời gian kết thúc đã thay đổi
                            timeEndInput.addEventListener("change", function () {
                                // Lấy giá trị thời gian bắt đầu và thời gian kết thúc
                                var startTime = new Date(timeStartInput.value);
                                var endTime = new Date(timeEndInput.value);

                                // Kiểm tra nếu thời gian kết thúc nhỏ hơn hoặc bằng thời gian bắt đầu
                                if (endTime <= startTime) {
                                    // Thiết lập giá trị của thời gian bắt đầu bằng thời gian kết thúc trước đó - 1 giây
                                    startTime = new Date(endTime.getTime() + 86400);
                                    // Cập nhật giá trị của thời gian bắt đầu trong thẻ input
                                    timeStartInput.value = startTime.toISOString().slice(0, 16);
                                }
                            });
                        </script>
                    </div>
                    <div class="form-element">
                        <label>8. Diện tích <span style="font-size: 10px;">(m²)</span></label>
                        <input type="text" class="form-control" id="area" name="area" placeholder="(m²)" oninput="formatCurrency(this)" required></br>
                        <script>
                            function validateArea() {
                                // Lấy giá trị diện tích từ trường input
                                var areaValue = document.getElementById("area").value;

                                // Chuyển đổi giá trị diện tích sang kiểu số
                                var areaNumber = parseFloat(areaValue);

                                // Kiểm tra nếu giá trị diện tích là lớn hơn 0
                                if (areaNumber <= 0 || isNaN(areaNumber)) {
                                    // Hiển thị thông báo lỗi
                                    alert("Diện tích phải lớn hơn 0");
                                    // Ngăn chặn việc gửi form đi
                                    return false;
                                }
                                // Cho phép gửi form đi nếu điều kiện hợp lệ
                                return true;
                            }
                        </script>
                    </div>
                    <div class="form-element">
                        <label>9. Mô tả</label>
                        <textarea id="detail" class="form-control" name="detail" rows="6" cols="60" placeholder="Nhập mô tả tài sản..." required style="height:134px;"></textarea></br>
                    </div>
                    <div class="form-element">
                        <label>10. Hình ảnh <span style="font-size: 10px; color: red;">ĐỊNH DẠNG: .JPG\.PNG\.JPEG</span></label><br>
                        <input type="file" title="Chọn Ảnh" name="image1" required/>
                        <input type="file" title="Chọn Ảnh" name="image2" required/> 
                        <input type="file" title="Chọn Ảnh" name="image3" required/>
                    </div></br>

                    <div class="checkbox-container">
                        <input type="checkbox" id="agreeCheckbox" required>
                        <label for="agreeCheckbox">Tôi đảm bảo mọi thông tin là sự thật</label>
                    </div>

                    <button type="submit" value="submitPost" name="action" class="btn-submit">
                        Đăng tin
                    </button>

                </form>

            </div>
        </div>
        <!-- END BODY -->

        <footer class="footer" style="position: inherit; margin-top: 30px"> 
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

            function formatCurrency(input) {
                // Hàm định dạng số tiền sang dạng chuỗi có định dạng tiền tệ
                var value = input.value.replace(/[^\d]/g, '');

                // Định dạng giá trị thành chuỗi có dấu phân cách hàng nghìn
                var formattedValue = new Intl.NumberFormat().format(value);

                // Gán giá trị định dạng vào trường input
                input.value = formattedValue;
            }

        </script>
    </body>
</html>
