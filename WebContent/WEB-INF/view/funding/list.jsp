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
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/funding.css">
<script src="../js/funding/list.js"></script>
</head>


<body>
	<h1 class="hidden">BLACKSWAN</h1>
	<jsp:include page="../inc/header.jsp" />

	<main> <jsp:include page="../inc/nav.jsp" />

	<section id="main">
		<h1 class="hidden">메인컨텐츠</h1>
		<div class="center">
			<section class="count-option">
				<h1 class="hidden">펀딩수 및 정렬옵션</h1>
				<div class="list-count">
					<span>전체</span><span>410</span>
				</div>
				<div class="list-option">
					<input type="checkbox" id="check"><label for="check">성공한
						펀딩 보기</label> <select>
						<option>종료임박순</option>
						<option>인기순</option>
						<option>최신순</option>
						<option>참여율순</option>
					</select>
				</div>
			</section>
			<section class="funding-list">
				<h1 class="hidden">펀딩 리스트</h1>
				<ul>
					<li class="first-page-img"></li>
					<c:forEach var="f" items="${flist}">
						<c:if test="${f.partRate >= 100}">
							<li class="complete">
						</c:if>
						<c:if test="${f.partRate < 100}">
							<li>
						</c:if>
						<a href="/blackswan2/funding/detail?id=${f.id}">
							<div class="item-img">
								<img src="../images/.jpg">
							</div>
							<div class="item-info">
								<div class="title">${f.title}</div>
								<div class="category">
									<span>${f.cateName}</span><span>${f.companyName}</span>
								</div>
								<div class="graph">
									<div class="percent" style="width: ${f.partRate}%"></div>
								</div>


								<div class="gvalue">
									<span>${f.partRate}%</span><span>${f.pay}원</span>
								</div>
							</div>
						</a>
						</li>
					</c:forEach>

				</ul>
			</section>
			
			<c:set var="p" value="${(empty param.page) ? 1 : param.page}" />
			<c:set var="start" value="${p - (p-1)%5}" />

			<section class="paging">
				<h1 class="hidden">페이저</h1>
				<div class="first-page">
					<a href="list?p=1">처음</a>
				</div>
				<div class="prev-page">
					<a
						href="list?page=${(p < 6)? p : p -5}&state=${param.state}&sdate=${param.sdate}&edate=${param.edate}&title=${param.title}">이전</a>
				</div>
				<ul>
					<c:forEach var="n" begin="${start}" end="${start+4}" varStatus="s">
						<li><a
							href="list?page=${n}&state=${param.state}&sdate=${param.sdate}&edate=${param.edate}&title=${param.title}">${n}</a></li>
					</c:forEach>
				</ul>
				<div class="next-page">
					<a
						href="list?page=${start+5}&state=${param.state}&sdate=${param.sdate}&edate=${param.edate}&title=${param.title}">다음</a>
				</div>
				<div class="end-page">
					<a href="">끝</a>
				</div>
			</section>
		</div>
	</section>
	</main>

	<jsp:include page="../inc/footer.jsp" />

</body>
</html>

