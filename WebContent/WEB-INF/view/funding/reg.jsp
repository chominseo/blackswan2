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
<link rel="stylesheet" type="text/css" href="../css/style3.css">

</head>

<body>
	<h1 class="hidden">BLACKSWAN</h1>
	<div class="class b-fundingreg">
		<jsp:include page="../inc/header.jsp" />

		<main> <jsp:include page="../inc/breadcrumb.jsp" />

		<section id="main">
			<h1 class="hidden">펀딩등록 페이지</h1>
			<div class="center">
				<form action="reg" method="post" enctype="multipart/form-data">
					<table class="list-table column">
						<tr>
							<td>카테고리</td>
							<td><select name="categoryId">
									<option value="4">사료</option>
									<option value="5">간식</option>
									<option value="6">배변용품</option>
									<option value="7">건강관리</option>
									<option value="8">미용용품</option>
									<option value="9">장난감</option>
									<option value="10">리빙</option>
									<option value="11">패션</option>
									<option value="12">야외용품</option>
									<option value="13">기타</option>
							</select></td>
						</tr>
						<tr>
							<td>프로젝트 제목</td>
							<td><textarea name="title"></textarea></td>
						</tr>
						<tr>
							<td>목표 금액</td>
							<td><input type="text" name="tAmount"></td>
						</tr>
						<tr>
							<td>프로젝트 이미지</td>
							<td><input type="file" name="introImg"></td>
						</tr>
						<tr>
							<td>프로젝트 희망시작일</td>
							<td><input type="date" name="sdate"></td>
						</tr>
						<tr>
							<td>프로젝트 희망종료일</td>
							<td><input type="date" name="edate"></td>
						</tr>
						<tr>
							<td>상태</td>
							<td><input type="text" name="state"></td>
						</tr>
						<tr class="table-full">
							<td>프로젝트 소개</td>
							<td><textarea name="content"></textarea></td>
						</tr>
						<tr>
							<td>리워드 내용</td>
							<td><label>금액</label><input type="text" name="rPrice">
								<label>내용</label><input type="text" name="rContent"></td>
						</tr>
						<tr>
							<td><input type="button" name="p-add" value="추가"></td>
							<td><input type="button" name="p-del" value="삭제"></td>
						</tr>


					</table>
					<div>
						<input type="submit" value="저장"> <a href="list">취소</a>
					</div>
				</form>

			</div>
		</section>

		</main>

		<jsp:include page="../inc/footer.jsp" />
	</div>
</body>
</html>