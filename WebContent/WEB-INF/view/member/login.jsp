<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Black Swan Funding</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">

<link rel="stylesheet" type="text/css" href="../css/page.css">
</head>
<body>

	<h1 class="hidden">BLACKSWAN</h1>
	<jsp:include page="../inc/header.jsp" />

	<main>

	<section id="main" class="log">
		<div>
		<h1>로그인</h1>

		<form action="login" method="post">
			<input name="email" type="text" placeholder="email을 입력하세요">
			<input name="pw" type="password" placeholder="비밀번호를 입력하세요">
			<input class="login" type="submit" value="로그인">
			<a href="/blackswan2/member/signUp">가입하기</a>
		</form>

		</div>
	</section>

	</main>

	<jsp:include page="../inc/footer.jsp" />

</body>
</html>