<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
$(function(){
	
	$("#main").on("click",function(){
		alert("메인으로 가기 ");
	});
	
	$("#test").on("click",function(){
		alert("리뷰작성으로 가기 ");
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
						<li><a id ="main"><span class="icon fa-home"></span></a></li>
						<li><a id ="test"><span class="icon fa-camera-retro"></span></a></li>
						<li><a id = "top"><span class="icon fa-file-text-o"></span></a></li>
						<li><a id ="addPayView"><span class="icon fa fa-paypal"></span></a></li>
						<li><a id ="listPay"><span class="icon fa fa-list"></span></a></li>
	
					</ul>
				</nav>