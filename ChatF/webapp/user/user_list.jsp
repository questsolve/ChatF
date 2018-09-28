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
		alert("로그인으로 던지기");
	}else{
		var userId = "${loginUser.userId}";
		var check = "listPay";
		
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
	  //alert(queryString);
	  searchUserId(queryString);
  });
});
  
  
// */




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
							<h1>User List</h1>
					</header>					
				
					<div class="content">
							<table>
								<thead>
									<tr>
										<td>회원아이디</td>
										<td>회원명</td>
										<td>생년월일</td>
										<td>이메일</td>
										<td>가입일</td>
										<td>회원사진</td>
									</tr>
								</thead>
								<tbody>
									
									
										<c:if test="${empty userList}">
											<tr>
												<td>-</td>
												<td>-</td>
												<td>-</td>
												<td>-</td>
												<td>-</td>
												<td>-</td>
											</tr>
										</c:if>
										<c:if test="${!empty userList}">	
											<c:forEach items="${userList}" var="user">
												<tr>
													<td>${user.userId}</td>
													<td>${user.userName}</td>
													<td>${user.userBirthday}</td>
													<td>${user.userEmail}</td>
													<td>${user.userRegdate}</td>
													<td>${user.userImage}</td>
												</tr>
											</c:forEach>
										</c:if>
										
									
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