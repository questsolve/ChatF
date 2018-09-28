<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "com.chatf.user.dao.UserDAOImpl" %>
<%@ page import = "com.chatf.user.UserVO" %>

<!DOCTYPE HTML>
<!--
	Snapshot by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
<head>
<title>Snapshot by TEMPLATED</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/jquery.poptrox.min.js"></script>
<script src="assets/js/jquery.scrolly.min.js"></script>
<script src="assets/js/skel.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<script type="text/javascript" src="./chat/js/chatMain.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>

	$(function() {
		
		$('.ui-dialog-titlebar .ui-corner-all .ui-widget-header .ui-helper-clearfix .ui-draggable-handle').prop("display","none");
		
		$('.tabs .tab').click(function() {
			if ($(this).hasClass('signin')) {
				$('.tabs .tab').removeClass('active');
				$(this).addClass('active');
				$('.cont').hide();
				$('.signin-cont').show();
			}
			if ($(this).hasClass('signup')) {
				$('.tabs .tab').removeClass('active');
				$(this).addClass('active');
				$('.cont').hide();
				$('.signup-cont').show();
			}
		});

		var dialog, form,

 
		dialog = $(".loginView").dialog({
			autoOpen : false,
			height : 500,
			width : 500,
			modal : true
			
			
			,close : function() {
				form[0].reset();
				form[1].reset();
			}
		});

		form = dialog.find("form").on("submit", function(event) {
			event.preventDefault();
			
		});

		$("#create-user").button().on("click", function() {
			dialog.dialog("open");
		});
		
		$("input[value=Login]").on("click",function(){
			//alert("ㅎ2ㅇ");
			/* $("form[name=Login]").attr("method","POST").attr("action","/UserServlet").submit(); */
			//self.location ="/UserServlet";
			document.Login.action='/UserServlet';
			document.Login.submit();
		
			
		})
		
		$("input[value=SignIn]").on("click",function(){
			
			document.join.action='/UserServlet';
			document.join.submit();
			
			/* $("form[name=join]").attr("method","POST").attr("action","/UserServlet").submit(); */
		})
		
		
		
		function closeDialog(){
			dialog.dialog("close");
		}
		
		
		
		$("input[name=close_login]").on("click",function(){
			closeDialog();
		})
		
		$("input[name=close_SignIn]").on("click",function(){
			closeDialog();
		});
		
		
		
	});
</script>
<style>
.buttonyagn {
	background-color: #df7366;
	display: inline-block;
	border-radius: 100%;
	width: 4.5em;
	height: 4.5em;
	line-height: 4.5em;
	text-align: center;
	font-size: 1.25em;
	color: #fff;
	padding: 0;
}

#topBtn {
	position: fixed;
	right: 2%;
	bottom: 50px;
	z-index: 999;
	background: #6cc;
	font-weight: bolder
}

.toastMessage {
	width: 400px;
	height: auto;
	position: fixed;
	left: 50%;
	margin-left: -200px;
	bottom: 15px;
	background-color: #000000;
	color: #F0F0F0;
	font-size: 18px;
	padding: 12px;
	text-align: center;
	border-radius: 2px;
	-webkit-box-shadow: 0px 0px 24px -1px rgba(56, 56, 56, 1);
	-moz-box-shadow: 0px 0px 24px -1px rgba(56, 56, 56, 1);
	box-shadow: 0px 0px 24px -1px rgba(56, 56, 56, 1);
	z-index: 100;
}

.loginView * {
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	z-index: 10;
}

.loginView {
	font-family: 'Lato', sans-serif;
	background-color: #f8f8f8;
}

.loginView .container {
	position: relative;
	overflow: hidden;
	max-width: 500px;
	width: auto;
	height: 500px;
	background-color: #ffffff;
}

.loginView .container .half {
	float: left;
	width: 100%;
	height: 100%;
	padding: 58px 40px 0;
}

.loginView .container .half.bg {
	background-image: url("http://www.blueb.co.kr/SRC2/_image/v01.jpg");
	background-size: 400px;
	background-repeat: no-repeat;
}

.loginView .container h1 {
	font-size: 18px;
	font-weight: 700;
	margin-bottom: 23px;
	text-align: center;
	text-indent: 6px;
	letter-spacing: 7px;
	text-transform: uppercase;
	color: #263238;
}

.loginView .container .tabs {
	width: 100%;
	margin-bottom: 29px;
	border-bottom: 1px solid #d9d9d9;
}

.loginView .container .tabs .tab {
	display: inline-block;
	margin-bottom: -1px;
	padding: 20px 15px 10px;
	cursor: pointer;
	letter-spacing: 0;
	border-bottom: 1px solid #d9d9d9;
	-moz-user-select: -moz-none;
	-ms-user-select: none;
	-webkit-user-select: none;
	user-select: none;
	transition: all 0.1s ease-in-out;
}

.loginView .container .tabs .tab a {
	font-size: 11px;
	text-decoration: none;
	text-transform: uppercase;
	color: #d9d9d9;
	transition: all 0.1s ease-in-out;
}

.loginView .container .tabs .tab.active a, .loginView .container .tabs .tab:hover a
	{
	color: #263238;
}

.loginView .container .tabs .tab.active {
	border-bottom: 1px solid #263238;
}

.loginView .container .content form {
	position: relative;
	height: 287px;
}

.loginView .container {
	width: 500px;
	height: 500px;
}

.loginView .container .content label:first-of-type, .loginView .container .content input:first-of-type,
	.loginView .container .content .more:first-of-type {
	-moz-animation: slideIn 0.4s cubic-bezier(0.37, 0.82, 0.2, 1);
	-webkit-animation: slideIn 0.4s cubic-bezier(0.37, 0.82, 0.2, 1);
	animation: slideIn 0.4s cubic-bezier(0.37, 0.82, 0.2, 1);
}

.loginView .container .content label:nth-of-type(2), .loginView .container .content input:nth-of-type(2),
	.loginView .container .content .more:nth-of-type(2) {
	-moz-animation: slideIn 0.5s cubic-bezier(0.37, 0.82, 0.2, 1);
	-webkit-animation: slideIn 0.5s cubic-bezier(0.37, 0.82, 0.2, 1);
	animation: slideIn 0.5s cubic-bezier(0.37, 0.82, 0.2, 1);
}

.loginView .container .content label:nth-of-type(3), .loginView .container .content input:nth-of-type(3),
	.loginView .container .content .more:nth-of-type(3) {
	-moz-animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
	-webkit-animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
	animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
}

.loginView .container .content label:nth-of-type(4), .loginView .container .content input:nth-of-type(4),
	.loginView .container .content .more:nth-of-type(4) {
	-moz-animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
	-webkit-animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
	animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
}

.loginView .container .content label:nth-of-type(5), .loginView .container .content input:nth-of-type(5),
	.loginView .container .content .more:nth-of-type(5) {
	-moz-animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
	-webkit-animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
	animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
}

.loginView img {
	-moz-animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
	-webkit-animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
	animation: slideIn 0.6s cubic-bezier(0.37, 0.82, 0.2, 1);
}

.loginView .container .content label {
	font-size: 12px;
	color: #263238;
	-moz-user-select: -moz-none;
	-ms-user-select: none;
	-webkit-user-select: none;
	user-select: none;
}

.loginView .container .content label:not ([for='remember'] ) {
	display: none;
}

.loginView .container .content input.inpt {
	font-size: 13pt;
	display: block;
	width: 100%;
	height: 42px;
	margin-bottom: 12px;
	color: #999999;
	border: 1px solid #d9d9d9;
	background: transparent;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
}

.loginView .container .content input.inpt.email {
	font-size: 14px;
	display: block;
	width: 80%;
	height: 42px;
	margin-bottom: 12px;
	padding: 16px 13px;
	color: #999999;
	border: 1px solid #d9d9d9;
	background: transparent;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	float: left;
}

.loginView .container .content input.inpt.access {
	font-size: 14px;
	display: block;
	width: 20%;
	height: 42px;
	margin-bottom: 12px;
	color: #ffffff;
	border: 1px solid #d9d9d9;
	background: transparent;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	background: #111111;
}

.loginView .container .content input.inpt::-webkit-input-placeholder {
	font-size: 14px;
	color: #999999;
	font-family: 'Lato', sans-serif;
}

.loginView .container .content input.inpt:-moz-placeholder {
	font-size: 14px;
	color: #999999;
	font-family: 'Lato', sans-serif;
}

.loginView .container .content input.inpt::-moz-placeholder {
	font-size: 14px;
	color: #999999;
	font-family: 'Lato', sans-serif;
}

.loginView .container .content input.inpt:-ms-input-placeholder {
	font-size: 14px;
	color: #999999;
	font-family: 'Lato', sans-serif;
}

.loginView .container .content input.inpt:focus {
	border-color: #999999;
}

.loginView .container .content input.submit {
	font-size: 12px;
	line-height: 42px;
	display: block;
	width: 100%;
	height: 42px;
	cursor: pointer;
	vertical-align: middle;
	letter-spacing: 2px;
	text-transform: uppercase;
	color: #263238;
	border: 1px solid #263238;
	background: transparent;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
}

.loginView .container .content.signin-cont.cont input.submit {
	font-size: 12px;
	line-height: 42px;
	display: block;
	width: 100%;
	height: 42px;
	cursor: pointer;
	vertical-align: middle;
	letter-spacing: 2px;
	text-transform: uppercase;
	color: #263238;
	border: 1px solid #263238;
	background: transparent;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
}

.loginView .container .content input.submit:hover {
	background-color: #263238;
	color: #ffffff;
	-moz-transition: all 0.2s;
	-o-transition: all 0.2s;
	-webkit-transition: all 0.2s;
	transition: all 0.2s;
}

.loginView .container .content input:focus {
	outline: none;
}

.loginView .container .content .submit-wrap {
	position: relative;
	bottom: 0;
	width: 100%;
}

.loginView .container .content .submit-wrap a {
	font-size: 14px;
	display: block;
	margin-bottom: 20px;
	text-align: center;
	text-decoration: none;
	color: #6b6b6b;
}

.loginView .container .content .submit-wrap a:hover {
	text-decoration: underline;
}

.loginView .container .content .signup-cont {
	display: none;
}

@
keyframes slideIn { 0% {
	filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=0);
	opacity: 0;
	margin-left: -320px;
}

100%
{
filter
:
 
progid
:DXImageTransform
.Microsoft
.Alpha
(enabled=false);

    
opacity
:
 
1;
margin-left
:
 
0
px
;

  
}
}
@
-webkit-keyframes slideIn { 0% {
	filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=0);
	opacity: 0;
	margin-left: -320px;
}

100%
{
filter
:
 
progid
:DXImageTransform
.Microsoft
.Alpha
(enabled=false);

    
opacity
:
 
1;
margin-left
:
 
0
px
;

  
}
}
.loginView .credits {
	display: block;
	position: absolute;
	right: 0;
	bottom: 0;
	color: #999999;
	font-size: 14px;
	margin: 0 10px 10px 0;
}

.loginView .credits a {
	filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=80);
	opacity: 0.8;
	color: inherit;
	font-weight: 700;
	text-decoration: none;
}

.loginView img {
	max-width: 100%;
	width: auto;
	height: auto;
}

.white {
	width: 90px;
	float: right;
	font-size: 10pt;
	padding: 0;
	background: #ffffff;
}

.white:hover {
	background: none;
}

.loginView input[type="button"] {
	padding: 0;
}
</style>
</head>
<body>
	<div class="page-wrap">

		<jsp:include page="/common/navbar.jsp"></jsp:include>


		<!-- Main -->
		<section id="main">

			<!-- Banner -->
			<section id="banner">
				<div class="inner">
					<h1>Hey, I'm Snapshot</h1>
					<p>
						A fully responsive gallery template by <a
							href="https://templated.co">TEMPLATED</a>
					</p>
					<ul class="actions">
					<c:if test="${empty loginUser}">
						<li><button id="create-user">Create new user</button></li>
					</c:if>
					
					</ul>
				</div>
			</section>

			<!-- Gallery -->
			<section id="galleries">

				<!-- Photo Galleries -->
				<div class="gallery">
					<header class="special">
						<h2>What's New</h2>
					</header>
					<div class="content">
						<div class="media">
							<a href="images/fulls/01.jpg"><img src="images/thumbs/01.jpg"
								alt="" title="This right here is a caption." /></a>
						</div>
						<div class="media">
							<a href="images/fulls/05.jpg"><img src="images/thumbs/05.jpg"
								alt="" title="This right here is a caption." /></a>
						</div>
						<div class="media">
							<a href="images/fulls/09.jpg"><img src="images/thumbs/09.jpg"
								alt="" title="This right here is a caption." /></a>
						</div>
						
						<div class="media">
							<a href="images/fulls/02.jpg"><img src="images/thumbs/02.jpg"
								alt="" title="This right here is a caption." /></a>
						</div>
						<div class="media">
							<a href="images/fulls/06.jpg"><img src="images/thumbs/06.jpg"
								alt="" title="This right here is a caption." /></a>
						</div>
						<div class="media">
							<a href="images/fulls/10.jpg"><img src="images/thumbs/10.jpg"
								alt="" title="This right here is a caption." /></a>
						</div>
						<div class="media">
							<a href="images/fulls/03.jpg"><img src="images/thumbs/03.jpg"
								alt="" title="This right here is a caption." /></a>
						</div>
						<div class="media">
							<a href="images/fulls/07.jpg"><img src="images/thumbs/07.jpg"
								alt="" title="This right here is a caption." /></a>
						</div>
					</div>
					<footer>
						<a href="gallery.html" class="button big">Full Gallery</a>
					</footer>
				</div>
			</section>

			<!-- Contact -->
			<section id="contact">

				<!-- Chat -->
				<div class="column">
					<h3>Chatting</h3>
					<form action="#" method="post">


						<div class="field">
							<label for="message">Message</label>
							<textarea name="message" class="messageWindow" id="messageWindow"
								rows="20" readonly="true" placeholder="Message"></textarea>
						</div>

						<div class="field half first">
							<input name="message-submit" id="inputMessage" type="text"
								placeholder="Insert the Text">
						</div>
						<input type="button" id="inputBtn" class="inputBtn" value="send">

					</form>
				</div>

			</section>









			<div class="loginView" style="display: none;">
				<section class="container">

					<article class="">

						<div class="tabs">
							<span class="tab signin active"><a href="#signin"
								style="font-size: 15pt;">로그인</a></span> &nbsp;&nbsp;&nbsp; <span
								class="tab signup"><a href="#signup"
								style="font-size: 15pt;">가입하기</a></span>
						</div>
						<div class="content">
							<div class="signin-cont cont">
								<form name="Login">
									<input type="hidden" name="info" value ="login">
									<input type="text" name="userId" class="inpt"
										required="required" placeholder="아이디"> <input
										type="password" name="password" class="inpt"
										required="required" placeholder="비밀번호">

									<div class="submit-wrap">
										<a class="button white" role="button" href="#">비밀번호 찾기</a> <a
											class="button white" role="button" href="#">아이디 찾기</a> <input
											type="button" value="Login" class="submit"> <br>
										<input type="button" value="close" name ="close_login" class="submit">

									</div>
								</form>
							</div>
							<div class="signup-cont cont">
								<form name="join">
								<input type="hidden" name="info" value ="addUser">
									<input type="text" name="userId" class="inpt"
										required="required" placeholder="아이디" oninput="checkId();">
										 <input type="button"
										
										
										class="inpt access" name="idCheck" value="중복확인">
										
									<input type="password" name="password" class="inpt"
										required="required" placeholder="비밀번호"> <input
										type="password" name="password2" class="inpt"
										required="required" placeholder="비밀번호 확인"> <input
										type="text" name="email" class="inpt email"
										required="required" placeholder="이메일" value=""
										oninput="emailValid();">
										
										 <input type="button"
										
										
										class="inpt access" name="sendEmail" value="인증"> <input
										type="text" name="code" class="inpt email" required="required"
										placeholder="인증번호">
										
										 <input type="button"
										class="inpt access" name="checkCode" value="확인"> <input
										type="button" value="SignIn" class="submit"> <br>
									<input type="button" value="close" name="close_SignIn" class="submit">


								</form>
							</div>
						</div>
					</article>
				</section>
			</div>

			<!-- Footer -->
			<footer id="footer">
				<div class="copyright">
					&copy; Untitled Design: <a href="https://templated.co/">TEMPLATED</a>.
					Images: <a href="https://unsplash.com/">Unsplash</a>.
				</div>
			</footer>
		</section>
	</div>

	<!-- Scripts -->

</body>
</html>