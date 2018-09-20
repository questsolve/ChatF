package com.chatf.user;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chatf.user.dao.UserDAO;
import com.chatf.user.dao.UserDAOImpl;


/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDao;
	
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info = request.getParameter("info");
		System.out.println("info");
		if(info.equals("addUser")) {
		
			addUser(request, response);
		
		}else if(info.equals("readUser")) {
			
			readUser(request, response);
		
		}else if(info.equals("listUser")) {
		
			listUser(request, response);

		}else if(info.equals("deleteUser")) {
		
			deleteUser(request, response);
		
		}else if(info.equals("login")) {
			
			login(request, response);
		
		}else if(info.equals("logout")) {

			logout(request, response);
		
		}
	}
	
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add");
		//TODO	
	}
	
	private void readUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO		
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDao = new UserDAOImpl();
		HttpSession session = request.getSession(true);
		String userId = request.getParameter("userId");
		String password =request.getParameter("password");
		System.out.println(userId);
		
		UserVO user = userDao.readUser(userId);
		
		if(user.getUserPw().equals(password)) {
			session.setAttribute("loginUser", user);
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
		response.sendRedirect("chIndex.jsp");
		
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("logOut");
		
		session.removeAttribute("loginUser");
		response.sendRedirect("chIndex.jsp");
	}
	
	
}
