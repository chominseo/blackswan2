<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Black Swan Funding</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
	<jsp:include page="../inc/header.jsp" />

	<div class="content-box">

		<main>
		<section id="main">
			<h1>공지사항</h1>

			<section id="notice-search">
				<h1 class="d-none">qna 검색</h1>
				<form>
					<select>
						<option>제목</option>
						<option>작성자</option>
						<option>내용</option>
					</select> <input type="text"> <input type="submit" value="검색">
				</form>
			</section>
			<section id="notice">
				<h1 class="d-none">qna 목록</h1>
				<form method="post">
					<table border="1">
						<thead class="notice-header">
							<tr>
								<td class="id">qna 넘버</td>
								<td class="member_id">회원 이름</td>
								<td class="title">제목</td>
								<td class="content">내용</td>
								<td class="regdate">작성일</td>
								<td class="reply">답글</td>
								<td class="r-date">답글 일자</td>
								<td class="secretnum">비밀번호</td>
								<td class="state">글상태</td>
							</tr>
						</thead>
						<tbody class="qna-body">
							<c:forEach var="q" items="${qlist}">
								<tr>
									<td class="num">${q.num}</td>
									<td class="name">${q.name}</td>
									<td class="title">${q.title}</td>
									<td class="content">${q.content}</td>
									<td class="regdate">${q.regdate}</td>
									<td class="reply">${q.reply}</td>
									<td class="r_date">${q.r_date}</td>
									<td class="secretnum">${q.secretnum}</td>
									<td class="state">${q.state}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</form>
			</section>

			<jsp:include page="../inc/paging.jsp" />
		</section>
		</main>
	</div>



	<jsp:include page="../inc/footer.jsp" />

</body>
</html>