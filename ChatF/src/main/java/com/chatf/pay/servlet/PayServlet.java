package com.chatf.pay.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import com.chatf.point.PointVO;
import com.chatf.point.dao.PointDao;
import com.chatf.point.dao.PointDaoImpl;
import com.chatf.user.User;
import com.google.gson.Gson;

import oracle.net.aso.p;

/**
 * Servlet implementation class PayServlet
 */
@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
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
		String check = request.getParameter("check");
		System.out.println(check);
		if(check.equals("addPay")) {
			addPay(request, response);
		}else if(check.equals("readPay")){
			readPay(request, response);
		}else if (check.equals("listPay")) {
			listPay(request, response);
		}
		
	}
	
	private void addPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PointDao pointDao = new PointDaoImpl();
		User user =(User)session.getAttribute("loginUser");
		int currentPointNO = 0;
		if(user == null) {
			currentPointNO = pointDao.readCurrentPointNO("testuser01");
			System.out.println("payServlet: "+currentPointNO);
		}
		PointVO point = pointDao.readPoint(currentPointNO);
		
		PayDao payDao = new PayDaoImpl();
		int price = Integer.parseInt(request.getParameter("point"));		
		PayVO payVo = new PayVO();
		payVo.setUsageNo(point);
		payVo.setPayFlag("add");
		payVo.setPayWay("payPal");
		payVo.setPrice(price);
		
		int res = payDao.addPay(payVo);
		
		int payNo = payDao.readCurrentPay(currentPointNO);
		
		
		
		if(res > 0) {
			response.sendRedirect("/PayServlet?check=readPay&no="+payNo);
		}
	
	}
	
	private void readPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		User user =(User)session.getAttribute("loginUser");
		
		int payNo = Integer.parseInt(request.getParameter("no"));
		System.out.println(payNo);
		
		PayDao payDao = new PayDaoImpl();
		PayVO pay = payDao.readPay(payNo);
		
		PointDao pointDao = new PointDaoImpl();
		int totalPoint =0;
		

		if(user == null) {
			totalPoint = pointDao.readPoint("testuser01");
			System.out.println("payServlet: "+totalPoint);
		}else {
			//TODO 
			//totalPoint = pointDao.readPoint(user.getUserId);
			System.out.println("payServlet: "+totalPoint);
		}
		
		request.setAttribute("pay", pay);
		request.setAttribute("totalPoint", totalPoint);
		//TODO 현재 포인트 량 확인해서 requestScope에 넘겨주기
		
		request.getRequestDispatcher("/pay/pay_read.jsp").forward(request, response);
		
	}
	
	private void listPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		System.out.println(userId);
		Search search = new Search();
		
		String curPage = request.getParameter("page");
				
		if(curPage != null) {
			search.setCurrentPage(Integer.parseInt(curPage));
			
		}else {
			search.setCurrentPage(1);
		}
		
		
		search.setPageSize(10);
		System.out.println(search.getStartRowNum());
		System.out.println(search.getEndRowNum());
		
		PayDao paydao = new PayDaoImpl();
		List<PayVO> list = paydao.listPay(userId, search);
			
		
		
		Gson gson = new Gson(); 
		String gsonStr = gson.toJson(list); 
		String page = gson.toJson(search);
		System.out.println(gsonStr); 
		
		PrintWriter out = response.getWriter();
		out.println(gsonStr);
		
	}
	
	
	private void countPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
