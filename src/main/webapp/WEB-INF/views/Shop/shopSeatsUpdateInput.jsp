<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>席情報更新</title>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/shopCarousel.css" rel="stylesheet">
<script src="/js/jquery.min.js"></script>
</head>
<body class="text-center">
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
			<p>編集したい項目を入力してください
			<br>※席数は数字のみ有効です。
			<br>当店の総席数は${fn:escapeXml(shopTotalSeats)}です。</p>

			<c:if test="${not empty errmsg}">
				<p class="error">${fn:escapeXml(errmsg)}</p>
			</c:if>

	<form:form action="shopSeatsUpdate" method="post" modelAttribute="seatUpdateForm">
		<fieldset>
			<div class="row">
				<div class="col-3">
					<label for="updateSeats">カウンター</label>
					<form:input id="updateSeats" class="form-control" type="text" path="seatType" placeholder="席数を入力してください。例:5" />
				</div>
			</div>

			<div class="row">
				<div class="col-3">
					<label for="updateSeats">2人テーブル</label>
					<form:input id="updateSeats" class="form-control" type="text" path="seatType" placeholder="席数を入力してください。例:15" />
				</div>
			</div>

			<div class="row">
				<div class="col-3">
					<label for="updateSeats">4人テーブル</label>
					<form:input id="updateSeats" class="form-control" type="text" path="seatType" placeholder="席数を入力してください。例:10" />
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

	</form:form>
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
	<script>
$('#ok').click(function(){
    if(!confirm('こちら内容で変更しますか？')){
        /* キャンセルの時の処理 */
        return false;
    }else{
        /*　OKの時の処理 */
        location.href = 'shopSeatsUpdareResult';
    }
});
</script>
</body>
</html>