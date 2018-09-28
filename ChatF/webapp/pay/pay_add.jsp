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
<script>
	var USDprice = 5;
	var productNo = 1;

	$(function() {
		$("input[name=amount]").keyup(function() {
			USDprice = $("input[name=amount]").val();
		})
	})

	paypal.Button
			.render(
					{
						env : 'sandbox', // sandbox | production

						client : {
							sandbox : 'AZDxjDScFpQtjWTOUtWKbyN_bDt4OgqaF4eYXlewfBP4-8aqX3PiV8e1GWU6liB2CUXlkA59kJXE7M6R',
							production : productNo
						},

						commit : true, // Show a 'Pay Now' button

						style : {
							label : 'paypal',
							size : 'medium', // small | medium | large | responsive
							shape : 'rect', // pill | rect
							color : 'gold', // gold | blue | silver | black
							tagline : false
						},

						payment : function(data, actions) {
							return actions.payment.create({
								payment : {
									transactions : [ {
										amount : {
											total : USDprice,
											currency : 'USD'
										}
									} ]
								}
							});
						},

						// Wait for the payment to be authorized by the customer
						onAuthorize : function(data, actions) {
							// Execute the payment
							return actions.payment.execute().then(function() {
								//makeToast('Payment Complete!');
								addPay();
							});

						},
						onCancel : function(data, actions) {
							makeToast("결제 진행이 취소되었습니다. 다시 결제 부탁드립니다. :: ");
						},
						onError : function(err) {
							makeToast("결제에 실패하였습니다. 다시 결제 부탁드립니다. :: ");
						}
					}, '#paypal-button');
	
	
	function addPay(){
		$("form").attr("method","POST").attr("action","/PointServlet").submit();
	}
	
</script>

<style type="text/css">
#galleries .column {
	padding-left: 30%;
	padding-right: 30%;
	padding-top:5%;
	
}
</style>
</head>
<body>
	<div class="page-wrap">

		<!-- Nav -->
		<jsp:include page="../common/navbar.jsp"></jsp:include>

		<!-- Main -->
		<section id="main">
<c:if test="${loginUser.userRoll != 'a'}">
	<!-- Header -->
	<header id="header">
		<div></div>
	</header>
</c:if>

<c:if test="${loginUser.userRoll == 'a'}">
	<!-- Header -->
	<header id="header">
		<div>관리자 로그인</div>
	</header>
</c:if>

	
			<!-- Gallery -->
			<section id="galleries">

				<div class="gallery">
				
					<header>
							<h1>Pay Add</h1>
					</header>					
				
					<div class="content">
					
					
					
							<table>
								<tbody>
									
									
									<form action="#" method="post">
										<input type="hidden" name="check" value= "addPay">
									
									
										<div class="field half first">
											<label for="name">
											<c:if test="${! empty loginUser}">
												${loginUser.userId}
											</c:if>
											<c:if test="${ empty loginUser}">
												userid
											</c:if>
											
											</label> 
										</div>
										<div class="field">
											<label for="message">결제 금액</label>
											<input type="text" name="amount" value=""><br/>
										</div>
										<ul class="actions">
											
											<li><div class="col-sm-3 pay"><a id="paypal-button"></a></div></li>
											
										</ul>
									</form>
									
								</tbody>
							</table>
							
						</div>
						
				</div>
				
			</section>


			
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
		
		<jsp:include page="../common/toast.jsp"></jsp:include>
	
</body>
</html>