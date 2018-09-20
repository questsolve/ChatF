package com.chatf.reply.like.dao;

import java.util.ArrayList;

import com.chatf.reply.like.LikeVO;

public interface LikeDAO {

	public int addLike(LikeVO vo);
	public int readLike(int reviewNo);
	public int update(int reviewNO , String userId);
}
