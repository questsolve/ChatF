<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ITBANK ���̵� ã��</title>
<script type="text/javascript">
function findid(){
document.form1.submit();
}
</script>
<style type="text/css">
td{
 padding-left:10px;
}
</style>
</head>
<body>
<br>
<br>
<br>
<img src="member/image/Findidtitle.png" style="padding-left: 60px"><br><br>
<span style="padding-left: 60px">
   <img
    src="member/image/regTitle4.png" width="290" height="100" border="0">
</span>
<br><br><br><br>
<p align="center">
<form action="ChatF/webapp/FindidProc.jsp" method="post" name="form1">
<table style="padding-left: 60px" width="550">
 <tr>
  <td align="center" bgcolor="gray">
   �� ������ ã��
  </td>
 </tr>
 <tr>
  <td align="left">
  <br>
   �̸� : <input type="text" name="name" size="15" maxlength="20">
  </td>
 </tr>
 <tr>
  <td align="left">
  <br>
   �ڵ��� ��ȣ : <select name="ph1">
       <option value="010">010</option>
       <option value="011">011</option>
       <option value="016">016</option>
       <option value="017">017</option>
       <option value="019">019</option>
     </select> -
   <input type="text" size="4" maxlength="4" name="ph2"> -
   <input type="text" size="4" maxlength="4" name="ph3">
  </td>
 </tr>
 <tr>
  <td align="left">
  <br>
   ������� : <select name="birth1">
       <%for(int i=2013; i>=1900; i--){ %>
       <option value="<%=i %>"><%=i %></option>
       <%} %>
     </select>��&nbsp;
     <select name="birth2">
       <%for(int i=1; i<=12; i++){ %>
       <option value="<%=i %>"><%=i %></option>
       <%} %>
     </select>
     <select name="birth3">
       <%for(int i=1; i<=31; i++){ %>
       <option value="<%=i %>"><%=i %></option>
       <%} %>
     </select>��
  </td>
 </tr>
 <tr>
  <td align="center">
   <img src="member/image/Findid.png" onclick="findid()">
  </td>
 </tr>
</table>
</form>
</body>
</html>