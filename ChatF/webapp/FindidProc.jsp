 

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("euc-kr"); %>
    <jsp:useBean id="DAO" class="com.chatf.user.dao.UserDAOImpl"/>
    <jsp:useBean id="VO" class="com.chatf.user.UserVO"/>
    <jsp:setProperty property="*" name="vo"/>
<%
  String id = null;
UserVO vo = new UserVO();
Userid = dao.findid(vo);
%>

<%if(id==null){ %>
<script type="text/javascript">
alert("존재하지 않은 계정입니다");
history.go(-1);
</script>
<%}else{%>
<script type="text/javascript">
alert("찾으시는 계정은 <%=id%>입니다.");
location.href="../chindex.jsp";
</script>
<%}%>