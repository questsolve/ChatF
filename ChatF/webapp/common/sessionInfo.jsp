<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.chatf.user.UserVO"%>
    
<%
 UserVO vo = (UserVO)session.getAttribute("loginUser"); //session에 있는 정보를 받아온다.
 
 if(vo == null){
  System.out.println("로그인 안한 사용자");
 }else{
  System.out.println("로그인한 사용자");
 }
 System.out.println("현재 세션에 올라와있는것 : "+session.getAttribute("loginUser"));
%>
<%String myId = vo.getUserId(); %>    
    
   