<%--
  Created by IntelliJ IDEA.
  User: HDC
  Date: 6/30/2023
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="/admin/assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="/admin/assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>ADMIN</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />

    <meta name="keywords" content="Material Design, html dashboard, html css dashboard, web dashboard, bootstrap 4 dashboard, bootstrap 4, css3 dashboard, bootstrap 4 admin, material dashboard bootstrap 4 dashboard, frontend, responsive bootstrap 4 dashboard, material design, material dashboard bootstrap 4 dashboard">
    <meta name="description" content="Material Dashboard PRO is a Premium Material Bootstrap 4 Admin with a fresh, new design inspired by Google's Material Design.">
    <meta property="og:description" content="Material Dashboard PRO is a Premium Material Bootstrap 4 Admin with a fresh, new design inspired by Google's Material Design." />
    <meta property="og:site_name" content="Material Design" />

    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
    <link rel="stylesheet" href="/admin/assets/fontawesome/css/all.min.css">

    <link href="/admin/assets/css/material-dashboard.minf066.css" rel="stylesheet" />

    <link href="/admin/assets/demo/demo.css" rel="stylesheet" />
</head>
<body class="">

<div class="wrapper ">
    <div class="sidebar" data-color="rose" data-background-color="black" data-image="/admin/assets/img/sidebar-1.jpg">
        <div class="logo">
            <a href="/admin" class="simple-text logo-mini">
                HD
            </a>
            <a href="/admin" class="simple-text logo-normal">
                Cuong Design
            </a>
        </div>
        <div class="sidebar-wrapper">

            <div class="user">
                <div class="photo">
                    <img src="/admin/assets/img/faces/admin.jpg" />
                </div>
                <div class="user-info">
                    <a data-toggle="collapse" href="#collapseExample" class="username">
                <span>
                   ADMIN
                    <b class="caret"></b>
                </span>
                    </a>
                    <div class="collapse" id="collapseExample">
                        <ul class="nav">
                            <li class="nav-item">
                                <a class="nav-link" target="_blank" href="/index">
                                    <span class="sidebar-mini"> LO </span>
                                    <span class="sidebar-normal"> LogOut </span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>



            <ul class="nav">
                <li class="nav-item active ">
                    <a class="nav-link" href="/admin">
                        <i class="material-icons">dashboard</i>
                        <p> Dashboard </p>
                    </a>
                </li>

                <li class="nav-item ">
                    <a class="nav-link" data-toggle="collapse" href="#account">
                        <i class="material-icons">apps</i>
                        <p>
                            Account
                            <b class="caret"></b>
                        </p>
                    </a>
                    <div class="collapse" id="account">
                        <ul class="nav">
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/account">
                                    <span class="sidebar-mini"> UA </span>
                                    <span class="sidebar-normal"> ACCOUNT Manager </span>
                                </a>
                            </li>


                        </ul>
                    </div>
                </li>

                <li class="nav-item ">
                    <a class="nav-link" data-toggle="collapse" href="#product">
                        <i class="material-icons">apps</i>
                        <p>
                            Product
                            <b class="caret"></b>
                        </p>
                    </a>
                    <div class="collapse" id="product">
                        <ul class="nav">
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/shoe">
                                    <span class="sidebar-mini"> US </span>
                                    <span class="sidebar-normal"> SHOE Manager </span>
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/shoedetail">
                                    <span class="sidebar-mini"> USD </span>
                                    <span class="sidebar-normal"> SHOEDETAIL Manager </span>
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/color">
                                    <span class="sidebar-mini"> UC </span>
                                    <span class="sidebar-normal"> COLOR Manager </span>
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/size">
                                    <span class="sidebar-mini"> US </span>
                                    <span class="sidebar-normal"> SIZE Manager </span>
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/image">
                                    <span class="sidebar-mini"> UI </span>
                                    <span class="sidebar-normal"> IMAGE Manager </span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>

                <li class="nav-item ">
                    <a class="nav-link" data-toggle="collapse" href="#order">
                        <i class="material-icons">apps</i>
                        <p>
                            Order
                            <b class="caret"></b>
                        </p>
                    </a>
                    <div class="collapse" id="order">
                        <ul class="nav">
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/order">
                                    <span class="sidebar-mini"> UO </span>
                                    <span class="sidebar-normal"> ORDER Manager </span>
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/orderdetail">
                                    <span class="sidebar-mini"> UOD </span>
                                    <span class="sidebar-normal"> ORDERDETAIL Manager </span>
                                </a>
                            </li>
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/status">
                                    <span class="sidebar-mini"> US </span>
                                    <span class="sidebar-normal"> STATUS Manager </span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>

                <li class="nav-item ">
                    <a class="nav-link" data-toggle="collapse" href="#blog">
                        <i class="material-icons">apps</i>
                        <p>
                            Blog
                            <b class="caret"></b>
                        </p>
                    </a>
                    <div class="collapse" id="blog">
                        <ul class="nav">
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/blog">
                                    <span class="sidebar-mini"> UB </span>
                                    <span class="sidebar-normal"> BLOG Manager </span>
                                </a>
                            </li>


                        </ul>
                    </div>
                </li>

                <li class="nav-item ">
                    <a class="nav-link" data-toggle="collapse" href="#sales">
                        <i class="material-icons">apps</i>
                        <p>
                            SALES
                            <b class="caret"></b>
                        </p>
                    </a>
                    <div class="collapse" id="sales">
                        <ul class="nav">
                            <li class="nav-item ">
                                <a class="nav-link" href="/admin/sale">
                                    <span class="sidebar-mini"> US </span>
                                    <span class="sidebar-normal"> SALES Manager </span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </li>


            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
            <div class="container-fluid">
                <div class="navbar-wrapper">
                    <div class="navbar-minimize">
                        <button id="minimizeSidebar" class="btn btn-just-icon btn-white btn-fab btn-round">
                            <i class="material-icons text_align-center visible-on-sidebar-regular">more_vert</i>
                            <i class="material-icons design_bullet-list-67 visible-on-sidebar-mini">view_list</i>
                        </button>
                    </div>
                    <a class="navbar-brand" href="#pablo">Dashboard</a>
                </div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="navbar-toggler-icon icon-bar"></span>
                    <span class="navbar-toggler-icon icon-bar"></span>
                    <span class="navbar-toggler-icon icon-bar"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end">
                    <form class="navbar-form">
                        <div class="input-group no-border">
                            <input type="text" value="" class="form-control" placeholder="Search...">
                            <button type="submit" class="btn btn-white btn-round btn-just-icon">
                                <i class="material-icons">search</i>
                                <div class="ripple-container"></div>
                            </button>
                        </div>
                    </form>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#pablo">
                                <i class="material-icons">dashboard</i>
                                <p class="d-lg-none d-md-block">
                                    Stats
                                </p>
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link" href="http://example.com/" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="material-icons">notifications</i>
                                <span class="notification">5</span>
                                <p class="d-lg-none d-md-block">
                                    Some Actions
                                </p>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Mike John responded to your email</a>
                                <a class="dropdown-item" href="#">You have 5 new tasks</a>
                                <a class="dropdown-item" href="#">You're now friend with Andrew</a>
                                <a class="dropdown-item" href="#">Another Notification</a>
                                <a class="dropdown-item" href="#">Another One</a>
                            </div>
                        </li>


                        <li class="nav-item dropdown">
                            <a class="nav-link" href="#pablo" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="material-icons">person</i>
                                <p class="d-lg-none d-md-block">
                                    !
                                </p>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                                <a class="dropdown-item" target="_blank" href="Identity/Account/Login">Login</a>
                                <a class="dropdown-item" target="_blank" href="Identity/Account/Register">Register</a>

                            </div>
                        </li>


                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="content">
            <!--   Core JS Files   -->
            <script src="/admin/assets/js/core/jquery.min.js"></script>

            <!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
            <script src="/admin/assets/js/plugins/jquery.dataTables.min.js"></script>

            <script type="text/javascript">

                function Init() {
                    $.ajaxSetup({cache: false});
                };

                // Render Actions to open Dialog when onclick
                function RenderActions(renderActionstring) {
                    $("#OpenDialog").load(renderActionstring);
                };

                function showError(txt) {
                    $("#showError").show();
                    var errorTxt = '<strong>Warning! </strong>' + txt;
                    $("#ErrorTxt").fadeIn(400)(errorTxt);
                };

                function hideError() {
                    $("#showError").hide(300);
                };

                // Clean Form when you need
                function Clean() {
                    $('#modalUser').find('textarea,input').val('');
                };

                // Click button or tag a to call function CreateROLE
                function CreateUser() {
                    if (!ValidateInputs()) {
                        showError('Please check the information entered');
                        return;
                    }
                    hideError()
                    var user = {
                        Name: $('#Name').val(),
                        Email: $('#Email').val(),
                        Password: $('#Password').val(),
                        ConfirmPassword: $('#ConfirmPassword').val(),
                        PhoneNumber: $('#PhoneNumber').val(),
                        GenderId: $('#GenderId').val(),
                    }
                    $.ajax({
                        url: '/Users/CreateUser',
                        type: 'POST',
                        dataType: 'json',
                        contentType: "application/json;charset=utf-8",
                        data: JSON.stringify(user),
                        success: function (response) {
                            if (response.isExit) {
                                showError("Email or Phone already exists!");
                                return;
                            }
                            if (response.isError) {
                                showError("Create error, try again!");
                                return;
                            }

                            Clean();
                            $('#btnCloseModal').click();
                            location.reload();
                        },
                        error: function (err) {
                            alert("Error: " + err.responseText);
                        }
                    });
                };

                // Click button or tag a to call funcction Edit
                function EditUser() {
                    var flag = true;
                    var name = $('#Name');
                    if ($.trim(name.val()) != '') {
                        name.closest('.form-group').removeClass('has-danger');
                    }
                    if ($.trim(name.val()) === '') {
                        name.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }
                    var phoneNumber = $('#PhoneNumber');
                    if ($.trim(phoneNumber.val()) != '') {
                        phoneNumber.closest('.form-group').removeClass('has-danger');
                    }
                    if ($.trim(phoneNumber.val()) === '') {
                        phoneNumber.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }
                    var email = $('#Email');
                    if ($.trim(email.val()) != '') {
                        email.closest('.form-group').removeClass('has-danger');
                    }
                    if ($.trim(email.val()) === '') {
                        email.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }
                    var pattern = /^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$/;
                    if (!pattern.test(email.val())) {
                        email.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }
                    if (pattern.test(email.val())) {
                        email.closest('.form-group').removeClass('has-danger');
                    }
                    if (!flag) {
                        showError('Please check the information entered');
                        return;
                    }
                    hideError()
                    var user = {
                        Id: $('#Id').val(),
                        Name: $('#Name').val(),
                        Email: $('#Email').val(),
                        Password: $('#Password').val(),
                        ConfirmPassword: $('#ConfirmPassword').val(),
                        PhoneNumber: $('#PhoneNumber').val(),
                        GenderId: $('#GenderId').val(),
                    }
                    $.ajax({
                        url: '/Users/EditUser',
                        type: 'POST',
                        dataType: 'json',
                        contentType: "application/json;charset=utf-8",
                        data: JSON.stringify(user),
                        success: function (response) {
                            if (response.isExit) {
                                showError("Email or Phone already exists!");
                                return;
                            }
                            if (response.isError) {
                                showError("Create error, try again!");
                                return;
                            }
                            Clean();
                            $('#btnCloseModal').click();
                            location.reload();
                        },
                        error: function (err) {
                            alert("Error: " + err.responseText);
                        }
                    });
                };

                // Click button or tag a to add Role to User
                function AddUserToRole() {
                    var userRole = {
                        userId: $('#User_Id').val(),
                        roleId: $('#RoleId').val()
                    }
                    $.ajax({
                        url: '/Users/AddUserToRole',
                        type: 'POST',
                        dataType: 'json',
                        contentType: "application/json;charset=utf-8",
                        data: JSON.stringify(userRole),
                        success: function (response) {
                            Clean();
                            $('#btnCloseModal').click();

                        },
                        error: function (err) {
                            alert("Error: " + err.responseText);
                        }
                    });

                };

                // Click button or tag a to remove Role to User
                function RemoveUserToRole(userId, roleId) {
                    var userRole = {
                        userId: userId,
                        roleId: roleId
                    }
                    $.ajax({
                        url: '/Users/RemoveUserToRole',
                        type: 'POST',
                        dataType: 'json',
                        contentType: "application/json;charset=utf-8",
                        data: JSON.stringify(userRole),
                        success: function (response) {
                            Clean();
                            $('#btnCloseModal').click();

                        },
                        error: function (err) {
                            alert("Error: " + err.responseText);
                        }
                    });

                };

                // Validate from Input in Form
                function ValidateInputs() {
                    var flag = true;
                    var name = $('#Name');
                    if ($.trim(name.val()) != '') {
                        name.closest('.form-group').removeClass('has-danger');
                    }
                    if ($.trim(name.val()) === '') {
                        name.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }
                    var phoneNumber = $('#PhoneNumber');
                    if ($.trim(phoneNumber.val()) != '') {
                        phoneNumber.closest('.form-group').removeClass('has-danger');
                    }
                    if ($.trim(phoneNumber.val()) === '') {
                        phoneNumber.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }
                    var email = $('#Email');
                    if ($.trim(email.val()) != '') {
                        email.closest('.form-group').removeClass('has-danger');
                    }
                    if ($.trim(email.val()) === '') {
                        email.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }
                    var pattern = /^[a-zA-Z0-9\-_]+(\.[a-zA-Z0-9\-_]+)*@[a-z0-9]+(\-[a-z0-9]+)*(\.[a-z0-9]+(\-[a-z0-9]+)*)*\.[a-z]{2,4}$/;
                    if (!pattern.test(email.val())) {
                        email.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }
                    if (pattern.test(email.val())) {
                        email.closest('.form-group').removeClass('has-danger');
                    }

                    var password = $('#Password');
                    if ($.trim(password.val()) != '') {
                        password.closest('.form-group').removeClass('has-danger');
                    }
                    if ($.trim(phoneNumber.val()) === '') {
                        password.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }

                    var confirmPassword = $('#ConfirmPassword');
                    if ($.trim(confirmPassword.val()) != '') {
                        confirmPassword.closest('.form-group').removeClass('has-danger');
                    }
                    if ($.trim(confirmPassword.val()) === '') {
                        confirmPassword.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }
                    if ($.trim(password.val()) != '' && password.val() == confirmPassword.val()) {
                        password.closest('.form-group').removeClass('has-danger');
                        confirmPassword.closest('.form-group').removeClass('has-danger');
                    }
                    if (password.val() != confirmPassword.val()) {
                        password.closest('.form-group').addClass('has-danger');
                        confirmPassword.closest('.form-group').addClass('has-danger');
                        flag = false;
                    }
                    return flag;
                };

            </script>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header card-header-primary card-header-icon">
                                <div class="card-icon">
                                    <i class="material-icons">assignment</i>
                                </div>
                                <h4 class="card-title">CRUD Order</h4>
                                <a data-toggle="modal" href="/admin/order?action=create"
                                   data-target="#modalUser" class="pull-right btn btn-success">Create NewOrder <i
                                        class="fa fa-arrow-circle-right"></i></a>
                            </div>
                            <div class="card-body">
                                <div class="toolbar">
                                    <!--        Here you can write extra buttons/actions for the toolbar              -->
                                </div>
                                <div class="material-datatables table-responsive table">
                                    <table id="datatables" class="table table-striped table-no-bordered table-hover"
                                           cellspacing="0" width="100%" style="width:100%">
                                        <thead>
                                        <tr>
                                            <th>No.</th>
                                            <th>User_ID</th>
                                            <th>Date</th>
                                            <th>Total_Amount</th>
                                            <th>Status_ID</th>
                                            <th class="disabled-sorting text-right">Actions</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="order" items="${orderList}">
                                            <tr>
                                                <td><c:out value="${order.id}"/></td>
                                                <td><c:out value="${order.user_id}"/></td>
                                                <td><c:out value="${order.date}"/></td>
                                                <td><c:out value="${order.total_amount}"/></td>
                                                <td><c:out value="${order.status_id}"/></td>
                                                <td class="disabled-sorting text-right">
                                                    <a href="/admin/order?action=edit&id=${order.id}" class="btn btn-info" role="button">Edit</a>
                                                    <a href="/admin/order?action=delete&id=${order.id}" class="btn btn-info" role="button">Delete</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- end content-->
                        </div>
                        <!--  end card  -->
                    </div>
                    <!-- end col-md-12 -->
                </div>
                <!-- end row -->
            </div>
            <!-- /.box -->
            <div id="modalUser" class="modal fade show" role="dialog" data-backdrop="false" style="display: block;">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div id="OpenDialog" class="modal-body">
                            <div class="card ">
                                <div class="card-header card-header-rose card-header-icon">
                                    <div class="card-icon">
                                        <i class="material-icons">mail_outline</i>
                                    </div>
                                    <h4 class="card-title">Create Order</h4>
                                </div>
                                <form action="/admin/order?action=create" class="form-horizontal"  id="FormProCreate" method="post">
                                    <div class="card-body ">
                                        <div id="showError" style="display:none" class="alert alert-rose alert-with-icon" data-notify="container">
                                            <i class="material-icons" data-notify="icon">notifications</i>
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <i class="material-icons">close</i>
                                            </button>
                                            <span data-notify="message" id="ErrorTxt"></span>
                                        </div>
                                        <div>
                                            <label for="user_id" class="bmd-label-floating">User_ID</label>
                                            <input type="text" class="form-control" id="user_id" name="user_id" value="">
                                        </div>
                                        <div>
                                            <label for="date" class="bmd-label-floating">Date</label>
                                            <input type="text" class="form-control" id="date" name="date" value="">
                                        </div>
                                        <div>
                                            <label for="total_amount" class="bmd-label-floating">Total_Amount</label>
                                            <input type="text" class="form-control" id="total_amount" name="total_amount" value="">
                                        </div>
                                        <div>
                                            <label for="status_id" class="bmd-label-floating">Status_ID</label>
                                            <input type="text" class="form-control" id="status_id" name="status_id" value="">
                                        </div>
                                    </div>
                                    <div class="card-footer ">
                                        <a href="/admin/order" class="btn btn-info" role="button">Close</a>
                                        <button class="btn btn-fill btn-rose pull-right" type="submit">Create</button>
                                    </div>
                                    <input name="__RequestVerificationToken" type="hidden" value="CfDJ8BKL8rxejnZPsgNjeSHmfdAxQglr3fAztbW6pceg-teOxnwbUWL6ztYMw1n__0R5qp8J5ssRgTGRTPeF5RGNJEWZv9G2oCLRk2cADCj2fUb2-89FOgh1hrR49bDdOJYWxhgUdBwwtTNX2LCn9N45G98">
                                </form></div>

                        </div>
                    </div>
                </div>
            </div>
            <script>
                $(document).ready(function () {
                    $('#datatables').DataTable({
                        "pagingType": "full_numbers",
                        "lengthMenu": [
                            [10, 25, 50, -1],
                            [10, 25, 50, "All"]
                        ],
                        responsive: true,
                        language: {
                            search: "_INPUT_",
                            searchPlaceholder: "Search records",
                        }
                    });

                    var table = $('#datatables').DataTable();

                    // Edit record
                    table.on('click', '.edit', function () {
                        $tr = $(this).closest('tr');
                        var data = table.row($tr).data();
                        alert('You press on Row: ' + data[0] + ' ' + data[1] + ' ' + data[2] + '\'s row.');
                    });

                    // Delete a record
                    table.on('click', '.remove', function (e) {
                        $tr = $(this).closest('tr');
                        table.row($tr).remove().draw();
                        e.preventDefault();
                    });

                    //Like record
                    table.on('click', '.like', function () {
                        alert('You clicked on Like button');
                    });
                });
            </script>


        </div>
        <footer class="footer">
            <div class="container-fluid">
                <nav class="float-left">
                </nav>
                <div class="copyright float-right">
                    &copy;
                    <script>
                        document.write(new Date().getFullYear())
                    </script>, made with <i class="material-icons">favorite</i> by
                    <a href="index" target="_blank">CuongHD Design</a> for a better web.
                </div>
            </div>
        </footer>
    </div>
</div>
<div class="fixed-plugin">
    <div class="dropdown show-dropdown">
        <a href="#" data-toggle="dropdown">
            <i class="fa fa-cog fa-2x"> </i>
        </a>
        <ul class="dropdown-menu">
            <li class="header-title"> Sidebar Filters</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger active-color">
                    <div class="badge-colors ml-auto mr-auto">
                        <span class="badge filter badge-purple" data-color="purple"></span>
                        <span class="badge filter badge-azure" data-color="azure"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-warning" data-color="orange"></span>
                        <span class="badge filter badge-danger" data-color="danger"></span>
                        <span class="badge filter badge-rose active" data-color="rose"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Sidebar Background</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger background-color">
                    <div class="ml-auto mr-auto">
                        <span class="badge filter badge-black active" data-background-color="black"></span>
                        <span class="badge filter badge-white" data-background-color="white"></span>
                        <span class="badge filter badge-red" data-background-color="red"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Sidebar Mini</p>
                    <label class="ml-auto">
                        <div class="togglebutton switch-sidebar-mini">
                            <label>
                                <input type="checkbox">
                                <span class="toggle"></span>
                            </label>
                        </div>
                    </label>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Sidebar Images</p>
                    <label class="switch-mini ml-auto">
                        <div class="togglebutton switch-sidebar-image">
                            <label>
                                <input type="checkbox" checked="">
                                <span class="toggle"></span>
                            </label>
                        </div>
                    </label>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Images</li>
            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="/admin/assets/img/sidebar-1.jpg" alt="">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="/admin/assets/img/sidebar-2.jpg" alt="">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="/admin/assets/img/sidebar-3.jpg" alt="">
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="/admin/assets/img/sidebar-4.jpg" alt="">
                </a>
            </li>



        </ul>
    </div>
</div>
<!--   Core JS Files   -->
<script src="/admin/assets/js/core/jquery.min.js"></script>
<script src="/admin/assets/js/core/popper.min.js"></script>
<script src="/admin/assets/js/core/bootstrap-material-design.min.js"></script>
<script src="/admin/assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>

<!-- Plugin for the momentJs  -->
<script src="/admin/assets/js/plugins/moment.min.js"></script>
<!--  Plugin for Sweet Alert -->
<script src="/admin/assets/js/plugins/sweetalert2.js"></script>
<!-- Forms Validations Plugin -->
<script src="/admin/assets/js/plugins/jquery.validate.min.js"></script>
<!-- Plugin for the Wizard, full documentation here: https://github.com/VinceG/twitter-bootstrap-wizard -->
<script src="/admin/assets/js/plugins/jquery.bootstrap-wizard.js"></script>
<!--	Plugin for Select, full documentation here: http://silviomoreto.github.io/bootstrap-select -->
<script src="/admin/assets/js/plugins/bootstrap-selectpicker.js"></script>
<!--  Plugin for the DateTimePicker, full documentation here: https://eonasdan.github.io/bootstrap-datetimepicker/ -->
<script src="/admin/assets/js/plugins/bootstrap-datetimepicker.min.js"></script>
<!--  DataTables.net Plugin, full documentation here: https://datatables.net/  -->
<script src="/admin/assets/js/plugins/jquery.dataTables.min.js"></script>
<!--	Plugin for Tags, full documentation here: https://github.com/bootstrap-tagsinput/bootstrap-tagsinputs  -->
<script src="/admin/assets/js/plugins/bootstrap-tagsinput.js"></script>
<!-- Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
<script src="/admin/assets/js/plugins/jasny-bootstrap.min.js"></script>
<!--  Full Calendar Plugin, full documentation here: https://github.com/fullcalendar/fullcalendar    -->
<script src="/admin/assets/js/plugins/fullcalendar.min.js"></script>
<!-- Vector Map plugin, full documentation here: http://jvectormap.com/documentation/ -->
<script src="/admin/assets/js/plugins/jquery-jvectormap.js"></script>
<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="/admin/assets/js/plugins/nouislider.min.js"></script>
<!-- Include a polyfill for ES6 Promises (optional) for IE11, UC Browser and Android browser support SweetAlert -->
<script src="../cdnjs.cloudflare.com/ajax/libs/core-js/2.4.1/core.js"></script>
<!-- Library for adding dinamically elements -->
<script src="/admin/assets/js/plugins/arrive.min.js"></script>
<!--  Google Maps Plugin    -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB2Yno10-YTnLjjn_Vtk0V8cdcY5lC4plU"></script>
<!-- Place this tag in your head or just before your close body tag. -->
<script async defer src="../buttons.github.io/buttons.js"></script>
<!-- Chartist JS -->
<script src="/admin/assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="/admin/assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Material Dashboard: parallax effects, scripts for the example pages etc -->
<script src="/admin/assets/js/material-dashboard.minf066f066.js?v=2.1.0" type="text/javascript"></script>
<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="/admin/assets/demo/demo.js"></script>
<script>
    $(document).ready(function () {
        $().ready(function () {
            $sidebar = $('.sidebar');

            $sidebar_img_container = $sidebar.find('.sidebar-background');

            $full_page = $('.full-page');

            $sidebar_responsive = $('body > .navbar-collapse');

            window_width = $(window).width();

            fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p')();

            if (window_width > 767 && fixed_plugin_open == 'Dashboard') {
                if ($('.fixed-plugin .dropdown').hasClass('show-dropdown')) {
                    $('.fixed-plugin .dropdown').addClass('open');
                }

            }

            $('.fixed-plugin a').click(function (event) {
                // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
                if ($(this).hasClass('switch-trigger')) {
                    if (event.stopPropagation) {
                        event.stopPropagation();
                    } else if (window.event) {
                        window.event.cancelBubble = true;
                    }
                }
            });

            $('.fixed-plugin .active-color span').click(function () {
                $full_page_background = $('.full-page-background');

                $(this).siblings().removeClass('active');
                $(this).addClass('active');

                var new_color = $(this).data('color');

                if ($sidebar.length != 0) {
                    $sidebar.attr('data-color', new_color);
                }

                if ($full_page.length != 0) {
                    $full_page.attr('filter-color', new_color);
                }

                if ($sidebar_responsive.length != 0) {
                    $sidebar_responsive.attr('data-color', new_color);
                }
            });

            $('.fixed-plugin .background-color .badge').click(function () {
                $(this).siblings().removeClass('active');
                $(this).addClass('active');

                var new_color = $(this).data('background-color');

                if ($sidebar.length != 0) {
                    $sidebar.attr('data-background-color', new_color);
                }
            });

            $('.fixed-plugin .img-holder').click(function () {
                $full_page_background = $('.full-page-background');

                $(this).parent('li').siblings().removeClass('active');
                $(this).parent('li').addClass('active');


                var new_image = $(this).find("img").attr('src');

                if ($sidebar_img_container.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
                    $sidebar_img_container.fadeOut('fast', function () {
                        $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                        $sidebar_img_container.fadeIn('fast');
                    });
                }

                if ($full_page_background.length != 0 && $('.switch-sidebar-image input:checked').length != 0) {
                    var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

                    $full_page_background.fadeOut('fast', function () {
                        $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                        $full_page_background.fadeIn('fast');
                    });
                }

                if ($('.switch-sidebar-image input:checked').length == 0) {
                    var new_image = $('.fixed-plugin li.active .img-holder').find("img").attr('src');
                    var new_image_full_page = $('.fixed-plugin li.active .img-holder').find('img').data('src');

                    $sidebar_img_container.css('background-image', 'url("' + new_image + '")');
                    $full_page_background.css('background-image', 'url("' + new_image_full_page + '")');
                }

                if ($sidebar_responsive.length != 0) {
                    $sidebar_responsive.css('background-image', 'url("' + new_image + '")');
                }
            });

            $('.switch-sidebar-image input').change(function () {
                $full_page_background = $('.full-page-background');

                $input = $(this);

                if ($input.is(':checked')) {
                    if ($sidebar_img_container.length != 0) {
                        $sidebar_img_container.fadeIn('fast');
                        $sidebar.attr('data-image', '#');
                    }

                    if ($full_page_background.length != 0) {
                        $full_page_background.fadeIn('fast');
                        $full_page.attr('data-image', '#');
                    }

                    background_image = true;
                } else {
                    if ($sidebar_img_container.length != 0) {
                        $sidebar.removeAttr('data-image');
                        $sidebar_img_container.fadeOut('fast');
                    }

                    if ($full_page_background.length != 0) {
                        $full_page.removeAttr('data-image', '#');
                        $full_page_background.fadeOut('fast');
                    }

                    background_image = false;
                }
            });

            $('.switch-sidebar-mini input').change(function () {
                $body = $('body');

                $input = $(this);

                if (md.misc.sidebar_mini_active == true) {
                    $('body').removeClass('sidebar-mini');
                    md.misc.sidebar_mini_active = false;

                    $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar();

                } else {

                    $('.sidebar .sidebar-wrapper, .main-panel').perfectScrollbar('destroy');

                    setTimeout(function () {
                        $('body').addClass('sidebar-mini');

                        md.misc.sidebar_mini_active = true;
                    }, 300);
                }

                // we simulate the window Resize so the charts will get updated in realtime.
                var simulateWindowResize = setInterval(function () {
                    window.dispatchEvent(new Event('resize'));
                }, 180);

                // we stop the simulation of Window Resize after the animations are completed
                setTimeout(function () {
                    clearInterval(simulateWindowResize);
                }, 1000);

            });
        });
    });
</script>
<script>
    $(document).ready(function () {
        md.initDashboardPageCharts();
        md.initVectorMap();

    });
</script>
</body>
</html>

