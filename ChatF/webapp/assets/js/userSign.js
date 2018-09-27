

	$(function() {
		
	
		
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
			document.Login.method = "post"
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
	


     $(document).ready(function(){

  	   $('#SignIn').click(function(){
         if($('#userId').val()==""){
      	   alert("id입력")
      	   $('#userId').focus();
         }else if($('#password').val()==""){
      	   alert("pw입력")
      	   $('#password').focus();
         }else if($('#password2').val()==""){
      	   alert("pw입력")
      	   $('#password2').focus();
         }else{
      	   $("#join").submit();
         }
   });
  
      });
     