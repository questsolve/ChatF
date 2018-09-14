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
  </script>
<style type="text/css">
#galleries .column {
	padding-left: 20%;
	padding-right: 20%;
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
					<h3>Get in Touch</h3>
					<form action="#" method="post">
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
							<textarea name="message" id="message" rows="6"
								placeholder="Message"></textarea>
						</div>
						<ul class="actions">
							<li><input value="Send Message" class="button" type="submit"></li>
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