package com.chatf.user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chatf.user.dao.UserDAOImpl;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/Chatf")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	protected void doGet(HttpServletRequest request
//			, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("get....");
//		response.sendRedirect("/member/welcome.jsp");
//		
//	}
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		
		String info = request.getParameter("info");
		
		if(info.equals("join")) { 
			UserVO mvo = new UserVO();
			UserDAOImpl mdao = new UserDAOImpl();
			mvo.setUserId(request.getParameter("User_id"));
			mvo.setUserPw(request.getParameter("User_pw"));
			int res = mdao.add(mvo);
			//request.getContextPath()+
			response.sendRedirect("/Chatf/welcome.jsp");
		} else if(info.equals("login")) {
			UserDAOImpl mdao = new UserDAOImpl();
			UserVO mvo = new UserVO();
			mvo.setUserId(request.getParameter("User_id"));
			mvo.setUserPw(request.getParameter("User_pw"));
			mvo = mdao.adduser(mvo);
			if(mvo.getUserName() != null) {
				//님  
				if(mvo.getUserRoll().equals("u")) {
					HttpSession session = request.getSession();
					session.setAttribute("SESS_ID" ,mvo.getUserId());
					session.setAttribute("SESS_NAME",mvo.getUserName());
					session.setAttribute("SESS_ROLL",mvo.getUserRoll());
					response.sendRedirect("/chatf/user_main.jsp");
					
				} else if(mvo.getUserRoll().equals("a")) {
					HttpSession session = request.getSession();
					session.setAttribute("SESS_ID" ,mvo.getUserId());
					session.setAttribute("SESS_NAME",mvo.getUserName());
					session.setAttribute("SESS_ROLL",mvo.getUserRoll());
					//response.sendRedirect("/member/admin_main.jsp");
					ArrayList<UserVO> list = mdao.read();
					request.setAttribute("keylist",list); 
					
					request.getRequestDispatcher("/Chatf/admin_main.jsp").forward(request, response);
				} else {
					response.sendRedirect("/Chatf/error.jsp");
				}
			} else {
				response.sendRedirect("/Chatf/error.jsp");
			}
			
		} else if(info.equals("view")) {
			//회원정보...
			UserDAOImpl mdao = new UserDAOImpl();
			UserVO mvo = new UserVO();
			HttpSession session = request.getSession();
			//int seq = Integer.parseInt(request.getParameter("seq"));
			int seq = Integer.parseInt(session.getAttribute("SESS_SEQ").toString());
			mvo = mdao.read(mvo.getUserId());
			request.setAttribute("keymvo", mvo);
			request.getRequestDispatcher("/Chatf/chatf_update_form.jsp").forward(request, response);
			
		} else if(info.equals("update")) {
			//회원정보 수정...
			UserDAOImpl mdao = new UserDAOImpl();
			UserVO mvo = new UserVO();
			//int seq = Integer.parseInt(request.getParameter("seq"));
			HttpSession session = request.getSession();
			int seq = Integer.parseInt(session.getAttribute("SESS_SEQ").toString());
			
			mvo.setUserId("User_id");
			mvo.setUserPw(request.getParameter("User_pw"));
			mvo.setUserName(request.getParameter("User_name"));
			int res = mdao.update(mvo);
			
			//이동
			response.sendRedirect("/member/user_main.jsp");
		} else if(info.equals("delete")) {
			
			HttpSession session = request.getSession();//세션은 리퀘스트에 요청해서 받아서 쓰는거임 새로 못만듬 ex)HttpSession ss = new HttpSession
			int seq = Integer.parseInt(session.getAttribute("SESS_SEQ").toString());
			UserDAOImpl mdao = new UserDAOImpl();
			UserVO mvo = new UserVO();
			mvo.setUserId("user_id");
			
			int res = mdao.delete(mvo);
			response.sendRedirect("/chatf/	login.jsp");
		/*} else if(info.equals("logout")) {
		  HttpSession session = request.getSession();
		  session.invalidate();
		  response.sendRedirect("/member/member_login.jsp");
		}
		*/
	}

	}
}

