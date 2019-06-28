<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/admin.css">
<link rel="stylesheet" type="text/css" href="../css/style3.css">

<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<h1>이벤트관리</h1>
	<!-- 헤더 -------------------------------------------- -->
	<div>
		<a href="../main">home</a>

	</div>

	<!-- 바디 ------------------------------------------- -->

	<!--사이드 -------------------------------------------  -->

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

	<!--메인------------------------------------------------  -->

	<section>
		<form action="eventedit" method="post">
			<table>
				<tr>
					<td>업체명</td>
					<td>${funding.title}</td>
				</tr>
				<tr>
					<td>이벤트 기간</td>
					<td>${event.sdate}~${event.edate}</td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><img src="/upload/${event.attach}" style="width: 150px"></td>
				</tr>
				<tr>
					<td>상태</td>
					<td><input type="radio" name="state" value="1"><label>대기</label>
						<input type="radio" name="state" value="2"><label>시작</label>
						<input type="radio" name="state" value="3"><label>종료</label>
					</td>
				</tr>
			</table>
			<input type="hidden" name="id" value="${event.id}"> <input
				type="submit" value="확인"> <a href="event?page=#">취소</a>
		</form>
	</section>
</body>
</html>