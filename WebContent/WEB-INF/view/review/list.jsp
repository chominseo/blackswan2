<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" >

<head>
    <title>Document</title>
</head>

<body>
    <!-- --- header block ---------------------------------------------------------------------------------------------------------------- -->
 <jsp:include page=""></jsp:include>

<!-- --- Body block ---------------------------------------------------------------------------------------------------------------- -->
<div id="body">
    <div class="content-box">

    <jsp:include page=""/>

 	<main>
            <section id="review">
                <h1>리뷰 목록</h1>
                <table>
                    <thead>
                        <tr>
                            <td class="title">글번호</td>
                            <td class="writer">제목</td>
                            <td class="date">작성자</td>
                            <td class="hit">작성일</td>
                        </tr>
                    </thead>

                    <tbody>
                       <c:forEach var="n" items="${list}">
                        <tr>
                            <td class="num">${n.id}</td>
                            <td class="title"><a href="detail?id=${n.id}">${n.title}</a></td>
                            <td class="wrtierId">${n.writerId}</td>
                            <td class="date">${n.regDate}</td>
                            <td class=""></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div>
                	<a href="reg"> 글쓰기</a>
                </div>
            </section>

            <section id="page-index">
                <h1 class="d-none">페이지 정보</h1>
                <div>
                    <span class="color-highlight font-bold">1</span>
                     / 1 pages
                </div>
            </section>

            <section id="pager">
                <h1 class="d-none">페이지</h1>
                <div>
                    <div class="icon-prev-page">이전</div>
                    <ul>
                        <li class="current">1</li>
                        <li>2</li>
                        <li>3</li>
                    </ul>
                    <div class="icon-next-page">다음</div>
                </div>
            </section>
    </main>
    </div>
</div>
<!-- --- footer block ---------------------------------------------------------------------------------------------------------------- -->
    <jsp:include page=""/>

</body>

</html>