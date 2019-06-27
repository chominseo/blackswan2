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

</head>


<body>
	<h1 class="hidden">BLACKSWAN</h1>
	<div class="class b-fundingreg">
		<jsp:include page="../inc/header.jsp" />
			<main>


			<section>
				<h1>판매자등록</h1>

				<section>
					<h2>판매자등록 상세</h2>
					<form action="reg2" method="post" enctype="multipart/form-data">
						
						<table>
							<tbody>
						
								<tr>
									<th>메이커 이름</th>
									<td><input type="text" name="companyName"></td>
								</tr>
								<tr>
									<th>메이커 프로필 이미지</th>
									<td><input type="file" name="companyImg"></td>
								</tr>
								<tr>
									<th>메이커 홈페이지</th>
									<td><input type="text" name="companyWeb"></td>
								</tr>
								<tr>
									<th>연락처</th>
									<td><input type="text" name="companyTel"></td>
								</tr>
								<tr>
									<th>이메일</th>
									<td><input type="email" name="companyEmail"></td>
								</tr>
								<tr>
									<th>수수료</th>
									<td>
										<input type="checkbox" name="companyComi" value="1">
										<span>수수료정책 동의</span>
									</td>
								</tr>
								<tr>
									<th>계약정보 1) 사업자 여부 및 정보</th>
									<td>사업자번호<input type="text" name="companyRegNum"></td>
									<td>사업자등록증<input type="file" name="companyReg"></td>
									<td>통장사본<input type="file" name="companyPass"></td>
								</tr>
								<tr>
									<th>대표자명</th>
									<td><input type="text" name="companyBoss"></td>
								</tr>
								<tr>
									<th>대표자이메일</th>
									<td><input type="email" name="companyBossEmail"></td>
								</tr> 
							</tbody>
						</table>
						<div>
							<input type="submit" value="저장"> <a href="list">취소</a>
						</div>
					</form>
				</section>


			</section>
			</main>

	<jsp:include page="../inc/footer.jsp" />
	</div>
</body>
</html>