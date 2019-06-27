
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
<script type="text/javascript" src=".././js/funding/buying.js"></script>

</head>


<body>
	<h1 class="hidden">BLACKSWAN</h1>
	<div class="class b-fundingreg">
		<jsp:include page="../inc/header.jsp" />
		<main>
			<section>
				<h1>펀딩결제</h1>
				<form action="buying" method="post" >
						<h2>펀딩 목록</h2>
						
						<select id="mySelect">
						<option>선택</option>
						<c:forEach var="f" items="${fpr}">
							<option value="${f.rPrice}">
							${f.rPrice}원 펀딩하기
							${f.rContent}
							배송비 : 2500원 
							발송예상일 : 2019년7월중순(11일~20일) 예정
							</option>
						</c:forEach>
						</select>
						<div>
							<label>펀딩 금액<span id="demo"></span></label>
						</div>
						<div>
							<h2>배송정보</h2>
							<label>이름</label><br>
							<input name="name" type="text" placeholder="예)조민서"><br>
							<label>휴대폰 번호</label><br>
							<input name="phone" type="number" placeholder="예)01012345678"><br>
							<label>우편번호</label><br>
							<input name="adress_num" type="text" placeholder="예)123456"><br>
							<label>주소</label><br>
							<input name="adress" type="text" placeholder="예)서울시 ㅇㅇ구 ㅇㅇ동 ㅇㅇ호"><br>
							<label>배송시 요청사항</label><br>
							<input name="req" type="text" placeholder="예)부재시 문앞에 놓아주세요"><br>
							<div class="hidden" id="aa">
								<input type="text" name="pay_pr">
								<input type="text" name="funding_id" value="${param.id}">
							</div>
						</div>
						<div>
						<input class="buying" type="submit" value="결제하기"><a href="/blackswan2/index"></a><br>
						</div>
						
					
				</form>
			</section>
		</main>	
	<jsp:include page="../inc/footer.jsp" />
	</div>
</body>
</html>