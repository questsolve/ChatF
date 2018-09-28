package com.chatf.reply.text.dao;

import java.util.ArrayList;

import com.chatf.reply.like.LikeVO;
import com.chatf.reply.text.ReplyVO;

public interface ReplyDAO {

	public int addReply(ReplyVO vo);
	public int updateReply(ReplyVO vo);
	public int deleteReply(int replyNo);
    public ArrayList<ReplyVO> listReply(int reviewNo);
	
}
