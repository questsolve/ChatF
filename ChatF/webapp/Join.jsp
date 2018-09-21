<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/css/main.css" />
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html>
<body>

<h2>회원가입</h2>

<form action="/action_page.php">
아이디<br>
<input type="text" name="ID"><input type="submit" value="중복확인"><br>
이름<br>
<input type="text" name="Name">
<br>
패스워드<br>
<input type="text" name="PW"><br>
패스워드확인<br>
<input type="text" name="pwcheck"><br>
이메일<br>
<input type="text" name="Email"><input type="submit" value="이메일인증"><br>
<form action="/action_page.php">
 생년월일<br>
  <input type="date" name="bday"><br>
  

  프로필사진 <br>
  <input type="file" name="myFile"><br><br>
  <input type="submit" value="가입">
</form>


</body>
</html>
</body>
</html>