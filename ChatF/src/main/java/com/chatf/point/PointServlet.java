package com.chatf.point;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chatf.pay.PayVO;
import com.chatf.pay.dao.PayDao;
import com.chatf.pay.dao.PayDaoImpl;
import com.chatf.point.dao.PointDao;
import com.chatf.point.dao.PointDaoImpl;
import com.chatf.user.User;

/**
 * Servlet implementation class PointServlet
 */
@WebServlet("/PointServlet")
public class PointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String check = request.getParameter("check");
		if(check.equals("addPay")) {
			addPoint(request, response);
		}
		doGet(request, response);
	}
	
	private void addPoint(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		User user =(User)session.getAttribute("loginUser");
		
		PointDao pointDao = new PointDaoImpl();
		PointVO pointVO = new PointVO();
		int point = Integer.parseInt(request.getParameter("amount"));
		pointVO.setPoint(point);
		if(user ==null) {
			pointVO.setUserId("testuser01");
		}
		pointVO.setUsageFlag("add");
		
		int res = pointDao.addPoint(pointVO);
		
		int currentPointNO = pointDao.readCurrentPointNO(pointVO.getUserId());
		System.out.println("pointServlet : "+currentPointNO);
		response.sendRedirect("/PayServlet?check=addPay&point="+point);
		
	}

}
