<!-- session.jsp -->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Date t = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션 정보</title>
</head>
<body>
	세션 ID :
	<%=session.getId()%><br>
	<%
		t.setTime(session.getCreationTime());
	%>
	세션 생성시간 :
	<%=sf.format(t)%><br>
	<%
		t.setTime(session.getLastAccessedTime());
	%>
	최근 접근시간 :
	<%=sf.format(t)%>
</body>
</html>
<!-- 실행결과 세션 ID : 7FE891620D3A4A35E80FBBD176B86116 세션 생성시간 : 2013-09-22 03:33:10 최근 접근시간 : 2013-09-22 03:34:12 -->

출처: http://gangzzang.tistory.com/entry/JSP-기본-객체-세션session [갱짱.study]
