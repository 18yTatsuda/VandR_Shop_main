<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>店舗ログイン</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/shopSignin.css" rel="stylesheet">
</head>

<body class="text-center">
	<form:form action="login" method="post" class="form-signin" modelAttribute="shopLoginForm">
		<img class="mb-4"
			src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg"
			alt="" width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">VandR Systemログイン</h1>

<c:if test="${not empty errmsg}">
  <p class="error">${fn:escapeXml(errmsg)}</p>
</c:if>

		<label for="inputShopId" class="sr-only">店舗ID</label>
		<form:input id="inputShopId" class="form-control" placeholder="店舗ID" path="shopId"/><!-- required autofocus -->

		<label for="inputPassword" class="sr-only">パスワード</label>
		<form:password id="inputPassword" class="form-control" placeholder="パスワード" path="password" /> <!-- required -->

		<button class="btn btn-lg btn-primary btn-block" type="submit">ログイン</button>
		<p class="mt-5 mb-3 text-muted">&copy; Copyright © 2018
			VandR System.All Righys Reserved.</p>
	</form:form>
</body>
</html>