<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 

<header>
	<section id="header">
		<div class="center">
			<h1><a href="/blackswan2/index" alt="blackswan logo">블랙스완</a></h1>
			<section id="gnb">
				<h1 class="hidden">메인메뉴</h1>
				<ul class="main-menu">
					<li><a href="/blackswan2/funding/list">펀딩</a></li>
					<c:if test="${ssid != null }">
					<li><a href="/blackswan2/funding/reg2">등록신청</a></li>
					</c:if>
					<c:if test="${ssid == null}">
					<li><a href="/blackswan2/member/login">등록신청</a></li>
					</c:if>
					<li><a href="/blackswan2/notice/list">고객센터</a></li>
					<c:if test="${ssid == 1}">
					<li><a href="/blackswan2/admin/member/list">관리자</a></li>
					</c:if>
				</ul>
			</section>
			<section id="user-menu">
				<h1 class="hidden">사용자메뉴</h1>
				<div class="user-direct">
					<c:if test="${ssid == null}">
 					<div class="log"><a href="/blackswan2/member/login">로그인</a></div>
					<div class="signup"><a href="/blackswan2/member/signUp">회원가입</a></div>
					</c:if>
					<c:if test="${ssid != null}">
					<div class="user">
						<span>${hmember.name} 님</span>
						<span class="user-button"></span>
					</div>
					</c:if>
					
					<div class="search"><a href=""><span>검색</span></a></div>
				</div>
			</section>
			
			<nav id="mp-link">
				<h1 class="hidden">마이페이지 링크</h1>
				<ul>
					<li><a href="">최근 본 목록</a></li>
					<li><a href="/blackswan2/member/mypage">마이페이지</a></li>
					<li><a href="">회원정보수정</a></li>
					<li><a href="/blackswan2/member/logout">로그아웃</a></li>
				</ul>
			</nav>
		</div>
	</section>
<script>
$(document).ready(function(){
	$("#mp-link").hide();
	$(".user-button").click(function(){
		$("#mp-link").slideToggle("fast");
	});
});
</script>
</header>
