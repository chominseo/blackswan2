<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/style.css">
<link rel="stylesheet" type="text/css" href="../../css/admin.css">
</head>
<body>
	<h1 class="hidden">이벤트관리</h1>
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



	<section id="main" class="admin">
		<h1 class="hidden">이벤트관리페이지</h1>
		<div class="center">
			<form action="list" method="get">
				<table>
					<tr>
						<td>이벤트상태</td>
						<td><input type="radio" name="state" value="0" checked><label>전체</label>
							<input type="radio" name="state" value="1"><label>심사</label>
							<input type="radio" name="state" value="2"><label>진행</label>
							<input type="radio" name="state" value="3"><label>종료</label>
						</td>
					</tr>
					<tr>
						<td>이벤트기간</td>
						<td><input type="date" name="sdate"> <span>~</span> <input
							type="date" name="edate"></td>
					</tr>
					<tr>
						<td>업체명</td>
						<td><input type="text" name="title"></td>
					</tr>
				</table>
				<input type="hidden" name="page" value="${param.page}">
				<input type="hidden" name="old_title" value="${param.title}">
				<input type="hidden" name="old_edate" value="${param.edate}">
				<input type="hidden" name="old_sdate" value="${param.sdate}">
				<input type="hidden" name="old_state" value="${param.state}">
				<input type="submit" value="검색">
			</form>




			<section>
				<h1 class="hidden">이벤트 목록</h1>
				<c:if test="${not empty count}">
					<div>검색결과:총${count}건(진행중:${scount})</div>
				</c:if>
				<table class="list-table">
					<thead>
						<tr>
							<td>번호</td>
							<td>업체명</td>
							<td>신청일</td>
							<td>시작일</td>
							<td>종료일</td>
							<td>상태</td>
						</tr>
					</thead>
					<tbody>
						<c:if test=""></c:if>
						<c:forEach var="e" items="${event}">
							<c:set var="sta" value="${e.state}" />
							<tr>
								<td>${e.id}</td>
								<td><a href="eventedit?id=${e.id}">${e.title}</a></td>
								<td>${e.regdate}</td>
								<td>${e.sdate}</td>
								<td>${e.edate}</td>
								<c:if test="${sta==1}">
									<td>심사</td>
								</c:if>
								<c:if test="${sta==2}">
									<td>진행</td>
								</c:if>
								<c:if test="${sta==3}">
									<td>종료</td>
								</c:if>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<a href="reg">이벤트 등록</a>
				</div>
			</section>

			<c:set var="p" value="${(empty param.page) ? 1 : param.page}" />
			<c:set var="start" value="${p - (p-1)%5}" />

			<jsp:include page="../../inc/paging.jsp" />

		</div>
	</section>
	</main>
	<jsp:include page="../../inc/footer.jsp" />
</body>
</html>