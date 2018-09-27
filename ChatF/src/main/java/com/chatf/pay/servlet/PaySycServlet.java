package com.chatf.pay.servlet;

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
import com.chatf.point.PointVO;
import com.chatf.point.dao.PointDao;
import com.chatf.point.dao.PointDaoImpl;
import com.chatf.user.UserVO;
import com.google.gson.Gson;

/**
 * Servlet implementation class PaySycServlet
 */
@WebServlet("/PaySynServlet")
 
public class PaySycServlet extends HttpServlet {
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
		System.out.println(check+"!!!");
		
		//요구사항에 대한 각 메소드들의 교차 진행

		if(check.equals("addPay")) {
			addPay(request, response);
		}else if(check.equals("readPay")){
			readPay(request, response);
		}else if (check.equals("listPay")) {
			listPay(request, response);
		}else if (check.equals("addPayView")) {
			addPayView(request, response);
		}else if (check.equals("listPay_ajax")) {
			listPayByAjax(request, response);
		}
		
	}

	private void addPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("addPay");
		HttpSession session = request.getSession(true);
		PointDao pointDao = new PointDaoImpl();
		UserVO user =(UserVO)session.getAttribute("loginUser");
		
		System.out.println(user);
		
		
		
		int currentPointNO = 0;
		if(user != null) {
			currentPointNO = pointDao.readCurrentPointNO(user.getUserId());
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
		System.out.println("readPay");
		HttpSession session = request.getSession(true);
		UserVO user =(UserVO)session.getAttribute("loginUser");
		
		int payNo = Integer.parseInt(request.getParameter("no"));
		System.out.println(payNo);
		
		PayDao payDao = new PayDaoImpl();
		PayVO pay = payDao.readPay(payNo);
		
		PointDao pointDao = new PointDaoImpl();
		int totalPoint =0;
		


		totalPoint = pointDao.readPoint(user.getUserId());
		System.out.println("payServlet: "+totalPoint);
			
		request.setAttribute("pay", pay);
		request.setAttribute("totalPoint", totalPoint);
		//TODO 현재 포인트 량 확인해서 requestScope에 넘겨주기
		
		request.getRequestDispatcher("/pay/pay_read2.jsp").forward(request, response);
		
	}
	
	private void listPay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listPay");
		HttpSession session = request.getSession(true);
		
		UserVO user = (UserVO)session.getAttribute("loginUser"); 
		//System.out.println(user.getUserId());
		Search search = new Search();
		
		String curPage = request.getParameter("page");
				
		if(curPage != null) {
			search.setCurrentPage(Integer.parseInt(curPage));
			
		}else {
			search.setCurrentPage(1);
		}
		
		
		if((request.getAttribute("loginUser"))==null &&
			(session.getAttribute("loginUser"))==null) {
		}
			
		
		search.setPageSize(10);
		System.out.println(search.getStartRowNum());
		System.out.println(search.getEndRowNum());
		System.out.println(user.getUserId());
		
		PayDao paydao = new PayDaoImpl();
		List<PayVO> list = paydao.listPay(user.getUserId(), search);
		System.out.println(list.size());
		request.setAttribute("payList", list);
		request.getRequestDispatcher("/pay/pay_list2.jsp").forward(request, response);
		
	}
	
	private void addPayView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/pay/pay_add2.jsp");
	}
	
	private void listPayByAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("listPayAjax");
		HttpSession session = request.getSession(true);
		
		String searchUser = request.getParameter("searchUser");
		UserVO user = (UserVO)session.getAttribute("loginUser"); 
		System.out.println(user.getUserId());
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
		List<PayVO> list = paydao.listPay(searchUser, search);
			
		
		
		Gson gson = new Gson(); 
		String gsonStr = gson.toJson(list); 
		System.out.println(gsonStr); 
		
		PrintWriter out = response.getWriter();
		out.println(gsonStr);
		
	}
}
