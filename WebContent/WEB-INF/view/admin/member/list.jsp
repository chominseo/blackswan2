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
<script src="/js/admin/member/list.js"></script>
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
		<div class="center">
			<section id="member-search">
				<h1 class="hidden">회원 검색</h1>
				<form id="member-search-form" method="post">
					<input type="radio" name="field" value="email" id="msemail">
					<label for="msemail">
						<label for="member-mail">이메일</label><input type="text" name="query" id="member-mail">
					</label>
					<input type="radio" name="field" value="name" id="msname">
					<label for="msname">
						<label for="member-name">이름</label><input type="text" name="query" id="member-name">
					</label>
					<input type="radio" name="field" value="id" id="msid">
					<label for="msid">
						<label for="member-id">회원번호</label><input type="text" name="query" id="member-id">
					</label>
					<input type="radio" name="field" value="regdate" id="msregdate">
					<label for="msregdate">
						<label for="member-reg">가입일</label><input type="date" name="query" id="member-reg">
					</label>
					<input type="submit" value="검색">
				</form>
			</section>
			<section id="member-list">
				<h1 class="hidden">회원 목록</h1>
				<div class="search-count">검색결과 : 총 ${count}건</div>
				<table class="list-table">
					<thead>
						<tr>
							<th>회원번호</th>
							<th>아이디(메일)</th>
							<th>이름(기업명)</th>
							<th>가입일</th>
							<th>정보조회</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="m" items="${member}">
							<tr>
								<td class="id">${m.id}</td>
								<td class="email">${m.email}</td>
								<td class="name">${m.name}</td>
								<td class="regdate">${m.regdate}</td>
								<td><a href="detail?id=${m.id}">보기</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>

			<jsp:include page="../../inc/paging.jsp" />
		</div>
	</section>
	</main>

	<jsp:include page="../../inc/footer.jsp" />

</body>
</html>

