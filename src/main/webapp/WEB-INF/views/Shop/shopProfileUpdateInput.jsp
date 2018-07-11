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
				編集したい項目を入力してください<br>
				ID、店舗名、TEL、地域情報は変更できません。<br>
				※は必須項目です
			</p>
			<c:if test="${not empty errmsg}">
				<p class="error">${fn:escapeXml(errmsg)}</p>
			</c:if>
		</div>
		<form:form action="shopUpdate" method="post" enctype="multipart/form-data" modelAttribute="shopUpdateForm">
			<fieldset>
				<div class="row">
					<div class="col-3">
						<label>※店舗ID：</label>${fn:escapeXml(shop.shop_id)}
					</div>
				</div>
				<div class="row">
					<div class="col-3">
						<label>※店舗名：</label>${fn:escapeXml(shop.shop_name)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>※TEL：</label>${fn:escapeXml(shop.telephone)}
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>※地域：</label>
						<c:if test="${1== shop.region_id}">東京</c:if>
						<c:if test="${2== shop.region_id}">日本橋</c:if>
					</div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="mr-sm-2" for="inlineFormCustomSelect">営業開始時間</label>
						<select  class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="starttime" required>
						<option value="${fn:escapeXml(shop.starttime)}" selected>営業開始時間を選んでください</option>
							<option value="10:00">10:00～</option>
							<option value="11:00">11:00～</option>
							<option value="12:00">12:00～</option>
							<option value="13:00">13:00～</option>
							<option value="14:00">14:00～</option>
							<option value="15:00">15:00～</option>
							<option value="16:00">16:00～</option>
							<option value="17:00">17:00～</option>
							<option value="18:00">18:00～</option>
							<option value="19:00">19:00～</option>
						</select>
					</div>
					<div class="col-3">
						<label class="mr-sm-2" for="inlineFormCustomSelect">営業終了時間</label>
						<select class="custom-select d-block w-100" id="inlineFormCustomSelect" name="finishtime" required>
						<option value="${fn:escapeXml(shop.finishtime)}" selected>営業終了時間を選んでください</option>
							<option value="20:00">～20:00</option>
							<option value="21:00">～21:00</option>
							<option value="22:00">～22:00</option>
							<option value="23:00">～23:00</option>
							<option value="24:00">～24:00</option>
							<option value="1:00">～1:00</option>
							<option value="2:00">～2:00</option>
							<option value="3:00">～3:00</option>
							<option value="4:00">～4:00</option>
							<option value="5:00">～5:00</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label class="mr-sm-2" for="inlineFormCustomSelect">※定休日</label>
						<div class="checkbox-inline" id="inlineFormCustomSelect">
							<label><input type="checkbox" name="holiday" value="月曜" />月曜</label>
							<label><input type="checkbox" name="holiday" value="火曜" />火曜</label>
							<label><input type="checkbox" name="holiday" value="水曜" />水曜</label>
							<label><input type="checkbox" name="holiday" value="木曜" />木曜</label>
							<label><input type="checkbox" name="holiday" value="金曜" />金曜</label>
							<label><input type="checkbox" name="holiday" value="土曜" />土曜</label>
							<label><input type="checkbox" name="holiday" value="日曜" />日曜</label>
							<label><input type="checkbox" name="holiday" value="祝日" />祝日</label>
							<label><input type="checkbox" name="holiday" value="なし" />定休日なし</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<label>席数</label><input class="form-control" type="text" name="numberofseats" value="${fn:escapeXml(shop.numberofseats)}"
						 placeholder="席数を入力してください。例:50" />
					</div>
				</div>
				<div class="row">
				<div class="col-3">
					<label class="mr-sm-2" for="inlineFormCustomSelect">※料理ジャンル</label>
					<select class="custom-select mr-sm-2" id="inlineFormCustomSelect" name="category_id" required>
					<option value="${fn:escapeXml(shop.category_id)}" selected>料理ジャンルを選んでください</option>
						<option value="1">和食</option>
						<option value="2">中華</option>
						<option value="3">イタリアン</option>
						<option value="4">フレンチ</option>
					</select>
				</div>
				<div class="col-3">
					<label class="mr-sm-2" for="inlineFormCustomSelect">予算</label>
					<select class="custom-select d-block w-100" id="inlineFormCustomSelect" name="budget"  required>
					<option value="${fn:escapeXml(shop.budget)}" selected>予算を選んでください</option>
						<option value="0～1000">～1000</option>
						<option value="1000～2000">1000～2000</option>
						<option value="2000～3000">2000～3000</option>
						<option value="3000～4000">3000～4000</option>
						<option value="5000～">5000～</option>
					</select>
				</div>
				</div>
			<div class="row">
				<div class="col">
					<div class="view_box">
						<label class="mr-sm-2" for="inlineFormCustomSelect">店舗イメージ</label>
						<input type="file" class="file" id="upload_file" name="shopimage"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="view_box">
						<label class="mr-sm-2" for="inlineFormCustomSelect">料理イメージ</label>
					<input type="file" class="file" id="upload_file" name="foodimage"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="mr-sm-2" for="inlineFormCustomSelect">備考欄</label>
					<textarea class="form-control" rows="3" name="comment">${fn:escapeXml(shop.comment)}</textarea>
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
<script>
$(document).ready(function () {
	  $(".file").on('change', function(){
	     var fileprop = $(this).prop('files')[0],
	         find_img = $(this).parent().find('img'),
	         filereader = new FileReader(),
	         view_box = $(this).parent('.view_box');

	    if(find_img.length){
	       find_img.nextAll().remove();
	       find_img.remove();
	    }

	    var img = '<div class="img_view"><img alt="" class="img"><p><a href="#" class="img_del">画像を削除する</a></p></div>';

	    view_box.append(img);

	    filereader.onload = function() {
	      view_box.find('img').attr('src', filereader.result);
	      img_del(view_box);
	    }
	    filereader.readAsDataURL(fileprop);
	  });

	  function img_del(target){
	    target.find("a.img_del").on('click',function(){
	      var self = $(this),
	          parentBox = self.parent().parent().parent();
	      if(window.confirm('画像を削除します。\nよろしいですか？')){
	        setTimeout(function(){
	          parentBox.find('input[type=file]').val('');
	          parentBox.find('.img_view').remove();
	        } , 0);
	      }
	      return false;
	    });
	  }

	});
</script>
</body>
</html>