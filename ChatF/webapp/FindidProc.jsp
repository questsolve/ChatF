 

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
alert("�������� ���� �����Դϴ�");
history.go(-1);
</script>
<%}else{%>
<script type="text/javascript">
alert("ã���ô� ������ <%=id%>�Դϴ�.");
location.href="../chindex.jsp";
</script>
<%}%>