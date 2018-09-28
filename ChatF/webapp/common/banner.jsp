<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${loginUser.userRoll != 'a'}">
					<!-- Banner -->
						<section id="banner">
							<div class="inner">
								<h1>Hey, I'm ChatF</h1>
								<p>Go on a trip together!</p>
								<ul class="actions">
									<li><a href="#galleries" class="button big">Continue</a></li>
								</ul>
									<ul class="actions">
				
				<!-- create 버튼  -->
					<c:if test="${empty loginUser}">
						<li><button id="create-user">Create new user</button></li>
					</c:if>
					
					</ul>
				<!--             -->	
					
							</div>
						</section>
</c:if>

<c:if test="${loginUser.userRoll == 'a'}">
	<!-- Header -->
						<header id="header">
							<div>관리자 로그인</div>
						</header>
</c:if>
						


					<!-- Gallery -->
						<section id="galleries">

							<!-- Photo Galleries -->
								<div class="gallery">
									<header class="special">
										<h2>Where are you going?</h2>
									</header>
									<div class="content">
										<div class="media">
										
										<!-- TODO -->
									<!-- 사진(서버) 클릭시 바로 채팅화면으로 이동 -->
									<a href="/kantoChat.jsp" class="movecontact">
										<img src="images/thumbs/kanto.jpg"/></a>
										<!--       -->
								
										</div>
										<div class="media">
											<a href="#contact" class="movecontact"><img src="images/thumbs/kansai.jpg" alt="" title="This right here is a caption." /></a>
										</div>			
										
										<div class="media">
											<a href="#contact" class="movecontact"><img src="images/thumbs/hokkaido.jpg" alt="" title="This right here is a caption." /></a>
										</div>
										<div class="media">
											<a href="#contact" class="movecontact"><img src="images/thumbs/kyusyu.jpg" alt="" title="This right here is a caption." /></a>
										</div>
									<div class="media">
											<a href="images/fulls/06.jpg"><img src="images/thumbs/06.jpg" alt="" title="This right here is a caption." /></a>
										</div>
										<div class="media">
											<a href="images/fulls/10.jpg"><img src="images/thumbs/10.jpg" alt="" title="This right here is a caption." /></a>
										</div>
										<div class="media">
											<a href="images/fulls/03.jpg"><img src="images/thumbs/03.jpg" alt="" title="This right here is a caption." /></a>
										</div>
										<div class="media">
											<a href="images/fulls/07.jpg"><img src="images/thumbs/07.jpg" alt="" title="This right here is a caption." /></a>
										</div>
									</div>
									<footer>
										<a href="gallery.html" class="button big">My Info</a>
									</footer>
								</div>
						</section>

<!-- 
<script>
	$('a href').click(function() {
		$('html, body').animate({
			scrollTop : $($(this).attr('href')).offset().top
		}, 500);

		return false;
	});
</script>
 -->


<!-- Contact -->
<section id="contact" >

	<!-- Chat -->
	<div class="column" style="
	width: 70%;
	height: 70%;
    margin: 40px auto;">
		<h3>Chatting</h3>
		<form action="#" method="post">

<!-- 
			<div class="field">
				<label for="message">Message</label>
				<textarea name="message" class="messageWindow" id="messageWindow"
					rows="20" readonly="true" placeholder="Message"></textarea>
			</div> -->


<div class="messageDiv" id="messageDiv">
<label for="message">Message</label>
<div class="messageField" id="messageField" style="
		
		border-radius: 4px;
		border: solid 1px rgba(25, 181, 254, 0.25);
		color: inherit;
		display: block;
		outline: 0;
		padding: 0 1em;
		text-decoration: none;
		width: 100%;
		height: 500px;
		background-color: #F2F3F4;
		overflow:scroll;
		transform rotate(180deg);
		resize: horizontal;
		margin: auto;
	">

</div>

</div>



			<div class="field half first">
				<input name="message-submit" id="inputMessage" type="text"
					placeholder="Insert the Text">
			</div>
			<input type="button" id="inputBtn" class="inputBtn" value="send">

		</form>
	</div>
</section>
