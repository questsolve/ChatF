package com.chatf.reply.like.dao;

import java.util.ArrayList;

import com.chatf.reply.like.LikeVO;

public class LikeDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LikeDAOImpl like = new LikeDAOImpl();
/*		LikeVO vo = new LikeVO();
		
		vo.setUserId("user");
		vo.setReviewNo(2100007);
		
		int re = like.addLike(vo);
		
		System.out.println(re);*/
/*		LikeVO vo = new LikeVO();
	int re = like.update(2100007 ,"user");
	
	System.out.println(re);*/
	
		int re =  like.readLike(2100007);
	    System.out.println(re);	
	}
	

}
