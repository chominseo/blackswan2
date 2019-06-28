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
<link rel="stylesheet" type="text/css" href="../css/page.css">
<script src="../js/member/signUp.js"></script>

</head>
<body>

	<h1 class="hidden">BLACKSWAN</h1>
	<jsp:include page="../inc/header.jsp" />

	<main>

	<section id="main" class="sign">
		<div>
			<h1>회원가입</h1>

			<form action="signUp" method="post">
				<input name="email" type="email" placeholder="email을 입력하세요">
				<input name="name" type="text" placeholder="이름을 입력하세요">
				<input name="pw" type="password" placeholder="새 비밀번호(6~18자리)" minlength="6" maxlength="18">
				<input name="pwc" type="password" placeholder="비밀번호 확인">
				<input name="phone" type="number" placeholder="휴대폰번호(‘-’ 없이 입력)">
				
				<input name="event_agree" id="sign-up-agree" type="checkbox" value="Y" checked>
				<label for="sign-up-agree">펀딩 소식과 이벤트 안내를 받습니다(선택)</label>
				<p>본인은 만 14세 이상이며 회원기본약관, 이용약관, 개인정보처리방침 내용에 동의합니다.</p>
				<input class="signUp" type="submit" value="가입하기">	
		</form>
		</div>
	</section>

	</main>

	<jsp:include page="../inc/footer.jsp" />

</body>
</html>