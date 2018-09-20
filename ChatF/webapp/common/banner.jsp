<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
					<!-- Banner -->
						<section id="banner">
							<div class="inner">
								<h1>Hey, I'm ChatF</h1>
								<p>Go on a trip together!</p>
								<ul class="actions">
									<li><a href="#galleries" class="button alt scrolly big">Continue</a></li>
								</ul>
							</div>
						</section>

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
									<a href="#contact" class="movecontact">
										<img src="images/thumbs/kanto.jpg"/></a>
										<!--       -->
								
										</div>
										<div class="media">
											<a href="images/fulls/05.jpg"><img src="images/thumbs/kansai.jpg" alt="" title="This right here is a caption." /></a>
										</div>			
										
										<div class="media">
											<a href="images/fulls/09.jpg"><img src="images/thumbs/hokkaido.jpg" alt="" title="This right here is a caption." /></a>
										</div>
										<div class="media">
											<a href="images/fulls/02.jpg"><img src="images/thumbs/kyusyu.jpg" alt="" title="This right here is a caption." /></a>
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
										<a href="gallery.html" class="button big">Full Gallery</a>
									</footer>
								</div>
						</section>
						
						
    <!-- Contact -->
						<section id="contact">
														
							<!-- Chat -->
								<div class="column">
									<h3>Chatting</h3>
									<form action="#" method="post">
										
									
										<div class="field">
											<label for="message">Message</label>
											<textarea name="message" class="messageWindow" id="messageWindow" rows="20" readonly="true" placeholder="Message"></textarea>
										</div>
										
										
										<div class="field half first">
											<input name="message-submit" id="inputMessage" type="text" placeholder="Insert the Text">
										</div>
										<input type="button" id="inputBtn" class="inputBtn" value="send">
										
									</form>
								</div>
						</section>