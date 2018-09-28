package com.chatf.chat.chatLog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chatf.chat.chatLog.chatLogVO;
import com.chatf.chat.chatLog.dao.chatLogDao;
import com.chatf.chat.chatLog.dao.chatLogDaoImpl;
@WebServlet("/chat_logServelet")
public class chatLogServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String msg = request.getParameter("msg");
		String datestr = request.getParameter("datestr");
		
		chatLogVO mvo = new chatLogVO();
		mvo.setUserId(user);
		mvo.setChatServerNo(0);
		mvo.setChatText(msg);
	
		
		chatLogDao dao = new chatLogDaoImpl();
		int re = dao.addChatLog(mvo);
		System.out.println("서블릿 "+re+"건 완료 ");
		System.out.println(user + "," + msg + "," + datestr);
		
		
//		PrintWriter out = response.getWriter();
//		out.println("11ok");
		
		 
		 
	}

}
