<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(function(){
	
	$("#login").on("click",function(){
		alert("login");
	});
	
	$("#logout").on("click",function(){
		alert("logout");
	});
	
	
	$("#chat").on("click",function(){
		self.location = "/chIndex.jsp"
	});
	
	$("#test").on("click",function(){
		self.location = "/share/list_review.jsp"
	});
	$("#top").on("click",function(){
		alert("채팅으로 가기 ");
	});
	
	$("#addPayView").on("click",function(){
		self.location="/pay/pay_add.jsp";		
	});
	
	
	$("#listPay").on("click",function(){
		self.location="/pay/pay_list.jsp";
	});
	
	
	
});

</script>
<nav id="nav">
					<ul>
						<c:if test="${empty loginUser}">
						
							<li><a id ="login"><span class="icon fa fa-id-card-o"></span></a></li>
						</c:if>
						<c:if test="${! empty loginUser}">
						
							<li><a id ="logout"><span class="icon fa fa-envelope"></span></a></li>
						</c:if>
					
						<li><a id ="chat"><span class="icon fa fa-home"></span></a></li>
						<li><a id ="test"><span class="icon fa-camera-retro"></span></a></li>
						<li><a id = "top"><span class="icon fa-file-text-o"></span></a></li>
						<li><a id ="addPayView"><span class="icon fa fa-paypal"></span></a></li>
						<li><a id ="listPay"><span class="icon fa fa-list"></span></a></li>
	
					</ul>
				</nav>