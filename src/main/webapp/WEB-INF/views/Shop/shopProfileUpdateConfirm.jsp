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

<title>店舗詳細更新確認画面</title>
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
	<form action="shopProfileUpdate" method="post">
	<img class="mb-4"
			src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg"
			alt="" width="72" height="72">
		<fieldset>
			<p>これでよろしいですか？</p>
			<div>
				<label for="shopId">店舗ID：</label><input type="text" class="form-control" id="shopId" readonly>
			</div>
		</fieldset>
	<div class="row">
		<fieldset class="col-md-4 order-md-2 mb-4">
			<legend>変更前</legend>
			<div>
				<label for="prevName">店舗名：</label><input type="text" class="form-control" id="prevName" readonly>
			</div>
			<div>
				<label for="prevTel">TEL：</label><input type="text" class="form-control" id="prevTel" disabled>
			</div>
			<div>
				<label for="prevPassword">PASS：</label><input type="text" class="form-control" id="prevPassword" disabled>
			</div>
			<div>
				<label for="prevOpen">営業開始時間：</label><input type="text" class="form-control" id="prevOpen" disabled>
			</div>
			<div>
				<label for="prevClose">営業終了時間：</label><input type="text" class="form-control" id="prevClose" disabled>
			</div>
			<div>
				<label for="prevShopTotalSeats">席数：</label><input type="text" class="form-control" id="prevShopTotalSeats" disabled>
			</div>
			<div>
				<label for="prevGenre">料理ジャンル：</label><input type="text" class="form-control" id="prevGenre" disabled>
			</div>
			<div>
				<label for="prevBudget">予算：</label><input type="text" class="form-control" id="prevBudget" disabled>
			</div>
			<div>
				<label for="prevComment">備考欄：</label><input type="text" class="form-control" id="prevComment" disabled>
			</div>
		</fieldset>
		</div>
<div class="row">
		<div class="col-md-4 order-md-2 mb-4">⇒</div>
		</div>
<div class="row">
		<fieldset class="col-md-4 order-md-2 mb-4">
			<legend>変更後</legend>
			<div>
				<label for="newName">店舗名：</label><input type="text" class="form-control" id="newName" readonly>
			</div>
			<div>
				<label for="newTel">TEL：</label><input type="text" class="form-control" id="newTel" readonly>
			</div>
			<div>
				<label for="confirmNewPassword">PASS(再入力)：</label><input type="password" class="form-control" id="confirmNewPassword">
			</div>
			<div>
				<label for="newOpen">営業開始時間：</label><input type="text" class="form-control" id="newOpen" disabled>
			</div>
			<div>
				<label for="newClose">営業終了時間：</label><input type="text" class="form-control" id="newClose" disabled>
			</div>
			<div>
				<label for="newShopTotalSeats">席数：</label><input type="text" class="form-control" id="newShopTotalSeats" disabled>
			</div>
			<div>
				<label for="newGenre">料理ジャンル：</label><input type="text" class="form-control" id="newGenre" disabled>
			</div>
			<div>
				<label for="newBudget">予算：</label><input type="text" class="form-control" id="newBudget" disabled>
			</div>
			<div>
				<label for="newComment">備考欄：</label><input type="text" class="form-control" id="newComment" disabled>
			</div>
		</fieldset>
		</div>
		<div>
			<button class="btn btn-lg btn-warning btn-block" type="submit">更新する</button>
			<button class="btn btn-default btn-block" type="submit" onclick="location.href='updateInputBack'; return false;">入力画面に戻る</button>
		</div>
	</form>
	<div>
		<a href="shopProfile" class="btn btn-default btn-block">店舗詳細に戻る</a>
	</div>
	</div>
	<div>
		<p class="mt-5 mb-3 text-muted">&copy; Copyright © 2018 VandR System.All Righys Reserved.</p>
	</div>
</body>
</html>