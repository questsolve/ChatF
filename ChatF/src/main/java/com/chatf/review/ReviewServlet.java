package com.chatf.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chatf.review.dao.ReviewDAO;
import com.chatf.review.dao.ReviewDAOImpl;
import com.chatf.user.UserVO;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String info=request.getParameter("info");
		System.out.println("info");
		if(info.equals("addReview")) {
			addReview(request,response);
		}else if(info.equals("updateReview")) {
			updateReview(request,response);
		}else if(info.equals("readReivew")) {
			readReview(request,response);
		}else if(info.equals("deleteReivew")) {
			deleteReview(request,response);
		}
			
			
	}

	private void addReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ReviewDAO reviewdao= new ReviewDAOImpl();
		ReviewVO rvo = new ReviewVO();
		HttpSession session = request.getSession(true);
		UserVO user =(UserVO)session.getAttribute("loginUser");
		System.out.println("글쓰기 실패");
		
		int area =Integer.parseInt(request.getParameter("area"));
		int tag =Integer.parseInt(request.getParameter("tag"));
		String title = request.getParameter("title");
		String contents = request.getParameter("summernote");
		String userId= user.getUserId();
		
		rvo.setLocalCode(area);
		rvo.setTagCode(tag);
		rvo.setUserId(userId);
		rvo.setReviewTitle(title);
		rvo.setReviewContents(contents);
		
		int re=reviewdao.addReview(rvo);
		System.out.println(re);
		
		
		response.sendRedirect("share/list_review.jsp");
		
		
	}
	private void updateReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}
	private void readReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(true);
		UserVO user =(UserVO)session.getAttribute("loginUser");
		
		ReviewDAO reviewdao= new ReviewDAOImpl();
		ReviewVO rvo = new ReviewVO();
		ArrayList<ReviewVO> rlist = new ArrayList<ReviewVO>();
		
		
		//int area  = Integer.parseInt(request.getParameter("area"));
		
		
		rlist = reviewdao.listLocalReview(101);
		request.setAttribute("keylist", rlist);
		request.getRequestDispatcher("share/list_review.jsp").forward(request,response);
		
				
	}
	private void deleteReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}
}
