<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Black Swan Funding</title>
<link rel="stylesheet" type="text/css" href="../css/admin.css">
<link rel="stylesheet" type="text/css" href="../css/style3.css">

<link rel="stylesheet" type="text/css" href="../css/style.css">
<script src="/js/admin/member/list.js"></script>
</head>


<body>
	<h1 class="hidden">BLACKSWAN</h1>
	<jsp:include page="../../inc/header.jsp" />

	<main>
	<section id="admin-title">관리자</section>
	<section id="admin-tab">
		<h1 class="hidden">관리자 탭</h1>
		<div class="center">
			<ul>
				<li><a href="/blackswan2/admin/member/list">회원관리</a></li>
				<li><a href="/blackswan2/admin/funding/list">펀딩관리</a></li>
				<li><a href="/blackswan2/admin/event/list">이벤트관리</a></li>
				<li><a href="/blackswan2/admin/category">카테고리관리</a></li>
			</ul>
		</div>
	</section>
	<section id="main" class="admin">
		<h1 class="hidden">펀딩관리페이지</h1>
		<div class="center">
			<table class="list-table">
				<tr>
					<td></td>
					<td>${fd.id}</td>
				</tr>
				<tr>
					<td></td>
					<td>${fd.id}</td>
				</tr>
			</table>
	</section>
	</div>
	</section>
	</main>

	<jsp:include page="../../inc/footer.jsp" />

</body>
</html>

