<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約追加</title>
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
		<h3>予約を追加します、必要事項を入力してください。</h3>
			<form action="shopReservationInsertResult" method="post">
				<div class="row">
					<div class="col">
						<label class="mr-sm-2" for="inlineFormCustomSelect">お客様名：</label>
						<input class="form-control" type="text" placeholder="お客様名" required>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label class="mr-sm-2" for="inlineFormCustomSelect">人数：</label>
						<select class="custom-select mr-sm-2" id="inlineFormCustomSelect" required>
						<option selected>人数を選んでください</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label class="mr-sm-2" for="inlineFormCustomSelect">来店予定時刻：</label>
						<select class="custom-select mr-sm-2" id="inlineFormCustomSelect" required>
						<option selected>来店予定時刻を選んでください</option>
							<option value="1">16:00～</option>
							<option value="2">16:30～</option>
							<option value="3">17:00～</option>
							<option value="4">17:30～</option>
							<option value="5">18:00～</option>
							<option value="6">18:30～</option>
							<option value="7">19:00～</option>
							<option value="8">19:30～</option>
							<option value="9">20:00～</option>
							<option value="10">20:30～</option>
							<option value="11">21:00～</option>
							<option value="12">21:30～</option>
							<option value="13">22:00～</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label class="mr-sm-2" for="inlineFormCustomSelect">希望席種別：</label>
						<select class="custom-select mr-sm-2" id="inlineFormCustomSelect" required>
						<option selected>希望席種別を選んでください</option>
							<option value="1">カウンター</option>
							<option value="2">2人テーブル</option>
							<option value="3">4人テーブル</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<button class="btn btn-lg btn-warning" type="submit">決定</button>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<button class="btn btn-lg btn-default" type="button" onclick="location.href='shopReservationCheck'">予約確認画面に戻る</button>
					</div>
				</div>
			</form>
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