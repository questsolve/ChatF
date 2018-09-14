package com.chatf.reply.text.dao;

import java.util.ArrayList;

import com.chatf.reply.text.ReplyCommentVO;
import com.chatf.reply.text.ReplyVO;

public interface ReplyCommentDAO {

	//대댓글 달기
	public int addReplyCommnet(ReplyCommentVO vo);
	//대댓글 수정
	public int updateReplyComment(ReplyCommentVO vo);
	//대댓글 삭제
	public int deleteReplyComment(int replyNo);
	//대댓글 가져오기
    public ArrayList<ReplyCommentVO> listReplyComment(int replyNo);
}
