package com.chatf.reply.text.dao;

import java.util.ArrayList;

import com.chatf.reply.text.ReplyVO;

public class ReplyDAOtTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ReplyDAOImpl dao = new ReplyDAOImpl();

		
/*		//댓글 입력
		ReplyVO vo = new ReplyVO();
		vo.setUserId("user");
		vo.setReviewNo(2100007);
		vo.setReply("사진이 너무 이뻐요");
		
		int re= dao.addReply(vo);
		System.out.println(re);*/
		
/*		//댓글 수정
		ReplyVO vo = new ReplyVO();
		vo.setReply("도쿄 날씨가 참 좋네요");
		vo.setReplyNo(2200000);
		int re = dao.updateReply(vo);
		System.out.println(re);
*/	
		
/*		//댓글 불러오기
		ReplyVO vo = new ReplyVO();
        ArrayList<ReplyVO> list = new ArrayList<ReplyVO>();
        list = dao.listReply(2100007);
        System.out.println(list.size());
        
        for(int i=0; i<list.size();i++) {
        	System.out.println(list.get(i).getReply());
        }*/
        
/*        //댓글 삭제
		
		int re = dao.deleteReply(2200000);
		System.out.println(re);
		*/
	
	
	
	
	
	
	}

}
