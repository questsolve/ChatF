<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(function(){
	
	$("#login").on("click",function(){
		dialog.dialog("open");
	});
	
	$("#logout").on("click",function(){
		self.location = "/UserServlet?info=logout"
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
	

	$("#user").on("click",function(){
		self.location="/user/user_list.jsp";
	});
	
});

</script>
<nav id="nav">
	<ul>
		<c:if test="${empty loginUser}">

			<li><a id="login"><span class="icon fa fa-id-card-o"></span></a></li>
		</c:if>
		<c:if test="${! empty loginUser}">

			<li><a id="logout"><span class="icon fa fa-envelope"></span></a></li>
		</c:if>
		<li><a id="user">U</a></li>
		<li><a id="chat">C</a></li>
		<li><a id="test">B</a></li>
		<li><a id="listPay">P</a></li>
	</ul>
</nav>