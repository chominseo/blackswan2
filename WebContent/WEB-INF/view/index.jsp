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
<link rel="stylesheet" type="text/css" href="./css/style.css">


 <link rel="stylesheet" type="text/css" href="./css/index.css">
<script src="./js/index.js"></script>



</head>


<body>
	<h1 class="hidden">BLACKSWAN</h1>
	<div class="class b-index">
	<jsp:include page="./inc/header.jsp" />

	<main>
	<jsp:include page="./inc/nav.jsp" />

	<section id="banner">
		<h1 class="hidden">배너</h1>
		<div class="center">
			<ul>
				<li class="main"><a href="/blackswan2"><img src="images/banner.jpg"></a></li>
				<li><a href="/blackswan2"><img src="https://happybean-phinf.pstatic.net/20190621_199/1561108953977zW45e_JPEG/PC_%D7%BC%B8%EB%A1%A4%D7%BA%EB%B0%B0%EB_%EA%B0%D7%D9_%281%29.jpg"></a></li>
				<li><a href="/blackswan2"><img src="https://happybean-phinf.pstatic.net/20190625_2/1561426010401WjsbF_JPEG/PC__.jpg"></a></li>
			</ul>
			<div class="prev-banner"></div>
			<div class="next-banner"></div>
			<!-- <div class="banner-page">1&nbsp;/&nbsp;3</div> -->
		</div>
	</section>

	<section id="main">
		<h1 class="hidden">메인컨텐츠</h1>
		<div class="center">
			<section class="tap-select">
				<h1 class="hidden">메인펀딩 탭</h1>
				<ul>
					<li>인기펀딩</li>
					<li>신규펀딩</li>
					<li>종료임박</li>
				</ul>
			</section>
<!-- 			<section class="page-select">
				<h1 class="hidden">메인펀딩 페이징</h1>
				<div class="prev-select"></div>
				<div class="next-select"></div>
			</section> -->
			<section class="funding-select">
				<h1 class="hidden">메인펀딩</h1>
				<div class="info-select">
					<div class="info-title">펀딩</div>
					<div class="info-content">
						가치 있는 소비가<br>세상을 바꾸는 이들을<br>응원합니다
					</div>
					<table class="info-count">
						<tr>
							<td>참여</td>
							<td>316명</td>
						</tr>
						<tr>
							<td>참여금액</td>
							<td>8,258,200원</td>
						</tr>
					</table>
					<div class="info-more">
						<a href="/blackswan2/funding/list">인기펀딩 보러가기</a>
					</div>

				</div>


				<ul>
					<c:forEach var="f" items="${iflist}" begin="0" end="2">
						<c:if test="${f.partRate >= 100}">
							<li class="complete">
						</c:if>
						<c:if test="${f.partRate < 100}">
							<li>
						</c:if>
						<a href="/blackswan2/funding/detail?id=${f.id}">
							<div class="item-img">
								<img
								src="https://happybean-phinf.pstatic.net/20190516_270/1557995844250za2Lj_JPEG/00.jpg?type=w720">
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
		</div>
	</section>
	
	
	</main>

	<jsp:include page="./inc/footer.jsp" />

	</div>
</body>
</html>

