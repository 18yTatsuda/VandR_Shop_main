<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>店舗詳細</title>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/shopCarousel.css" rel="stylesheet">
</head>
<body>
<header>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#">VandR System</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="shopMenu">メニュー<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="shopReservationCheck">予約確認</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="shopLogout">ログアウト</a>
            </li>
          </ul>
        </div>
      </nav>
    </header>
		<div class="container">
			<div class="py-5 text-center">
				<img class="d-block mx-auto mb-4"
					src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg"
					alt="" width="72" height="72">
				<h1 class="h3 mb-3 font-weight-normal">店舗情報</h1>
				<div class="row">
					<div class="col">
						<label>店舗ID:</label>${fn:escapeXml(shopId)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>店舗名:</label>${fn:escapeXml(shopName)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>TEL:</label>${fn:escapeXml(shopTel)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>営業開始時間:</label>${fn:escapeXml(shopOpen)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>営業終了時間:</label>${fn:escapeXml(shopClose)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>定休日:</label>${fn:escapeXml(shopHoliday)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>席数:</label>${fn:escapeXml(shopTotalSeats)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>料理ジャンル:</label>${fn:escapeXml(genre)}
					</div>
				</div>
				<div class="row">
					<div class="col">
					<label>予算:</label>${fn:escapeXml(budget)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>備考欄:</label>${fn:escapeXml(comment)}
					</div>
				</div>
				<a href="shopProfileUpdateInput" class="btn btn-warning btn-block">店舗詳細を変更する</a>
				<a href="shopMenu" class="btn btn-default btn-block">店舗メニューへ</a>
			</div>
		</div>
<footer class="mastfoot mt-auto">
		<div class="inner">
			<p class="mt-5 mb-3 text-muted">&copy; Copyright © 2018
				VandR System.All Righys Reserved.</p>
		</div>
		</footer>
	</body>
</html>