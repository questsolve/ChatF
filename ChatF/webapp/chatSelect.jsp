<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%> 
<%@page import="java.util.Date"%>
<%@page import="com.chatf.user.UserVO"%>

<!DOCTYPE HTML>
<!--
	Snapshot by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
<title>Create have a travel Friends</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css"/>

<script src="assets/js/jquery.min.js"></script>
<!-- <script src="assets/js/jquery.poptrox.min.js"></script>-->
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<!-- <script src="assets/js/main.js"></script>-->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="assets/js/loginSign.js"></script>
<script src="assets/js/userSign.js"></script>
<link rel="stylesheet" href="assets/css/sign.css" />


<script>
var user= '${loginUser.userId}';
</script> 
<script type="text/javascript" src="./chat/js/chatMain.js?ver=2"></script>

</head>

<body>



<!-- 스크롤 부드럽게 넘어가기 -->
<style>
html {
  scroll-behavior: smooth;
}
</style>
<!-- 스크롤 부드럽게 넘어가기 -->


<!-- 현재 (세션)로그인한 아이디 -->

<!--  TODO 0926 getUserId 의 문제 . 널 처리 해줄방법 todo  -->
<%
 UserVO vo = (UserVO)session.getAttribute("loginUser"); //session에 있는 정보를 받아온다.
 
 if(vo == null){
  System.out.println("로그인 안한 사용자");
 }else{
  System.out.println("로그인한 사용자");
  System.out.println("로그인한 유저"+vo.getUserId()); 
 }
  System.out.println("현재 세션에 올라와있는것 : "+session.getAttribute("loginUser"));

%>
 <!--   --> 

	<div class="page-wrap">

		<jsp:include page="/common/navbar.jsp"></jsp:include>

			<!-- Main -->
			<section id="main">
<c:if test="${loginUser.userRoll != 'a'}">
<!-- Header -->
	<header id="header">
		<div></div>
	</header>
</c:if>

			<!-- banner -->
			<jsp:include page="/common/chatBanner.jsp"></jsp:include>
		</section>
	</div>
	
	
	

</body>
</html>