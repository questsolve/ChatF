<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Gallery - Snapshot by TEMPLATED</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		
		
		<!-- include libraries(jQuery, bootstrap) -->
        <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

        <!-- include summernote css/js-->
        <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
        <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
    
	<script type="text/javascript">
        /* summernote에서 이미지 업로드시 실행할 함수 */
	 	function sendFile(file, editor) {
            // 파일 전송을 위한 폼생성
	 		data = new FormData();
	 	    data.append("uploadFile", file);
	 	    $.ajax({ // ajax를 통해 파일 업로드 처리
	 	        data : data,
	 	        type : "POST",
	 	        url : "./summernote_imageUpload.jsp",
	 	        cache : false,
	 	        contentType : false,
	 	        processData : false,
	 	        success : function(data) { // 처리가 성공할 경우
                    // 에디터에 이미지 출력
	 	        	$(editor).summernote('editor.insertImage', data.url);
	 	        }
	 	    });
	 	}
	</script>
	</head>
	<body>
		<div class="page-wrap">

			<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="index.html"><span class="icon fa-home"></span></a></li>
						<li><a href="gallery.html" ><span class="icon fa-camera-retro"></span></a></li>
						<li><a href="generic.html"><span class="icon fa-file-text-o"></span></a></li>
						<li><img src="https://cdn1.iconfin	der.com/data/icons/customicondesign-mini-lightcolour-png/48/Login_in.png" class="active" width=22 height=33></li>
						
						
					</ul> 
				</nav>

			<!-- Main -->
				<section id="main">

					<!-- Gallery -->
						<section id="galleries">

							<!-- Photo Galleries -->
							
								<div class="gallery">

									<!-- Filters -->
									
										<div>
										
										</div>
										<h1>JOIN</h1>
										
<form action="/action_page.php">
UserID<br>
<input type="text" name="ID"><input type="submit" value="중복확인"><br>
Name<br>
<input type="text" name="Name">
<br>
PW<br>
<input type="text" name="PW"><br>
PWcheck<br>
<input type="text" name="pwcheck"><br>
Email<br>
<input type="text" name="Email"><input type="submit" value="이메일인증"><br>
<form action="/action_page.php">
 BirthDay<br>
  <input type="date" name="bday"><br>
  
  
  Photo <br>
  <input type="file" name="myFile"><br><br>
  <input type="submit" value="가입">
</form>
	

								</div>
      
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.poptrox.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>