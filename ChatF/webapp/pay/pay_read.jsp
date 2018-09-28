<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="../assets/css/main.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/jquery.poptrox.min.js"></script>
<script src="../assets/js/jquery.scrolly.min.js"></script>
<script src="../assets/js/skel.min.js"></script>
<script src="../assets/js/util.js"></script>
<script src="../assets/js/main.js"></script>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://www.paypalobjects.com/api/checkout.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
#galleries{
	padding-top: 5%;
	padding-left: 30%;
    padding-right: 30%;
}

</style>
</head>
<body>
		<div class="page-wrap">

			<jsp:include page="../common/navbar.jsp"></jsp:include>

			<!-- Main -->
				<section id="main">

					<!-- Banner -->
						<section id="banner">
							<div class="inner">
								<h1>Hey, I'm Snapshot</h1>
								<p>A fully responsive gallery template by <a href="https://templated.co">TEMPLATED</a></p>
								<ul class="actions">
									<li><a href="#galleries" class="button alt scrolly big">Continue</a></li>
								</ul>
							</div>
						</section>

					<!-- Gallery -->
						<section id="galleries">
						
						<table>
								<tr>
									<td>결제 번호</td>
									<td>
									<c:if test="${! empty pay}">
											${pay.payNo}
									</c:if> <c:if test="${ empty pay}">
											test11111111
									</c:if>
									</td>
								</tr>
								
								<tr>
									<td>결제 ID</td>
									<td>
									<c:if test="${! empty loginUser.userId}">
										${loginUser.userId}
									</c:if>
									<c:if test="${ empty loginUser.userId}">
										userid
									</c:if>
									</td>
								</tr>
								
								<tr>
									<td>결제 수단</td>
									<td>
									<c:if test="${! empty pay}">
											${pay.payWay}
									</c:if> <c:if test="${ empty pay}">
											testPayWay
									</c:if>
									</td>
								</tr>
								
								<tr>
									<td>결제일</td>
									<td>
									
									<c:if test="${! empty pay}">
											${pay.payDate}
									</c:if> <c:if test="${ empty pay}">
											test2018.01.01
									</c:if>
									
									</td>
								</tr>
								
								<tr>
									<td>결제액</td>
									<td>
									<c:if test="${! empty pay}">
											${pay.price}
									</c:if> <c:if test="${ empty pay}">
											100000	
									</c:if>
									</td>
								</tr>
								
								<tr>
									<td>충전 포인트</td>
									<td>
									<c:if test="${! empty pay}">
											${pay.price}
									</c:if> <c:if test="${ empty pay}">
											100000	
									</c:if>
									</td>
								</tr>
								
								<tr>
									<td>현재 포인트</td>
									<td>
									<c:if test="${! empty totalPoint}">
											${totalPoint}
									</c:if> 
									<c:if test="${ empty totalPoint}">
											12300000	
									</c:if>
									</td>
								</tr>
								</table>
								<div>
									<input value="Home" class="button" type="button">
									<input value="My Page" class="button" type="button">
								</div>
								</div>
						</section>

					
					<!-- Footer -->
						<footer id="footer">
							<div class="copyright">
								&copy; Untitled Design: <a href="https://templated.co/">TEMPLATED</a>. Images: <a href="https://unsplash.com/">Unsplash</a>.
							</div>
						</footer>
				</section>
		</div>

		
			

	</body>
</html>