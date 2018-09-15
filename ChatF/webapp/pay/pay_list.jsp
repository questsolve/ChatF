<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
  $( function() {
    $( "#speed" ).selectmenu();
 
    $( "#files" ).selectmenu();
 
    $( "#number" )
      .selectmenu()
      .selectmenu( "menuWidget" )
        .addClass( "overflow" );
 
    $( "#salutation" ).selectmenu();
  } );
  
  $(function(){
	  $("input[name=submit]").on("click",function(){
		  var cmd =$("input[name=cmd]").val();
		  var business=$("input[name=business]").val();
		  var name= $("input[name=item_name]").val();
		  var number = $("input[name=item_number]").val();
		  var code = $("input[name=currency_code]").val();
		  var amount = $("input[name=amount]").val();
		  var chset = $("input[name=charset]").val();
		  
		  //alert(cmd+","+business+","+name+","+number+","+code+","+amount+","+chset);
		  
		  ajaxPayPal()
		// onSubmit(cmd,business,name,number,code,amount,chset);
		  
		  // $("form").attr("method","post").attr("action","https://www.sandbox.paypal.com/cgi-bin/webscr").submit();
		  //window.open("https://www.sandbox.paypal.com/cgi-bin/webscr");
	  })
  });
  
  function onSubmit(cmd,business,name,number,code,amount,chset){
	  alert($("input[name=cmd]").val());
	  
	  var myForm = $("form");
	  var url = "https://www.sandbox.paypal.com/cgi-bin/webscr";
	  window.open("https://www.sandbox.paypal.com/cgi-bin/webscr" ,"testform", 
	        "toolbar=no, width=540, height=467, directories=no, status=no,    scrollorbars=no, resizable=no"); 
	   
	  myForm.method="post";
	  myForm.target="popForm";
	  myForm.cmd.val = cmd
	  myForm.business.val = business
	  myForm.item_number.val = number 
	  myForm.item_name.val = name
	  myForm.currency_code.val = code
	  myForm.amount.val = amount
	  myForm.charset.val = charset
	  
	  
	  myForm.testVal = 'test';
	  myForm.submit();
	 }
  
  var target ={
		  cmd : $("input[name=cmd]").val(),
		  business:$("input[name=business]").val(),
		  item_name: $("input[name=item_name]").val(),
		  item_number :$("input[name=item_number]").val(),
		  currency_code : $("input[name=currency_code]").val(),
		  amount : $("input[name=amount]").val(),
		  charset : $("input[name=charset]").val()
  }

   
  function ajaxPayPal(){
	  $.ajax({
		  url:"https://www.sandbox.paypal.com/cgi-bin/webscr",
			type:"post",
			data:JSON.stringify(target),
			success:function(res){
				window.open(res);
			}
	  })
  }
  
  
  
  
  
  
  </script>
<style type="text/css">
#galleries .column {
	padding-left: 20%;
	padding-right: 20%;
	padding-top:5%;
}
</style>
</head>
<body>
	<div class="page-wrap">

		<!-- Nav -->
		<nav id="nav">
			<ul>
				<li><a href="index.html" class="active"><span
						class="icon fa-home"></span></a></li>
				<li><a href="gallery.html"><span
						class="icon fa-camera-retro"></span></a></li>
				<li><a href="generic.html"><span
						class="icon fa-file-text-o"></span></a></li>
			</ul>
		</nav>

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
					<input type="hidden" name="cmd" value="_xclick">
					<input type="hidden" name="business" value="questsolve-facilitator@hanmail.net">
					
					<input type="hidden" name="item_name" value="Test Item 0001"><br/>
					<input type="hidden" name="item_number" value="ITEM0001"><br />
					<input type="hidden" name="currency_code" value="USD"><br /> 
					
					<input type="hidden" name="charset" value="UTF-8"><br /><br />
						<div class="field half first">
							<label for="name">userId</label> <input name="name" id="name"
								type="text" placeholder="Name">
						</div>
						<div class="field half">
							<label for="email">pay_way</label>
							<!-- <img src ="../custom_image/images.png"> -->
							<fieldset>
							
								<select name="speed" id="speed">
									<option>paypal</option>
									<option>kakaopay</option>
									<option selected="selected">line</option>
									<option>Fast</option>
									<option>Faster</option>
								</select>
							</fieldset>

							<!-- <input name="email" id="email" type="email" placeholder="Email"> -->
						</div>
						<div class="field">
							<label for="message">Message</label>
							<input type="text" name="amount" value="5"><br />
						</div>
						<ul class="actions">
							<li><input value="Send Message" class="button" type="submit"></li>
							<li><input type="image" name="submit" border="0" src="https://www.paypalobjects.com/en_US/i/btn/btn_buynow_LG.gif" alt="PayPal - The safer, easier way to pay online"></li>
						</ul>
					</form>
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
	
</body>
</html>