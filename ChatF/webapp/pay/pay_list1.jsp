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

<script>

/////////////////키보드 입력시 마다 해당 값으로 DB 검색///////////////////////////////

$(function(){
	$("input[name=userId]").keyup(function(){
		$("#board tr").remove();
		var queryString = $("form").serialize();
		
		
		searchUserId(queryString);
	});
});

/////////////////실제로 DB 검색하는 AJAX///////////////////////////////

function searchUserId(query){
	//alert($("input[name=userId]").val());
	$.ajax({
		url :"/PayServlet",
		method:"post",
		data:query,
		success:function(res){
			showListPay(res);
		}
	})
}

/////////////////검색한 결과값을 화면에 송출///////////////////////////////

function showListPay(data){
	var jsonData = JSON.parse(data);
	var htmlStr ="";
	$.map(jsonData, mapCallback);
	function mapCallback( v,  i) { 
		htmlStr += "<tr>"
		htmlStr +="<td>"+v.payNo+"</td>";
		htmlStr += "<td>"+v.payDate+"</td>";
		htmlStr += "<td>"+v.price+"</td>";
		htmlStr += "<td>"+v.payFlag+"</td>";
		htmlStr += "<input type='hidden' name='payNo' value='"+v.payNo+"'>"
		htmlStr += "</tr>"
	}
	
	
	$("#board").append(htmlStr);
}




var flag=0;
var page =1;
var checkId;
///* 

/////////////////무한 스크롤로 page처리///////////////////////////////
$(function () {
	$(document).scroll(function() {
	    var maxHeight = $(document).height();
	    var currentScroll = $(window).scrollTop() + $(window).height();
		var id = $("input[name=userId]").val();
	    checkId =id;
	    if (maxHeight <= currentScroll && !(id ==null || id =="") && flag==0 ) {
		
		flag==1
		page++;
		$("input[name=page]").val(page);
		var queryString = $("form").serialize();
		
		searchUserId(queryString);
		
	    }
	    
	    if(maxHeight >= currentScroll && flag==1 ) {
	    	flag=0;
	    }
	    
	    
	})
});

function listpay(){
	$.ajax({
		url :"/PayServlet",
		method:"post",
		data:query,
		success:function(res){
			showListPay(res);
		}
	})
}


$(function(){
	var userRoll = '${loginUser.userRoll}';
	
	if(userRoll == "" || userRoll==null){
		//alert("로그인으로 던지기");
	}else{
		var userId = "${loginUser.userId}";
		var check = "listPay_ajax";
		alert(check);
		$.ajax({
			url :"/PayServlet",
			method:"POST",
			data:"userId="+userId+"&check ="+check,
			success:function(res){
				showListPay(res);
			}
		})
	}
})



	




///*
$( function() {
    var jbOffset = $("#search").offset();
    $( window ).scroll( function() {
      if ( $( document ).scrollTop() > jbOffset.top ) {
    	  $("#search").addClass( 'jbFixed' );
      }
      else {
    	  $("#search").removeClass( 'jbFixed' );
      }
    });
  });
  

$(function(){  
  $(document).on("keyup", ".jbFixed input[name=userId]", function() {
	  
	  
	  //alert($("input[name=page]").val());
	  //alert($(".jbFixed input[name=userId]").val());
	  $("#board tr").remove();
	  $("input[name=page]").val(1);
	  //alert($("input[name=page]").val());
	  
	  var queryString = $("form").serialize();
	  alert(queryString);
	  searchUserId(queryString);
  });
});
  
  
// */
/////////////////////////상세 결제 내역 보기///////////////////////////////////////////////
var payNo;
$(function(){
	$(document).on("click","#board tr",function(e){
		//payNo = $($("#board tr td")[$("#board").index(this)]).val();
		//payNo = $($("input[name=payNo]")[$(".payNo tr").index(this)]).val();
		
		payNo = $($("input[name=payNo]")[$("#board tr").index(this)]).val();
		//alert(payNo)
		readPay(payNo);
	})
	
	
	
	
	function readPay(payNo){
		$.ajax({
			url :"/PayServlet",
			method:"GET",
			data:"check=readPay_ajax&payNo="+payNo,
			success:function(res){
				
				appendReadPay(res);
				dialog.dialog("open");
			}
		})
		
	}
	
	
	
	function appendReadPay(data) {
		$("#ajaxPayNo").remove();	
		$("#sessionUserId").remove();
		$("#ajaxPayWay").remove();
		$("#ajaxPrice").remove();
		$("#ajaxPayFlag").remove();
		$("#ajaxPayDate").remove();
		
		var payData = JSON.parse(data);
		
		
		$("#payNoTr").append("<td id='ajaxPayNo'>"+payData.payNo+"</td>");
		$("#userIdTr").append("<td id='sessionUserId'>"+'${loginUser.userId}'+"</td>");
		$("#payWayTr").append("<td id='ajaxPayWay'>"+payData.payWay+"</td>");
		$("#priceTr").append("<td id='ajaxPrice'>"+payData.price+"</td>");
		$("#payFlagTr").append("<td id='ajaxPayFlag'>"+payData.payFlag+"</td>");
		$("#payDateTr").append("<td id='ajaxPayDate'>"+payData.payDate+"</td>");
	}

		var dialog, form,

		dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 400,
			width : 350,
			modal : true,
		});

	});
</script>


<style type="text/css">
#galleries .column {
	padding-left: 20%;
	padding-right: 20%;
	padding-top:5%;

}
#search tr{
border-right:none;
border-left:none;
border-top:none;
border-bottom:none;
 

}
.jbFixed{
position: fixed;
top: 0px;
background-color: #f1f1f1;
}


</style>
</head>
<body>
	<div class="page-wrap">

		<!-- Nav -->
		<jsp:include page="../common/navbar.jsp"></jsp:include>

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
						<li><a href="#galleries" class="button alt scrolly big">Continue</a></li>
					</ul>
				</div>
			</section>


			<!-- Gallery -->
			<section id="galleries">

				<div class="column">
					
					<form action="#" method="post">
						<div id="search">
							<table>
								<tbody >
									<tr >
										<td>확인할 User :</td>
										<c:if test="${loginUser.userRoll=='a'}">
										<td><input type="text" name="userId" value=""></td>
										</c:if>
										<c:if test="${loginUser.userRoll =='u'}">
										<td>${loginUser.userId}</td>
										</c:if>
										
									</tr>
										<input type="hidden" name="page" value="1">
								</tbody>
							</table>

						</div>
								<input type="hidden" name="check" value="listPay_ajax">
						
						
					</form>

						<div class="field">
							<table>
								<thead>
									<tr>
										<td>결제 번호</td>
										<td>결제일</td>
										<td>결제액</td>
										<td>구분</td>
									</tr>
								</thead>

								<tbody id="board">
								
								<c:if test="${! empty payList}">
										<c:forEach items="${payList}" var="pay">
									<tr class="payNo">

											<td>${pay.payNo}</td>
											<td>${pay.payDate }</td>
											<td>${pay.price }</td>
											<td>${pay.payFlag}</td>
											<input type='hidden' name='payNo' value="${pay.payNo}">

									</tr>
										</c:forEach>
								</c:if>
							</tbody>
							</table>
							
						</div>
						<ul class="actions">
							

							
						</ul>
					
				</div>
				
			</section>



			<div id="dialog-form" title="Pay Detail">
				<table>
					<tr id="payNoTr"><td> payNo.</td></tr>
						
					<tr id="userIdTr"><td> User Id</td></tr>
					<tr id="payWayTr"><td> pay way</td></tr>
					<tr id="priceTr"><td> price</td></tr>
					<tr id="payFlagTr"><td> payFlag</td></tr>
					<tr id="payDateTr"><td> payDate</td></tr>
				</table>
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
		
		<jsp:include page="../common/toast.jsp"></jsp:include>
	
</body>
</html>