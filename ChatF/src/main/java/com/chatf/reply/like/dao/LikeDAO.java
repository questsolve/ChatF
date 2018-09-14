package com.chatf.reply.like.dao;

import com.chatf.reply.like.LikeVO;

public interface LikeDAO {

	public int addLike(LikeVO vo);
	public void readLike(int reviewNo);
	public int update(LikeVO vo);
}
