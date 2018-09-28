<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

			<div class="loginView" style="display: none;">
				<section class="container">

					<article class="">

						<div class="tabs">
							<span class="tab signin active"><a href="#signin"
								style="font-size: 15pt;">로그인</a></span> &nbsp;&nbsp;&nbsp; <span
								class="tab signup"><a href="#signup"
								style="font-size: 15pt;">가입하기</a></span>
						</div>
						<div class="content">
							<div class="signin-cont cont">
								<form name="Login">
									<input type="hidden" name="info" value ="login">
									<input type="text" name="userId" class="inpt"
										required="required" placeholder="아이디"> <input
										type="password" name="password" class="inpt"
										required="required" placeholder="비밀번호">

									<div class="submit-wrap">
										<a class="button white" role="button" href="#">비밀번호 찾기</a> <a
											class="button white" role="button" href="#">아이디 찾기</a> <input
											type="button" value="Login" class="submit"> <br>
										<input type="button" value="close" name ="close_login" class="submit">

									</div>
								</form>
							</div>
							<div class="signup-cont cont">
								<form name="join">
								<input type="hidden" name="info" value ="addUser">
									<input type="text" name="userId" class="inpt"
										required="required" placeholder="아이디" oninput="checkId();">
									<input type="password" name="password" class="inpt"
										required="required" placeholder="비밀번호"> <input
										type="password" name="password2" class="inpt"
										required="required" placeholder="비밀번호 확인"> <input
										type="text" name="email" class="inpt email"
										required="required" placeholder="이메일" value=""
										oninput="emailValid();"> <input type="button"
										class="inpt access" name="sendEmail" value="인증"> <input
										type="text" name="code" class="inpt email" required="required"
										placeholder="인증번호"> <input type="button"
										class="inpt access" name="checkCode" value="확인"> <input
										type="button" value="SignIn" class="submit"> <br>
									<input type="button" value="close" name="close_SignIn" class="submit">


								</form>
							</div>
						</div>
					</article>
				</section>
			</div>
