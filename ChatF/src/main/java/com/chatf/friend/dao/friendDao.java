package com.chatf.friend.dao;

import com.chatf.friend.friendVO;

public interface friendDao {

//	insert into friend(friend_no,reciever_id,sender_id,friend_flag) values( friend_no_seq.nextval,?,?,?);
//	select receiver_id,sender_id from friend where receiver_id=user_id or sender_id=user_id and friend_flag=’0’; ;
//	select sender_id from friend where receiver_id=user_id and friend_flag=’?’;
//	update friend set friend_flag=1 where friend_no=?;

//4개 

	public int addFriend(friendVO vo);
	public void readFriend(friendVO vo);
	public int updateFriend(friendVO vo);
	
	
}