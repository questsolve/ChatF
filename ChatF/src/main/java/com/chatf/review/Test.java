package com.chatf.review;

import java.util.ArrayList;

import com.chatf.review.dao.ReviewDAOImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	ReviewDAOImpl dao = new ReviewDAOImpl();
/*		ReviewVO vo = new ReviewVO();
		
		vo.setLocalCode(101);
		vo.setTagCode(201);
		vo.setUserId("user");
		vo.setReviewTitle("도쿄타워 후기");
		vo.setReviewContents("저녁에 본 도쿄타워 너무 이뻐요!");
		vo.setUploadFile(null);
		vo.setUploadMapX(null);
		vo.setUploadMapY(null);
		
		int re = dao.addReview(vo);
		System.out.println(re);
		
		ReviewVO uvo = new ReviewVO();
		uvo.setReviewTitle("TKOTKO");
		uvo.setReviewContents("sugoideshita");
		uvo.setReviewNo(2100007);
		
		int ure = dao.updateReview(uvo);
		System.out.println(ure);
		ReviewVO dvo = new ReviewVO();
		dvo.setActiveYn("n");
		int dre = dao.deleteReview(2100007);
		System.out.println(dre);
 */
	/*
	    ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
	    list = dao.listLocalReview(101);
	    System.out.println(list.size());
	    for(int i=0; i<list.size();i++) {
	    	System.out.println(list.get(i).getReviewNo());
	    	System.out.println(list.get(i).getTagCode());
	    	System.out.println(list.get(i).getUserId());
	    	System.out.println(list.get(i).getWriteDate());
	    	System.out.println(list.get(i).getReviewTitle());
	   	
	    }*/
	
	   ReviewVO vo = new ReviewVO();
	   vo = dao.readReview(2100007);
	   System.out.println(vo.getReviewTitle());
	    
	}

}
