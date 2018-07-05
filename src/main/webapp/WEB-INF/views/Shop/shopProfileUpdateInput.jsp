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
<title>店舗詳細更新</title>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/shopCarousel.css" rel="stylesheet">
<script src="/js/jquery.min.js"></script>
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
			<h1 class="h3 mb-3 font-weight-normal">店舗情報更新</h1>
			<p>
				編集したい項目を入力してください<br> ※ID、店舗名、TELは変更できません。
			</p>

			<c:if test="${not empty errmsg}">
				<p class="error">${fn:escapeXml(errmsg)}</p>
			</c:if>
		</div>

		<form action="shopProfileUpdate" method="post">
			<fieldset>
				<div class="row">
					<div class="col-3">
						<label>店舗ID：</label>${fn:escapeXml(shopId)}
					</div>
				</div>
				<div class="row">
					<div class="col-3">
						<label>店舗名：</label>${fn:escapeXml(shopName)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>TEL：</label>${fn:escapeXml(shopTel)}
					</div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="mr-sm-2" for="inlineFormCustomSelect">営業開始時間</label>
						<select class="custom-select mr-sm-2" id="inlineFormCustomSelect" required>
						<option selected>営業開始時間を選んでください</option>
							<option value="1">16:00～</option>
							<option value="2">17:00～</option>
							<option value="3">18:00～</option>
							<option value="4">19:00～</option>
							<option value="5">20:00～</option>
							<option value="6">21:00～</option>
						</select>
					</div>
					<div class="col-3">
						<label class="mr-sm-2" for="inlineFormCustomSelect">営業終了時間</label>
						<select class="custom-select d-block w-100" id="inlineFormCustomSelect" required>
						<option selected>営業終了時間を選んでください</option>
							<option value="1">～22:00</option>
							<option value="2">～23:00</option>
							<option value="3">～24:00</option>
							<option value="4">～1:00</option>
							<option value="5">～2:00</option>
							<option value="6">～3:00</option>
							<option value="7">～4:00</option>
							<option value="8">～5:00</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label class="mr-sm-2" for="inlineFormCustomSelect">定休日</label>
						<div class="checkbox-inline" id="inlineFormCustomSelect">
							<label><input type="checkbox" value="月曜">月曜</label>

							<label><input type="checkbox" value="火曜">火曜</label>

							<label><input type="checkbox" value="水曜">水曜</label>

							<label><input type="checkbox" value="木曜">木曜</label>

							<label><input type="checkbox" value="金曜">金曜</label>

							<label><input type="checkbox" value="土曜">土曜</label>

							<label><input type="checkbox" value="日曜">日曜</label>

							<label><input type="checkbox" value="祝日">祝日</label>

							<label><input type="checkbox" value="定休日なし">定休日なし</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>席数</label><input class="form-control" type="text" placeholder="席数を入力してください。例:50">
					</div>
				</div>
				<div class="row">
				<div class="col-3">
					<label class="mr-sm-2" for="inlineFormCustomSelect">料理ジャンル</label>
					<select class="custom-select mr-sm-2" id="inlineFormCustomSelect" required>
					<option selected>料理ジャンルを選んでください</option>
						<option value="1">和食</option>
						<option value="2">中華</option>
						<option value="3">イタリアン</option>
						<option value="4">フレンチ</option>
					</select>
				</div>
				<div class="col-3">
					<label class="mr-sm-2" for="inlineFormCustomSelect">予算</label>
					<select class="custom-select d-block w-100" id="inlineFormCustomSelect" required>
					<option selected>予算を選んでください</option>
						<option value="1">～1000</option>
						<option value="2">1000～1999</option>
						<option value="3">2000～2999</option>
						<option value="4">3000～4999</option>
						<option value="5">5000～</option>
					</select>
				</div>
				</div>
				<div class="row">
				<div class="col">
					<label>備考欄</label>
					<textarea class="form-control" rows="3"></textarea>
				</div>
				</div>
			</fieldset>
			<div class="row">
				<div class="col">
					<button class="btn btn-lg btn-warning btn-block" id="ok" type="submit">決定</button>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<button class="btn btn-lg btn-default btn-block" type="button" onclick="location.href='shopProfile'">店舗詳細に戻る</button>
				</div>
			</div>
		</form>
		<div>
			<a href="shopMenu" class="btn btn-default btn-block">メニュー</a>
		</div>
	</div>
<footer class="mastfoot mt-auto">
		<div class="inner">
			<p class="mt-5 mb-3 text-muted">&copy; Copyright © 2018
				VandR System.All Righys Reserved.</p>
		</div>
		</footer>
	<script>
$('#ok').click(function(){
    if(!confirm('こちら内容で変更しますか？')){
        /* キャンセルの時の処理 */
        return false;
    }else{
        /*　OKの時の処理 */
        location.href = 'shopProfileUpdareResult';
    }
});
</script>
</body>
</html>