<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Gallery - Snapshot by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../assets/css/main.css" />
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

	    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-lite.js"></script>
    

	</head>
	<body>
		<div class="page-wrap">

			<jsp:include page="../common/navbar.jsp"></jsp:include>

			<!-- Main -->
				<section id="main">

					<!-- Header -->
						<header id="header">
							
						</header>

					<!-- Gallery -->
						<section id="galleries">

							<!-- Photo Galleries -->
							
								<div class="gallery">

									<!-- Filters -->
									
										<div>
										
										</div>
										<h1>REVIEW WRITE</h1>
    AREA   <form action="/action_page.php">
       <select name="cars">
       <option value="volvo">KANTO</option>
       <option value="saab">KANSAI</option>
       <option value="fiat">HOKKAIDO</option>
       <option value="audi">KYUSYU</option>
       </select>    
    TAG   <select name="cars">
       <option value="volvo">TOURISM</option>
       <option value="saab">GOURMET</option>
       
       </select>         
											<b>TITLE</b>   <input type="text" name="title" SIZE="60" > 
	  <div id="summernote"></div>
    <script>
      $('#summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 800
      });
    </script>
  

								</div>
								<p align="right">
								<input type="button" name="rewri"  value="WRITE">
								<input type="button" name="rewrite"  value="CANCLE" onCick="ddd.jsp">
								</p>
      
		<!-- Scripts -->
			<script src="../assets/js/jquery.min.js"></script>
			<script src="../assets/js/jquery.poptrox.min.js"></script>
			<script src="../assets/js/jquery.scrolly.min.js"></script>
			<script src="../assets/js/skel.min.js"></script>
			<script src="../assets/js/util.js"></script>
			<script src="../assets/js/main.js"></script>

	</body>
</html>