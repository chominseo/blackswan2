<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/index.css">
<link rel="stylesheet" type="text/css" href="../css/mypage.css">
<script src="../js/member/mypage.js"></script>
</head>
<body>
	<!-- header--------------------- -->
	<jsp:include page=".././inc/header.jsp" />
	<!-- main------------------ -->
	<section id="profile">
		<ul>
			<li>개인회원</li>
			<li>${member.name}</li>
			<li>참여펀딩</li>
			<li>개설펀딩</li>
			<li><img class="pro-img"
				src="/blackswan2/upload/${member.profile}"></li>
		</ul>
	</section>
	<section id="section">
		<div class="h-click">
			<ul class="tab-menu-list">
				<li><a href="#tab1">참여펀딩</a></li>
				<li><a href="#tab2">개설펀딩</a></li>
				<li><a href="#tab3">설정</a></li>
			</ul>
		</div>
		<div class="content-list">
			<div id="tab1" class="d-none current">
				<h2>참여펀팅</h2>
				<div>
					<form method="get">
						<input type="date">~ <input type="date"> <input
							type="submit" value="검색">
					</form>
				</div>
				<div>2019.05</div>
				<div>
					<ul>
						<li>날짜</li>
						<li>댕댕이집</li>
						<li>9000</li>
						<li><a href=""></a></li>
						<li><a href=""></a></li>
					</ul>
				</div>
			</div>
			<div id="tab2" class="d-none">
				<h2>개설펀딩</h2>
				<div>
					<form method="get">
						<input type="date">~ <input type="date"> <input
							type="submit" value="검색">
					</form>
				</div>
				<div>2019.05</div>
				<div>심사대기 중 입니다.</div>
				<c:forEach var="f" items="${flist}">
				<%-- <div class="circle">${funding.partRate}</div> --%>
				<div class="tAmount">${f.tAmount}원목표</div>
				<div class="sdate">${f.sdate} ~ ${f.edate}</div>
				<div class="title">${f.title}</div>
				<div class="company_name">${f.companyName}</div>
				</c:forEach>
				<input name="event_apply" type="button" value="이벤트신청"><a href=""></a>
				<input name="funding_edit" type="submit" value="펀딩 수정">
				<input name="funding_del" type="submit" value="펀딩 삭제">
			</div>
			<div id="tab3" class="d-none">
				<h2>설정</h2>
				<form action="profile" method="post" enctype="multipart/form-data">
					<dl>
						<dt>
							<img class="pro-img" src="/blackswan2/upload/${member.profile}">
						</dt>
						<dd>
							<input type="file" name="file">
						</dd>
					</dl>
					<input type="submit" value="설정저장">
					<dl>
						<dt>이름</dt>
						<dd>${member.name}</dd>
					</dl>
					<dl>
						<dt>이메일</dt>
						<dd>${member.email}</dd>
					</dl>
					<dl>
						<dt>전화번호</dt>
						<dd>${member.phone}</dd>
					</dl>
				</form>
				<form action="edit" method="get">
					<dl>
						<dt>우편번호</dt>
						<dd>
							<input type="text" name="addnum" style="border: 1px solid">현재나의우편번호${member.addressNum}
						</dd>
					</dl>
					<dl>
						<dt>주소</dt>
						<dd>
							<input type="text" name="address">현재나의주소${member.address}
						</dd>
					</dl>
					<c:if test="${param.error==1}">
						<div>우편번호, 주소를 입력해주세요</div>
					</c:if>
					<input type="submit" value="설정저장">
				</form>
				<form action="edit" method="post">
					<label>현재 비밀번호</label><input type="password" name="pw"> <label>새비밀번호</label><input
						type="password" name="npw"> <label>비밀번호 확인</label><input
						type="password" name="npw1">
					<c:if test="${param.error==2}">
						<div>새로운 비밀번호가 일치하지 않습니다.</div>
					</c:if>
					<c:if test="${param.error==3}">
						<div>현재비밀번호가 맞지않습니다.</div>
					</c:if>
					<c:if test="${empty param.error}">
						<div>비밀번호 변경완료</div>
					</c:if>
					<input type="submit" value="비밀번호 변경">
				</form>
			</div>
		</div>
	</section>

	<!-- footer------------------------------ -->
	<jsp:include page=".././inc/footer.jsp" />
</body>
</html>