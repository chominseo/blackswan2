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
<link rel="stylesheet" type="text/css" href="../../css/style.css">

<link rel="stylesheet" type="text/css" href="../../css/style3.css">
<link rel="stylesheet" type="text/css" href="../../css/admin.css">
</head>


<body>
	<h1 class="hidden">BLACKSWAN</h1>
	<jsp:include page="../../inc/header.jsp" />

	<main>
	<section id="title"><h1>관리자</h1></section>
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
	<section id="main" class="admin">
		<h1 class="hidden">회원관리페이지</h1>
		<div class="center admin-detail">
			<table class="list-table">
				<tr>
					<td>회원번호</td>
					<td>${md.id}</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>${md.email}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${md.name}</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>${md.phone}</td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td>${md.addressNum}</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>${md.address}</td>
				</tr>
				<tr>
					<td>오픈한 펀딩</td>
					<td>${md.mCount}</td>
				</tr>
				<tr>
					<td>참여한 펀딩</td>
					<td>${md.bCount}</td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td>${md.regdate}</td>
				</tr>
				<tr>
					<td>이벤트 수신 동의</td>
					<td>
					<c:if test="${md.eventAgree == 'Y'}">
						동의
					</c:if>
					<c:if test="${md.eventAgree == 'N'}">
						거부
					</c:if>
					</td>
				</tr>
			</table>

		</div>
	</section>
	</main>

	<jsp:include page="../../inc/footer.jsp" />

</body>
</html>

