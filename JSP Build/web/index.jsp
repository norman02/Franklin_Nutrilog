<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
	Industrious by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Infant Nutrition Log</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a class="logo" href="index.jsp">Infant Nutrition Log</a>
				<nav>
					<a href="#menu">Menu</a>
				</nav>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="nutrilog/registration.jsp">Register a Baby</a></li>
					<li><a href="nutrilog/search.jsp">Search for a Baby</a></li>
                                        <li><a href="nutrilog/event.jsp">Log an Event</a></li>
				</ul>
			</nav>
                <!-- Banner -->
			<section id="banner">
				<div class="inner">
					<h1>Welcome to NutriLog</h1>
					<p>The Infant Nutrition Information Log</p>
				</div>
				<video autoplay loop muted src="images/banner.mp4"></video>
			</section>

		<!-- Highlights -->
			<section class="wrapper">
				<div class="inner">
					<header class="special">
						<h2></h2>
					</header>
					<div class="highlights">
						<section>
							<a href="registration.jsp"><div class="content">
								<header>
									<a href="nutrilog/registration.jsp" class="icon fa-vcard-o"><span class="label">Icon</span></a>
									<h3>Register a Baby</h3>
								</header>
							</div></a>
						</section>
						<section>
							<a href="search.jsp"><div class="content">
								<header>
									<a href="nutrilog/search.jsp" class="icon fa-files-o"><span class="label">Icon</span></a>
									<h3>Search for a Baby</h3>
								</header>
							</div></a>
						</section>
						<section>
							<a href="event.jsp"><div class="content">
								<header>
									<a href="nutrilog/event.jsp" class="icon fa-line-chart"><span class="label">Icon</span></a>
									<h3>Log An Event</h3>
								</header>
							</div></a>
						</section>
					</div>
				</div>
			</section>

<%@include file="assets/footer.jsp" %>