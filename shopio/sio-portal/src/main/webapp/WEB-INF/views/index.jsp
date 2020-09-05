<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <base href="/">
        <title>Thế Giới Đồ Chơi Gỗ - Mỡ Mỡ Shop</title>
        <link rel="stylesheet" href="sio-portal/css/bootstrap.min.css">
        <link rel="stylesheet" href="sio-portal/css/font-lobster.css">
        <link rel="stylesheet" href="sio-portal/css/font-roboto.css">
        <link rel="stylesheet" href="sio-portal/css/style.css">        
    </head>
    <body ng-app="myApp" ng-controller="IndexCtrl">
    <div class="header">
        <div class="row">
            <div class="col-md-1"><img src="sio-portal/asset/logo.png"></div>
            <div class="col-md-6">
                <ul>
                    <li><a href="sio-portal/#/home">Trang Chủ</a></li>
                    <li><a href="sio-portal/#/product">Sản Phẩm</a></li>
                    <li><a href="sio-portal/#/location">Vị Trí</a></li>
                    <li><a href="sio-portal/#/stories">Giới Thiệu</a></li>
                    <li><a href="sio-portal/#/policy">Chính Sách Đổi Trả</a></li>
                </ul>
            </div>
            <div class="col-md-5">
                <ul class="right-control">
                    <li class="margin-left">
                        <li><input placeholder="Tìm Kiếm"></li>
                        <li><div class="btn_search"></div></li>
                    </li>
                    <li class="margin-left"><a href="javascript:void(0)" ng-click="openLoginView()" class="user"></a></li>
                    <li class="margin-left"><a class="cart" href="sio-portal/#/cart"></a></li>
                </ul>
            </div>
        </div>
    </div>
    <div ng-view></div>
    <div class="row new-letter">
        <div class="col-md-8"><input type="text" placeholder="Nhập thông tin bạn muốn gửi đến Mỡ Mỡ Shop !!!"></div>
        <div class="col-md-4"><button class="btn btn-info">GỬI EMAIL</button></div>
    </div>
    <div class="row info">
        <div class="col-md-3">
            <h4>THÔNG TIN LIÊN HỆ</h4>
            <ul>
                <li>Giờ Làm Việc: 7h - 22h</li>
                <li>87/89/52 Nguyễn Sỹ Sách, P15, Tân Bình, HCM</li>
                <li>Chủ Shop: 0974.964.847</li>
                <li>Hot Line: 0984.292.847</li>
                <li><a href="#">Email: momoshop@gmail.com</a></li>
            </ul>
        </div>
        <div class="col-md-3">
            <h4>CHĂM SÓC KHÁCH HÀNG</h4>
            <ul>
                <li><a href="#">Tư Vấn Sản Phẩm</a></li>
                <li><a href="#">Chính Sách Bảo Hành</a></li>
                <li><a href="#">Giao Hàng - Thanh Toán</a></li>
            </ul>
        </div>
        <div class="col-md-3">
            <h4>KÊNH ONLINE</h4>
            <ul>
                <li><a href="#">Facebook</a></li>
                <li><a href="#">Twitter</a></li>
                <li><a href="#">Google +</a></li>
            </ul>
        </div>
        <div class="col-md-3">
            <h4>DANH SÁCH CỬA HÀNG</h4>
            <ul>
                <li><a href="#">Chi Nhánh Hồ Chí Minh/a></li>
                <li><a href="#">Chi Nhánh Bến Tre</a></li>
                <li><a href="#">Chi Nhánh Hà Nội</a></li>
            </ul>
        </div>
    </div>
    <div class="footer">Founder: Vi Huynh - Designed By: Nhut Nguyen, Since: 14-04-2020</div>

    <script src="sio-portal/js/jquery-3.5.1.min.js"></script>
    <script src="sio-portal/js/agularjs-1.5.8/angular.min.js"></script>
    <script src="sio-portal/js/agularjs-1.5.8/angular-route.js"></script>
    <script src="sio-portal/js/boostrap-4.0/bootstrap.min.js"></script>
    <script src="sio-portal/js/boostrap-4.0/ui-bootstrap-tpls-2.5.0.js"></script>
    <script src="sio-portal/js/contants.js"></script>

    <script src="sio-portal/js/app.js"></script>

    <script src="sio-portal/static/directive/category-directive.js"></script>
    <script src="sio-portal/static/directive/navigation-directive.js"></script>
    <script src="sio-portal/static/directive/contact-directive.js"></script>
    
    <script src="sio-portal/static/factory/authorization-factory.js"></script>
    <script src="sio-portal/static/service/api-provider-service.js"></script>

    <script src="sio-portal/static/ui/home/home.js"></script>
    <script src="sio-portal/static/ui/products/products.js"></script>
    <script src="sio-portal/static/ui/location/location.js"></script>
    <script src="sio-portal/static/ui/stories/stories.js"></script>
    <script src="sio-portal/static/ui/product-detail/product-detail.js"></script>
    <script src="sio-portal/static/ui/shopping-cart/shopping-cart.js"></script>
    <script src="sio-portal/static/ui/login/login.js"></script>
    <script src="sio-portal/static/ui/register/register.js"></script>
    <script src="sio-portal/static/ui/policy/policy.js"></script>

    <script src="sio-portal/js/lodash.js" type="text/javascript"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDbC88CJ-7KMMZs1GLokAPSIwwmk6p6M1A"></script>

    </body>
</html>