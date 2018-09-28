<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  page contentType = "text/html; charset=utf-8" %>
    <%@ page import = "java.sql.DriverManager" %>
    <%@ page import = "java.sql.Connection" %>
    <%@ page import = "java.sql.Statement" %>
    <%@ page import = "java.sql.ResultSet" %>
    <%@ page import = "java.sql.SQLException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>회원목록</title></head>
<body>
MEMBER테이블의 내용
<table width="100%" border="1">
<tr>
<td>이름</td><td>아이디</td><td>이메일</td>
</tr>
<% 

Class.forName("com.mysql.jdbc.Driver");
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;


try { 
	String jdbcDriver = "jdbc:mysql://localhost1521/chatf?" + "userUnicode=truw&characterEncoding=utf8";
	
	String dbUser = "jspeaxm";
	String dbPass = "jsppw";
	
	String query = "select * from MEMBER order by MEMBERID";
	
	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	
	stmt = conn.createStatement();
	
	rs = stmt.executeQuery(query);
	
	while(rs.next()){
     
%>
<tr>
<td><%=rs.getString("NAME") %></td>
<td><%=rs.getString("MEMBERID")%></td>
<td><%=rs.getString("EMAIL") %></td>
</tr>
 <%
 }
} catch(SQLException ex){
	out.println(ex.getMessage());
	ex.printStackTrace();
}finally{
	if(rs != null) try { rs.close();} catch(SQLException ex){}
	if(stmt != null) try { stmt.close(); } catch(SQLException ex) {}
	
	if (conn != null) try { conn.close(); } catch(SQLException ex){}
	
}
%>

</table>

</body>
</html>
