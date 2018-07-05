<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約確認</title>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/shopCarousel.css" rel="stylesheet">
</head>
<body>
	<header> <nav
		class="navbar navbar-expand-md navbar-dark fixed-top bg-dark"> <a
		class="navbar-brand" href="#">VandR System</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarCollapse" aria-controls="navbarCollapse"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarCollapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="shopMenu">メニュー<span
					class="sr-only">(current)</span></a></li>
			<li class="nav-item"><a class="nav-link"
				href="shopReservationCheck">予約確認</a></li>
			<li class="nav-item"><a class="nav-link" href="shopLogout">ログアウト</a>
			</li>
		</ul>
	</div>
	</nav> </header>
	<div class="container">
		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4"
				src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg"
				alt="" width="72" height="72">
				<h1 class="h3 mb-3 font-weight-normal">現在の予約状況</h1>
				<a href="shopReservationInsert" class="btn btn-warning btn-block">予約追加</a>
			<div class="table-responsive">
				<table class="table table-striped table-sm">
					<thead>
						<tr>
							<th>お客様名</th>
							<th>人数</th>
							<th>来店予定時刻</th>
							<th>希望席種別</th>
							<th>キャンセル</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>テスト</td>
							<td>テスト</td>
							<td>テスト</td>
							<td>テスト</td>
							<td><a class="btn btn-danger" href="shopReservationDelete"
								role="button">キャンセルする</a></td>
						</tr>
						<c:forEach items="${userlist}" var="user">
							<tr>
								<td>${fn:escapeXml(user.userName)}</td>
								<td>${fn:escapeXml(user.userPeoples)}</td>
								<td>${fn:escapeXml(user.visitTime)}</td>
								<td>${fn:escapeXml(user.seatType)}</td>
								<td><a class="btn btn-danger" href="shopReservationDelete"
									role="button">キャンセルする</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div>
				<a href="shopMenu" class="btn btn-default btn-block">メニュー</a>
			</div>
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