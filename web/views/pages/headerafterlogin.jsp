<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en"> <!--<![endif]-->
<head>
    <title>Facebook | ${param.title}</title>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon -->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="views/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="views/resources/css/comments.css">
    <link rel="stylesheet" href="views/resources/css/style.css">
    <link rel="stylesheet" href="views/resources/css/profile.css">
    <!-- CSS Page Style -->
    <link rel="stylesheet" href="views/resources/css/pages/page_log_reg_v1.css">
    <link rel="stylesheet" href="views/resources/css/pages/font-awesome-min.css">
    <link rel="stylesheet" href="views/resources/css/pages/page_search_inner_tables.css">
    <!-- CSS Theme -->
    <link rel="stylesheet" href="views/resources/css/themes/default.css" id="style_color">
</head>
<body>
<div class="wrapper">
    <!--=== Header ===-->
    <div class="header">
        <!-- Topbar -->
        <div class="topbar">
            <div class="container">
                <!-- Topbar Navigation -->
                <ul class="loginbar pull-right">
                    <i class="glyphicon glyphicon-user"></i>
                    <li><a href="#">Logged in as ${sessionScope.user.firstName} ${sessionScope.user.lastName}</a></li>
                    <li class="topbar-devider"></li>
                    <li><a href="/logout">Logout</a></li>
                </ul>
                <!-- End Topbar Navigation -->
            </div>
        </div>
        <!-- End Topbar -->
        <!-- Navbar -->
        <div class="navbar navbar-default" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target=".navbar-responsive-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="fa fa-bars"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">
                        <img id="logo-header" src="views/resources/img/facebook.png" alt="Logo">
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-responsive-collapse">
                    <ul class="nav navbar-nav">
                        <!-- Home -->
                        <li>
                            <a href="<c:url value='/home' />">
                                Home
                            </a>
                        </li>
                        <!-- End Home -->
                        <!-- NewsFeed -->
                        <li>
                            <a href="<c:url value='/newsfeed' />">
                                NewsFeed
                            </a>
                        </li>
                        <!-- End NewsFeed -->
                        <!-- Posts -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle">
                                Posts
                            </a>
                            <ul class="dropdown-menu">
                                <!-- About Posts -->
                                <li>
                                    <a href="<c:url value='/editpost' />">Edit Post</a>
                                    <a href="<c:url value='/deletepost' />">Delete Post</a>
                                </li>
                                <!-- End About Posts -->
                            </ul>
                        </li>
                        <!-- End Posts -->
                        <!-- Message -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle">
                                Messages
                            </a>
                            <ul class="dropdown-menu">
                                <!-- About Message -->
                                <li>
                                    <a href="<c:url value='/viewusers' />">Send Message</a>
                                    <a href="<c:url value='/viewmessage' />">See All Messages</a>
                                </li>
                                <!-- End About Message -->
                            </ul>
                        </li>
                        <!-- End Message -->
                        <!-- Users -->
                        <li>
                            <a href="<c:url value='/viewusers' />">
                                Users
                            </a>
                        </li>
                        <!-- End Users -->
                        <!-- Profile -->
                        <li>
                            <a href="<c:url value='/myprofile' />">
                                Profile
                            </a>
                        </li>
                        <!-- End Profile -->
                        <!-- Update Profile Info -->
                        <li>
                            <a href="<c:url value='/updateprofile' />">
                                Update Info
                            </a>
                        </li>
                        <!-- End Update -->
                    </ul>
                </div>
                <!--/navbar-collapse-->
            </div>
        </div>
        <!-- End Navbar -->
    </div>
    <!--=== End Header ===-->
    <!--=== Breadcrumbs ===-->
    <div class="breadcrumbs">
        <div class="container">
            <h1 class="pull-left">${param.heading}</h1>
        </div>
        <!--/container-->
    </div>
    <!--/breadcrumbs-->
    <!--=== End Breadcrumbs ===-->
