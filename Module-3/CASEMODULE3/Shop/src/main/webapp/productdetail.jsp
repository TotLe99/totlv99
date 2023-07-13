<%--
  Created by IntelliJ IDEA.
  User: HDC
  Date: 7/1/2023
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html class="no-js" lang="vi">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0,
      user-scalable=0" name="viewport">
  <meta name="revisit-after" content="1 day">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <meta name="HandheldFriendly" content="true">
  <link rel="stylesheet" href="/plugins/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="/plugins/animate/animate.min.css">
  <link rel="stylesheet" href="/plugins/fontawesome/all.css">
  <link href="/plugins/webfonts/font.css" rel="stylesheet">
  <link rel="stylesheet" href="/plugins/owl.carousel/owl.carousel.min.css" type="text/css">
  <link rel="stylesheet" href="/plugins/owl.carousel/owl.theme.default.min.css">
  <!-- UIkit CSS -->
  <link rel="stylesheet" href="/plugins/uikit/uikit.min.css"/>
  <link rel="stylesheet" type="text/css" href="/css/style.css">
  <link rel="stylesheet" href="/css/detaiproduct.css">

  <title> Sản phẩm </title>

</head>

<body>
<div class="header">
  <a style="color: #ffffff;text-decoration: none">MIỄN PHÍ
    VẬN CHUYỂN VỚI ĐƠN HÀNG NỘI THÀNH > 300K
    - ĐỔI TRẢ TRONG 30 NGÀY - ĐẢM BẢO CHẤT LƯỢNG</a>
</div>

<!--Navbar-->

<nav class="navbar navbar-expand-lg navbar-light bg-white sticky-top">

  <div class="container">
    <a class="navbar-brand" href="index">
      <img src="/images/logo.png" class="logo-top" alt="">
    </a>
    <div class="desk-menu collapse navbar-collapse justify-content-md-center" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item active">

        </li>
        <li class="nav-item">
          <a class="nav-link" href="/index">Trang chủ</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/product">BỘ SƯU TẬP</a>
        </li>

        <li class="nav-item">
          <a class="nav-link" href="/introduce">GIỚI THIỆU</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/blog">BLOG</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/contact">LIÊN HỆ</a>
        </li>
      </ul>
    </div>
    <div id="offcanvas-flip" uk-offcanvas="flip: true; overlay: true">
      <div class="uk-offcanvas-bar" style="    background: white;
              width: 350px;">

        <button class="uk-offcanvas-close" style="color:#272727" type="button" uk-close></button>

        <h3 style="font-size: 14px;
                  color: #272727;
                  text-transform: uppercase;
                  margin: 3px 0 30px 0;
                  font-weight: 500; letter-spacing: 2px;">Tìm kiếm</h3>
        <div class="search-box wpo-wrapper-search">
          <form action="search" class="searchform searchform-categoris ultimate-search">
            <div class="wpo-search-inner" style="display:inline">
              <input type="hidden" name="type" value="product">
              <input required="" id="inputSearchAuto" name="q" maxlength="40" autocomplete="off"
                     class="searchinput input-search search-input" type="text" size="20"
                     placeholder="Tìm kiếm sản phẩm...">
            </div>
            <button type="submit" class="btn-search btn" id="search-header-btn">
              <i style="font-weight:bold" class="fas fa-search"></i>
            </button>
          </form>
          <div id="ajaxSearchResults" class="smart-search-wrapper ajaxSearchResults" style="display: none">
            <div class="resultsContent"></div>
          </div>
        </div>
      </div>
    </div>
    <div id="offcanvas-flip2" uk-offcanvas="flip: true; overlay: true">
      <div class="uk-offcanvas-bar" style="    background: white;
              width: 350px;">

        <button class="uk-offcanvas-close" style="color:#272727" type="button" uk-close></button>

        <h3 style="font-size: 14px;
                  color: #272727;
                  text-transform: uppercase;
                  margin: 3px 0 30px 0;
                  font-weight: 500; letter-spacing: 2px;">Giỏ hàng</h3>
        <div class="site-nav-container-last" style="color:#272727">
          <div class="cart-view clearfix">
            <table id="cart-view">
              <tbody>
              <tr class="item_1">
                <td class="img"><a href="" title="Nike Air Max 90 Essential &quot;Grape&quot;"><img
                        src="/images/shoes/1.jpg" alt="/products/nike-air-max-90-essential-grape"></a>
                </td>
                <td>
                  <a class="pro-title-view" style="color: #272727" href=""
                     title="Nike Air Max 90 Essential &quot;Grape&quot;">Nike Air Max 90 Essential
                    "Grape"</a>
                  <span class="variant">Tím / 36</span>
                  <span class="pro-quantity-view">
                                        <div class="quantity-picker">
                                            <div class="quantity-controls">
                                            <button type="button" class="quantity-decrease">-</button>
                                            <input type="text" id="quantity-input" min="1" value="1">
                                            <button type="button" class="quantity-increase">+</button>
                                            </div>
                                         </div>
                                    </span>
                  <span class="pro-price-view">4,800,000₫</span>
                  <span class="remove_link remove-cart"><a href=""><i style="color: #272727;"
                                                                      class="fas fa-times"></i></a></span>
                </td>
              </tr>
              </tbody>
            </table>
            <span class="line"></span>
            <table class="table-total">
              <tbody>
              <tr>
                <td class="text-left">TỔNG TIỀN:</td>
                <td class="text-right" id="total-view-cart">4,800,000₫</td>
              </tr>
              <tr>
                <td><a href="viewcart" class="linktocheckout btn btn-success" style="color: white">Thanh toán</a></td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

    <div class="icon-ol">
      <a style="color: #272727" href="/login">
        <i class="fas fa-user-alt"></i>
      </a>
      <button class="navbar-toggler" type="button" uk-toggle="target: #offcanvas-flip1" data-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
  </div>
  </div>

</nav>
<!--  detail product -->
<main class="">

  <div id="product" class="productDetail-page">

    <!-- detail product chính -->
    <div class="container">
      <div class="row product-detail-wrapper">
        <div class="col-md-12 col-sm-12 col-xs-12">
          <div class="row product-detail-main pr_style_01">
            <div class="col-md-7 col-sm-12 col-xs-12">
              <div class="product-gallery">
                <div class="product-gallery__thumbs-container hidden-sm
                    hidden-xs">
                  <div class="product-gallery__thumbs thumb-fix">

                    <div class="product-gallery__thumb  active" id="img1">
                      <a class="product-gallery__thumb-placeholder" href="javascript:void(0);"
                         data-image="${viewShoe.url}"
                         data-zoom-image="${viewShoe.url}">
                        <img src="${viewShoe.url}"
                             data-image="${viewShoe.url}"
                             alt="Nike Air Max 90 Essential" grape="">
                      </a>
                    </div>

                  </div>
                </div>
                <div class="product-image-detail box__product-gallery
                    scroll hidden-xs">
                  <ul id="sliderproduct" class="site-box-content
                      slide_product">

                    <li class="product-gallery-item gallery-item
                        current " id="imgg1a">
                      <img class="product-image-feature " src="${viewShoe.url}"
                           alt="Nike Air Max 90 Essential" grape="">
                    </li>

                  </ul>
                  <div class="product-image__button">
                    <div id="product-zoom-in" class="product-zoom
                        icon-pr-fix" aria-label="Zoom in" title="Zoom in">
                        <span class="zoom-in" aria-hidden="true">
                          <svg version="1.1" xmlns="http://www.w3.org/2000/svg"
                               xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 36 36" style="enable-background:new 0 0 36 36; width:
                            30px; height: 30px;" xml:space="preserve">
                            <polyline points="6,14 9,11 14,16 16,14 11,9
                              14,6 6,6">
                            </polyline>
                            <polyline points="22,6 25,9 20,14 22,16 27,11
                              30,14 30,6">
                            </polyline>
                            <polyline points="30,22 27,25 22,20 20,22
                              25,27 22,30 30,30">
                            </polyline>
                            <polyline points="14,30 11,27 16,22 14,20 9,25
                              6,22 6,30">
                            </polyline>
                          </svg>
                        </span>
                    </div>
                    <div class="gallery-index icon-pr-fix"><span class="current">1</span>
                      / <span class="total">8</span></div>
                  </div>
                </div>
              </div>
              <div class="product-gallery-slide">
                <div class="owl-carousel owl-theme owl-product-gallery-slide">
                  <div class=" item">
                    <div class="product-gallery__thumb  >
                      <a class=" product-gallery__thumb-placeholder href="javascript:void(0);"
                         data-image="${viewShoe.url}"
                         data-zoom-image="${viewShoe.url}">
                      <img src="${viewShoe.url}"
                           data-image="${viewShoe.url}"
                           alt="Nike Air Max 90 Essential" grape="">
                      </a>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-5 col-sm-12 col-xs-12
                product-content-desc" id="detail-product">
              <div class="product-content-desc-1">
                <div class="product-title">
                  <h1>${viewShoe.name}</h1>
                  <span id="pro_sku">${viewShoe.id}</span>
                </div>
                <div class="product-price" id="price-preview"><span class="pro-price">${viewShoe.price}₫</span>
                </div>
                <form id="add-item-form" action="/login" method="post" class="variants clearfix">
                  <div class="select clearfix">
                    <div class="selector-wrapper"><label for="product-select-option-0">Màu
                      sắc</label><span
                            class="custom-dropdown custom-dropdown--white">
                      <select class="single-option-selectorcustom-dropdown__select
                             custom-dropdown__select--white" data-option="option1" id="product-select-option-0">
                        <option value="Tím">Tím</option>
                        <option value="Xanh">Xanh</option>
                      </select></span>
                    </div>
                    <div class="selector-wrapper"><label for="product-select-option-1">Kích
                      thước</label><span
                            class="custom-dropdown custom-dropdown--white"><select class="single-option-selector
                            custom-dropdown__select
                            custom-dropdown__select--white" data-option="option2" id="product-select-option-1">
                          <option value="35">35</option>
                          <option value="36">36</option>
                          <option value="37">37</option>
                          <option value="38">38</option>
                          <option value="39">39</option>
                          <option value="40">40</option>
                          <option value="41">41</option>
                          <option value="42">42</option>
                        </select></span></div>
                    <select id="product-select" name="id" style="display:none;">

                      <option value="1040377813">Tím / 36 - 4,800,000₫</option>
                      <option value="1040377814">Tím / 37 - 4,800,000₫</option>
                      <option value="1040377815">Tím / 38 - 4,800,000₫</option>
                      <option value="1040409049">Xanh / 35 - 4,800,000₫</option>
                      <option value="1040409050">Xanh / 36 - 4,800,000₫</option>
                      <option value="1040409053">Xanh / 37 - 4,800,000₫</option>
                      <option value="1040409054">Xanh / 38 - 4,800,000₫</option>
                    </select>
                  </div>
                  <br>
                  <div class="color-product">
                    <button type="button" class="btn btn-primary"></button>
                    <button type="button" class="btn btn-warning"></button>
                    <button type="button" class="btn btn-danger"></button>
                    <button type="button" class="btn btn-success"></button>
                    <button type="button" class="btn btn-dark"></button>
                    <button type="button" class="btn btn-light" style="border: solid 1px"></button>
                  </div>
                  <br>
                  <div class="group-filter" aria-expanded="true">
                    <div class="layered_subtitle dropdown-filter">
                    </div>
                    <div class="layered-content filter-size s-filter size-shoe">
                      <ul class="check-box-list clearfix" style="list-style: none">
                        <li>
                          <input type="radio" id="data-size-p1" name="size" value="35">
                          <label for="data-size-p1">35</label>
                        </li>
                        <li>
                          <input type="radio" id="data-size-p2" name="size" value="36">
                          <label for="data-size-p2">36</label>
                        </li>
                        <li>
                          <input type="radio" id="data-size-p3" name="size" value="37">
                          <label for="data-size-p3">37</label>
                        </li>
                        <li>
                          <input type="radio" id="data-size-p4" name="size" value="38">
                          <label for="data-size-p4">38</label>
                        </li>
                        <li>
                          <input type="radio" id="data-size-p5" name="size" value="39">
                          <label for="data-size-p5">39</label>
                        </li>
                        <li>
                          <input type="radio" id="data-size-p6" name="size" value="40">
                          <label for="data-size-p6">40</label>
                        </li>
                      </ul>
                    </div>
                  </div>


                  <div class="selector-actions">
                    <div class="quantity-area clearfix">
                      <p><b>Chọn số lượng</b></p>
                      <input type="button" value="-" onclick="minusQuantity()" class="qty-btn">
                      <input type="text" id="quantity" name="quantity" value="1" min="1"
                             class="quantity-selector">
                      <input type="button" value="+" onclick="plusQuantity()" class="qty-btn">
                    </div>

                    <script>
                      function minusQuantity() {
                        var quantityInput = document.getElementById("quantity");
                        var currentValue = parseInt(quantityInput.value);

                        if (currentValue > 1) {
                          quantityInput.value = currentValue - 1;
                        }
                      }

                      function plusQuantity() {
                        var quantityInput = document.getElementById("quantity");
                        var currentValue = parseInt(quantityInput.value);

                        quantityInput.value = currentValue + 1;
                      }
                    </script>

                    <div class="wrap-addcart clearfix">
                      <a href="/login">
                        <button type="button" class="btn btn-success" style="width: 100%">
                          Thêm vào giỏ hàng
                        </button></a>
                    </div>
                  </div>
                </form>
                <div class="product-description">
                  <div class="title-bl">
                    <h2>Mô tả</h2>
                  </div>
                  <div class="description-content">
                    <div class="description-productdetail">
                      <p><span>Hiện đại và thời trang khi diện item mới
                          của Nike. Màu sắc lạ mắt, chất liệu
                          thoáng mát, nhẹ nhàng, phù hợp với những chàng
                          trai yêu phong cách
                          sports.</span><br><br></p>
                      <ul>
                        <li>Chất liệu cao cấp EVA, PU, Cushlon, Phylon.</li>
                        <li>Bền, chống bám bẩn, dễ dàng lau chùi. Mũi giày
                          đầy đặn, form dáng chuẩn.
                        </li>
                        <li>Bảo vệ đầu ngón chân khi hoạt động. Có lớp lót
                          đệm bên trong.
                        </li>
                        <li>Êm, di chuyển nhiều không bị đau chân. Cổ giày
                          thiết kế đơn giản, vừa vặn.
                        </li>
                        <li>Di chuyển dễ dàng, thoải mái.</li>
                        <li>Đế bằng chất liệu cao su<br></li>
                        <li>Êm ái, độ bám tốt, chống trơn trượt.</li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="list-productRelated clearfix">
            <div class="heading-title text-center">
              <h2>Sản phẩm liên quan</h2>
            </div>
            <div class="container">
              <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-6 col-6">
                  <div class="product-block">
                    <div class="product-img fade-box">
                      <a href="/product" title="Adidas EQT Cushion ADV" class="img-resize">
                        <img src="/images/shoes/800502_01_e92c3b2bb8764b52a791846d84a3a360_grande.jpg"
                             alt="Adidas EQT Cushion ADV" class="lazyloaded">
                        <img src="/images/shoes/shoes fade 1.jpg" alt="Adidas EQT Cushion ADV"
                             class="lazyloaded">
                      </a>

                    </div>
                    <div class="product-detail clearfix">
                      <div class="pro-text">
                        <a style="color: black;
                            font-size: 14px;text-decoration: none;" href="/product" title="Adidas EQT Cushion ADV" inspiration
                           pack>
                          Adidas EQT Cushion ADV "North America"
                        </a>
                      </div>
                      <div class="pro-price">
                        <p class="">7,000,000₫</p>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-6 col-6">
                  <div class="product-block">
                    <div class="product-img fade-box">
                      <a href="/product" title="Adidas Nmd R1" class="img-resize">
                        <img src="/images/shoes/201493_1_017364c87c3e4802a8cda5259e3d5a95_grande.jpg"
                             alt="Adidas Nmd R1"
                             class="lazyloaded">
                        <img src="/images/shoes/shoes fade 2.jpg" alt="Adidas Nmd R1"
                             class="lazyloaded">
                      </a>

                    </div>
                    <div class="product-detail clearfix">
                      <div class="pro-text">
                        <a style="color: black;
                            font-size: 14px;text-decoration: none;" title="Adidas Nmd R1" href="/product">
                          Adidas Nmd R1 "Villa Exclusive"
                        </a>
                      </div>
                      <div class="pro-price">
                        <p class="">7,000,000₫</p>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-6 col-6">
                  <div class="product-block">
                    <div class="product-img fade-box">
                      <a href="/product" title="Adidas PW Solar HU NMD" class="img-resize">
                        <img src="/images/shoes/805266_02_b8b2cdd1782246febf8879a44a7e5021_grande.jpg"
                             alt="Adidas PW Solar HU NMD" class="lazyloaded">
                        <img src="/images/shoes/shoes fade 3.jpg" alt="Adidas PW Solar HU NMD"
                             class="lazyloaded">
                      </a>

                    </div>
                    <div class="product-detail clearfix">
                      <div class="pro-text">
                        <a style="color: black;
                            font-size: 14px;text-decoration: none;" href="/product" title="Adidas PW Solar HU NMD" inspiration
                           pack>
                          Adidas PW Solar HU NMD "Inspiration Pack"
                        </a>
                      </div>
                      <div class="pro-price">
                        <p class="">5,000,000₫</p>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-6 col-6">
                  <div class="product-block">
                    <div class="product-img fade-box">
                      <a href="/product" title="Adidas Ultraboost W" class="img-resize">
                        <img src="/images/shoes/801432_01_b16d089f8bda434bacfe4620e8480be1_grande.jpg"
                             alt="Adidas Ultraboost W" class="lazyloaded">
                        <img src="/images/shoes/shoes fade 4.jpg" alt="Adidas Ultraboost W"
                             class="lazyloaded">
                      </a>

                    </div>
                    <div class="product-detail clearfix">
                      <div class="pro-text">
                        <a style="color: black;
                            font-size: 14px;text-decoration: none;" href="/product" title="Adidas Ultraboost W" inspiration
                           pack>
                          Adidas Ultraboost W
                        </a>
                      </div>
                      <div class="pro-price">
                        <p class="">5,300,000₫</p>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>


  <!-- show zoom detail product -->
  <!-- zoom -->
  <div class="product-zoom11">
    <div class="product-zom">
      <div class="divclose">
        <i class="fa fa-times-circle"></i>
      </div>
      <div class="owl-carousel owl-theme owl-product1">

        <div class="item"><img src="${viewShoe.url}" alt="">
        </div>

      </div>
    </div>
  </div>

</main>
<!--gallery-->
<section class="section section-gallery">
  <div class="">
    <div class="hot_sp" style="padding-top: 70px;padding-bottom: 50px;">
      <h2 style="text-align:center;padding-top: 10px">
        <a style="font-size: 28px;color: black;text-decoration: none" href="">Khách hàng và Runner Inn</a>
      </h2>
    </div>
    <div class="list-gallery clearfix">
      <ul class="shoes-gp">
        <li>
          <div class="gallery_item">
            <img class="img-resize" src="/images/shoes/gallery_item_1.jpg" alt="">
          </div>
        </li>
        <li>
          <div class="gallery_item">
            <img class="img-resize" src="/images/shoes/gallery_item_2.jpg" alt="">
          </div>
        </li>
        <li>
          <div class="gallery_item">
            <img class="img-resize" src="/images/shoes/gallery_item_3.jpg" alt="">
          </div>
        </li>
        <li>
          <div class="gallery_item">
            <img class="img-resize" src="/images/shoes/gallery_item_4.jpg" alt="">
          </div>
        </li>
        <li>
          <div class="gallery_item">
            <img class="img-resize" src="/images/shoes/gallery_item_5.jpg" alt="">
          </div>
        </li>
        <li>
          <div class="gallery_item">
            <img class="img-resize" src="/images/shoes/gallery_item_6.jpg" alt="">
          </div>
        </li>
      </ul>
    </div>
  </div>
</section>


<!-- footer -->

<footer class="main-footer">
  <div class="container">
    <div class="">
      <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-3">
          <div class="footer-col footer-block">
            <h4 class="footer-title">
              Giới thiệu
            </h4>
            <div class="footer-content">
              <p>Runner Inn trang mua sắm trực tuyến của thương hiệu giày,
                thời trang nam, nữ, phụ kiện, giúp bạn
                tiếp
                cận xu hướng thời trang mới nhất.</p>
              <div class="logo-footer">
                <img src="/images/logo-bct.png" alt="Bộ Công Thương">
              </div>
              <div class="social-list">
                <a href="#" class="fab fa-facebook"></a>
                <a href="#" class="fab fa-google"></a>
                <a href="#" class="fab fa-twitter"></a>
                <a href="#" class="fab fa-youtube"></a>
                <a href="#" class="fab fa-skype"></a>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
          <div class="footer-col footer-link">
            <h4 class="footer-title">
              PHÁP LÝ &amp; CÂU HỎI
            </h4>
            <div class="footer-content toggle-footer">
              <ul>
                <li class="item">
                  <a href="#" title="Tìm kiếm">Tìm kiếm</a>
                </li>
                <li class="item">
                  <a href="#" title="Giới thiệu">Giới thiệu</a>
                </li>
                <li class="item">
                  <a href="#" title="Chính sách đổi trả">Chính sách đổi trả</a>
                </li>
                <li class="item">
                  <a href="#" title="Chính sách bảo mật">Chính sách bảo mật</a>
                </li>
                <li class="item">
                  <a href="#" title="Điều khoản dịch vụ">Điều khoản dịch vụ</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
          <div class="footer-col footer-block">
            <h4 class="footer-title">
              Thông tin liên hệ
            </h4>
            <div class="footer-content toggle-footer">
              <ul>
                <li><span>Địa chỉ:</span> 1 Đại Cồ Việt, Bách Khoa, Quận Hai Bà Trưng, TP. Hà Nội,
                  Vietnam
                </li>
                <li><span>Điện thoại:</span> +84 986640945</li>
                <li><span>Fax:</span> +84 1233456789</li>
                <li><span>Mail:</span> cuong.hd160536@sis.hust.edu.vn</li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-3">
          <div class="footer-col footer-block">
            <h4 class="footer-title">
              FANPAGE
            </h4>
            <div class="footer-content">
              <div id="fb-root">
                <div class="footer-static-content">
                  <div class="fb-page"
                       data-href="https://www.facebook.com/AziWorld-Viet-Nam-908555669481794/"
                       data-tabs="timeline" data-width="" data-height="215" data-small-header="false"
                       data-adapt-container-width="true" data-hide-cover="false"
                       data-show-facepile="true">
                    <blockquote cite="https://www.facebook.com/AziWorld-Viet-Nam-908555669481794/"
                                class="fb-xfbml-parse-ignore"><a
                            href="https://www.facebook.com/AziWorld-Viet-Nam-908555669481794/">AziWorld
                      Viet Nam</a>
                    </blockquote>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</footer>

<script async defer crossorigin="anonymous" src="/plugins/sdk.js"></script>
<script src="/plugins/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script src="/plugins/bootstrap/popper.min.js"></script>
<script src="/plugins/bootstrap/bootstrap.min.js"></script>
<script src="/plugins/owl.carousel/owl.carousel.min.js"></script>
<script src="/plugins/uikit/uikit.min.js"></script>
<script src="/plugins/uikit/uikit-icons.min.js"></script>
<script src="/js/script.js"></script>
<script src="/js/home.js"></script>
<script src="/js/cartInMain.js"></script>
</body>
</html>