package com.chatf.reply.text.dao;

import java.util.ArrayList;

import com.chatf.reply.text.ReplyCommentVO;

public class ReplyCommentDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ReplyCommentDAOImpl dao = new ReplyCommentDAOImpl();
		
/*		//대댓쓰기
		ReplyCommentVO vo = new ReplyCommentVO();
		vo.setUserId("user");
		vo.setReplyComment("감사합니다.");
		vo.setReplyNo(2200000);
		int re = dao.addReplyCommnet(vo);
		System.out.println( re);
	*/
		
		
	/*	//대댓수정
		ReplyCommentVO vo = new ReplyCommentVO();
		vo.setReplyComment("날씨가 정말 좋아요 ");
		vo.setCommentNo(2300000);
		int re = dao.updateReplyComment(vo);
		System.out.println(re);*/
		
	/*	//대댓 삭제
		int re= dao.deleteReplyComment(2300000);
		System.out.println(re);*/
		
		//대댓 불러오기
		ReplyCommentVO vo = new ReplyCommentVO();
		ArrayList<ReplyCommentVO> list = new ArrayList<ReplyCommentVO>();
		list = dao.listReplyComment(2200000);
		System.out.println(list.size());
		System.out.println(list.get(0).getCommentNo());
	}

}
