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
<!-- <link rel="stylesheet" type="text/css" href="../css/admin.css"> -->
<link rel="stylesheet" type="text/css" href="../css/style.css">
<script src="../js/admin/category/category.js"></script>
</head>
<body>
	<h1 class="hidden">BLACKSWAN</h1>
	<jsp:include page="../../inc/header.jsp" />

	<main>
	<section id="title">
		<h1>관리자</h1>
	</section>
	<section id="tab">
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
	<section id="main" class="adminCate">
		<h1 class="hidden">카테고리 관리페이지</h1>

		<div class="center">
			<section id="category">
				<form action="category" method="get">
					<template class="list-template">
					<tr>
						<td class="name"></td>
						<td class="count"></td>
					</tr>
					</template>
					<template class="sum-template">
					<tr>
						<td class="summ">합계</td>
						<td class="sum"></td>
					</tr>
					</template>
					<table class="list-table">
						<thead>
							<tr>
								<td>카테고리 이름</td>
								<td>업체 수</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cate" items="${countlist}">
								<tr>
									<td class="name">${cate.name}</td>
									<td class="sum">${cate.count}</td>
								</tr>
							</c:forEach>
							<tr>
								<td class="summ">합계</td>
								<td class="sum">${sum}</td>
							</tr>
						</tbody>
					</table>
				</form>
				<input type="text" name="name"> <input type="button"
					value="추가">
				<!-- <div>
				<dl>
					<c:forEach var="cate" items="${countlist}">
						<dt class="name">${cate.name}</dt>
						<dd class="count">${cate.count}</dd>
					</c:forEach>
					<dt class="summ">합계</dt>
					<dd class="sum">${sum}</dd>
				</dl>
			</div> -->
			</section>
		</div>
	</section>
	</main>

	<jsp:include page="../../inc/footer.jsp" />ter.jsp" />
</body>
</html>