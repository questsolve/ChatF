package com.chatf.friend.dao;

import com.chatf.friend.FriendVO;

public interface FriendDao {

	public int addFriend(FriendVO vo);
	public void readFriend(FriendVO vo);
	public int updateFriend(FriendVO vo);
}
