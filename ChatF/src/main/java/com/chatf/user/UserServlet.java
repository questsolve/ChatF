package com.chatf.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chatf.common.Search;
import com.chatf.pay.PayVO;
import com.chatf.pay.dao.PayDao;
import com.chatf.pay.dao.PayDaoImpl;
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
		System.out.println("addUser");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String sendEmail = request.getParameter("sendEmail"); //???
		String code = request.getParameter("code");
		String checkCode = request.getParameter("checkCode"); //>>>>
		
		UserVO vo = new UserVO();
		vo.setUserId(userId);
		vo.setUserPw(password);
		vo.setUserPw(password2);
		vo.setUserPw(email);
		vo.setUserPw(code);
		System.out.println(vo.toString());
		
		UserDAO dao = new UserDAOImpl();
		int res = dao.adduser(vo);
		PrintWriter out = response.getWriter();

		response.setContentType("text/html; charset=euc-kr");

		response.sendRedirect("chIndexOrigin.jsp");		
	}
	
	private void readUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TODO		
	}
	
	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String curPage = request.getParameter("page");
		Search search = new Search();
		if(curPage != null) {
			search.setCurrentPage(Integer.parseInt(curPage));
			
		}else {
			search.setCurrentPage(1);
		}
		search.setPageSize(10);
		
		
		userDao = new UserDAOImpl();
		List<UserVO> list = userDao.listUser(search);
		request.setAttribute("userList", list);
		request.getRequestDispatcher("user/user_list.jsp").forward(request, response);
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
			
			if(user.getUserRoll().equals("a") ) {
				response.sendRedirect("admin/Index.jsp");
			} else {	
				response.sendRedirect("chIndexOrigin.jsp");
			}
			
		}else {
			System.out.println("로그인 실패");
		}		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("logOut");
		
		session.removeAttribute("loginUser");
		
		response.sendRedirect("chIndexOrigin.jsp");
	}
	
	
}